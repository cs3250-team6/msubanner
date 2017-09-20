package edu.msudenver.cs3250.group6.msubanner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


// the purpose here is to get a mapping to the index.html in templates
// from: https://spring.io/blog/2016/11/21/the-joy-of-mustache-server-side-templates-for-the-jvm
//       https://springframework.guru/spring-boot-web-application-part-2-using-thymeleaf/
// TODO: make it work for /index.html too
@Controller
class HomeController {
  @RequestMapping("/")
  String index() {
    return "index";
  }
}