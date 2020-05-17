package java11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Factorial {

    public static void main(String[] args) {
        if(args.length != 1) throw new RuntimeException("Please provide 1 number");

        int number = Integer.parseInt(args[0]);
        System.out.println("Answer: " + calculateFactorial(number));
    }

    public static int calculateFactorial(int number) {
        if(number < 0) throw new RuntimeException("number must be positive");

        if(number == 0) return 1;
        if(number == 1) return 1;
        if(number == 2) return 2;
        else return calculateFactorial(number-1) * number;
    }
}
