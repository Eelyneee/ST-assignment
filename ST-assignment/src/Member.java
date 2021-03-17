package st.assignment;

public class Member extends User {
    private String memberID;
    private int phoneNumber;
    private String password;

	public String getPassword(){
		return password;
	}
    
	public String getMemberID() {
		return memberID;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}


	public Member(String memberID, String name, String password, int phoneNumber, Address userAddress) {
		super(name, userAddress);
		this.phoneNumber = phoneNumber;
		this.memberID = memberID;
	}

}