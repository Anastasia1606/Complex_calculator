package org.example.service;

import org.example.model.ComplexNumber;

public interface Calculable {
    Calculable sum(ComplexNumber arg);
    Calculable multi(ComplexNumber arg);

    Calculable divide(ComplexNumber arg);
    ComplexNumber getResult();
}
