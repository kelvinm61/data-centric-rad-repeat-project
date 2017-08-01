package College;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class CollegeController {

	private ArrayList<College> College;
	private DAO dao;

	public CollegeController() {
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<College> getCollege() {
		return College;
	}

	public void load() throws Exception {
		College = dao.getCollege();
	}

	public String add(College m) throws Exception {
		try {
			dao.add(m);
			return "College";
		} catch (Exception e) {
			return e.toString();
		}
	}

	public String update(College m) throws Exception {
		try {
			dao.updateCollege(m);
			return "College";
		} catch (Exception e) {
			return e.toString();
		}
	}

	public void delete(College m) {
		try {		
			dao.delete(m);
			FacesContext.getCurrentInstance().getExternalContext().redirect("College.xhtml");	
		} catch (SQLException e) {	
			FacesMessage msg = new FacesMessage("Error" + e);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
