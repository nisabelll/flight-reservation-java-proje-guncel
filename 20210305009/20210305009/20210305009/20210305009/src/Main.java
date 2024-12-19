import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FlightReservationSystem<Flight> reservationSystem = new FlightReservationSystem<>();

        // Uçuşları ekleyelim
        reservationSystem.addFlight(new EconomyFlight("TK101", "Istanbul", "TURKISH AIRLINES", "2024-12-19 10:00", "2024-12-19 14:00", 150.0));
        reservationSystem.addFlight(new BusinessFlight("125BA", "London", "BRITISH AIRWAYS", "2024-12-20 12:00", "2024-12-20 16:00", 500.0));
        reservationSystem.addFlight(new EconomyFlight("176EK", "New York", "EMIRATES", "2024-12-21 08:00", "2024-12-21 18:00", 250.0));
        reservationSystem.addFlight(new BusinessFlight("279IT", "Paris", "AIR FRANCE", "2024-12-22 09:00", "2024-12-22 13:00", 450.0));

        // Kullanıcı bilgileri
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        User user = null;
        while (user == null) {
            try {
                System.out.print("Enter your ID (11-digit number): ");
                String ID = scanner.nextLine();
                user = new User(firstName, lastName, ID); // User nesnesi oluştur
                System.out.println("Welcome, " + user.getFullName() + "!");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        // Kullanıcıya seçenekler sunma
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. View available flights");
            System.out.println("2. Book a flight");
            System.out.println("3. View booked flights");
            System.out.println("4. Cancel a flight");
            System.out.println("5. Search flights by destination");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (choice == 1) {
                reservationSystem.displayAvailableFlights(); // Mevcut uçuşları görüntüle
            } else if (choice == 2) {
                System.out.print("Enter flight number to book: ");
                String flightNumber = scanner.nextLine();
                reservationSystem.bookFlight(flightNumber, user); // User nesnesini ekledik
            } else if (choice == 3) {
                reservationSystem.displayFlightDetails(); // Rezerve edilen uçuşları görüntüle
            } else if (choice == 4) {
                System.out.print("Enter flight number to cancel: ");
                String flightNumber = scanner.nextLine();
                reservationSystem.cancelFlight(flightNumber); // Uçuşu iptal et
            } else if (choice == 5) {
                System.out.print("Enter destination: ");
                String destination = scanner.nextLine();
                reservationSystem.displayFlightsByDestination(destination); // Varış yerine göre uçuşları görüntüle
            } else if (choice == 6) {
                System.out.println("Exiting system. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }

        scanner.close();
    }
}
