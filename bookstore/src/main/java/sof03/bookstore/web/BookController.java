package sof03.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sof03.bookstore.domain.Book;
import sof03.bookstore.domain.BookRepository;

@Controller
public class BookController {

    @Autowired
    private BookRepository repository; 

    @RequestMapping(value = "/booklist", method = RequestMethod.GET)    
    public String bookList(Model model) {

        model.addAttribute("Books", repository.findAll());
        // http://localhost:8080/booklist

        return "booklist"; // booklist.html
    }

    // This Deletes Books from list
    @RequestMapping(value ="/delete/{id}", method=RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model){
        repository.deleteById(bookId);
        return "redirect:../booklist";
    }

    // Add new student
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addBook(Model model){
       model.addAttribute("book", new Book());
       return "addbook"; 
    }

    // Save new student
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        repository.save(book);
        return "redirect:booklist";
    }
}
