package facade;

import interfaces.AddressFacadeInterface;
import entity.Address;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class AddressFacadeImpl implements AddressFacadeInterface {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    public AddressFacadeImpl() {
        emf = Persistence.createEntityManagerFactory("jetbrainsDatabase");
    }

    @Override
    public Address createAddress(Address address) {
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(address);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return address;
    }

    @Override
    public Address findAddress(long id) {
        em = emf.createEntityManager();
        Address a = em.find(Address.class, id);
        em.close();
        return a;
    }

    @Override
    public Address deleteAddress(long id) {
        em = emf.createEntityManager();
        Address a = em.find(Address.class, id);
        try {
            em.getTransaction().begin();
            em.remove(a);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return a;
    }

    @Override
    public Address updateAddress(Address address) {
        em = emf.createEntityManager();
        Address a = em.find(Address.class, address.getId());
        try {
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return a;
    }

}
