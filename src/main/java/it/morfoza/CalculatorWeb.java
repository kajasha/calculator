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
                (reqest, response) -> {
                    String number1 = reqest.queryParams("number1");
                    String number2 = reqest.queryParams("number2");

                    int number1a = Integer.parseInt(number1);
                    int number2a = Integer.parseInt(number2);

                    int result = number1a + number2a;

                    return "<html> <h1> <font color=\"#0000FF\"> Sialalalala </h1> </font> <b> Your numbers: </b>"
                            + number1
                            + ","
                            + number2
                            + "and the result is...."
                            + result
                            + "</html>";

                });

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
