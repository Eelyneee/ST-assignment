package st.assignment;

import java.util.HashMap;
import java.util.ArrayList;

public class Order 
{
    private User orderUser;
    
    private ArrayList <OrderDetails> itemlist;
    private double totalPrice;
    private String orderID;

	public ArrayList <OrderDetails> getItemList()
	{
		return itemlist;
	}
    
    
    public Address getDeliveryAddress() {
    	
    	return orderUser.getUserAddress();
    }

	


	public Order(User orderUser, ArrayList <OrderDetails> itemlist, String orderID) {
		this.orderUser = orderUser;
		this.itemlist = itemlist;
		this.orderID = orderID;
	}

    
    
    
    


}