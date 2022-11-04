package ua.lviv.iot.labb4.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.lviv.iot.labb4.controller.*;
import ua.lviv.iot.labb4.domain.*;

import java.util.*;

@Component
public class MyView {

    @Autowired
    private ClientController clientController;
    @Autowired
    private HotelController hotelController;
    @Autowired
    private LocationController locationController;
    @Autowired
    private PaymentController paymentController;
    @Autowired
    private ReservedController reservedController;
    @Autowired
    private ReviewController reviewController;
    @Autowired
    private RoomController roomController;

    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private final Scanner input = new Scanner(System.in);
    private final Client nullClient = new Client(null, null, null, null, null, null, null);
    private final Hotel nullHotel = new Hotel(null, null, null, null);
    private final Location nullLocation = new Location(null, null, null);
    private final Payment nullPayment = new Payment(null, null, null);
    private final Reserved nullReserved = new Reserved(null, null, null);
    private final Review nullReview = new Review(null, null, null, null);
    private final Room nullRoom = new Room(null, null, null, null, null);

    public MyView() {
        menu = new LinkedHashMap<>();
        menu.put("A", "  A - Select all table");

        menu.put("1", "   1 - Table: Client");
        menu.put("11", "  11 - Create Client");
        menu.put("12", "  12 - Update Client");
        menu.put("13", "  13 - Delete from Client");
        menu.put("14", "  14 - Find all Clients");
        menu.put("15", "  15 - Find Client by ID");

        menu.put("2", "   2 - Table: Hotel");
        menu.put("21", "  21 - Create Hotel");
        menu.put("22", "  22 - Update Hotel");
        menu.put("23", "  23 - Delete from Hotel");
        menu.put("24", "  24 - Find all Hotels");
        menu.put("25", "  25 - Find Hotel by ID");

        menu.put("3", "   3 - Table: Location");
        menu.put("31", "  31 - Create Location");
        menu.put("32", "  32 - Update Location");
        menu.put("33", "  33 - Delete from Location");
        menu.put("34", "  34 - Find all Locations");
        menu.put("35", "  35 - Find Location by ID");

        menu.put("4", "   4 - Table: Payment");
        menu.put("41", "  41 - Create Payment");
        menu.put("42", "  42 - Update Payment");
        menu.put("43", "  43 - Delete from Payment");
        menu.put("44", "  44 - Find all Payments");
        menu.put("45", "  45 - Find Payment by ID");

        menu.put("5", "   5 - Table: Reserved");
        menu.put("51", "  51 - Create Reserved");
        menu.put("52", "  52 - Update Reserved");
        menu.put("53", "  53 - Delete from Reserved");
        menu.put("54", "  54 - Find all Reserveds");
        menu.put("55", "  55 - Find Reserved by ID");

        menu.put("6", "   6 - Table: Review");
        menu.put("61", "  61 - Create Review");
        menu.put("62", "  62 - Update Review");
        menu.put("63", "  63 - Delete from Review");
        menu.put("64", "  64 - Find all Reviews");
        menu.put("65", "  65 - Find Review by ID");

        menu.put("7", "   7 - Table: Room");
        menu.put("71", "  71 - Create Room");
        menu.put("72", "  72 - Update Room");
        menu.put("73", "  73 - Delete from Room");
        menu.put("74", "  74 - Find all Rooms");
        menu.put("75", "  75 - Find Room by ID");

        menu.put("Q", "  Q - exit");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("A", this::selectAllTable);

        methodsMenu.put("11", this::createClient);
        methodsMenu.put("12", this::updateClient);
        methodsMenu.put("13", this::deleteFromClient);
        methodsMenu.put("14", this::findAllClients);
        methodsMenu.put("15", this::findClientById);

        methodsMenu.put("21", this::createHotel);
        methodsMenu.put("22", this::updateHotel);
        methodsMenu.put("23", this::deleteFromHotel);
        methodsMenu.put("24", this::findAllHotels);
        methodsMenu.put("25", this::findHotelById);

        methodsMenu.put("31", this::createLocation);
        methodsMenu.put("32", this::updateLocation);
        methodsMenu.put("33", this::deleteFromLocation);
        methodsMenu.put("34", this::findAllLocations);
        methodsMenu.put("35", this::findLocationById);

        methodsMenu.put("41", this::createPayment);
        methodsMenu.put("42", this::updatePayment);
        methodsMenu.put("43", this::deleteFromPayment);
        methodsMenu.put("44", this::findAllPayments);
        methodsMenu.put("45", this::findPaymentById);

        methodsMenu.put("51", this::createReserved);
        methodsMenu.put("52", this::updateReserved);
        methodsMenu.put("53", this::deleteFromReserved);
        methodsMenu.put("54", this::findAllReserveds);
        methodsMenu.put("55", this::findReservedById);

        methodsMenu.put("61", this::createReview);
        methodsMenu.put("62", this::updateReview);
        methodsMenu.put("63", this::deleteFromReview);
        methodsMenu.put("64", this::findAllReviews);
        methodsMenu.put("65", this::findReviewById);

        methodsMenu.put("71", this::createRoom);
        methodsMenu.put("72", this::updateRoom);
        methodsMenu.put("73", this::deleteFromRoom);
        methodsMenu.put("74", this::findAllRooms);
        methodsMenu.put("75", this::findRoomById);

    }
        private void selectAllTable () {
            findAllClients();
            findAllHotels();
            findAllLocations();
            findAllPayments();
            findAllReserveds();
            findAllReviews();
            findAllRooms();

        }

