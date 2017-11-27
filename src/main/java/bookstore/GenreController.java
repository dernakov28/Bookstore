package bookstore;

import antlr.collections.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class GenreController {

    @Autowired
    GenreRepository repository;

    @RequestMapping(value = "/api/createGenre", method = RequestMethod.POST)
    public ResponseEntity<Genre> createGenre(@RequestBody Genre genre) {
        Genre newGenre = repository.save(new Genre(genre.getName()));
        return new ResponseEntity<Genre>(newGenre, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/readGenre")
    public ResponseEntity<Genre> readGenre(@RequestBody Genre genre) {
        genre = repository.findOne(genre.getId());
        return new ResponseEntity<Genre>(genre, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/updateGenre", method = RequestMethod.POST)
    public ResponseEntity<Genre> updateGenre(@RequestBody Genre requestGenre) {
        Genre genre = repository.findOne(requestGenre.getId());
        if (genre != null) {
            genre.setName(requestGenre.getName());
            repository.save(genre);
            return new ResponseEntity<Genre>(genre, HttpStatus.OK);
        }
        return new ResponseEntity<Genre>(HttpStatus.NOT_MODIFIED);
    }

    @RequestMapping(value = "/api/deleteGenre", method = RequestMethod.POST)
    public ResponseEntity<Genre> deleteGenre(@RequestBody Genre genre) {
        Genre foundGenre = repository.findOne(genre.getId());
        if (foundGenre != null) {
            repository.delete(genre.getId());
            return new ResponseEntity<Genre>(foundGenre, HttpStatus.OK);
        }
        return new ResponseEntity<Genre>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping("/api/readGenres")
    public ResponseEntity<ArrayList<Genre>> readGenres() {
        ArrayList<Genre> genres = new ArrayList<Genre>();
        for (Genre genre: repository.findAll()) {
            genres.add(genre);
        }
        return new ResponseEntity<>(genres, HttpStatus.OK);
    }

}
