package bookstore;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class BookController {

    @Autowired
    BookRepository repository;

    @RequestMapping(value = "/api/readBooks", method = RequestMethod.POST)
    public ResponseEntity<ArrayList<Book>> readAll(@RequestBody Book reqBook) {
        ArrayList<Book> books;

        if (reqBook.getGenreId() == 0) {
            books = (ArrayList<Book>) repository.findByIsDeleted(false);
        } else {
            books = (ArrayList<Book>) repository.findByGenreIdAndIsDeleted(reqBook.getGenreId(), false);
        }

        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/readBook", method = RequestMethod.POST)
    public ResponseEntity<Book> read(@RequestBody Book reqBook) {
        long bookId = reqBook.getId();
        Book book = repository.findOne(bookId);

        if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @RequestMapping(value = "/api/createBook", method = RequestMethod.POST)
    public ResponseEntity<Book> create(@RequestBody Book book) {
        Book newBook = new Book(book);
        book.setDeleted(false);
        repository.save(book);

        return new ResponseEntity<>(newBook, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/updateBook", method = RequestMethod.POST)
    public ResponseEntity<Book> update(@RequestBody Book reqBook) {
        Book book = repository.findOne(reqBook.getId());

        book.setName(reqBook.getName());
        book.setDescription(reqBook.getDescription());
        book.setAuthor(reqBook.getAuthor());
        book.setYear(reqBook.getYear());
        book.setGenreId(reqBook.getGenreId());
        book.setLanguage(reqBook.getLanguage());
        book.setPublishingHouse(reqBook.getPublishingHouse());
        book.setCover(reqBook.getCover());
        book.setPrice(reqBook.getPrice());
        book.setAmount(reqBook.getAmount());
        book.setImageUrl(reqBook.getImageUrl());

        Book newBook = repository.save(book);

        return new ResponseEntity<>(newBook, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/deleteBook", method = RequestMethod.POST)
    public ResponseEntity<Book> delete(@RequestBody Book book) {
        Book foundBook = repository.findOne(book.getId());
        if (foundBook != null) {
            foundBook.setDeleted(true);
            foundBook = repository.save(foundBook);
            return new ResponseEntity<>(foundBook, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}