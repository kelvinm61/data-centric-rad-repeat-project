package College;

import javax.faces.bean.ManagedBean;

@ManagedBean

public class Course{

	private String colId;
	private String cID;
	private String cName;
	

	// Constructors
	public Course() {
	}

	public Course(String colId, String cID, String cName) {
		super();
		this.colId = colId;
		this.cID = cID;
		this.cName = cName;
	}

	// Getters and Setters
	public String getManCode() {
		return colId;
	}

	public void setManCode(String colId) {
		this.colId = colId;
	}
	
	public String getCarCode() {
		return cID;
	}

	public void setCarCode(String cID) {
		this.cID = cID;
	}

	public String getName() {
		return cName;
	}

	public void setName(String cName) {
		this.cName = cName;
	}

	public String getColId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCID() {
		// TODO Auto-generated method stub
		return null;
	}
}