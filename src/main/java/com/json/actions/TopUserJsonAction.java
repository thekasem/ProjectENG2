package com.json.actions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.contact.action.ContactActivityLog;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class TopUserJsonAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8038905110598528714L;

	private List<String> user = new ArrayList<String>();
	private List<Float> datauser1 = new ArrayList<Float>();
	private List<Float> datauser2 = new ArrayList<Float>();
	private List<Float> datauser3 = new ArrayList<Float>();
	private List<Float> datauser4 = new ArrayList<Float>();
	private List<Float> datauser5 = new ArrayList<Float>();
	private ContactActivityLog Controller;
	private String []sex = { "male", "female" };
	private String year = "";
	
	
	public void ContactController() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringBeans.xml");
		Controller = (ContactActivityLog) context.getBean("activitylog");
	}
	public String execute() {
		ContactController();
		user = Controller.nameTopUser(year);
		datauser1 = Controller.getDataAverageTimeByUser(year, 1);
		datauser2 = Controller.getDataAverageTimeByUser(year, 2);
		datauser3 = Controller.getDataAverageTimeByUser(year, 3);
		datauser4 = Controller.getDataAverageTimeByUser(year, 4);
		datauser5 = Controller.getDataAverageTimeByUser(year, 5);
		return Action.SUCCESS;
	}

	public String [] getSex() {
		return sex;
	}

	public void setSex(String [] sex) {
		this.sex = sex;
	}

	public List<String> getUser() {
		return user;
	}

	public List<Float> getDatauser1() {
		return datauser1;
	}

	public List<Float> getDatauser2() {
		return datauser2;
	}

	public List<Float> getDatauser3() {
		return datauser3;
	}

	public List<Float> getDatauser4() {
		return datauser4;
	}

	public List<Float> getDatauser5() {
		return datauser5;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}