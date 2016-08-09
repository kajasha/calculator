package it.morfoza;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CalculatorController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
