package io.javalab.mockitospringboot.service;

import io.javalab.mockitospringboot.service.external.QuarterGeneratorService;
import io.javalab.mockitospringboot.service.external.QuarterGeneratorServiceImpl;

import java.util.Arrays;
import java.util.Optional;

public class TaxCalculation {

    private QuarterGeneratorService quarterGeneratorService;


    public void setQuarterGeneratorService(QuarterGeneratorService quarterGeneratorService) {
        this.quarterGeneratorService = quarterGeneratorService;
    }

    public Integer calculateTaxPerAnnual(int [] quarters){
        return Arrays.stream(quarters).mapToObj(Integer::new).reduce(Integer::sum).orElseThrow(ArithmeticException::new);
    }

    public Integer [] calculateTaxPerQuarter (Integer quarterNumber)throws Exception{

       Integer [] result;
        switch (quarterNumber){
            case 2:
                result=this.quarterGeneratorService.retrieveSecondQuarter();
                break;
            case 3:
                result=this.quarterGeneratorService.retrieveThirdQuarter();
                break;
            case 4:
                result=this.quarterGeneratorService.retrieveFourthQuarter();
                break;
            default:
                result=this.quarterGeneratorService.retrieveFirstQuarter();

        }
        return result;
    }
/*
    public static void main(String[] args) throws Exception {

        QuarterGeneratorServiceImpl s1=new QuarterGeneratorServiceImpl();
        TaxCalculation t1=new TaxCalculation(s1);
       // t1.setQuarterGeneratorService(s1);
        //System.out.println(Arrays.stream(s1.retrieveSecondQuarter()).reduce(Integer::sum));
        System.out.println(t1.calculateTaxPerQuarter(3));
    }*/
}
