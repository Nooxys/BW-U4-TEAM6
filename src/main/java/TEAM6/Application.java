package TEAM6;

import TEAM6.entities.Stores;
import TEAM6.entities.Transport;
import TEAM6.enums.TransportStatus;
import TEAM6.enums.TransportType;
import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {
Random random = new Random();
//    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("BW4");

    public static void main(String[] args) {
        List<Stores.Subscription> subscriptionList = new ArrayList<>();
        for (int i = 0; i <20 ; i++) {
            Stores.Subscription prova = new Stores.Subscription(5.99, TransportType.SubType.randomSubType());
            subscriptionList.add(prova);
        }
        subscriptionList.forEach(System.out::println);


        Faker faker = new Faker();

        EntityManager em = emf.createEntityManager();

        List<Transport> transportList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Random random = new Random();
            List<TransportType> transportTypeList = new ArrayList<>();
            transportTypeList.add(TransportType.BUS);
            transportTypeList.add(TransportType.TRAM);
            List<TransportStatus> transportStatusList = new ArrayList<>();
            transportStatusList.add(TransportStatus.ON_SERVICE);
            transportStatusList.add(TransportStatus.UNDER_MAINTENANCE);
            transportList.add(new Transport(transportTypeList.get(random.nextInt(0,2)), faker.space().galaxy(), transportStatusList.get(random.nextInt(0, 2))));
        }

        transportList.forEach(System.out::println);

        em.close();
        emf.close();
    }
}
