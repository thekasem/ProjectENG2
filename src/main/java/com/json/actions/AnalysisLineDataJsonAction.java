package com.json.actions;

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
		ContactController();
		userNameLogin = (String) session.getAttribute("user");
		if (selectTime.trim().equals("1")) {
			ListDataShowContI();
//			valueCustomer = analysisBuyAsset.getValuesCustomer();
//			valuetAsset = analysisBuyAsset.getvaluesAsset();
			dateSelect = "AllYear";
		} else if (selectTime.trim().equals("2")) {
			ListDataShowContII();
//			valueCustomer = analysisBuyAsset.getvaluesCustomer(fromYear + "01",
//					toYear + "12");
//			valuetAsset = analysisBuyAsset.getValuesAsset(fromYear + "01",
//					toYear + "12");
			dateSelect = "From " + fromYear + " To " + toYear;
		} else if (selectTime.trim().equals("3")) {
			ListDataShowContIII();
//			valueCustomer = analysisBuyAsset.getvaluesCustomer(
//					yearAndMonth(toYearII, Integer.parseInt(fromMonth)),
//					yearAndMonth(toYearII, Integer.parseInt(toMonth)));
//			valuetAsset = analysisBuyAsset.getValuesAsset(
//					yearAndMonth(toYearII, Integer.parseInt(fromMonth)),
//					yearAndMonth(toYearII, Integer.parseInt(toMonth)));
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

	private void ListDataShowContI() {
		person = analysisBuyAsset.getValuesCustomer("1", '2');
		corperation = analysisBuyAsset.getValuesCustomer("2", '2');
		stocks = analysisBuyAsset.getvaluesAsset("1", '2');
		exchange = analysisBuyAsset.getvaluesAsset("2", '2');
		gold = analysisBuyAsset.getvaluesAsset("3", '2');
		land = analysisBuyAsset.getvaluesAsset("4", '2');
		oil = analysisBuyAsset.getvaluesAsset("5", '2');
		bulding = analysisBuyAsset.getvaluesAsset("6", '2');
		equipment = analysisBuyAsset.getvaluesAsset("7", '2');
		mine = analysisBuyAsset.getvaluesAsset("8", '2');
	}

	private void ListDataShowContII() {
		person = analysisBuyAsset.getvaluesCustomer(fromYear + "01",toYear + "12", "1", '2');
		corperation = analysisBuyAsset.getvaluesCustomer(fromYear + "01",toYear + "12", "2", '2');
		stocks = analysisBuyAsset.getValuesAsset(fromYear + "01",toYear + "12", "1", '2');
		exchange = analysisBuyAsset.getValuesAsset(fromYear + "01",toYear + "12", "2", '2');
		gold = analysisBuyAsset.getValuesAsset(fromYear + "01",toYear + "12", "3", '2');
		land = analysisBuyAsset.getValuesAsset(fromYear + "01",toYear + "12", "4", '2');
		oil = analysisBuyAsset.getValuesAsset(fromYear + "01",toYear + "12", "5", '2');
		bulding = analysisBuyAsset.getValuesAsset(fromYear + "01",toYear + "12", "6", '2');
		equipment = analysisBuyAsset.getValuesAsset(fromYear + "01",toYear + "12", "7", '2');
		mine = analysisBuyAsset.getValuesAsset(fromYear + "01",toYear + "12", "8", '2');

	}

	private void ListDataShowContIII() {
		person = null;
		corperation = null;
		stocks = null;
		exchange = null;
		gold = null;
		land = null;
		oil = null;
		bulding = null;
		equipment = null;
		mine = null;

	}

}
