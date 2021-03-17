package st.assignment;

public class Item {
	private String itemName;
	private String itemType;
	private double memberPrice;
	private double nonMemberPrice;
	private boolean promotion;
	public String getItemName() {
		return itemName;
	}



	public String getItemType() {
		return itemType;
	}



	public double getMemberPrice() {
		return memberPrice;
	}



	public double getNonMemberPrice() {
		return nonMemberPrice;
	}

	

	public boolean isPromotion() {
		return promotion;
	}

	

	public String toString(){
		return String.format("%s %s %.2f %.2f %s", itemName, itemType, memberPrice, nonMemberPrice, isPromotion());
	}



	public Item(String itemName, String itemType, double memberPrice, double nonMemberPrice, boolean promotion) {
		super();
		this.itemName = itemName;
		this.itemType = itemType;
		this.memberPrice = memberPrice;
		this.nonMemberPrice = nonMemberPrice;
		this.promotion = promotion;
	}
	
	

}
