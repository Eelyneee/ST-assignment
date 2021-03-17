package st.assignment;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public class ApplicationData{


    private ArrayList<Order> orderArray;
    private ArrayList<User> userArray;
    private ArrayList<Item> itemArray;

    private ArrayList<DeliveryRates> deliveryRates;

    private User loggedInUser;


    private static final String itemFile = "itemList.txt";
    private static final String memberFile = "memberList.txt";
    private static final String deliveryRatesFile = "deliveryRates.txt";

    public User getLoggedInUser (){
        return loggedInUser;
    }

    public void setLoggedInUser (User u){
        this.loggedInUser = u;
    }

    
    public ArrayList<Order> getOrderArray (){
        return orderArray;
    }

    public ArrayList<Item> getItemArray (){
        return itemArray;
    }

    public ArrayList<User> getUserArray (){
        return userArray;
    }

    public User[] getUserArr ()
	{
		User [] userArr = new User [userArray.size()];
		userArr = userArray.toArray(userArr);
		return userArr;		
	}

    public ArrayList<DeliveryRates> getDeliveryRates (){
        return deliveryRates;
    }



    private void readDeliveryRatesFile() throws IOException{
        Scanner fin = new Scanner(Paths.get(deliveryRatesFile), "UTF-8");

        fin.useDelimiter(",");
        while (fin.hasNext()) {
            String area = fin.next();
            double rates = Double.parseDouble(fin.next());

            fin.nextLine();
            
            DeliveryRates temp = new DeliveryRates(area, rates);
            deliveryRates.add(temp);
        }
    }


    private void readMemberFile() throws IOException{
        Scanner fin = new Scanner(Paths.get(memberFile), "UTF-8");

        fin.useDelimiter(",");
        while (fin.hasNext()) {
            String memberId = fin.next();
            String name = fin.next();
            String password = fin.next();
            int phone = Integer.parseInt(fin.next());

            String unitno = fin.next();
            String street = fin.next();
            String postalcode = fin.next();
            String area = fin.next();
            String district = fin.next();
            String state = fin.next();

            fin.nextLine();

            Address tempAd = new Address(unitno, street, postalcode, area, district, state);
            Member tempMem = new Member(memberId, name, password, phone, tempAd);

            userArray.add(tempMem);

        }
    }

    private void readItemFile() throws IOException{

        Scanner fin = new Scanner(Paths.get(itemFile), "UTF-8");

		fin.useDelimiter(",");
		while (fin.hasNext()) {
            String name = fin.next();
            String type = fin.next();
            double memberPrice = Double.parseDouble(fin.next());
            double nonMemberPrice = Double.parseDouble(fin.next());
            String promotionText = fin.next();
            boolean promotion;
            if (promotionText.equalsIgnoreCase("Yes")){
                promotion = true;
            }else{
                promotion = false;
            }

            fin.nextLine();
            Item temp = new Item (name,type, memberPrice, nonMemberPrice, promotion);
            itemArray.add(temp);

        }
		fin.close();
    }

    public ApplicationData() throws IOException{

        itemArray = new ArrayList<Item>();
        userArray = new ArrayList<User>();
        orderArray = new ArrayList<Order>();
        readDeliveryRatesFile();
        readMemberFile();
        readItemFile();

    }

    




}