package TEAM6.dao;

import TEAM6.entities.Dispenser;
import TEAM6.entities.Rate;
import TEAM6.entities.Store;
import TEAM6.entities.Subscription;
import TEAM6.entities.Ticket;
import TEAM6.exceptions.NoFoundException;
import TEAM6.exceptions.NoRateException;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

public class RatesDAO {
    private EntityManager em;

    public RatesDAO(EntityManager em) {
        this.em = em;
    }

    // SAVE ON DB BY ID

    public void save(Rate rate) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(rate);
            t.commit();
            System.out.println("Rate " + rate.getId() + " - created!");
        } catch (NoRateException e) {
            System.out.println(e.getMessage());
        }
    }

    // FIND ON DB BY ID
    public Rate findById(long id) {
        return em.find(Rate.class, id);
    }

    // FIND AND DELETE BY ID
    public void findByIdAndDelete(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            Rate found = em.find(Rate.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("Rate eliminated");
            } else System.out.println("Rate not found");


        } catch (NoRateException e) {
            System.out.println(e.getMessage());
        }
    }

//    QUERIES
    public long numberOfTicketsByStoreAndDate(long storeId, int month) {
        TypedQuery<Long> query = em.createNamedQuery("numberOfTicketsByStoreAndDate", Long.class);
        query.setParameter("storeId", storeId);
        query.setParameter("month", month);
        return query.getSingleResult();
    }

    public long numberOfSubscriptionsByStoreAndDate(long storeId, int month) {
        TypedQuery<Long> query = em.createNamedQuery("numberOfSubscriptionsByStoreAndDate", Long.class);
        query.setParameter("storeId", storeId);
        query.setParameter("month", month);
        return query.getSingleResult();
    }

    public long numberOfRatesByStoreAndData(long storeId, int month){
        return numberOfTicketsByStoreAndDate(storeId, month) + numberOfSubscriptionsByStoreAndDate(storeId, month);
    }

    //STAMPA BIGLIETTI
    public void ticketPrint(int storeIntId) {
        Store storeFound = em.find(Store.class, storeIntId);
        if (storeFound != null) {
            Rate ticket = new Ticket();
            RatesDAO ratesDao = new RatesDAO(em);
            ratesDao.save(ticket);
        } else if (storeFound instanceof Dispenser) {
            Dispenser dispenser = (Dispenser) storeFound;
            if (!dispenser.getStatus()) {
                System.out.println("Impossibile emettere il ticket. Distributore non attivo.");
            }
        }
        else {
            throw new NoRateException(storeIntId);
        }
    public long countTicketByMonth(int month){
        TypedQuery<Long> query = em.createNamedQuery("countTicketByMonth", Long.class);
        query.setParameter("month", month);
        return query.getSingleResult();
    }

    public List<Subscription> verifyActiveSubscription(int card){
        TypedQuery<Subscription> query = em.createNamedQuery("verifyActiveSubscription", Subscription.class);
        query.setParameter("card", card);
        return query.getResultList();
    }
}