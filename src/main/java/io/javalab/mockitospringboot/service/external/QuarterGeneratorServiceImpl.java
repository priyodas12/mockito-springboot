package io.javalab.mockitospringboot.service.external;

public class QuarterGeneratorServiceImpl implements QuarterGeneratorService{
    public Integer [] retrieveFirstQuarter(){
        return new Integer[]{1,2,3};
    }
    public Integer [] retrieveSecondQuarter(){
        return new Integer[]{4,5,6};
    }
    public Integer [] retrieveThirdQuarter(){
        return new Integer[]{7,8,9};
    }
    public Integer [] retrieveFourthQuarter(){
        return new Integer[]{10,11,12};
    }
}
