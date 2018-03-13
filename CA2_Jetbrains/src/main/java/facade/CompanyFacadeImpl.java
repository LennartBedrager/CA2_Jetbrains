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

    @Override
    public Company createCompany(Company company) {
        em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(company);
            em.getTransaction().commit();
            return company;
        } finally {
            em.close();
        }
    }

    @Override
    public Company deleteCompany(long id) {
        em = emf.createEntityManager();
        Company c = em.find(Company.class, id);
        try {
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return c;
    }

    @Override
    public Company updateCompany(Company company) {
        em = emf.createEntityManager();
        Company c = em.find(Company.class, company.getId());
        try {
            em.getTransaction().begin();
            c = company;
            em.persist(c);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return c;
    }

    @Override
    public List<Company> getAllCompanies() {
        em = emf.createEntityManager();
        List<Company> companies = new ArrayList();
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("Select c from Company c");
            companies = q.getResultList();

        } finally {
            em.close();
        }
        return companies;
    }

    @Override
    public Company getCompany(long id) {
        em = emf.createEntityManager();
        Company c = em.find(Company.class, id);
        em.close();
        return c;
    }

}
