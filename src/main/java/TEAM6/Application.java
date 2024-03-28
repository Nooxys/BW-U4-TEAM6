package TEAM6;

import TEAM6.dao.*;
import TEAM6.entities.Subscription;
import TEAM6.entities.Ticket;
import TEAM6.entities.Transport;
import TEAM6.enums.TransportStatus;
import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
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

        int value;
        do {
            System.out.println("Starting program..");
            System.out.println("Press 0 to close the program!");
            System.out.println("Press 1 to count tickets for store and date!");
            System.out.println("Press 2 to count subscriptions for store and date!");
            System.out.println("Press 3 to count all the rates for store and date!");
            System.out.println("Press 4 to validate a ticket on a transport!");
            System.out.println("Press 5 count how many tickets were validate on 1 specific transport!");
            System.out.println("Press 6 to count how many tickets were validate in a specific range of time");
            System.out.println("Press 7 to verify the subscriptions based on user card!");
            System.out.println("Press 8 count how many times a transport traveled 1 specific route!");
            System.out.println("Press 9 to renew your User card!");
            System.out.println("Press 10 to create a new rate");
            value = scanner.nextInt();
            switch (value) {

//          FUNZIONA CONTA TICKET PER STORE E DATA (ERRORI GESTITI)
                case 1: {
                    int userControl;
                    do {
                        System.out.println("Press 1 to continue or 0 to go back");
                        userControl = scanner.nextInt();
                        switch (userControl) {
                            case 1: {
                                System.out.println("Insert the store Id");
                                int storeId = scanner.nextInt();
                                System.out.println("Insert the number of the month to check");
                                int month = scanner.nextInt();
                                if (ratesDAO.numberOfTicketsByStoreAndDate(storeId, month) != 0) System.out.println(ratesDAO.numberOfTicketsByStoreAndDate(storeId, month));
                                break;
                            }

                            case 0: {
                                break;
                            }

                            default: {
                                System.out.println("You must press 1 or 0!");
                            }
                        }
                    } while (userControl != 0);
                    break;
                }

//        FUNZIONE CONTA SUBSCRIPTION PER STORE E DATA (ERRORI GESTITI)
                case 2:{
                    int userControl;
                    do {
                        System.out.println("Press 1 to continue or 0 to go back");
                        userControl = scanner.nextInt();
                        switch (userControl) {
                            case 1: {
                                System.out.println("Insert the store Id");
                                int storeId = scanner.nextInt();
                                System.out.println("Insert the number of the month to check");
                                int month = scanner.nextInt();
                                if (ratesDAO.numberOfSubscriptionsByStoreAndDate(storeId, month) != 0) System.out.println(ratesDAO.numberOfSubscriptionsByStoreAndDate(storeId, month));
                                break;
                            }

                            case 0: {
                                break;
                            }

                            default: {
                                System.out.println("You must press 1 or 0!");
                            }
                        }
                    } while (userControl != 0);
                    break;
                }

                //        FUNZIONA CONTA RATES PER STORE E DATA (ERRORI GESTITI)
                case 3:{
                    int userControl;
                    do {
                        System.out.println("Press 1 to continue or 0 to go back");
                        userControl = scanner.nextInt();
                        switch (userControl) {
                            case 1: {
                                System.out.println("Insert the store Id");
                                int storeId = scanner.nextInt();
                                System.out.println("Insert the number of the month to check");
                                int month = scanner.nextInt();
                                System.out.println("The number of tickets and subscriptions is: " + ratesDAO.numberOfRatesByStoreAndData(storeId, month));
                                break;
                            }

                            case 0: {
                                break;
                            }

                            default: {
                                System.out.println("You must press 1 or 0!");
                            }
                        }
                    } while (userControl != 0);
                    break;
                }

//        FUNZIONE PER LA VALIDAZIONE DEI TICKET DA UN CERTO MEZZO (ERRORI GESTITI)
                case 4:{
                    int userControl;
                    do {
                        System.out.println("Press 1 to continue or 0 to go back");
                        userControl = scanner.nextInt();
                        switch (userControl) {
                            case 1: {
                                System.out.println("Insert the ticket Id");
                                int ticketId = scanner.nextInt();
                                transportDAO.updateTicketStatus(ticketId);
                                break;
                            }

                            case 0: {
                                break;
                            }

                            default: {
                                System.out.println("You must press 1 or 0!");
                            }
                        }
                    } while (userControl != 0);
                    break;
                }

                //        conta quanti ticket sono stati vidimati su mezzo (ERRORI GESTITI)
                case 5:{
                    int userControl;
                    do {
                        System.out.println("Press 1 to continue or 0 to go back");
                        userControl = scanner.nextInt();
                        switch (userControl) {
                            case 1: {
                                System.out.println("Insert the transport Id");
                                int transportId = scanner.nextInt();
                                Transport transport = transportDAO.findById(transportId);
                                if (transport != null) {
                                    System.out.println(transport.getTicketList().stream().filter(Ticket::isUsed).toList().size());
                                } else {
                                    System.out.println("No transport have been found!");
                                }
                                break;
                            }

                            case 0: {
                                break;
                            }

                            default: {
                                System.out.println("You must press 1 or 0!");
                            }
                        }
                    } while (userControl != 0);
                    break;
                }

//        conta quanti ticket sono stati vidimati in un periodo di tempo (ERRORI GESTITI)
                case 6:{
                    int userControl;
                    do {
                        System.out.println("Press 1 to continue or 0 to go back");
                        userControl = scanner.nextInt();
                        switch (userControl) {
                            case 1: {
                                System.out.println("Insert the month to check");
                                int month = scanner.nextInt();
                                if (ratesDAO.countTicketByMonth(month) != 0) System.out.println(ratesDAO.countTicketByMonth(month));
                                break;
                            }

                            case 0: {
                                break;
                            }

                            default: {
                                System.out.println("You must press 1 or 0!");
                            }
                        }
                    } while (userControl != 0);
                    break;
                }

//        FUNZIONE PER LA VERIFICA DEGLI ABBONAMENTI DA UNA TESSERA UTENTE (ERRORI GESTITI)
                case 7:{
                    int userControl;
                    do {
                        System.out.println("Press 1 to continue or 0 to go back");
                        userControl = scanner.nextInt();
                        switch (userControl) {
                            case 1: {
                                System.out.println("Insert the user card number");
                                int cardNumber = scanner.nextInt();
                                List<Subscription> subscriptionList = ratesDAO.verifyActiveSubscription(cardNumber);
                                if (!subscriptionList.isEmpty()) {
                                    ratesDAO.verifyActiveSubscription(cardNumber).forEach(System.out::println);
                                } else System.out.println("This user has no active subscriptions");
                            }

                            case 0: {
                                break;
                            }

                            default: {
                                System.out.println("You must press 1 or 0!");
                            }
                        }
                    } while (userControl != 0);
                    break;
                }

//        FUNZIONE PER CONTARE QUANTE VOLTE UN MEZZO HA PERCORSO UNA ROTTA (ERRORI GESTITI)
                case 8:{
                    int userControl;
                    do {
                        System.out.println("Press 1 to continue or 0 to go back");
                        userControl = scanner.nextInt();
                        switch (userControl) {
                            case 1: {
                                System.out.println("Insert the transport id");
                                int transportId = scanner.nextInt();
                                countTransportTravelsOnRoutes(transportId, transportDAO);
                            }

                            case 0: {
                                break;
                            }

                            default: {
                                System.out.println("You must press 1 or 0!");
                            }
                        }
                    } while (userControl != 0);
                    break;
                }

//        FUNZIONE PER AGGIORNARE LA CARD (ERRORI GESTITI)
                case 9:{
                    int userControl;
                    do {
                        System.out.println("Press 1 to continue or 0 to go back");
                        userControl = scanner.nextInt();
                        switch (userControl) {
                            case 1: {
                                System.out.println("Insert the user id");
                                int userId = scanner.nextInt();
                                userDAO.updateUserCard(userId);
                            }

                            case 0: {
                                break;
                            }

                            default: {
                                System.out.println("You must press 1 or 0!");
                            }
                        }
                    } while (userControl != 0);
                    break;
                }

                case 0:{
                    System.out.println("closing program..");
                    scanner.close();
                    break;
                }

                default: {
                    System.err.println("error! insert the correct value!");

                }

            }
        } while (value != 0);

        scanner.close();
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