        // region Client ---------------------------------------------------
        private void createClient () {
            System.out.println("Input new 'name': ");
            String name = input.nextLine();
            System.out.println("Input new 'surname': ");
            String surname = input.nextLine();
            System.out.println("Input new 'phone_number': ");
            Integer phone_number = Integer.valueOf((input.nextLine()));
            System.out.println("Input new 'email': ");
            String email = input.nextLine();
            System.out.println("Input new 'birthday': ");
            String birthday = input.nextLine();
            System.out.println("Input new 'gender': ");
            String gender = input.nextLine();

            Client client = new Client(null, name, surname, phone_number, email, birthday, gender);

            int count = clientController.create(client);
            System.out.printf("There are created %d rows\n", count);
        }

        private void updateClient () {
            System.out.println("Input 'id': ");
            Integer id = Integer.valueOf((input.nextLine()));

            System.out.println("Input new 'name': ");
            String name = input.nextLine();
            System.out.println("Input new 'surname': ");
            String surname = input.nextLine();
            System.out.println("Input new 'phone_number': ");
            Integer phone_number = Integer.valueOf((input.nextLine()));
            System.out.println("Input new 'email': ");
            String email = input.nextLine();
            System.out.println("Input new 'birthday': ");
            String birthday = input.nextLine();
            System.out.println("Input new 'gender': ");
            String gender = input.nextLine();

            Client client = new Client(null, name, surname, phone_number, email, birthday, gender);

            int count = clientController.update(id, client);
            System.out.printf("There are updated %d rows\n", count);
        }

        private void deleteFromClient () {
            System.out.println("Input 'id': ");
            Integer id = Integer.valueOf((input.nextLine()));

            int count = clientController.delete(id);
            System.out.printf("There are deleted %d rows\n", count);
        }

        private void findAllClients () {
            System.out.println("\nTable: CLIENT");
            List<Client> clients = clientController.findAll();
            for (Client client : clients) {
                System.out.println(client);
            }
        }

        private void findClientById () {
            System.out.println("Input 'id': ");
            Integer id = Integer.valueOf((input.nextLine()));

            Optional<Client> client = clientController.findById(id);
            System.out.println(client.orElse(nullClient));
        }

