package TEAM6;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {
Random random = new Random();
//    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("BW4");

    public static void main(String[] args) {
        List<Subscription> subscriptionList = new ArrayList<>();
        for (int i = 0; i <20 ; i++) {
            Subscription prova = new Subscription(5.99, SubType.randomSubType());
            subscriptionList.add(prova);
        }
        subscriptionList.forEach(System.out::println);


    }
}
