package facade;

import interfaces.CompanyFacadeInterface;
import entity.Company;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * Facade for persisting entities of the Company class
 *
 * @author Kasper RB
 */
public class CompanyFacadeImpl implements CompanyFacadeInterface {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    public CompanyFacadeImpl() {
        emf = Persistence.createEntityManagerFactory("jetbrainsDatabase");
    }

    //C
    @Override
    public void createCompany(Company company) {
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(company);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    //R
    @Override
    public Company getCompany(int id) {
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("SELECT c FROM Company c WHERE c.id = :id");
            q.setParameter("id", id);
            em.getTransaction().commit();
            Company company = (Company) q.getSingleResult();
            return company;
        } finally {
            em.close();
        }
    }

    //U
    @Override
    public void updateCompany(Company company) {
        EntityManager em = emf.createEntityManager();
        Company c = em.find(Company.class, company.getId());
        try {
            em.getTransaction().begin();
            c.setName(company.getName());
            c.setDescription(company.getDescription());
            c.setCvr(company.getCvr());
            c.setNumEmployees(company.getNumEmployees());
            c.setMarketValue(company.getMarketValue());
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    //D
    @Override
    public void deleteCompany(int id) {
        em = emf.createEntityManager();
        Company company = em.find(Company.class, id);
        try {
            em.getTransaction().begin();
            em.remove(company);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Company> getAllCompanies() {
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("Select c from Company c");
            em.getTransaction().commit();
            return q.getResultList();
        } finally {
            em.close();
        }
    }

}
