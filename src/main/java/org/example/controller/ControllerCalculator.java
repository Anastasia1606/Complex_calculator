package org.example.controller;

import org.example.model.ComplexNumber;
import org.example.model.History;
import org.example.service.Calculable;
import org.example.service.ICalculableFactory;
import org.example.view.ViewCalculator;

import java.util.List;

public class ControllerCalculator {

    private ICalculableFactory calculableFactory;
    private ViewCalculator view;
    public ControllerCalculator(ICalculableFactory calculableFactory) {
        this.calculableFactory = calculableFactory;
        view = new ViewCalculator();
    }

    public void run() {
        ComplexNumber inputComplexNumber;
        String cmd;
        while (true) {
            inputComplexNumber = inputComplexNumber();
            Calculable calculator = calculableFactory.create(inputComplexNumber);
            while (true) {
                cmd = view.prompt("Введите команду (*, +, /, =) : ");
                if (cmd.equals("*")) {
                    inputComplexNumber = inputComplexNumber();
                    calculator.multi(inputComplexNumber);
                    continue;
                }
                if (cmd.equals("+")) {
                    inputComplexNumber = inputComplexNumber();
                    calculator.sum(inputComplexNumber);
                    continue;
                }
                if (cmd.equals("/")) {
                    inputComplexNumber = inputComplexNumber();
                    calculator.divide(inputComplexNumber);
                    continue;
                }
                if (cmd.equals("=")) {
                    ComplexNumber result = calculator.getResult();
                    view.print("Результат " + result.toString());
                    break;
                }
                view.print("Введена не опознная команда");
            }
            cmd = view.prompt("Рассчитать ещё (Y/N)?");
            if (cmd.equals("Y") || cmd.equals("y")) {
                view.print("------------------");
                continue;
            }
            cmd = view.prompt("Вывести историю рассчетов (Y/N)?");
            if (cmd.equals("Y") || cmd.equals("y")) {
                view.print("История рассчетов:");
                for (String elem : History.getHistory()) {
                    view.print(elem);
                }
            }
            break;
        }
    }

    private ComplexNumber inputComplexNumber() {
        Double real = view.promptDouble("Введите действительную часть аргумента: ");
        if (real == null) { return null;}
        Double imaginary = view.promptDouble("Введите мнимую часть аргумента: ");
        if (imaginary == null) { return null;}
        return new ComplexNumber(real, imaginary);
    }

}
