/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entity.Person;
import java.util.List;


public interface PersonFacadeInterface {

    public Person createPerson(Person person);

    public Person deletePerson(int id);

    public Person updatePerson(Person person);

    public Person getPerson(int id);

    public List<Person> getAllPersons();

}
