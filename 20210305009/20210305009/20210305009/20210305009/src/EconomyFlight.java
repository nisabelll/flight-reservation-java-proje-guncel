public class EconomyFlight extends Flight {
    public EconomyFlight(String flightNumber, String destination, String flightName, String departureTime, String arrivalTime, double price) {
        super(flightNumber, destination, flightName, departureTime, arrivalTime, price);
    }

    @Override
    public void displayFlightDetails() {
        System.out.println("Economy Flight - " + getFlightNumber() + " to " + getDestination());
        System.out.println("Flight Name: " + getFlightName());
        System.out.println("Departure Time: " + getDepartureTime());
        System.out.println("Arrival Time: " + getArrivalTime());
        System.out.println("Price: $" + getPrice());
    }
}
