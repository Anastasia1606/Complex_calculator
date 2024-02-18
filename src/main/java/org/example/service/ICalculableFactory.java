package org.example.service;

import org.example.model.ComplexNumber;

public interface ICalculableFactory {
    Calculable create(ComplexNumber primaryArg);
}
