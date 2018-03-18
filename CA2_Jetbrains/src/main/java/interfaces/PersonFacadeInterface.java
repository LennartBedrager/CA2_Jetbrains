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

    public Person updatePerson(Person person, int id);

    public Person deletePerson(int id);

    public List<Person> getAllPersons();

    public List<Person> getPersonsViaZipcode(int zip);
    
    public Person getPersonByPhone(String phone);
    
    public List<Person> getPersonsViaFirstName(String fname);

    public List<Person> getPersonsViaLastName(String lname);
}
