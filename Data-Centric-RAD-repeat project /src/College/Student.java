package College;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Student {

	private String sID;
	private String colID;
	public String cID;
	private String first_name;
	private String last_name;
	private String Address;

	
	// Constructors
	public Student() {
	}

	public Student(String sID, String colID, String cID, String first_name, String last_name, String Address) {
		super();
		this.sID = sID;
		this.colID = colID;
		this.cID = cID;
		this.first_name = first_name;
		this.last_name = last_name;
		this.Address = Address;
		
	}

	// Getters and Setters
	public String getSID() {
		return sID;
	}

	public void setSID(String sID) {
		this.sID = sID;
	}

	public String getColID() {
		return colID;
	}

	public void setColID(String colID) {
		this.colID = colID;
	}

	public String getCID() {
		return cID;
	}

	public void setCID(String cID) {
		this.cID = cID;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAdress(String Address) {
		this.Address = Address;
	}

}