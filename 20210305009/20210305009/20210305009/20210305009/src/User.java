public class User {
    private String firstName;
    private String lastName;
    private String ID;

    public User(String firstName, String lastName, String ID) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (ID != null && !ID.isEmpty() && ID.matches("\\d{11}")) {
            this.ID = ID;
        } else {
            throw new IllegalArgumentException("ID must be a valid 11-digit number.");
        }
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getID() {
        return ID;
    }
}
