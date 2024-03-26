package TEAM6.dao;


import TEAM6.entities.Route;
import TEAM6.exceptions.NoFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class RouteDAO {
    private EntityManager em;

    public RouteDAO(EntityManager em) {
        this.em = em;
    }

    // SAVE ON DB BY ID
    public void save(Route route) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(route);
            t.commit();
            System.out.println("The Route " + route.getId() + " - has been created!");
        } catch (NoFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    // FIND ON DB BY ID
    public Route findById(long id) {
        return em.find(Route.class, id);
    }

    // FIND AND DELETE BY ID
    public void findByIdAndDelete(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            Route found = em.find(Route.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("Route eliminated");
            } else System.out.println("Route not found");


        } catch (NoFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
