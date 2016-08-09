package it.morfoza;

import spark.ModelAndView;
import spark.Spark;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.Map;

public class CalculatorSpark {


    public static void runOnSpark (String[] args) {

        Spark.staticFileLocation("/webfiles");

        String port = System.getenv("PORT");
        if (port != null) {
            int portInt = Integer.parseInt(port);
            Spark.port(portInt);
        }

        Spark.get(
                "/calculator",
                (request, response) -> {
                    String number1 = request.queryParams("number1");
                    String number2 = request.queryParams("number2");
                    String operation = request.queryParams("operation");

                    int number1a = Integer.parseInt(number1);
                    int number2a = Integer.parseInt(number2);

                    int result;
                    if(operation.equals("+")) {
                        result = Calculator.add(number1a, number2a);
                    } else {

                        result = Calculator.subtract(number1a, number2a);
                    }



                    Map<String, Object> model = new HashMap();
                    model.put("result", result);


                    return new ModelAndView(model, "result.ftl");
                }, new FreeMarkerEngine());


//        Spark.get(
//                "/contact",
//                ((request, response) -> {
//                    return "<html>" +
//                            "<form action=\"/calculator\">" +
//                            "<input name=\"number1\">" +
//                            "<input name=\"number2\">" +
//                            "<input type=\"submit\">" +
//                            "</form>" +
//                            "<html>";
//                }));
        Spark.get(
                "/calculator2",
                (reqest, response) -> {
                    String number1 = reqest.queryParams("number1");
                    String number2 = reqest.queryParams("number2");

                    int number1a = Integer.parseInt(number1);
                    int number2a = Integer.parseInt(number2);

                    int result = number1a * number2a;

                    Map<String, Object> model = new HashMap();
                    model.put("result", result);
                    model.put("number1", number1);
                    model.put("number2", number2);

                    return new ModelAndView(model, "result.ftl");
                }, new FreeMarkerEngine());

        Spark.get(
                "/contact2",
                ((request, response) -> {
                    return "<html>" +
                            "<form action=\"/calculator2\">" +
                            "<input name=\"number1\">" +
                            "<input name=\"number2\">" +
                            "<input type=\"submit\">" +
                            "</form>" +
                            "<html>";
                }));
        Spark.get(
                "/calculator3",
                (reqest, response) -> {

                    Map<String, Object> model = new HashMap();
                    model.put("name", "lucyna" );
                    model.put("surname", "Kowalska");

                    return new ModelAndView(model, "user.ftl");
                }, new FreeMarkerEngine());

        Spark.get(
                "/sparktest",
                (request, response) -> {


                    Map<String, Object> model = new HashMap();


                    return new ModelAndView(model, "test.ftl");
                },
                new FreeMarkerEngine());


        Spark.get(
                "/contact3",
                ((request, response) -> {
                    return "<html>" +
                            "<form action=\"/calculator3\">" +
                            "<input name=\"name\">" +
                            "<input name=\"surname\">" +
                            "<input type=\"submit\">" +
                            "</form>" +
                            "<html>";
                }));
        Spark.get(
                "/rejestracja",
                (reqest, response) -> {
                    String name = reqest.queryParams("name");
                    String surname = reqest.queryParams("surname");
                    String user = "Pan " + name + " : " + surname;


                    Map<String, Object> model = new HashMap();
                    model.put("atrybut", user);


                    return new ModelAndView(model, "user.ftl");
                }, new FreeMarkerEngine());
    }




}
