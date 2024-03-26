package TEAM6.dao;

import TEAM6.entities.Rate;
import TEAM6.exceptions.NoFoundException;
import TEAM6.exceptions.NoRateException;
import jakarta.persistence.*;

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

}