package TEAM6;

import TEAM6.dao.RouteDAO;
import TEAM6.dao.TransportDAO;
import TEAM6.entities.Route;
import TEAM6.entities.Subscription;
import TEAM6.entities.Transport;
import TEAM6.enums.SubType;
import TEAM6.enums.TransportStatus;
import TEAM6.enums.TransportType;
import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

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


//        CIRO PROVA SUBSCRIPTIONS
//        List<Subscription> subscriptionList = new ArrayList<>();
//        for (int i = 0; i <20 ; i++) {
//            Subscription prova = new Subscription(5.99, SubType.randomSubType());
//            subscriptionList.add(prova);
//        }
//        subscriptionList.forEach(System.out::println);


        Faker faker = new Faker(Locale.ITALY);

        for (int i = 0; i < 5; i++) {
           routeDAO.save(new Route(faker.address().cityName(), faker.address().cityName(), random.nextInt(15, 30)));
        }

        for (int i = 0; i < 20; i++) {
            List<TransportType> transportTypeList = new ArrayList<>();
            transportTypeList.add(TransportType.BUS);
            transportTypeList.add(TransportType.TRAM);
            List<TransportStatus> transportStatusList = new ArrayList<>();
            transportStatusList.add(TransportStatus.ON_SERVICE);
            transportStatusList.add(TransportStatus.UNDER_MAINTENANCE);
            transportDAO.save(new Transport(transportTypeList.get(random.nextInt(0,2)), faker.space().galaxy(), transportStatusList.get(random.nextInt(0, 2)), routeDAO.findById(random.nextInt(1, 5))));
        }

        em.close();
        emf.close();
    }
}
