/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junitTesting;

import javax.persistence.Persistence;

/**
 *
 * @author KnaldeKalle
 */
public class testMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        PersonGenerator g = new PersonGenerator();

        StringBuilder builder = new StringBuilder();
        for (String value : g.generate(30, 0)) {
            builder.append(value);
        }
        String text = builder.toString();
        System.out.println(text);

    }

}
