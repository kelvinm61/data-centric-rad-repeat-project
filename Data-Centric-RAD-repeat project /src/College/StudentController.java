package College;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class StudentController {

	private ArrayList<Student> Student;
	private DAO dao;

	public StudentController() {
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Student> getStudent() {
		return Student;
	}

	public void load() throws Exception {
		Student = dao.getStudent();
	}
	
	public void loadDetails(Student v) throws Exception {
		Student = dao.getStudentDetails(v);
	}

	public String add(Student v) throws Exception {
		try {
			dao.addStudent(v);
			return "Student";
		} catch (Exception e) {
			return e.toString();
		}
	}
}
