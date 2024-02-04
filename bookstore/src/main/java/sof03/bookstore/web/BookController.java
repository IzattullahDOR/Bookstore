package sof03.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {

    @RequestMapping(value = "/kirjakauppa", method = RequestMethod.GET)
    public String kirjakauppa() {

        // http://localhost:8080/kirjakauppa

        return "kauppa"; // kauppa.html
    }

}
