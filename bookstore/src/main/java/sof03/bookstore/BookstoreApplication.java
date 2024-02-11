package sof03.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sof03.bookstore.domain.Book;
import sof03.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

@Bean
public CommandLineRunner demo(BookRepository repository){
	return(args) -> {
		//adding some demo data to database
		Book book1= new Book("Kirja", "Matti Mattinen", 2024, 78634, 19.99);
		Book book2= new Book("Toinen kirja", "Matti Partanen", 2022, 1234, 9.9);
		Book book3= new Book("Kolmas kirja", "Minä Itse", 2021, 876, 14.99);

		repository.save(book1);
		repository.save(book2);
		repository.save(book3);
	};
}

}
