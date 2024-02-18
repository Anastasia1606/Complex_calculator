package org.example;

import org.example.controller.ControllerCalculator;
import org.example.service.CalculableFactory;
import org.example.service.ICalculableFactory;

public class Main {
    public static void main(String[] args) {

        ICalculableFactory calculableFactory = new CalculableFactory();
        new ControllerCalculator(calculableFactory).run();
    }
}