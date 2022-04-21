package com.dinobotica.paletas.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControladorPrincipal {

    @RequestMapping("")
    public String index()
    {
        return "index/index.jsp";
    }
    
}
