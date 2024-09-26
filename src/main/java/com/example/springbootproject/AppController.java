package com.example.springbootproject;

import java.util.List; // Импортируем коллекцию (класс списков)
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
    @Autowired
    private bookService service;
    @RequestMapping("/")
    public String viewHomePage(Model model,
                               @RequestParam(value = "keyword", required = false) String keyword,
                               @RequestParam(value = "sortOrder", required = false) String sortOrder,
                               @RequestParam(value = "sortField", required = false) String sortField) {
        List<Book> listBooks = service.listAll(keyword, sortField, sortOrder);
        model.addAttribute("listBooks", listBooks);
        model.addAttribute("keyword", keyword);
        model.addAttribute("sortOrder", sortOrder);
        model.addAttribute("sortField", sortField);
        return "index";
    }
    @RequestMapping("/new") // Добавление студента
    public String showNewBookForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "new_book";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute("book") Book book) {
        service.save(book);
        return "redirect:/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditBookForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_book");
        Book book = service.get(id);
        mav.addObject("book", book);
        return mav;
    }
    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
}
