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

public class AnalysisScatterDataJsonAction extends ActionSupport {

	
	private String selectTime;
	private String fromYear;
	private String toYear;
	private String fromMonth;
	private String toMonth;
	private String toYearII;

	private List<Object[]> person;
	private List<Object[]> corperation;
	private List<Object[]> stocks;
	private List<Object[]> exchange;
	private List<Object[]> gold;
	private List<Object[]> land;
	private List<Object[]> oil;
	private List<Object[]> bulding;
	private List<Object[]> equipment;
	private List<Object[]> mine;

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

	public String getDataGrahp() {
		
		person = new ArrayList<Object[]>();
		corperation = new ArrayList<Object[]>();
		stocks = new ArrayList<Object[]>();
		exchange = new ArrayList<Object[]>();
		gold = new ArrayList<Object[]>();
		land = new ArrayList<Object[]>();
		oil = new ArrayList<Object[]>();
		bulding = new ArrayList<Object[]>();
		equipment = new ArrayList<Object[]>();
		mine = new ArrayList<Object[]>();
		
		ContactController();
		userNameLogin = (String) session.getAttribute("user");
		dateList = analysisBuyAsset.getDateList(selectTime, fromYear, toYear, fromMonth, toMonth, toYearII);
		List<Object[]> listCustomer = analysisBuyAsset.getValueCutomer(dateList, selectTime);
		List<Object[]> listAsset = analysisBuyAsset.getValueAsset(dateList, selectTime);
		getCustomer(listCustomer,dateList);
		getAsset(listAsset, dateList);
		
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


	public List<Object[]> getPerson() {
		return person;
	}

	public List<Object[]> getCorperation() {
		return corperation;
	}

	public List<Object[]> getStocks() {
		return stocks;
	}

	public List<Object[]> getExchange() {
		return exchange;
	}

	public List<Object[]> getGold() {
		return gold;
	}

	public List<Object[]> getLand() {
		return land;
	}

	public List<Object[]> getOil() {
		return oil;
	}

	public List<Object[]> getBulding() {
		return bulding;
	}

	public List<Object[]> getEquipment() {
		return equipment;
	}

	public List<Object[]> getMine() {
		return mine;
	}

	private void getCustomer(List<Object[]> listCustomer, List<String> dateList){
		Object[] temp = new Object[2];
		int i = 0;
		for(Object[] result:listCustomer){
			temp[0] = dateList.get(i);
			temp[1] = result[0];
 			person.add(temp);
 			temp[1] = result[1];
			corperation.add(temp);
			i++;
		}
	}
	
	private void getAsset(List<Object[]> listAsset, List<String> dateList){
		Object[] temp = new Object[2];
		int i = 0;
		for(Object[] result: listAsset){
			temp[0] = dateList.get(i);
			temp[1] = result[0];
			stocks.add(temp);
			temp[1] = result[1];
			exchange.add(temp);
			temp[1] = result[2];
			gold.add(temp);
			temp[1] = result[3];
			land.add(temp);
			temp[1] = result[4];
			oil.add(temp);
			temp[1] = result[5];
			bulding.add(temp);
			temp[1] = result[6];
			equipment.add(temp);
			temp[1] = result[7];
			mine.add(temp);
			i++;
		}
	}

}
