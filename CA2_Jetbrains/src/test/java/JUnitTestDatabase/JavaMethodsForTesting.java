/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnitTestDatabase;

import entity.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Oliver
 */
public class JavaMethodsForTesting {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jetbrainsDatabase");

    EntityManager em;

    public Person getPerson(String fName, String lName) {
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("SELECT p "
                    + "FROM Person p "
                    + "WHERE p.firstName = :fName "
                    + "AND "
                    + "p.lastName = :lName");
            q.setParameter("fName", fName);
            q.setParameter("lName", lName);
            em.getTransaction().commit();
            if (q.getSingleResult() != null) {
                Person person = (Person) q.getSingleResult();
                return person;
            } else {
                return null;
            }
        } finally {
            em.close();
        }
    }
}
