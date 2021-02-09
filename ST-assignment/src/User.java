abstract public class User {
    private String name;
    private Address userAddress;
    
    

    public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Address getUserAddress() {
		return userAddress;
	}



	public void setUserAddress(Address userAddress) {
		this.userAddress = userAddress;
	}



	public User(String name, Address userAddress) {
        this.name = name;
        this.userAddress = userAddress;
    }
}