package io.javalab.mockitospringboot.service;

import io.javalab.mockitospringboot.service.external.QuarterGeneratorServiceImpl;

import java.util.Arrays;

public class TaxCalculation {

    private QuarterGeneratorServiceImpl quarterGeneratorServiceImpl;

    public TaxCalculation(QuarterGeneratorServiceImpl quarterGeneratorServiceImpl) {
        this.quarterGeneratorServiceImpl = quarterGeneratorServiceImpl;
    }

    public TaxCalculation() {

    }

    public Integer calculateTaxPerAnnual(int [] quarters){
        return Arrays.stream(quarters).mapToObj(Integer::new).reduce(Integer::sum).orElseThrow(ArithmeticException::new);
    }

    public Integer calculateTaxPerQuarter (int quarterNumber)throws Exception{
        Integer result;
        switch (quarterNumber){
            case 1:
                result=Arrays.asList(quarterGeneratorServiceImpl.retrieveFirstQuarter()).stream().reduce((integer, integer2) -> integer+integer2).orElseThrow(ArithmeticException::new);
            case 2:
                result=Arrays.asList(quarterGeneratorServiceImpl.retrieveSecondQuarter()).stream().reduce((integer, integer2) -> integer+integer2).orElseThrow(ArithmeticException::new);
            case 3:
                result=Arrays.asList(quarterGeneratorServiceImpl.retrieveThirdQuarter()).stream().reduce((integer, integer2) -> integer+integer2).orElseThrow(ArithmeticException::new);
            case 4:
                result=Arrays.asList(quarterGeneratorServiceImpl.retrieveFourthQuarter()).stream().reduce((integer, integer2) -> integer+integer2).orElseThrow(ArithmeticException::new);
            default:
                result=Arrays.asList(quarterGeneratorServiceImpl.retrieveFirstQuarter()).stream().reduce((integer, integer2) -> integer+integer2).orElseThrow(ArithmeticException::new);

        }
        return result;
    }
}
