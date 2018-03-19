/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnitTestDatabase;

import entity.Person;
import facade.PersonFacadeImpl;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oliver
 */
public class DatabaseTests {

    PersonFacadeImpl con = new PersonFacadeImpl();
    JavaMethodsForTesting data = new JavaMethodsForTesting();

    public DatabaseTests() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    //TestConnection
    public void testConnectionToDatabase() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jetbrainsDatabase");
        assertTrue(emf.isOpen());
    }
    
    //CRUD
    @Test
    public void TestCRUD() {
        
        //C
        con.createPerson(new Person("Test", "Machine"));

        //R
        Person getPerson = data.getPerson("Test", "Machine");
        assertEquals("Test", getPerson.getFirstName());
        assertEquals("Machine", getPerson.getLastName());

        //U
        con.updatePerson(new Person("newFName", "newLName"), 61);
        Person getUpdatedPerson = data.getPerson("newFName", "newLName");
        assertEquals("newFName", getUpdatedPerson.getFirstName());
        assertEquals("newLName", getUpdatedPerson.getLastName());
        
        //D
        con.deletePerson(61);

    }

}
