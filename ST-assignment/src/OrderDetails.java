package st.assignment;
public class OrderDetails 

{
	private String OrderDetailsID;
	
	public String getOrderDetailsID() {
		return OrderDetailsID;
	}

	private Item item;
	public Item getItem() {
		return item;
	}
    private int quantity;
	public int getQuantity() {
		return quantity;
	}

	
	public OrderDetails(String orderDetailsID, Item item, int quantity) 
	{
		OrderDetailsID = orderDetailsID;
		this.item = item;
		this.quantity = quantity;
	}
	
	
}
