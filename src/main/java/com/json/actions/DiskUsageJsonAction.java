package com.json.actions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.contact.action.ContactAUMByBranch;
import com.contact.action.ContactAUMByCIF;
import com.contact.action.ContactActivityLog;
import com.contact.action.ContactApplicationLog;
import com.contact.action.ContactPortHoldingBySubAccount;
import com.entity.bonanza.AUMByBranchMini;
import com.entity.bonanza.AUMByCIFMini;
import com.entity.bonanza.ActivityLogMini;
import com.entity.bonanza.ApplicationLogMini;
import com.entity.bonanza.PortHoldingBySubAccountMini;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class DiskUsageJsonAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1437159621211187771L;
	private ContactActivityLog ControllerActivity;
	private ContactApplicationLog ControllerApplication;
	private ContactAUMByCIF ControllerAUMByCIF;
	private ContactAUMByBranch ControllerAUMByBranch;
	private ContactPortHoldingBySubAccount ControllerPortHoldingBySubAccount;
	
	private List<Integer> dataactivity = new ArrayList<Integer>();
	private List<Integer> dataapplication = new ArrayList<Integer>();
	private List<Integer> dataaumbycif = new ArrayList<Integer>();
	private List<Integer> dataaumbybranch = new ArrayList<Integer>();
	private List<Integer> dataportholding = new ArrayList<Integer>();
	
	private String[] namemodules = {"Activity", "Application", "AUM BY CIF", "AUM BY Branch", "Portholding"};
	
	public void ContactController() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringBeans.xml");
		ControllerActivity = (ContactActivityLog) context.getBean("activitylog");
		ControllerApplication = (ContactApplicationLog) context.getBean("applicationlog");
		ControllerAUMByCIF = (ContactAUMByCIF) context.getBean("aumByCIF");
		ControllerAUMByBranch = (ContactAUMByBranch) context.getBean("aumByBranch");
		ControllerPortHoldingBySubAccount = (ContactPortHoldingBySubAccount) context.getBean("portHoldingBySubAccount");
	}
	
	public String execute() {
		ContactController();
		
		dataactivity .add(ControllerActivity.getCountByCriteriaSearch(new ActivityLogMini()));
		dataapplication .add(ControllerApplication.getCountByCriteriaSearch(new ApplicationLogMini()));
		dataaumbycif .add(ControllerAUMByCIF.getCountByCriteriaSearch(new AUMByCIFMini()));
		dataaumbybranch .add(ControllerAUMByBranch.getCountByCriteriaSearch(new AUMByBranchMini()));
		dataportholding .add(ControllerPortHoldingBySubAccount.getCountByCriteriaSearch(new PortHoldingBySubAccountMini()));
		return Action.SUCCESS;
	}

	public List<Integer> getDataapplication() {
		return dataapplication;
	}

	public ContactActivityLog getControllerActivity() {
		return ControllerActivity;
	}

	public List<Integer> getDataactivity() {
		return dataactivity;
	}

	public List<Integer> getDataaumbycif() {
		return dataaumbycif;
	}

	public List<Integer> getDataaumbybranch() {
		return dataaumbybranch;
	}

	public List<Integer> getDataportholding() {
		return dataportholding;
	}

	public String[] getNamemodules() {
		return namemodules;
	}

	public ContactApplicationLog getControllerApplication() {
		return ControllerApplication;
	}

	public ContactAUMByCIF getControllerAUMByCIF() {
		return ControllerAUMByCIF;
	}

	public ContactAUMByBranch getControllerAUMByBranch() {
		return ControllerAUMByBranch;
	}

	public ContactPortHoldingBySubAccount getControllerPortHoldingBySubAccount() {
		return ControllerPortHoldingBySubAccount;
	}
	
}