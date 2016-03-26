package com.json.actions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class UserJsonAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9119998754555711912L;
	private String[] month = {"Jan", "Feb", "Mar", "Apr","May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	private int[] dataCurrentYear = {1,13,6,5,25,40,12,15,17,28,29,10};
	private int[] dataLastYear = {3,6,7,2,32,12,45,56,75,76,24,25};

	public String execute() {
		return Action.SUCCESS;
	}

	public String[] getMonth() {
		return month;
	}

	public int[] getDataCurrentYear() {
		return dataCurrentYear;
	}

	public int[] getDataLastYear() {
		return dataLastYear;
	}

}
