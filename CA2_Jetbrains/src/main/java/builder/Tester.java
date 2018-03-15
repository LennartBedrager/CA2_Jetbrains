/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

import RestApi.RestPersons;
import RestFacade.RestPersonFacade;
import entity.Person;
import java.util.List;

/**
 *
 * @author Oliver
 */
public class Tester {
    public static void main(String[] args) {
        
        RestPersons rp = new RestPersons();
        
        String persons = rp.getAllPersons();
//        List<Person> persons = RestPersonFacade.getAllPets();
        System.out.println(persons);
        
        Person person = RestPersonFacade.getPersonById(3);
        System.out.println(person.getFirstName());
        
    }
}
