public class Member extends User {
    private String memberID;
    private int phoneNumber;


    public Member(String memberID, int phoneNumber) {
        this.memberID = memberID;
        this.phoneNumber = phoneNumber;
    }
}