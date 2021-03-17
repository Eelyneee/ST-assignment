package st.assignment;

public class Payment {
	private boolean orderStatus;
	private String paymentMethod;
	private String paymentStatus;
	private double totalPrice;
	private Order paymentOrder;
	
	
	
	public Payment(boolean orderStatus, String paymentMethod, String paymentStatus, double totalPrice,
			Order paymentOrder) {
		this.orderStatus = orderStatus;
		this.paymentMethod = paymentMethod;
		this.paymentStatus = paymentStatus;
		this.totalPrice = totalPrice;
		this.paymentOrder = paymentOrder;
	}
	
	

}
