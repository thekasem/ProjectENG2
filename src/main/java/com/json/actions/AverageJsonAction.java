package com.json.actions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.contact.action.ContactActivityLog;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class AverageJsonAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5384765347204943525L;

	private String timeonsite = "Time On Site";
	private String year = "";
	private List<Float> dataaverage = new ArrayList<Float>();
	private ContactActivityLog Controller;
	
	public void ContactController() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringBeans.xml");
		Controller = (ContactActivityLog) context.getBean("activitylog");
	}

	public String execute() {
		ContactController();
		//List<String> test4 = Controller.nameTopUser(year);
		dataaverage = Controller.getListAverageTimeOnSite(year);
		return Action.SUCCESS;
	}

	public String getTimeonsite() {
		return timeonsite;
	}

	public void setTimeonsite(String timeonsite) {
		this.timeonsite = timeonsite;
	}

	public List<Float> getDataaverage() {
		return dataaverage;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}