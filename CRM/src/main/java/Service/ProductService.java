package Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.CRM.Product;

public class ProductService {

    private EntityManager em;

    public ProductService(EntityManager em) {
        this.em = em;
    }

    public void createProduct(Product p) {

        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(p);
        tx.commit();

        System.out.println("Product created");
    }
}