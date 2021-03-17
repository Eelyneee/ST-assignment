package st.assignment;

import java.util.*;
import java.io.IOException;



public class OrderApplication {
    static ArrayList<OrderDetails> itemArray = new ArrayList<OrderDetails>();
    static ArrayList<DeliveryRates> delivery = new ArrayList<DeliveryRates>();
    private static final Scanner in = new Scanner("System.in");
    private static ApplicationData appData; 

    public static void main(String[] args) throws IOException{  
		appData = new ApplicationData();
		login();
		int choice = 0;

		do{
        System.out.println("1- View item menu");
        System.out.println("2- Place order");
        System.out.println("3- Check order status");
        
		switch (choice){
			case 1:{

			}
			case 2:{
				
			}
			case 3:{

			}
			default:{
				System.out.println("Please enter between the range!");
			}
		}

		}while(choice!=4);
        
    }

	public static void login(){
		int choice;
		String memberID;
		String password;
		User[] ulist = appData.getUserArr();
		boolean logged = false;
        
		do{
			System.out.println("1. Login ");
			System.out.println("2. Login As Guest");
			System.out.println("3. Quit");
			choice = in.nextInt();

			switch (choice){
				case 1:{
                
				System.out.println("Enter member ID: ");
				memberID = in.next();

				System.out.println("Enter password: ");
				password = in.next();

				for(int i = 0; i < ulist.length; i++){
					if(ulist[i] instanceof Member){
						if (memberID.equals(((Member)ulist[i]).getMemberID())){
							if(password.equals(((Member)ulist[i]).getPassword())){
								appData.setLoggedInUser(ulist[i]);
								System.out.println("Logged in.");
								logged = true;
							}
						}
					}		
				}
				System.out.println("ID or password inncorrect, please try again");
				break;
				}			
				case 2:{
					System.out.println("Please enter your name: ");
					String name = in.nextLine();


					System.out.println("Enter unit No: ");
					String unitno = in.next();
					System.out.println("Enter street name: ");
            		String street = in.next();
					System.out.println("Enter postal code: ");					
            		String postalcode = in.next();
					System.out.println("Enter area: ");
            		String area = in.next();
					System.out.println("Enter district: ");
            		String district = in.next();
					System.out.println("Enter state: ");
            		String state = in.next();

           		 	Address tempAd = new Address(unitno, street, postalcode, area, district, state);
					
					appData.setLoggedInUser(new User (name, tempAd));
					System.out.println("Logged in as Guest");
					logged = true;
				break;
				}
				case 3:{
					System.exit(0);
				}
				default:{
					System.out.println("Please enter between 1 - 3");
				}
				
			}
	
		}while (logged == false);
	}


    public static double calculate_order_total (Order order, User user)
    {
		ArrayList <OrderDetails> itemlist = order.getItemList();
	    double total = 0.0;
	    if (user instanceof Member)
	    {
	    		//System.out.println("Item\tPrice(RM)\tQuantity");
	    	for (int i = 0; i < itemlist.size(); i++)
	    	        
		    {
	    		double price;
	    		if (itemlist.get(i).getItem().isPromotion())
	    		{
	    			price = itemlist.get(i).getItem().getMemberPrice()*0.95;
	    		}
	    		else
	    			price = itemlist.get(i).getItem().getMemberPrice();
	    			
		        	//System.out.println(itemlist.get(i).getItem().getItemName() + "\t" + price +  "\t" + itemlist.get(i).getQuantity());
		        total += price*itemlist.get(i).getQuantity();
		    }
	    		//System.out.println("------------------------------------------------------------------");
	    	
	    }
	    	
	    else
	    {
	    	//System.out.println("Item\tPrice(RM)\tQuantity");
	    	for (int i = 0; i < itemlist.size(); i++)
	    	        
		    {
	    		double price;
	    		if (itemlist.get(i).getItem().isPromotion())
	    		{
	    			price = itemlist.get(i).getItem().getNonMemberPrice()*0.95;
	    		}
	    	    else
	    		    price = itemlist.get(i).getItem().getNonMemberPrice();
	    			
		        System.out.println(itemlist.get(i).getItem().getItemName() + "\t" + price +  "\t" + itemlist.get(i).getQuantity());
		        total += price*itemlist.get(i).getQuantity();
		    }
	    	System.out.println("------------------------------------------------------------------");
	    		
	    }
	    return total;
    }

