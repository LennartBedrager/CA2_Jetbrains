/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

import RestApi.RestPersons;
import entity.Person;
import facade.PersonFacadeImpl;
import java.util.List;

/**
 *
 * @author Oliver
 */
public class Tester {
    public static void main(String[] args) {
    
        RestPersons rp = new RestPersons();
        PersonFacadeImpl pfi = new PersonFacadeImpl();
        
        System.out.println(rp.getAllPersons());
        Person p = pfi.getPerson(51);
        System.out.println(p.getFirstName());
        
        //System.out.println(rp.getPersonById(51));
    }
}
