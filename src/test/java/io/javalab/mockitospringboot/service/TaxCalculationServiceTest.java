package io.javalab.mockitospringboot.service;

import io.javalab.mockitospringboot.service.external.QuarterGeneratorService;
import io.javalab.mockitospringboot.service.external.QuarterGeneratorServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TaxCalculationServiceTest {

    @Test
    void calculateTaxPerQuarter() throws Exception {

        QuarterGeneratorService service=mock(QuarterGeneratorServiceImpl.class);
        TaxCalculation taxCalculation=new TaxCalculation();
        taxCalculation.setQuarterGeneratorService(service);
        when(taxCalculation.calculateTaxPerQuarter(1)).thenReturn(new Integer[]{4,5,6});
        Optional<Integer> actualResult= Arrays.stream(taxCalculation.calculateTaxPerQuarter(1)).reduce(Integer::sum);
        int expectedResult=15;
        assertEquals(expectedResult,actualResult.get());
    }
}