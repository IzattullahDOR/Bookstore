package sof03.bookstore;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sof03.bookstore.domain.Book;
import sof03.bookstore.domain.BookRepository;
import sof03.bookstore.domain.Category;
import sof03.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

@Bean
public CommandLineRunner demo(BookRepository bRepository, CategoryRepository cRepository){
	return(args) -> {
		//adding some demo data to database
		Category category1 = new Category("Scifi");
		cRepository.save(category1);
		Category category2 = new Category("Comic");
		cRepository.save(category2);
		Category category3 = new Category("Fantasy");		
		cRepository.save(category3);

		bRepository.save(new Book("EnsimmäinenKirja", "Matti Mattinen", 2024, 78634, 19.99, category1));
		bRepository.save(new Book("ToinenKirja", "Matti Partanen", 2000, 111, 11.99, category2));
		bRepository.save(new Book("KolmasKirja", "John Cena", 2010, 777, 9.90, category3));


		

		log.info("fetch all books");
		for (Book book : bRepository.findAll()) {
			log.info(book.toString());

		}
	};
}

}
