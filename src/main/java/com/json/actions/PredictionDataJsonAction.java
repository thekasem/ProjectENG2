package com.json.actions;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.contact.action.ContactPredictionBuyAsset;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class PredictionDataJsonAction extends ActionSupport{
	
	private HttpSession session;
	private String userNameLogin;
	private String functionPrediction;
	private ContactPredictionBuyAsset predictionBuyAsset;
	
	private void ContactController(){
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
		predictionBuyAsset = (ContactPredictionBuyAsset) context.getBean("preditionbuyasset");
		session = ServletActionContext.getRequest().getSession();
		userNameLogin = (String) session.getAttribute("user");
	}

	public String getDataPredictionLine(){
		ContactController();
		return Action.SUCCESS;
	}
	
	public String getDataPredictionScatter(){
		ContactController();
		return Action.SUCCESS;
	}
	
	public String getDataPredictionColumn(){
		ContactController(); 
		return Action.SUCCESS;
	}
	
}
