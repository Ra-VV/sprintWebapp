package test.springframework.sprintWebapp.repositories;

import org.springframework.data.repository.CrudRepository;
import test.springframework.sprintWebapp.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
