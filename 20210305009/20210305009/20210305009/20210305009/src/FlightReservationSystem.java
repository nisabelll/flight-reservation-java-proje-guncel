import java.util.*;
import java.util.stream.Collectors;

public class FlightReservationSystem<T extends Flight> implements Reservation {
    private List<T> flights;               // Uçuşları tutan liste
    private Map<String, T> flightMap;      // Uçuş numarasına göre uçuşları tutan Map

    public FlightReservationSystem() {
        flights = new ArrayList<>();       // Listeyi başlatıyoruz
        flightMap = new HashMap<>();       // Map'i başlatıyoruz
    }

    // Uçuş ekleme
    public void addFlight(T flight) {
        flights.add(flight);               // Listeye ekle
        flightMap.put(flight.getFlightNumber(), flight); // Map'e ekle
    }

    // Mevcut uçuşları görüntüleme
    public void displayAvailableFlights() {
        if (flights.isEmpty()) {
            System.out.println("No available flights at the moment.");
        } else {
            System.out.println("Available flights:");
            flights.forEach(flight -> {
                flight.displayFlightDetails();
                System.out.println();
            });
        }
    }

    //Lambda kullanımı
    @Override
    public void bookFlight(String flightNumber, User user) {
        flightMap.entrySet().stream()
                .filter(entry -> entry.getKey().equals(flightNumber))
                .findFirst()
                .ifPresentOrElse(
                        entry -> System.out.println(user.getFullName() + " booked flight: " + flightNumber),
                        () -> System.out.println("Flight not found.")
                );
    }

    //Lambda kullanımı ekledik
    @Override
    public void cancelFlight(String flightNumber) {
        T removedFlight = flightMap.remove(flightNumber); // Map'ten kaldır
        if (removedFlight != null) {
            flights.removeIf(flight -> flight.getFlightNumber().equals(flightNumber)); // Listeden kaldır
            System.out.println("Flight " + flightNumber + " has been cancelled.");
        } else {
            System.out.println("Flight not found.");
        }
    }

    // Uçuş detaylarını görüntüleme (eklenmiş uçuşlar için)
    public void displayFlightDetails() {
        if (flights.isEmpty()) {
            System.out.println("No flights have been booked yet.");
        } else {
            flights.forEach(T::displayFlightDetails); // Lambda ile listeyi dolaşma
        }
    }

    // Belirli bir varış noktasına uçuşları listeleme (Lambda ve Stream API kullanımı)
    public void displayFlightsByDestination(String destination) {
        List<T> filteredFlights = flights.stream()
                .filter(flight -> flight.getDestination().equalsIgnoreCase(destination))
                .collect(Collectors.toList());

        if (filteredFlights.isEmpty()) {
            System.out.println("No flights available to " + destination);
        } else {
            System.out.println("Flights to " + destination + ":");
            filteredFlights.forEach(T::displayFlightDetails);
        }
    }
}
