public class Member extends User {
    private String memberID;
    private int phoneNumber;
    
    
    
	public Member(String name, Address userAddress, String memberID, int phoneNumber) {
		super(name, userAddress);
		this.phoneNumber = phoneNumber;
		this.memberID = memberID;
	}

  

}