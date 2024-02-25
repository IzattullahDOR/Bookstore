package sof03.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sof03.bookstore.domain.Book;
import sof03.bookstore.domain.BookRepository;
import sof03.bookstore.domain.CategoryRepository;

@Controller
public class BookController {

    @Autowired
    private BookRepository repository; 
    @Autowired
    private CategoryRepository cRepository;

    @RequestMapping(value = "/booklist", method = RequestMethod.GET)    
    public String bookList(Model model) {

        model.addAttribute("books", repository.findAll());
        // http://localhost:8080/booklist

        return "booklist"; // booklist.html
    }

    // This Deletes Books from list
    @RequestMapping(value ="/delete/{id}", method=RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model){
        repository.deleteById(bookId);
        return "redirect:../booklist";
    }

    // Add new book
    @GetMapping("/addbook")
    public String addBook(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("categories", cRepository.findAll());
        
        return "addbook";  //addbook.html
    }

    // Save new book
    @PostMapping("/save")
    public String save(Book book){
        repository.save(book);
        return "redirect:booklist";
    }

}
