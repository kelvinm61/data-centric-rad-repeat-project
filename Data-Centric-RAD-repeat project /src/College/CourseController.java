package College;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CourseController {

	private ArrayList<Course> Course;
	private DAO dao;

	public CourseController() {
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Course> getCourse() {
		return Course;
	}

	public void load() throws Exception {
		Course = dao.getCourse();
	}

	public String add(Course m) throws Exception {
		try {
			dao.addCourse(m);
			return "Course";
		} catch (Exception e) {
			return e.toString();
		}
	}
}
