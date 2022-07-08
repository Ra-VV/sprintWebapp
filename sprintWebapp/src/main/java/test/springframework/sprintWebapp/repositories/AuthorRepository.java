package test.springframework.sprintWebapp.repositories;

import org.springframework.data.repository.CrudRepository;
import test.springframework.sprintWebapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
