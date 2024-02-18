package org.example.model;

import org.example.service.Calculable;

public final class Calculator implements Calculable {

    private ComplexNumber primaryArg;

    public Calculator(ComplexNumber primaryArg) {
        this.primaryArg = primaryArg;
    }

    @Override
    public Calculable sum(ComplexNumber arg) {
        String beforeChange = primaryArg.toString();
        primaryArg = new ComplexNumber(primaryArg.getReal() + arg.getReal(),
                primaryArg.getImaginary() + arg.getImaginary());
        History.addEntry(beforeChange + " + " + arg.toString() + " = " + primaryArg.toString());
        return this;
    }

    @Override
    public Calculable multi(ComplexNumber arg) {
        String beforeChange = primaryArg.toString();
        double real = primaryArg.getReal() * arg.getReal() - primaryArg.getImaginary() * arg.getImaginary();
        double imaginary = primaryArg.getReal() * arg.getImaginary() + primaryArg.getImaginary() * arg.getReal();
        primaryArg = new ComplexNumber(real, imaginary);
        History.addEntry(beforeChange + " * " + arg.toString() + " = " + primaryArg.toString());
        return this;
    }

    @Override
    public Calculable divide(ComplexNumber arg) {
        String beforeChange = primaryArg.toString();
        double denominator = arg.getReal() * arg.getReal() + arg.getImaginary() * arg.getImaginary();
        double real = (primaryArg.getReal() * arg.getReal() + primaryArg.getImaginary() * arg.getImaginary()) / denominator;
        double imaginary = (primaryArg.getImaginary() * arg.getReal() - primaryArg.getReal() * arg.getImaginary()) / denominator;
        primaryArg = new ComplexNumber(real, imaginary);
        History.addEntry(beforeChange + " / " + arg.toString() + " = " + primaryArg.toString());
        return this;
    }

    @Override
    public ComplexNumber getResult() {
        return primaryArg;
    }
}