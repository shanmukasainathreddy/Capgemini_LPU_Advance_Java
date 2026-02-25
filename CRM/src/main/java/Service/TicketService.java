
package Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.CRM.SupportTicket;

public class TicketService {

    private EntityManager em;

    public TicketService(EntityManager em) {
        this.em = em;
    }

    public void createTicket(SupportTicket t) {

        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(t);
        tx.commit();

        System.out.println("Ticket created");
    }
}
