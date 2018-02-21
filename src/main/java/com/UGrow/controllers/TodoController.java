package com.UGrow.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Calendar;

@Controller
public class TodoController extends AbstractController {

    @RequestMapping(value = "/todo")
    public String index(Model model, HttpServletRequest request) {

        model.addAttribute("title", "U-Grow Todo");
        //add calander
        model.addAttribute();
        model.addAttribute("sessionOn", isSessionActive(request.getSession()));
        return "todo";
    }

//    Calendar date= Calendar.getInstance();
//    ArrayList<Calendar> dates = new ArrayList<>();
//
//    for (int i=0; i<10; i++) {
//        date.add(Calendar.WEEK_OF_YEAR, 4);
//        // Create new instance of cal
//        Calendar tmp= Calendar.getInstance();
//        //Makes its inner values the same
//        tmp.setTime(date.getTime());
//        // Add unique instance to list
//        dates.add(tmp);
//    }

}