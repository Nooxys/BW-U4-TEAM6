package TEAM6.dao;

import TEAM6.entities.Dispenser;
import TEAM6.entities.Rate;
import TEAM6.entities.Store;

import TEAM6.entities.Ticket;
import TEAM6.exceptions.NoFoundException;
import TEAM6.exceptions.NoRateException;
import TEAM6.exceptions.NoStoreException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;


public class StoresDAO {
    private EntityManager em;

    public StoresDAO(EntityManager em) {
        this.em = em;
    }

    // SAVE ON DB BY ID

    public void save(Store store) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(store);
            t.commit();
            System.out.println("Store " + store.getId() + " - created!");
        } catch (NoStoreException e) {
            System.out.println(e.getMessage());
        }
    }

    // FIND ON DB BY ID
    public Store findById(long id) {
        return em.find(Store.class, id);
    }

    // FIND AND DELETE BY ID
    public void findByIdAndDelete(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            Store found = em.find(Store.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("Store eliminated");
            } else System.out.println("Store not found");


        } catch (NoStoreException e) {
            System.out.println(e.getMessage());
        }
    }

    public void storeList() {
        List<Store> list = em
                .createQuery("SELECT s FROM Store s", Store.class).getResultList();
        list.forEach(System.out::println);
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
    }

}
