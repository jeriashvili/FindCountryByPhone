package levan.jeriashvili.findcountrybyphone.controller;


import org.springframework.web.bind.annotation.RequestMapping;


@org.springframework.stereotype.Controller
public class Controller {


    @RequestMapping(value = "/index")
    public String index() {
        return "index.html";
    }


}
