package io.javalab.mockitospringboot.service;

import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SomeBusinessImplTest {

    @BeforeAll
    static void systemConfig(){
        System.out.println("Avl Processor:: "+Runtime.getRuntime().availableProcessors());
    }

    @RepeatedTest(5)
    void freeSystemBytes(){
        System.out.println("Free Byte:: "+Runtime.getRuntime().freeMemory());
    }


    @BeforeEach
    void printTimestamp(){
        System.out.println("Time::  "+LocalDateTime.now());
    }

    @AfterEach
    void printExecutionStatus(){
        System.out.println("--------DONE--------");
    }



    @Test
    @Order(2)
    @DisplayName("BASIC TEST CASE:WITH NON NULL ARRAY")
    void calculateSum_Basic() {

        SomeBusinessImpl someBusiness=new SomeBusinessImpl();
        Integer actualResult=someBusiness.calculateSum(new Integer[]{2,9,5});
       // System.out.println(actualResult);
        Integer expectedResult=16;
        assertEquals(expectedResult,actualResult);
    }

    @Test
    @Order(1)
    @DisplayName("BASIC TEST CASE:WITH NULL ARRAY")
    void calculateSum_EmptyArray() {

        SomeBusinessImpl someBusiness=new SomeBusinessImpl();
        Integer actualResult=someBusiness.calculateSum(new Integer[]{});
        Integer expectedResult=0;
        assertEquals(expectedResult,actualResult);
    }

    //@Disabled:for non executing test method;
}