package TEAM6.dao;


import TEAM6.entities.User;
import TEAM6.exceptions.NoFoundException;
import TEAM6.exceptions.NoUserException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;

public class UserDAO {
    private EntityManager em;

    public UserDAO(EntityManager em) {
        this.em = em;
    }

    // SAVE ON DB BY ID

    public void save(User user) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(user);
            t.commit();
            System.out.println("User " + user.getName() + " - has been created!");
        } catch (NoUserException e) {
            System.out.println(e.getMessage());
        }
    }

    // FIND ON DB BY ID
    public User findById(long id) {
        return em.find(User.class, id);
    }

    // FIND AND DELETE BY ID
    public void findByIdAndDelete(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            User found = em.find(User.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("User eliminated");
            } else System.out.println("User not found");


        } catch (NoUserException e) {
            System.out.println(e.getMessage());
        }
    }

    //    QUERIES
    public void updateUserCard(int id){
        User newUser = findById(id);
        if (newUser != null) {
            if(newUser.getCardEndDate().isBefore(LocalDate.now())){
                newUser.setCardStartDate(LocalDate.now());
                newUser.setCardEndDate(LocalDate.now().plusYears(1));
                save(newUser);
            } else {
                System.out.println("The user card is still valid!");
            }
        } else {
            System.out.println("No user has been found with this id: " + id);
        }

    }
}
