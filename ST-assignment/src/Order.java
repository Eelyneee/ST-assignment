public class Order {
    private User orderUser;
    private double deliveryCharges;
    
    
    
    public Address getDeliveryAddress() {
    	
    	return orderUser.getUserAddress();
    }
    
    


}