package sof03.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sof03.bookstore.domain.Book;
import sof03.bookstore.domain.Category;
import sof03.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {


    @Autowired
    private CategoryRepository cRepository;

    // Shows All categories from categorylist
    @GetMapping("/categorylist")
    public String categorylist( Model model) {

        model.addAttribute("categories", cRepository.findAll());
        return "categorylist"; // categorylist.html
    }

    // Add categories
    @GetMapping("/addcategory")
    public String addcategory(Model model) {

        model.addAttribute("category",new Category());
        return "/addcategory"; //addcategory.html
    }

    // Save new category
    @PostMapping("/savecategory")
    public String save(Category category){
        cRepository.save(category);
        return "redirect:categorylist";
    }

    
}
