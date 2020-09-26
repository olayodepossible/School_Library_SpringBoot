package com.possible.springwebapp.bootstrapData;

import com.possible.springwebapp.model.Author;
import com.possible.springwebapp.model.Book;
import com.possible.springwebapp.model.Publisher;
import com.possible.springwebapp.repositories.AuthorRepository;
import com.possible.springwebapp.repositories.BookRepository;
import com.possible.springwebapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publishRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publishRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publishRepository = publishRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData(){

        Publisher publisher1 = new Publisher();
        publisher1.setName("Soyinka");
        publisher1.setAddress("Nigeria");

        publishRepository.save(publisher1);

        Publisher publisher2 = new Publisher();
        publisher2.setName("Worx");
        publisher2.setAddress("USA");
        publishRepository.save(publisher2);

        // first book
        Author soyinka = new Author("Wole",  "Soyinka");
        Book book1 = new Book("Jethro Play", "1234", publisher1 );
        soyinka.getBooks().add(book1);
        book1.getAuthors().add(soyinka);

        authorRepository.save(soyinka);
        bookRepository.save(book1);

        // second book
        Author rod = new Author("Rod",  "Johnson");
        Book book2 = new Book("J2EE Development without EJB", "22344", publisher2);
        rod.getBooks().add(book2);
        book2.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(book2);
    }
}
