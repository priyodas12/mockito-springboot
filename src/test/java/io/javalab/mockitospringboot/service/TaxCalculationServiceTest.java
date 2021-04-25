package io.javalab.mockitospringboot.service;

import io.javalab.mockitospringboot.service.external.QuarterGeneratorService;
import io.javalab.mockitospringboot.service.external.QuarterGeneratorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaxCalculationServiceTest {

    @InjectMocks
    TaxCalculation taxCalculation;//=new TaxCalculation();

    @Mock
    QuarterGeneratorService service;//=mock(QuarterGeneratorService.class);


    /* @BeforeEach
    public void beforeAll(){
        taxCalculation.setQuarterGeneratorService(service);
    }*/

    @Test
    void calculateTaxPerQuarter_basic() throws Exception {
        when(taxCalculation.calculateTaxPerQuarter(1)).thenReturn(new Integer[]{4,5,6});
        Optional<Integer> actualResult= Arrays.stream(taxCalculation.calculateTaxPerQuarter(1)).reduce(Integer::sum);
        int expectedResult=15;
        assertEquals(expectedResult,actualResult.get());
    }
    @Test
    void calculateTaxPerQuarter_empty() throws Exception {
        when(taxCalculation.calculateTaxPerQuarter(9)).thenReturn(new Integer[]{});
        Optional<Integer> actualResult= Optional.of(Arrays.stream(taxCalculation.calculateTaxPerQuarter(9)).reduce(Integer::sum).orElse(0));
        int expectedResult=0;
        assertEquals(expectedResult,actualResult.get());
    }
}