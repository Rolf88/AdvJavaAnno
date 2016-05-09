/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testwithannotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import testwithannotations.RetrieveAnnotations.TestClassDef;
import testwithannotations.test.Tests;

/**
 *
 * @author RolfMoikjær
 */
public class TestWithAnnotations {

    private static final Calculator calc = new Calculator();
    private static final RetrieveAnnotations retrieve = new RetrieveAnnotations();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

//        System.out.println("Adding result is: " + calc.adding(5.0, 12.5));
//        System.out.println("Subtract result is: " + calc.subtract(10, 5));
//        System.out.println("Multiplying result is: " + calc.multiplying(5, 5));
//        System.out.println("Dividing result is: " + calc.dividing(10, 2));
        for (TestClassDef testDef : retrieve.getMethods(Tests.class, Tests.class)) {
            for (Method m : testDef.methods) {
                try {
                    System.out.println(m.getName() + m.invoke(testDef.object));
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    Logger.getLogger(TestWithAnnotations.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
