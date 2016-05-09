/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testwithannotations;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import testwithannotations.test.Tests;

/**
 *
 * @author RolfMoikjær
 */
public class RetrieveAnnotations {

    public List<TestClassDef> getMethods(Class... classes) {

        List<TestClassDef> definations = new ArrayList();

        for (Class klass : classes) {
            try {
                Object object = klass.newInstance();

                if (object != null) {
                    TestClassDef def = new TestClassDef();
                    def.object = object;

                    for (Method method : klass.getDeclaredMethods()) {
                        if (method.isAnnotationPresent(TestAnnotation.class)) {
                            def.methods.add(method);
                        }
                    }

                    definations.add(def);
                }
            } catch (InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(RetrieveAnnotations.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return definations;
    }

    public class TestClassDef {

        public Object object;
        public List<Method> methods = new ArrayList<>();
    }
}
