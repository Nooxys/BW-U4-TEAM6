package TEAM6.dao;




import TEAM6.entities.Transport;
import TEAM6.exceptions.NoFoundException;
import TEAM6.exceptions.NoRateException;
import TEAM6.exceptions.NoTransportException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class TransportDAO {
    private EntityManager em;

    public TransportDAO(EntityManager em) {
        this.em = em;
    }

    // SAVE ON DB BY ID
    public void save(Transport transport) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(transport);
            t.commit();
            System.out.println("The transport " + transport.getId() + " - has been created!");
        } catch (NoTransportException e) {
            System.out.println(e.getMessage());
        }
    }

    // FIND ON DB BY ID
    public Transport findById(long id) {
        return em.find(Transport.class, id);
    }

    // FIND AND DELETE BY ID
    public void findByIdAndDelete(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            Transport found = em.find(Transport.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("Transport eliminated");
            } else System.out.println("Transport not found");


        } catch (NoTransportException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateTicketStatus(long id){
        EntityTransaction t = em.getTransaction();
        t.begin();
        Query query = em.createNamedQuery("updateTicketStatus");
        query.setParameter("id", id);
        query.executeUpdate();
        t.commit();
        System.out.println("Ticket has been updated correctly");
    }
}
