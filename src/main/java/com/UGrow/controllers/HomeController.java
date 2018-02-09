package com.UGrow.controllers;

import com.UGrow.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController extends AbstractController {

    @RequestMapping(value = "/")
    public String index(Model model, HttpServletRequest request) {

        model.addAttribute("title", "U-Grow");
        model.addAttribute("sessionOn", isSessionActive(request.getSession()));
        return "index";
    }

}
