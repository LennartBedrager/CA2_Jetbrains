package facade;

import interfaces.HobbyFacadeInterface;
import entity.Company;
import entity.Hobby;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HobbyFacadeImpl implements HobbyFacadeInterface {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    public HobbyFacadeImpl() {
        emf = Persistence.createEntityManagerFactory("jetbrainsDatabase");
    }

    @Override
    public Hobby createHobby(Hobby hobby) {
        em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(hobby);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return hobby;
    }

    @Override
    public Hobby deleteHobbby(long id) {
        em = emf.createEntityManager();
        Hobby h = em.find(Hobby.class, id);
        try {
            em.getTransaction().begin();
            em.remove(h);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return h;
    }

    @Override
    public Hobby updateHobby(Hobby hobby) {
        em = emf.createEntityManager();
        Hobby h = em.find(Hobby.class, hobby.getId());
        try {
            em.getTransaction().begin();
            h = hobby;
            em.persist(h);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return h;
    }

    @Override
    public Hobby findHobby(long id) {
        em = emf.createEntityManager();
        Hobby h = em.find(Hobby.class, id);
        em.close();
        return h;
    }

}
