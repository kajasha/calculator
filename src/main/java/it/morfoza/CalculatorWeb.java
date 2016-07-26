package it.morfoza;

import spark.Spark;

import java.util.function.BiFunction;

public class CalculatorWeb {



    public static void main(String[] args) {

        String port = System.getenv("PORT");
        if (port != null) {
            int portInt = Integer.parseInt(port);
            Spark.port(portInt);
        }

        Spark.get(
                "/calculator",
                (reqest, response) -> {return "<html> <h1> Sialalalala </h1> <b> lalalalala </b>!</html>";}
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
