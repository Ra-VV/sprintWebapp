package test.springframework.sprintWebapp.repositories;

import org.springframework.data.repository.CrudRepository;
import test.springframework.sprintWebapp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
