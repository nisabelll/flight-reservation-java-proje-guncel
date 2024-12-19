//Interface (Arayüz)

//FlightReservationSystem sınıfı bu interface'i implement ederek uçuş rezervasyonu ve iptali gibi işlemleri gerçekleştirir.

public interface Reservation {
    void bookFlight(String flightNumber, User user);
    void cancelFlight(String flightNumber);
}


