package TEAM6.dao;

import TEAM6.entities.Maintenance;
import TEAM6.exceptions.NoFoundException;
import TEAM6.exceptions.NoMaintenanceException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class MaintenanceDAO {
    private EntityManager em;

    public MaintenanceDAO(EntityManager em) {
        this.em = em;
    }

    // SAVE ON DB BY ID
    public void save(Maintenance maintenance) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(maintenance);
            t.commit();
            System.out.println("Maintenance " + maintenance.getId() + " - has been created!");
        } catch (NoMaintenanceException e) {
            System.out.println(e.getMessage());
        }
    }

    // FIND ON DB BY ID
    public Maintenance findById(long id) {
        return em.find(Maintenance.class, id);
    }

    // FIND AND DELETE BY ID
    public void findByIdAndDelete(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            Maintenance found = em.find(Maintenance.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("Maintenance eliminated");
            } else System.out.println("Maintenance not found");


        } catch (NoMaintenanceException e) {
            System.out.println(e.getMessage());
        }
    }
}