     public static double get_delivery_rate(User user, double ordertotal)
	{
	    double deliveryrates =0.0;
	    boolean found = false;
	    for (int i = 0; i<delivery.size();i++)
	    {
	    	if (user.getUserAddress().getArea().equals(delivery.get(i).getArea()))
	    	{
	    		deliveryrates = delivery.get(i).getRates();
	    		found = true;
	    		break;
	    	}
	    			
	    }
	    	
	    return deliveryrates;
    }      

    public static void view_item_menu(ArrayList <Item> itemArray)
    {
		//int pagesize = 10;
		//int totalpage = itemArray.size() / pagesize;
		//int choice = 0;

    	//txt file to array
        System.out.println("Name\t\tType\tMember Price (RM)\tNon-r Price (RM)\tPromotional Item");
        for(int i = 0; i < itemArray.size() ; i++)
        {
            System.out.print(itemArray.get(i).getItemName() + "\t\t" + itemArray.get(i).getItemType()+ "\t" + itemArray.get(i).getMemberPrice() + "\t" +itemArray.get(i).getNonMemberPrice() + "\t");
            if (itemArray.get(i).isPromotion())
            {
                System.out.println("Yes");
            }
            else
                System.out.println("No");
        }
    }

    
    public static void place_order(ArrayList<Item> itemArray,User user) 
    {

    		String oItemName="";
    		Item tempItem;
        	int oItemQuantity=0;
        	String oDetailsID;
        	char repeat=0;
        	double total = 0.0;
        	ArrayList <OrderDetails> orderItemList= new ArrayList <OrderDetails>();
        	Order order;
        	//validate address
        	if(user.getUserAddress().getState().equals("Melaka"))
        	{
        		//view item menu
            	view_item_menu(itemArray);
            	oDetailsID = "";
            	//loop (prompt enter item name & quantity)
            	do
            	{
            		System.out.println("Enter item name: ");
            		oItemName = in.nextLine();
            		for(int i=0;i<itemArray.size();i++)
            		{
            			if(oItemName.equals(itemArray.get(i).getItemName()))
            			{
            				tempItem = itemArray.get(i);	
            				System.out.println("Enter quantity: ");
            				oItemQuantity = in.nextInt();
            				//oDetailsID = "OD000" + itemArray.get(i+1);
            				oDetailsID = "OD0001";
							orderItemList.add(new OrderDetails(oDetailsID,tempItem,oItemQuantity));
            			}            			           		        			
            		}
            		
            		System.out.println("Order more items? y-yes/n-no");
            		repeat=in.next().charAt(0);
            	}while(repeat=='y' || repeat == 'Y');
        		
                order = new Order (user, orderItemList, oDetailsID); 	
            	//print orderdetails
            	System.out.println("Items ordered are listed below: ");
            	for(int i =0;i<order.getItemList().size();i++)
               {
            	   System.out.println(i+1 +"	"+ order.getItemList().get(i).getItem().getItemName() +"	"+	order.getItemList().get(i).getQuantity());
               }
            	
            	//check total item price (if < 25,charge RM3)update total price
            	//check delivery area , calculate total price.
            	//why call order??//here i do ady
            	/*calculate_order_total (order,user); 
            	if(total <= 25.0)
            	{
            		total = total + 3 + get_delivery_rate(user,total);
            	}
            	else 
            	{
            		 total += get_delivery_rate(user,total);
            	}
                */
            Double ordertotal = calculate_order_total(order, user);
	        
	        System.out.println(ordertotal);
	        
	        if (ordertotal<25)
	        {
	        	ordertotal +=3;
	        }
	        
	        Double deliveryrates = get_delivery_rate(user, ordertotal);
	        
	        System.out.println(deliveryrates);
	        
	        System.out.println(ordertotal+deliveryrates);
	        
            	
            	
            	
            	//create order (orderUser, getuseraddress, item) still need order ID?
            	//order = new Order (user,orderItemList,"OID123");
            	
            	
        	}else
        		System.out.println("The delivery service is only provided within Melaka.Order cancel.");
        	

        
    }

    public static void validate_delivery_address (User orderUser)
    {
        if(orderUser.getUserAddress().getState()!=("Melaka"))
        {
            orderUser.setUserAddress(null);
            System.out.println("Address not available for delivery! ");
        }
        
    }
    
    public static double view_order_status(Payment payment){
        return 0.0;
    }


}
