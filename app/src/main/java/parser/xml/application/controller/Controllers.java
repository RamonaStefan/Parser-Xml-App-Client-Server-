package parser.xml.application.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.thymeleaf.context.WebContext;
import parser.xml.application.model.Angajat;
import parser.xml.application.model.Echipa;
import parser.xml.application.model.FunctionalClass;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class Controllers extends FunctionalClass {

    @RequestMapping(value="/")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping(value="/home")
    public String home(Model model) {
        model.addAttribute("angajat", getNumeAngajati(sistem.getAngajati()));
        model.addAttribute("echipa", getNumeEchipe(sistem.getEchipe()));
        model.addAttribute("proiect", getNumeProiecte(sistem.getProiecte()));
        return "home";
    }

    @RequestMapping(value="/results")
    public String results(Model model, HttpServletRequest request) {
        List results = getResults(request);
        if(results != null) {
            model.addAttribute("results", results);
        }
        return "results";
    }
}
