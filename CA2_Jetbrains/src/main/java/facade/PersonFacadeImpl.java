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
    
    @Override
    public List<Person> getPersonsViaZipcode(int zip) {
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("select p from Person p where p.address.city.zip = :zip");
            q.setParameter("zip", zip);
            em.getTransaction().commit();
            System.out.println(q.getResultList().toString());
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
    @Override
    public Person getPersonByPhone(String phone) {
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("SELECT p FROM Person p JOIN p.phone t where t.number = :phone");
            q.setParameter("phone", phone);
            em.getTransaction().commit();
            System.out.println("Result from getPersonViaPhone: " + q.getResultList().toString());
            Person person = (Person) q.getSingleResult();
            return person;
        } finally {
            em.close();
        }
    }
    
    @Override
    public List<Person> getPersonsViaFirstName(String fname) {
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("select p from Person p where p.firstName = :fname");
            q.setParameter("fname", fname);
            em.getTransaction().commit();
            System.out.println(q.getResultList().toString());
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
    @Override
    public List<Person> getPersonsViaLastName(String lname) {
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("select p from Person p where p.lastName = :lname");
            q.setParameter("lname", lname);
            em.getTransaction().commit();
            System.out.println(q.getResultList().toString());
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
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




    //U
    @Override
    public Person updatePerson(Person person, int id) {
        EntityManager em = emf.createEntityManager();
        Person p = em.find(Person.class, Long.valueOf(id));
        try {
            em.getTransaction().begin();
            p.setFirstName(person.getFirstName());
            p.setLastName(person.getLastName());
            em.getTransaction().commit();
            return p;
        } finally {
            em.close();
        }
    }

    //D
    @Override
    public Person deletePerson(int id) {
        em = emf.createEntityManager();
        Person person = em.find(Person.class, Long.valueOf(id));
        try {
            em.getTransaction().begin();
            em.remove(person);
            em.getTransaction().commit();
            return person;
        } finally {
            em.close();
        }
    }


}
