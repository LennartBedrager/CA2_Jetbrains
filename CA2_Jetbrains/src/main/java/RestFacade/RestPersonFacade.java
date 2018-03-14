/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestFacade;

import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Oliver
 */
public class RestPersonFacade {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jetbrainsDatabase");
    private static EntityManager em = emf.createEntityManager();

    public static List<Person> getAllPets() {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT p FROM Person p");
            em.getTransaction().commit();
            List<Person> persons = query.getResultList();
            return persons;
    }
    
    public static Person getPersonById(int id) {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT p FROM Person p WHERE p.id = :id");
            query.setParameter("id", id);
            em.getTransaction().commit();
            Person person = (Person) query.getSingleResult();
            return person;
    }
}
