package Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.CRM.Address;
import com.CRM.Customer;

public class CustomerService {

    private EntityManager em;

    public CustomerService(EntityManager em) {
        this.em = em;
    }

    public void register(Customer c) {

        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(c);
        tx.commit();

        System.out.println("Customer registered");
    }


    public void update(Customer c) {

        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.merge(c);
        tx.commit();

        System.out.println("Customer updated");
    }


    public void delete(long id) {

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Customer c = em.find(Customer.class, id);
        if(c != null) {
            em.remove(c);
        }

        tx.commit();

        System.out.println("Customer deleted");
    }



    public void addAddress(long customerId, Address addr) {

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Customer c = em.find(Customer.class, customerId);
        if(c != null) {
            c.setAddress(addr);  
        }

        tx.commit();

        System.out.println("Address added");
    }
}