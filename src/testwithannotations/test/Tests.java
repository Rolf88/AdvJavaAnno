/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testwithannotations.test;

import testwithannotations.Calculator;
import testwithannotations.TestAnnotation;

/**
 *
 * @author RolfMoikjær
 */
public class Tests {

    private final Calculator calc = new Calculator();

    @TestAnnotation
    public boolean addingTest() {
        double result = calc.adding(10, 5);

        return result == 15;
    }

    @TestAnnotation
    public boolean subtractTest() {
        double result = calc.subtract(10, 5);

        return result == 5;
    }
    
    @TestAnnotation
    public boolean multiplyTest() {
        double result = calc.multiplying(10, 5);

        return result == 50;
    }
    
    @TestAnnotation
    public boolean devidingTest() {
        double result = calc.dividing(10, 5);

        return result == 2;
    }
}
