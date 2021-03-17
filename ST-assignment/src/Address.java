package st.assignment;
public class Address 
{
    private String area;
    private String district;
    private String postalCode;
    private String state;
    private String streetName;
    private String unitNumber;
    
    
    
	public String getArea() {
		return area;
	}




	public String getDistrict() {
		return district;
	}




	public String getPostalCode() {
		return postalCode;
	}




	public String getState() {
		return state;
	}




	public String getStreetName() {
		return streetName;
	}




	public String getUnitNumber() {
		return unitNumber;
	}




	public Address(String unitNumber, String streetName, String postalCode, String area, String district, String state 
			) {
		super();
		this.area = area;
		this.district = district;
		this.postalCode = postalCode;
		this.state = state;
		this.streetName = streetName;
		this.unitNumber = unitNumber;
	}
    
    
}