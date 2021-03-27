package io.javalab.mockitospringboot.service;

import java.util.Arrays;

public class TaxCalculation {

    public int calculateTaxPerAnnual(int [] quarters){
        return Arrays.stream(quarters).sum();
    }
}
