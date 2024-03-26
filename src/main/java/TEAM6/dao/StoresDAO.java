package TEAM6.dao;

import TEAM6.entities.Store;

import TEAM6.exceptions.NoFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;



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
        } catch (NoFoundException e) {
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


        } catch (NoFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
