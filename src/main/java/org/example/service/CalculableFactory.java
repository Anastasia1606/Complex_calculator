package org.example.service;

import org.example.model.Calculator;
import org.example.model.ComplexNumber;

public class CalculableFactory implements ICalculableFactory {
    public Calculable create(ComplexNumber primaryArg) {
        return new Calculator(primaryArg);
    }
}
