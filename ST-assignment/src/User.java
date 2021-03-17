package st.assignment;

public class User {
    private String name;
    private Address userAddress;
    
    public String getName() {
		return name;
	}

	public Address getUserAddress() {
		return userAddress;
	}

    public void setUserAddress(Address address){}

	public User(String name, Address userAddress) {
        this.name = name;
        this.userAddress = userAddress;
    }
}