package facade;

import entity.CityInfo;
import entity.Company;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CityInfoFacade {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    public CityInfoFacade() {
        emf = Persistence.createEntityManagerFactory("jetbrainsDatabase");
    }

    public List<CityInfo> getAllCities() {
        em = emf.createEntityManager();
        List<CityInfo> cities = new ArrayList();
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("Select c from CityInfo c");
            cities = q.getResultList();
        } finally {
            em.close();
        }
        return cities;
    }
}
