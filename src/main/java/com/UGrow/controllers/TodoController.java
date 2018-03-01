package com.UGrow.controllers;

import com.UGrow.models.data.TodoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Calendar;

@Controller
public class TodoController extends AbstractController {

    @Autowired
    private TodoDao todoDao;

    @RequestMapping(value = "/todo", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {

        model.addAttribute("title", "U-Grow Todo");
        model.addAttribute("todo", todoDao.findAll());
        model.addAttribute("sessionOn", isSessionActive(request.getSession()));
        return "todo";
    }


}