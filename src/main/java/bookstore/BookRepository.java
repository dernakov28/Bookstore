package bookstore;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>{
    List<Book> findByName(String name);
    List<Book> findByIsDeleted(Boolean isDeleted);
    List<Book> findByGenreIdAndIsDeleted(int genreId, Boolean isDeleted);
}