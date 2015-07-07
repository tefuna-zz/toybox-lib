package com.tefuna.toybox.fizzbuzz;

public class Fizzbuzz {

    private static int FIZZ = 3;
    private static int BUZZ = 5;

    public void printFizzBuzz(int upto) {

        if (upto < 3) {
            System.out.println("upto is too small. should be over 3.");
            return;
        }

        for (int i = 2; i <= upto; i++) {

            if (i % Fizzbuzz.FIZZ == 0 && i % Fizzbuzz.BUZZ == 0) {
                System.out.println("i = " + i + ":FIZZBUZZ.");
                continue;
            } else if (i % Fizzbuzz.FIZZ == 0) {
                System.out.println("i = " + i + ":FIZZ.");
                continue;
            } else if (i % Fizzbuzz.BUZZ == 0) {
                System.out.println("i = " + i + ":BUZZ.");
                continue;
            } else {
                // no operation.
            }
        }

        return;
    }
}
