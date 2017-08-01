package College;

import javax.faces.bean.ManagedBean;

@ManagedBean

public class College<String> {

	private String colId;
	private String colName;
	public String colAddr;

	// Constructors
	public College() {
	}

	public College(String colId, String colName, String colAddr) {
		super();
		this.colId = colId;
		this.colName = colName;
		this.colAddr = colAddr;
	}

	// Getters and Setters
	public String getcolId() {
		return colId;
	}

	public void setcolId(String colId) {
		this.colId = colId;
	}

	public String getcolName() {
		return colName;
	}

	public void setcolName(String colName) {
		this.colName = colName;
	}
	
	public String getcolAddr() {
		return colAddr;
	}

	public void setcolAddr(String colAddr) {
		this.colAddr = colAddr;
	}

	public String getcolId1() {
		// TODO Auto-generated method stub
		return null;
	}
}