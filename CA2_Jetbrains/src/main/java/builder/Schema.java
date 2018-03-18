/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

import entity.Person;
import facade.PersonFacadeImpl;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author KnaldeKalle
 */
public class Schema {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Persistence.generateSchema("jetbrainsDatabase", null);
//        Generator pg2 = new Generator();
//        pg2.putGeneratedPeopleInDatabase(300);
//        pg2.putGeneratedCompaniesInDatabase(300);
        

    PersonFacadeImpl pfi = new PersonFacadeImpl();
    Person p = new Person("Kasper","Vink");
    pfi.updatePerson(p,272);
    

    }
    
}
