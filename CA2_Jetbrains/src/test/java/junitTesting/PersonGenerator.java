/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junitTesting;

import entity.Person;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KnaldeKalle
 */
public class PersonGenerator {
    
     public List<String> generate(int numberOfData, int startFrom){
        ArrayList<String> generatedFirstNames = this.firstName();
        ArrayList<String> generatedLastNames = this.lastName();
        ArrayList<String> generatedSQLData = new ArrayList();
        
        int randomNumberFirst;
        int randomNumberLast;
        int index = startFrom;
        
        
        while(generatedSQLData.size() <= numberOfData){
            randomNumberFirst = (int) (Math.random() * generatedFirstNames.size());
            randomNumberLast = (int) (Math.random() * generatedLastNames.size());
            
            generatedSQLData.add(
                    "INSERT INTO INFOENTITY (ID) VALUES ("+index+");" +
                    "INSERT INTO PERSON (FIRSTNAME,LASTNAME) VALUES ('"+generatedFirstNames.get(randomNumberFirst)+"','"+generatedLastNames.get(randomNumberLast)+"');");
            index++;
        }
        return generatedSQLData;
    }
    
    private ArrayList<String> firstName() {
        ArrayList<String> firstNames = new ArrayList();
        firstNames.add("Kasper");
        firstNames.add("David");
        firstNames.add("Oliver");
        firstNames.add("Lars");
        firstNames.add("Sigurt");
        firstNames.add("Joachim");
        firstNames.add("Kristian");
        firstNames.add("Christian");
        firstNames.add("Henrik");
        return firstNames;
    }

    private ArrayList<String> lastName() {
        ArrayList lastNames = new ArrayList();
        lastNames.add("Hansen");
        lastNames.add("Larsen");
        lastNames.add("Vink");
        lastNames.add("Nielsen");
        lastNames.add("Devil");
        lastNames.add("Black");
        lastNames.add("White");
        return lastNames;
    }
    
}