    // region Hotel ---------------------------------------------------
    private void createHotel () {
        System.out.println("Input new 'name': ");
        String name = input.nextLine();
        System.out.println("Input new 'phone': ");
        Integer phone = Integer.valueOf(input.nextLine());
        System.out.println("Input new 'hotel_code': ");
        Integer hotel_code = Integer.valueOf(input.nextLine());

        Hotel hotel = new Hotel(null, name, phone, hotel_code);

        int count = hotelController.create(hotel);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateHotel () {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'name': ");
        String name = input.nextLine();
        System.out.println("Input new 'phone': ");
        Integer phone = Integer.valueOf(input.nextLine());
        System.out.println("Input new 'hotel_code': ");
        Integer hotel_code = Integer.valueOf(input.nextLine());

        Hotel hotel = new Hotel(null, name, phone, hotel_code);

        int count = hotelController.update(id, hotel);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromHotel () {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = hotelController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllHotels () {
        System.out.println("\nTable: HOTEL");
        List<Hotel> hotels = hotelController.findAll();
        for (Hotel hotel : hotels) {
            System.out.println(hotel);
        }
    }

    private void findHotelById () {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Hotel> hotel = hotelController.findById(id);
        System.out.println(hotel.orElse(nullHotel));
    }

    // region Location ---------------------------------------------------
    private void createLocation () {
        System.out.println("Input new 'city': ");
        String city = input.nextLine();
        System.out.println("Input new 'street': ");
        String street = input.nextLine();

        Location location = new Location(null, city, street);

        int count = locationController.create(location);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateLocation () {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'city': ");
        String city = input.nextLine();
        System.out.println("Input new 'street': ");
        String street = input.nextLine();

        Location location = new Location(null, city, street);

        int count = locationController.update(id, location);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromLocation () {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = locationController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllLocations () {
        System.out.println("\nTable: LOCATION");
        List<Location> locations = locationController.findAll();
        for (Location location : locations) {
            System.out.println(location);
        }
    }

    private void findLocationById () {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Location> location = locationController.findById(id);
        System.out.println(location.orElse(nullLocation));
    }

    // region Payment ---------------------------------------------------
    private void createPayment () {
        System.out.println("Input new 'suma': ");
        Integer suma = Integer.valueOf(input.nextLine());
        System.out.println("Input new 'date': ");
        String date = input.nextLine();

        Payment payment = new Payment(null, suma, date);

        int count = paymentController.create(payment);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updatePayment () {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'suma': ");
        Integer suma = Integer.valueOf(input.nextLine());
        System.out.println("Input new 'date': ");
        String date = input.nextLine();

        Payment payment = new Payment(null, suma, date);

        int count = paymentController.update(id, payment);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromPayment () {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = paymentController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllPayments () {
        System.out.println("\nTable: PAYMENT");
        List<Payment> payments = paymentController.findAll();
        for (Payment payment : payments) {
            System.out.println(payment);
        }
    }

    private void findPaymentById () {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Payment> payment = paymentController.findById(id);
        System.out.println(payment.orElse(nullPayment));
    }

    // region Reserved ---------------------------------------------------
    private void createReserved () {
        System.out.println("Input new 'from_date': ");
        String from_date = input.nextLine();
        System.out.println("Input new 'to_date': ");
        String to_date = input.nextLine();

        Reserved reserved = new Reserved(null, from_date, to_date);

        int count = reservedController.create(reserved);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateReserved () {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'from_date': ");
        String from_date = input.nextLine();
        System.out.println("Input new 'to_date': ");
        String to_date = input.nextLine();

        Reserved reserved = new Reserved(null, from_date, to_date);

        int count = reservedController.update(id, reserved);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromReserved () {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = reservedController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllReserveds () {
        System.out.println("\nTable: RESERVED");
        List<Reserved> reserveds = reservedController.findAll();
        for (Reserved reserved : reserveds) {
            System.out.println(reserved);
        }
    }

    private void findReservedById () {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Reserved> reserved = reservedController.findById(id);
        System.out.println(reserved.orElse(nullReserved));
    }

    // region Review ---------------------------------------------------
    private void createReview () {
        System.out.println("Input new 'raiting': ");
        Integer raiting = Integer.valueOf(input.nextLine());
        System.out.println("Input new 'description': ");
        String description = input.nextLine();
        System.out.println("Input new 'date': ");
        String date = input.nextLine();

        Review review = new Review(null, raiting, description, date);

        int count = reviewController.create(review);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateReview () {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'raiting': ");
        Integer raiting = Integer.valueOf(input.nextLine());
        System.out.println("Input new 'description': ");
        String description = input.nextLine();
        System.out.println("Input new 'date': ");
        String date = input.nextLine();

        Review review = new Review(null, raiting, description, date);

        int count = reviewController.update(id, review);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromReview () {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = reviewController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllReviews () {
        System.out.println("\nTable: REVIEW");
        List<Review> reviews = reviewController.findAll();
        for (Review review : reviews) {
            System.out.println(review);
        }
    }

    private void findReviewById () {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Review> review = reviewController.findById(id);
        System.out.println(review.orElse(nullReview));
    }

    // region Room ---------------------------------------------------
    private void createRoom () {
        System.out.println("Input new 'number': ");
        Integer number = Integer.valueOf(input.nextLine());
        System.out.println("Input new 'floor': ");
        Integer floor = Integer.valueOf(input.nextLine());
        System.out.println("Input new 'price': ");
        Integer price = Integer.valueOf(input.nextLine());
        System.out.println("Input new 'type': ");
        String type = input.nextLine();

        Room room = new Room(null, number, floor, price, type);

        int count = roomController.create(room);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateRoom () {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'number': ");
        Integer number = Integer.valueOf(input.nextLine());
        System.out.println("Input new 'floor': ");
        Integer floor = Integer.valueOf(input.nextLine());
        System.out.println("Input new 'price': ");
        Integer price = Integer.valueOf(input.nextLine());
        System.out.println("Input new 'type': ");
        String type = input.nextLine();

        Room room = new Room(null, number, floor, price, type);

        int count = roomController.update(id, room);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromRoom () {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = roomController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllRooms () {
        System.out.println("\nTable: CLIENT");
        List<Room> rooms = roomController.findAll();
        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    private void findRoomById () {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Room> room = roomController.findById(id);
        System.out.println(room.orElse(nullRoom));
    }

    //-------------------------------------------------------------------------
    // region output
    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String key : menu.keySet())
            if (key.length() == 1) System.out.println(menu.get(key));
    }

    private void outputSubMenu(String fig) {

        System.out.println("\nSubMENU:");
        for (String key : menu.keySet())
            if (key.length() != 1 && key.substring(0, 1).equals(fig)) System.out.println(menu.get(key));
    }

    public void show () {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();

            if (keyMenu.matches("^\\d")) {
                outputSubMenu(keyMenu);
                System.out.println("Please, select menu point.");
                keyMenu = input.nextLine().toUpperCase();
            }

            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (!keyMenu.equals("Q"));
    }

}
