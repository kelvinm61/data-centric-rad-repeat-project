package College;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.naming.*;
import javax.sql.DataSource;

public class DAO {
	
	private DataSource mysqlDS;

	public DAO() throws Exception {
		Context context = new InitialContext();
		String jndiName = "java:comp/env/jdbc/College";
		mysqlDS = (DataSource) context.lookup(jndiName);
	}

	// Delete a College of cars
	public void delete(College m) throws SQLException {

		Connection conn = mysqlDS.getConnection();
		PreparedStatement statement = conn.prepareStatement("delete from College where colID ='" + ((College) m).getcolId() + "' and  ='" + m.getcolName() + "' and colAddr ='" + m.getcolAddr() + "'");

		statement.executeUpdate();
	} // delete

	// Update Addr of College
	public void updateCollege(College m) throws SQLException {
		Connection conn = mysqlDS.getConnection();
		PreparedStatement statement = conn.prepareStatement("update College set colID = ?, colName = ?, colAddr = ? where colID = ?");
		
		statement.setString(1, (String) m.getcolId());
		statement.setString(2, (String) m.getcolName());
		statement.setString(3, (String) m.getcolAddr());
		statement.setString(4, (String) m.getcolId());
		
		statement.executeUpdate();
	} // end update

	// Functions to add to the database
	// Add a College
	@SuppressWarnings("rawtypes")
	public void add(College m) throws SQLException {

		Connection conn = mysqlDS.getConnection();
		PreparedStatement statement = conn.prepareStatement("INSERT INTO College values(?, ?, ?)");

		statement.setString(1, (String) m.getcolId());
		statement.setString(2, (String) m.getcolName());
		statement.setString(3, (String) m.getcolAddr());
		
		statement.executeUpdate();
		
	} // end add
	
	// Add a new Course of Student 
	public void addCourse(Course m) throws SQLException {

		Connection conn = mysqlDS.getConnection();
		PreparedStatement statement = conn.prepareStatement("INSERT INTO Course values(?, ?, ?, ?)");

		statement.setString(1, m.getColId());
		statement.setString(2, m.getCID());
		statement.setString(3, m.getName());

		statement.executeUpdate();
		
	} // end addCourse
	
	// Add a unique Student to the database
	public void addStudent(Student v) throws SQLException {

		Connection conn = mysqlDS.getConnection();
		PreparedStatement statement = conn.prepareStatement("INSERT INTO Student values(?, ?, ?, ?, ?, ?)");

		statement.setString(1, v.getSID());
		statement.setString(2, v.getColID());
		statement.setString(3, v.getCID());
		statement.setString(4, v.getFirst_name());
		statement.setString(5, v.getLast_name());
		statement.setString(6, v.getAddress());

		statement.executeUpdate(); 
		
	} // end addStudent

	// Generating ArrayLists to display the required information
	// College Lists
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<College> getCollege() throws Exception {

		ArrayList<College> College = new ArrayList<College>();

		Connection conn = mysqlDS.getConnection();
		PreparedStatement statement = conn.prepareStatement("select * from College");

		ResultSet result = statement.executeQuery();

		while (result.next()) {

			String ID = result.getString("colID");
			String name = result.getString("colName");
			String Addr = result.getString("colAddr");

			College.add(new College(ID, name, Addr));
		}

		return College;
	} // end getCollege
	
	// Student Course lists
	public ArrayList<Course> getCourse() throws Exception {

		ArrayList<Course> Course = new ArrayList<Course>();

		Connection conn = mysqlDS.getConnection();
		PreparedStatement statement = conn.prepareStatement("select * from Course");

		ResultSet result = statement.executeQuery();

		while (result.next()) {

			String colID = result.getString("colID");
			String cID = result.getString("cID");
			String name = result.getString("model_name");
			
			Course.add(new Course(colID, cID, name));
		}

		return Course;
	} // end getCourse
	
	// Generate the Address of a Student to a list
	public ArrayList<Student> getStudent() throws Exception {

		ArrayList<Student> Student = new ArrayList<Student>();

		Connection conn = mysqlDS.getConnection();
		PreparedStatement statement = conn.prepareStatement("select * from Student");

		ResultSet result = statement.executeQuery();

		while (result.next()) {

			String sID = result.getString("sID");
			String colID = result.getString("colID");
			String cID = result.getString("cID");
			String first_name = result.getString("first_name");
			String last_name = result.getString("last_name");
			String Address = result.getString("Address");

			Student.add(new Student(sID, colID, cID, first_name,last_name, Address));
		}

		return Student;
	} // end getStudent
	
	// Generate the Address of a Student to a list
	public ArrayList<Student> getVehicleDetails(Student v) throws SQLException {

		ArrayList<Student> Student = new ArrayList<Student>();

		Connection conn = mysqlDS.getConnection();
		PreparedStatement statement = conn.prepareStatement("select * from Student where sID is ?");

		ResultSet result = statement.executeQuery();

		statement.setString(1, v.getSID());
		String sID = result.getString("sID");
		String colID = result.getString("colID");
		String cID = result.getString("cID");
		String first_name = result.getString("first_name");
		String last_name = result.getString("last_name");
		String Address = result.getString("Address");
		
		Student.add(new Student(sID, colID, cID, first_name, last_name, Address));
		
		return Student;
		
	} // end getStudent


}