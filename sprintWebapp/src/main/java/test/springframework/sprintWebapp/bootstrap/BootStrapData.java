package test.springframework.sprintWebapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import test.springframework.sprintWebapp.domain.Author;
import test.springframework.sprintWebapp.domain.Book;
import test.springframework.sprintWebapp.domain.Publisher;
import test.springframework.sprintWebapp.repositories.AuthorRepository;
import test.springframework.sprintWebapp.repositories.BookRepository;
import test.springframework.sprintWebapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("Best Publisher");
        publisher.setCity("Kolobrzeg");
        publisher.setState("Zachodniopomorskie");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());

        Author linus = new Author("Linus", "Torvalds");
        Book jff = new Book( "Just for fun", "9780066620725");
        linus.getBooks().add(jff);
        jff.getAuthors().add(linus);

        jff.setPublisher(publisher);
        publisher.getBooks().add(jff);

        authorRepository.save(linus);
        bookRepository.save(jff);
        publisherRepository.save(publisher);

        Author gene = new Author("Gene", "Kim");
        Book tpp = new Book("The Phoenix Project", "9781942788300");
        gene.getBooks().add(tpp);
        tpp.getAuthors().add(gene);

        tpp.setPublisher(publisher);
        publisher.getBooks().add(tpp);

        authorRepository.save(gene);
        bookRepository.save(tpp);
        publisherRepository.save(publisher);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());

    }
}
