package com.json.actions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.contact.action.ContactMember;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class PercentNewUserJsonAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7612478744414801297L;
	private String[] month = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
			"Aug", "Sep", "Oct", "Nov", "Dec" };
	private List<Float> dataCurrentYear = new ArrayList<Float>();
	private List<Float> dataLastYear = new ArrayList<Float>();
	private List<Float> avgDate = new ArrayList<Float>();
	private float totalCurrentYear = 0.0f;
	private float totalLastYear = 0.0f;
	private String year = "";
    private ContactMember controllerMember;
	
    public void ContactController() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringBeans.xml");
		controllerMember = (ContactMember) context.getBean("members");
		
	}

	public String execute() {
		ContactController();
		dataCurrentYear = controllerMember.getListAverageNewUser(year);
		dataLastYear = controllerMember.getListAverageNewUser((Integer.parseInt(year)-1)+"");
		totalCurrentYear = controllerMember.countAllByYear(year);
		totalLastYear = controllerMember.countAllByYear((Integer.parseInt(year)-1)+"");
		avgDate = controllerMember.getAverage(dataCurrentYear, dataLastYear);
		return Action.SUCCESS;
	}

	public String[] getMonth() {
		return month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public List<Float> getDataCurrentYear() {
		return dataCurrentYear;
	}

	public List<Float> getDataLastYear() {
		return dataLastYear;
	}

	public List<Float> getAvgDate() {
		return avgDate;
	}

	public float getTotalCurrentYear() {
		return totalCurrentYear;
	}

	public float getTotalLastYear() {
		return totalLastYear;
	}

	
}
