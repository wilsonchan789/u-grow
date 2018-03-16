package com.UGrow.controllers;

import com.UGrow.models.Todo;
import com.UGrow.models.data.TodoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Calendar;

@Controller
@RequestMapping(value = "todo")
public class TodoController extends AbstractController {

    @Autowired
    private TodoDao todoDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, int id, HttpServletRequest request) {

        Todo todo = todoDao.findOne(id);
        model.addAttribute("title", "U-Grow Todo");
        model.addAttribute("todo", todo);
        model.addAttribute("sessionOn", isSessionActive(request.getSession()));
        return "todo-detail";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model, HttpServletRequest request) {
        model.addAttribute("title", "Add Todo");
        model.addAttribute(new Todo());
        model.addAttribute("sessionOn", isSessionActive(request.getSession()));
        return "new-todo";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Todo todo, Errors errors, HttpServletRequest request) {

        model.addAttribute("sessionOn", isSessionActive(request.getSession()));
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Todo");
            model.addAttribute(todo);
            return "new-todo";
        }
        todo.setAuthor(getUserFromSession(request.getSession()));
        todoDao.save(todo);
        return "redirect:/todo/?id=" + todo.getId();
    }

}