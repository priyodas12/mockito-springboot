package io.javalab.mockitospringboot.service;

import java.util.Arrays;

public class SomeBusinessImpl {
    public int calculateSum(Integer [] intArray){
       return Arrays.stream(intArray).mapToInt(Integer::intValue).sum();
    }
}
