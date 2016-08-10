package it.morfoza;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CalculatorController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/calculator_form")
    public String calculator_form() {
        return "calculator_form";
    }

    @RequestMapping("/calculator")
    public String calculator (
        @RequestParam("number1") Integer number1,
        @RequestParam("number2") Integer number2,
        @RequestParam(value = "operation", required = false, defaultValue = "dodawanie") String operation, Model model) {


        int result;

        if (operation.equals("dodawanie")) {
            result = Calculator.add(number1, number2);
        } else {
            if (operation.equals("odejmowanie")) {
                result = Calculator.subtract(number1, number2);
            } else {
                throw new RuntimeException("błędna operacja "+operation);
            }
        }

        model.addAttribute( "resultOfOperation", result);
        return "result";
    }
}
