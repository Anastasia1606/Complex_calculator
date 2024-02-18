package org.example.view;

import java.util.Scanner;

public class ViewCalculator {

    private Scanner in;

    public ViewCalculator() {
        this.in = new Scanner(System.in);
    }

    public void print(String message) {
        System.out.println(message);
    }

    public String prompt(String message) {
        System.out.print(message);
        return in.nextLine();
    }

    public Double promptDouble(String message) {
        System.out.print(message);
        try {
            return Double.parseDouble(in.nextLine());
        } catch (NumberFormatException e) {
            prompt("Необходимо ввести вещественное число.");
            return null;
        }
    }
}
