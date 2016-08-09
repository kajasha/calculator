package it.morfoza;

public class CalculatorMain {

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("text")) {
            CalculatorConsole.runOnConsole(args);
        } else {
            //CalculatorSpark.runOnSpark(args);
            CalculatorSpringBoot.runOnSpringBoot(args);
        }
    }
}
