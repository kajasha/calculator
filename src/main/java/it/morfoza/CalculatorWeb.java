package it.morfoza;

import spark.Spark;

import java.util.function.BiFunction;

public class CalculatorWeb {



    public static void main(String[] args) {

        Spark.get(
                "/calculator",
                (reqest, response) -> {return "<html>Hi <b> buddy </b>!</html>";}
                );
        Spark.get(
                "/contact",
                ((request, response) -> {
                    return "<html>" +
                            "<form action=\"/calculator\">" +
                            "<input name=\"number1\">" +
                            "<input name=\"number2\">" +
                            "<input type=\"submit\">" +
                            "</form>" +
                            "<html>";
                }



        ));
    }
}
