package facade;

import entity.Person;
import interfaces.PersonFacadeInterface;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * Facade for persisting and removing entities of the Person class
 *
 * @author KnaldeKalle
 */
public class PersonFacadeImpl implements PersonFacadeInterface {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jetbrainsDatabase");

    EntityManager em;

    //C
    @Override
    public void createPerson(Person person) {
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    //R
    @Override
    public Person getPerson(int id) {
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("SELECT p FROM Person p WHERE p.id = :id");
            q.setParameter("id", id);
            em.getTransaction().commit();
            Person person = (Person) q.getSingleResult();
            return person;
        } finally {
            em.close();
        }
    }

    //U
    /*@Override
    public void updatePerson(Person person, int id) {
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("UPDATE Person p SET p.firstName ='" + person.getFirstName() + "', p.lastName ='" + person.getLastName() + " WHERE p.id = :id");
            q.setParameter("id", id);
            q.executeUpdate();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    } */

    //U
    @Override
    public void updatePerson(Person person) {
        EntityManager em = emf.createEntityManager();
        Person p = em.find(Person.class, person.getId());
        try {
            em.getTransaction().begin();
            p.setFirstName(person.getFirstName());
            p.setLastName(person.getLastName());
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    //D
    @Override
    public void deletePerson(int id) {
        em = emf.createEntityManager();
        Person person = em.find(Person.class, id);
        try {
            em.getTransaction().begin();
            em.remove(person);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Person> getAllPersons() {
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("Select p from Person p");
            em.getTransaction().commit();
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    /*@Override
    public List<Person> getPersonsViaZipcode(int zip) {
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("Select c from InfoEntity c WHERE c.zip = :zip");
            q.setParameter("zip", zip);
            em.getTransaction().commit();
            return q.getResultList();
        } finally {
            em.close();
        }
    } */
}
