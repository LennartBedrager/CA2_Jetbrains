/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entity.Person;
import java.util.List;

public interface PersonFacadeInterface {

    public void createPerson(Person person);

    public Person getPerson(int id);

    public void updatePerson(Person person);

    public void deletePerson(int id);

    public List<Person> getAllPersons();

    //public List<Person> getPersonsViaZipcode(int zip);

}
