
package Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.CRM.Order;
import com.CRM.Product;

public class OrderService {

    private EntityManager em;

    public OrderService(EntityManager em) {
        this.em = em;
    }

    public void placeOrder(Order order) {

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        double total = 0;
        for(Product p : order.getProducts()) {
            total += p.getPrice();
        }

        order.setTotalAmount(total);

        order.setOrderDate(java.time.LocalDate.now().toString());

        em.persist(order);

        tx.commit();

        System.out.println("Order saved successfully");
    }
}
