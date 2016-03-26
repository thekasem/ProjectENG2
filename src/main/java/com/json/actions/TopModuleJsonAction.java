package com.json.actions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.contact.action.ContactActivityLog;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class TopModuleJsonAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4994150963693242934L;
	private String[] month = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
			"Aug", "Sep", "Oct", "Nov", "Dec" };
    private List<String> nameModule = new ArrayList<String>();
    private List<Integer> dataModule1 = new ArrayList<Integer>();
    private List<Integer> dataModule2 = new ArrayList<Integer>();
    private List<Integer> dataModule3 = new ArrayList<Integer>();
    private List<Integer> dataModule4 = new ArrayList<Integer>();
    private List<Integer> dataModule5 = new ArrayList<Integer>();
    private String year = "";
    private ContactActivityLog Controller;
    
    public void ContactController() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringBeans.xml");
		Controller = (ContactActivityLog) context.getBean("activitylog");
	}
	public String execute() {
		ContactController();
		nameModule = Controller.getNameAction(year);
		
		dataModule1 = Controller.getDataAction(nameModule.get(0), year);
		dataModule2 = Controller.getDataAction(nameModule.get(1), year);
		dataModule3 = Controller.getDataAction(nameModule.get(2), year);
		dataModule4 = Controller.getDataAction(nameModule.get(3), year);
		dataModule5 = Controller.getDataAction(nameModule.get(4), year);
		return Action.SUCCESS;
	}
	public String[] getMonth() {
		return month;
	}
	public List<String> getNameModule() {
		return nameModule;
	}
	public List<Integer> getDataModule1() {
		return dataModule1;
	}
	public List<Integer> getDataModule2() {
		return dataModule2;
	}
	public List<Integer> getDataModule3() {
		return dataModule3;
	}
	public List<Integer> getDataModule4() {
		return dataModule4;
	}
	public List<Integer> getDataModule5() {
		return dataModule5;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}


}
