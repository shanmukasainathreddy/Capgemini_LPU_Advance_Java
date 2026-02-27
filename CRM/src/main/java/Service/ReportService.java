package Service;

import java.util.List;

import javax.persistence.EntityManager;

import com.CRM.Order;

public class ReportService {

    private EntityManager em;

    public ReportService(EntityManager em) {
        this.em = em;
    }

    public List<Order> getOrdersAbove(double amount) {

        return em.createQuery(
                "SELECT o FROM Order o WHERE o.totalAmount > :amt",
                Order.class)
                .setParameter("amt", amount)
                .getResultList();
    }
}