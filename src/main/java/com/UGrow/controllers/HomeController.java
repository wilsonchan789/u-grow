package com.UGrow.controllers;

import com.UGrow.models.Todo;
import com.UGrow.models.User;
import com.UGrow.models.data.TodoDao;
import com.UGrow.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class HomeController extends AbstractController {

    @Autowired
    private TodoDao todoDao;

    @RequestMapping(value = "/")
    public RedirectView index(Model model, HttpServletRequest request) {
        model.addAttribute("title", "U-Grow");
        model.addAttribute("sessionOn", isSessionActive(request.getSession()));
        return new RedirectView("home");
    }
    @RequestMapping(value= "/home")
    public String displayHome(Model model, int id, HttpServletRequest request) {
        Todo todo = todoDao.findOne(id);
        model.addAttribute("todo", todo);
        User user = getUserFromSession(request.getSession());
        String username =  user.getUsername();
        model.addAttribute("username", username);
        model.addAttribute("sessionOn", isSessionActive(request.getSession()));
        return "home";
    }

}
