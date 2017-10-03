package com.faltdor.app.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.faltdor.app.model.Author;
import com.faltdor.app.model.Book;
import com.faltdor.app.model.Publisher;
import com.faltdor.app.repositories.IAuthorRepository;
import com.faltdor.app.repositories.IBookRepository;
import com.faltdor.app.repositories.IPublisherRepository;


@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{
	
	private IAuthorRepository authorRepository;
	private IBookRepository bookRepository;
	private IPublisherRepository publisherRepository;
	
	
	public DevBootstrap(IAuthorRepository authorRepository, IBookRepository bookRepository,IPublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		initData();
	}
	
	private void initData(){
		Publisher publisher = new Publisher();
        publisher.setName("Harper Collins");

        publisherRepository.save(publisher);

		Author eric = new Author("Eric", "Evans");
		Book book = new Book("Domain Driven Design", "1234", publisher);
		eric.getBooks().add(book);
		book.getAuthors().add(eric);
		
		authorRepository.save(eric);
		bookRepository.save(book);
		
		
		//Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", publisher);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
		
		
	}

}
