package TEAM6;

import TEAM6.dao.*;
import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("BW4");

    Random random = new Random();

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        Random random = new Random();
        TransportDAO transportDAO = new TransportDAO(em);
        RouteDAO routeDAO = new RouteDAO(em);
        UserDAO userDAO = new UserDAO(em);
        StoresDAO storesDAO = new StoresDAO(em);
        RatesDAO ratesDAO = new RatesDAO(em);
        MaintenanceDAO maintenanceDAO = new MaintenanceDAO(em);
        Scanner scanner = new Scanner(System.in);

//        PROVA SUBSCRIPTIONS
//        List<Subscription> subscriptionList = new ArrayList<>();
//        for (int i = 0; i <20 ; i++) {
//            Subscription prova = new Subscription(5.99, SubType.randomSubType());
//            subscriptionList.add(prova);
//        }
//        subscriptionList.forEach(System.out::println);


        Faker faker = new Faker(Locale.ITALY);

//        ROUTE GENERATOR
//        for (int i = 0; i < 5; i++) {
//           routeDAO.save(new Route(faker.address().city(), faker.address().city(), random.nextInt(15, 30)));
//        }

//       TRANSPORT GENERATOR
//        for (int i = 0; i < 20; i++) {
//            List<TransportType> transportTypeList = new ArrayList<>();
//            transportTypeList.add(TransportType.BUS);
//            transportTypeList.add(TransportType.TRAM);
//            List<TransportStatus> transportStatusList = new ArrayList<>();
//            transportStatusList.add(TransportStatus.ON_SERVICE);
//            transportStatusList.add(TransportStatus.UNDER_MAINTENANCE);
//            transportDAO.save(new Transport(transportTypeList.get(random.nextInt(0,2)), faker.space().galaxy(), transportStatusList.get(random.nextInt(0, 2)), routeDAO.findById(random.nextInt(1, 6))));
//        }

//        MAINTENANCE GENERATOR
//        for (int i = 0; i < 40; i++) {
//            List<MaintenanceType> maintenanceTypeList = new ArrayList<>();
//            maintenanceTypeList.add(MaintenanceType.TIRES_CHANGE);
//            maintenanceTypeList.add(MaintenanceType.ENGINE_PROBLEM);
//            maintenanceTypeList.add(MaintenanceType.ROUTINE_CHECK_UP);
//            maintenanceTypeList.add(MaintenanceType.GENERIC_PROBLEM);
//            maintenanceTypeList.add(MaintenanceType.SANITATION);
//            maintenanceDAO.save(new Maintenance(maintenanceTypeList.get(random.nextInt(0, 5)), transportDAO.findById(random.nextInt(1, 21))));
//        }

//        USER GENERATOR
//        for (int i = 0; i < 20; i++) {
//            userDAO.save(new User(random.nextInt(100, 1000), faker.name().firstName(), faker.name().lastName(), LocalDate.of(random.nextInt(1968, 2002), random.nextInt(1, 13), random.nextInt(1, 29)), faker.phoneNumber().cellPhone(), faker.internet().emailAddress()));
//        }

//        STORE GENERATOR
//        for (int i = 0; i < 20; i++) {
//            if (random.nextInt(1, 3) == 1) {
//                storesDAO.save(new Dispenser(faker.address().city(), random.nextInt(1, 3) == 1));
//            } else {
//                storesDAO.save(new Reseller(faker.address().city(), LocalTime.of(8, 0), LocalTime.of(18, 0)));
//            }
//        }

//        RATE GENERATOR
//        for (int i = 0; i < 30; i++) {
//            if (random.nextInt(1, 3) == 1){
//                ratesDAO.save(new Subscription(storesDAO.findById(random.nextInt(1, 21)), userDAO.findById(random.nextInt(1, 21)), random.nextInt(1, 3) == 1 ? SubType.WEEKLY : SubType.MONTHLY));
//            } else {
//                ratesDAO.save(new Ticket(storesDAO.findById(random.nextInt(1, 21)), userDAO.findById(random.nextInt(1, 21)), random.nextInt(1, 3) == 1, transportDAO.findById(random.nextInt(1, 21)), LocalDate.of(2024, random.nextInt(1, 4), random.nextInt(1, 29))));
//            }
//        }

