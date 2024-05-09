package com.myorg.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello How aafdsfre your buddy!!";
    }


    @RequestMapping("/hello-html")
    @ResponseBody
    public String helloHTML(){
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title> My first HTML Page</title>");
        sb.append("</head>");
        sb.append("<body> My first html page body </body>");
        sb.append("</html>");

        return sb.toString();
    }

    @RequestMapping("/hello-jsp")
    public String helloJsp(){
        return "sayHello";
    }



}
