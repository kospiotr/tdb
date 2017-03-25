package pl.xperios.tdb.web.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@PreAuthorize("hasAuthority('TDB.homepage.read')")
public class IndexController {
//
//    @RequestMapping(value = "/")
//    public String slash(Model model) {
//        return "forward:index.html";
//    }
//
//    @RequestMapping(value = "/index.html")
//    public String index(Model model) {
//        return "index";
//    }

    @RequestMapping(value = "/api-doc")
    public String apiDoc(Model model) {
        return "redirect:/api-doc/index.html";
    }

}