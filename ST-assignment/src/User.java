abstract public class User {
    private String name;
    private Address userAddress;

    public User(String name, Address userAddress) {
        this.name = name;
        this.userAddress = userAddress;
    }
}