package org.launchcode.hellospring.controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {

    @RequestMapping(value = "")
    @ResponseBody
    public String index(HttpServletRequest request) {

        String name = request.getParameter("name");

        if (name == null) {
            name = "World";
        }

        return "Hello " + name;
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm() {
        String html = "<form method='post'>" +
                "<input type='text' name='name' />" +
                "<select name='language'>" +
                    "<option value='english' selected>English</option>" +
                    "<option value='chinese'>Chinese</option> " +
                    "<option value='spanish'>Spanish</option> " +
                    "<option value='japanese'>Japanese</option> " +
                    "<option value='french'>French</option> " +
                "</select>" +
                "<input type='submit' value='Greet Me!'/>" +
                "</form>";
        return html;
    }

    @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request) {
        String name = request.getParameter("name");
        return "Hello " + name;
    }

    public static createMessage(HttpServletRequest request) {
        String lang = request.getParameter("language");
        String name = request.getParameter("name");
        if (lang.equals("english")) {
            return "Hello " + name;
        } else if (lang.equals("chinese")) {
            return "Nǐ hǎo " + name;
        } else if (lang.equals("spanish")) {
            return "Hola " + name;
        } else if (lang.equals("japanese")) {
            return "Kon'nichiwa " + name;
        } else {
            return "Bonjour " + name;
        }

    }

    @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "goodbye")
    public String goodbye() {
        return "redirect:/";
    }

}
