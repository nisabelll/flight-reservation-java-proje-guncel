public abstract class Flight {
    private String flightNumber;
    private String destination;
    private String flightName;
    private String departureTime;
    private String arrivalTime;
    private double price;

    public Flight(String flightNumber, String destination, String flightName, String departureTime, String arrivalTime, double price) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.flightName = flightName;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public String getFlightName() {
        return flightName;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public double getPrice() {
        return price;
    }

    public abstract void displayFlightDetails();
}
