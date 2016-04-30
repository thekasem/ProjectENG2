package com.json.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.contact.action.ContactAnalysisBuyAsset;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class AnalysisLineDataJsonAction extends ActionSupport {

	private String selectTime;
	private String fromYear;
	private String toYear;
	private String fromMonth;
	private String toMonth;
	private String toYearII;

	private List<Double> person;
	private List<Double> corperation;
	private List<Double> stocks;
	private List<Double> exchange;
	private List<Double> gold;
	private List<Double> land;
	private List<Double> oil;
	private List<Double> bulding;
	private List<Double> equipment;
	private List<Double> mine;

	private List<String> dateList;

	private HttpSession session;
	private ContactAnalysisBuyAsset analysisBuyAsset;
	private String userNameLogin;
	private String dateSelect;

	public void ContactController() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringBeans.xml");
		analysisBuyAsset = (ContactAnalysisBuyAsset) context
				.getBean("analysisbuyasset");
		session = ServletActionContext.getRequest().getSession();
	}

	private String yearAndMonth(String year, int month) {
		String result = "";
		if (month < 10) {
			result = year + "0" + month;
		} else {
			result = year + month;
		}
		return result;
	}

	public String getDataCustomer() {
		
		person = new ArrayList<Double>();
		corperation = new ArrayList<Double>();
		stocks = new ArrayList<Double>();
		exchange = new ArrayList<Double>();
		gold = new ArrayList<Double>();
		land = new ArrayList<Double>();
		oil = new ArrayList<Double>();
		bulding = new ArrayList<Double>();
		equipment = new ArrayList<Double>();
		mine = new ArrayList<Double>();
		
		ContactController();
		userNameLogin = (String) session.getAttribute("user");
		dateList = analysisBuyAsset.getDateList(selectTime, fromYear, toYear, fromMonth, toMonth, toYearII);
		List<Object[]> listCustomer = analysisBuyAsset.getValueCutomer(dateList, selectTime);
		List<Object[]> listAsset = analysisBuyAsset.getValueAsset(dateList, selectTime);
		getCustomer(listCustomer);
		getAsset(listAsset);
		
		if (selectTime.trim().equals("1")) {
			dateSelect = "AllYear";
		} else if (selectTime.trim().equals("2")) {
			dateSelect = "From " + fromYear + " To " + toYear;
		} else if (selectTime.trim().equals("3")) {
			dateSelect = "From "+fromMonth+","+toYearII+ " To "+toMonth+","+toYearII;
		}
		
		return Action.SUCCESS;
	}

	public void setSelectTime(String selectTime) {
		this.selectTime = selectTime;
	}

	public void setFromYear(String fromYear) {
		this.fromYear = fromYear;
	}

	public void setToYear(String toYear) {
		this.toYear = toYear;
	}

	public void setFromMonth(String fromMonth) {
		this.fromMonth = fromMonth;
	}

	public void setToMonth(String toMonth) {
		this.toMonth = toMonth;
	}

	public void setToYearII(String toYearII) {
		this.toYearII = toYearII;
	}

	public String getUserNameLogin() {
		return userNameLogin;
	}

	public String getDateSelect() {
		return dateSelect;
	}

	public List<Double> getPerson() {
		return person;
	}

	public List<Double> getCorperation() {
		return corperation;
	}

	public List<Double> getStocks() {
		return stocks;
	}

	public List<Double> getExchange() {
		return exchange;
	}

	public List<Double> getGold() {
		return gold;
	}

	public List<Double> getLand() {
		return land;
	}

	public List<Double> getOil() {
		return oil;
	}

	public List<Double> getBulding() {
		return bulding;
	}

	public List<Double> getEquipment() {
		return equipment;
	}

	public List<Double> getMine() {
		return mine;
	}

	public List<String> getDateList() {
		return dateList;
	}

	private void getCustomer(List<Object[]> listCustomer){
		for(Object[] result:listCustomer){
			person.add(Double.parseDouble(result[0]+""));
			corperation.add(Double.parseDouble(result[1]+""));
		}
	}
	
	private void getAsset(List<Object[]> listAsset){
		for(Object[] result: listAsset){
			stocks.add(Double.parseDouble(result[0]+""));
			exchange.add(Double.parseDouble(result[1]+""));
			gold.add(Double.parseDouble(result[2]+""));
			land.add(Double.parseDouble(result[3]+""));
			oil.add(Double.parseDouble(result[4]+""));
			bulding.add(Double.parseDouble(result[5]+""));
			equipment.add(Double.parseDouble(result[6]+""));
			mine.add(Double.parseDouble(result[7]+""));
		}
	}

}
