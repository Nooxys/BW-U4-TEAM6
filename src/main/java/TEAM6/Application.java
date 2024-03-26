package TEAM6;

import TEAM6.dao.*;
import TEAM6.entities.*;
import TEAM6.enums.SubType;
import TEAM6.enums.TransportStatus;
import TEAM6.enums.TransportType;
import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Application {
Random random = new Random();
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("BW4");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        Random random = new Random();
        TransportDAO transportDAO = new TransportDAO(em);
        RouteDAO routeDAO = new RouteDAO(em);
        UserDAO userDAO = new UserDAO(em);
        StoresDAO storesDAO = new StoresDAO(em);
        RatesDAO ratesDAO = new RatesDAO(em);


//        CIRO PROVA SUBSCRIPTIONS
//        List<Subscription> subscriptionList = new ArrayList<>();
//        for (int i = 0; i <20 ; i++) {
//            Subscription prova = new Subscription(5.99, SubType.randomSubType());
//            subscriptionList.add(prova);
//        }
//        subscriptionList.forEach(System.out::println);


        Faker faker = new Faker(Locale.ITALY);

//        ROUTE GENERATOR
        for (int i = 0; i < 5; i++) {
           routeDAO.save(new Route(faker.address().city(), faker.address().city(), random.nextInt(15, 30)));
        }

//       TRANSPORT GENERATOR
        for (int i = 0; i < 20; i++) {
            List<TransportType> transportTypeList = new ArrayList<>();
            transportTypeList.add(TransportType.BUS);
            transportTypeList.add(TransportType.TRAM);
            List<TransportStatus> transportStatusList = new ArrayList<>();
            transportStatusList.add(TransportStatus.ON_SERVICE);
            transportStatusList.add(TransportStatus.UNDER_MAINTENANCE);
            transportDAO.save(new Transport(transportTypeList.get(random.nextInt(0,2)), faker.space().galaxy(), transportStatusList.get(random.nextInt(0, 2)), routeDAO.findById(random.nextInt(1, 6))));
        }

//        USER GENERATOR
        for (int i = 0; i < 20; i++) {
            userDAO.save(new User(random.nextInt(100, 1000), faker.name().firstName(), faker.name().lastName(), LocalDate.of(random.nextInt(1968, 2002), random.nextInt(1, 13), random.nextInt(1, 29)), faker.phoneNumber().cellPhone(), faker.internet().emailAddress()));
        }

//        STORE GENERATOR
        for (int i = 0; i < 20; i++) {
            if (random.nextInt(1, 3) == 1) {
                storesDAO.save(new Dispenser(faker.address().city(), random.nextInt(1, 3) == 1));
            } else {
                storesDAO.save(new Reseller(faker.address().city(), LocalTime.of(8, 0), LocalTime.of(18, 0)));
            }
        }

//        RATE GENERATOR
        for (int i = 0; i < 30; i++) {
            if (random.nextInt(1, 3) == 1){
                ratesDAO.save(new Subscription(storesDAO.findById(random.nextInt(1, 21)), userDAO.findById(random.nextInt(1, 21)), random.nextInt(1, 3) == 1 ? SubType.WEEKLY : SubType.MONTHLY));
            } else {
                ratesDAO.save(new Ticket(storesDAO.findById(random.nextInt(1, 21)), userDAO.findById(random.nextInt(1, 21)), random.nextInt(1, 3) == 1, transportDAO.findById(random.nextInt(1, 21))));
            }
        }

//       storesDAO.findById(20).getRateList().forEach(System.out::println);

        em.close();
        emf.close();
    }
}