//        FUNZIONA CONTA TICKET PER STORE E DATA (ERRORI GESTITI)
//        if (ratesDAO.numberOfTicketsByStoreAndDate(0, 0) != 0) System.out.println(ratesDAO.numberOfTicketsByStoreAndDate(0, 0));
//        public static void countTransportTravelsOnRoutes(long transportId, TransportDAO transportDAO) {
//            if (transportDAO.findById(transportId).getTransportStatus() == TransportStatus.ON_SERVICE) {
//                long numberOfTravels = Math.round(810 / (transportDAO.findById(transportId).getRoute().getAverageTime() * 2));
//                double realAverageTime = (double) 810 / numberOfTravels;
//                System.out.println("This transport has been completed his route " + numberOfTravels + " times");
//                System.out.println("The real average time is about to " + realAverageTime/2 + " minutes");
//            } else {
//                System.out.println("This transport is still under maintenance");
//            }
//        }

        int value;
        do {
            System.out.println("Starting program..");
            System.out.println("Press 0 to close the program!");
            System.out.println("Press 1 to count tickets for store and date!");
            System.out.println("Press 2 to count subriptions for store and date!");
            System.out.println("Press 3 to count all the rates for store and date!");
            System.out.println("Press 4 to validate a ticket on a transport!");
            System.out.println("Press 5 count how many tickets were validate on 1 specific transport!");
            System.out.println("Press 6 to count how many tickets were validate in a specific range of time");
            System.out.println("Press 7 to verify the subscriptions based on user card!");
            System.out.println("Press 8 count how many times a transport traveled 1 specific route!");
            System.out.println("Press 9 to renew your User card!");
            value = Integer.parseInt(scanner.nextLine());
            switch (value) {
                case 1:
                    System.out.println(ratesDAO.numberOfTicketsByStoreAndDate(17, 3));
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;

                case 0:
                    System.out.println("closing program..");
                    scanner.close();
                    break;
                default:
                    System.err.println("error! insert the correct value!");

            }
        } while (value != 0);


//        FUNZIONA CONTA TICKET PER STORE E DATA
//        System.out.println(ratesDAO.numberOfTicketsByStoreAndDate(8, 2));

//        FUNZIONE CONTA SUBSCRIPTION PER STORE E DATA (ERRORI GESTITI)
//        System.out.println(ratesDAO.);
//        if (ratesDAO.numberOfSubscriptionsByStoreAndDate(0, 0) != 0) System.out.println(ratesDAO.numberOfSubscriptionsByStoreAndDate(0, 0));

//        FUNZIONA CONTA RATES PER STORE E DATA (ERRORI GESTITI)
//        System.out.println("The number of tickets and subscriptions is: " + ratesDAO.numberOfRatesByStoreAndData(0, 0));

//        FUNZIONE PER LA VALIDAZIONE DEI TICKET DA UN CERTO MEZZO (ERRORI GESTITI)
//        transportDAO.updateTicketStatus(281);
//        transportDAO.findById(1).getTicketList().forEach(System.out::println);

//        conta quanti ticket sono stati vidimati su mezzo (ERRORI GESTITI)
//        Transport transport = transportDAO.findById(0);
//        if (transport != null) {
//            System.out.println(transport.getTicketList().stream().filter(Ticket::isUsed).toList().size());
//        } else {
//            System.out.println("No transport have been found!");
//        }
//
//        conta quanti ticket sono stati vidimati in un periodo di tempo (ERRORI GESTITI)
//        if (ratesDAO.countTicketByMonth(0) != 0) System.out.println(ratesDAO.countTicketByMonth(0));

//        FUNZIONE PER LA VERIFICA DEGLI ABBONAMENTI DA UNA TESSERA UTENTE (ERRORI GESTITI)
//        List<Subscription> subscriptionList = ratesDAO.verifyActiveSubscription(1);
//        if (!subscriptionList.isEmpty()) {
//            ratesDAO.verifyActiveSubscription(1).forEach(System.out::println);
//        } else System.out.println("This user has no active subscriptions");


//        FUNZIONE PER CONTARE QUANTE VOLTE UN MEZZO HA PERCORSO UNA ROTTA (ERRORI GESTITI)
//        countTransportTravelsOnRoutes(5, transportDAO);

//        FUNZIONE PER AGGIORNARE LA CARD (ERRORI GESTITI)
//        userDAO.updateUserCard(40);

        em.close();
        emf.close();
    }

    public static void countTransportTravelsOnRoutes(long transportId, TransportDAO transportDAO) {
        Transport transport = transportDAO.findById(transportId);
        if (transport != null) {
            if (transport.getTransportStatus() == TransportStatus.ON_SERVICE) {
                long numberOfTravels = Math.round(810 / (transport.getRoute().getAverageTime() * 2));
                double realAverageTime = (double) 810 / numberOfTravels;
                System.out.println("This transport has been completed his route " + numberOfTravels + " times");
                System.out.println("The real average time is about to " + realAverageTime/2 + " minutes");
            } else {
                System.out.println("This transport is still under maintenance");
            }
        } else {
            System.out.println("No transports have been found with this id: " + transportId);
        }

    }
}



