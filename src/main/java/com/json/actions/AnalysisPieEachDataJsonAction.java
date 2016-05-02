package com.json.actions;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.contact.action.ContactAnalysisBuyAsset;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class AnalysisPieEachDataJsonAction extends ActionSupport {

	private String selectTime;
	private String fromYear;
	private String toYear;
	private String fromMonth;
	private String toMonth;
	private String toYearII;

	private String assetId;
	private String customerId;

	private List<Double> percentCustomer;
	private List<Double> percentAsset;
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

	public String getDataPieEachCustomer() {
		ContactController();
		userNameLogin = (String) session.getAttribute("user");
		if (selectTime.trim().equals("1")) {
			percentCustomer = analysisBuyAsset
					.getValuesPieEachCustomer(assetId);
			dateSelect = "AllYear";
		} else if (selectTime.trim().equals("2")) {
			percentCustomer = analysisBuyAsset.getValuesPieEachCustomer(
					fromYear + "01", toYear + "12", assetId);
			dateSelect = "From " + fromYear + " To " + toYear;
		} else if (selectTime.trim().equals("3")) {
			percentCustomer = analysisBuyAsset.getValuesPieEachCustomer(
					yearAndMonth(toYearII, Integer.parseInt(fromMonth)),
					yearAndMonth(toYearII, Integer.parseInt(toMonth)), assetId);
			dateSelect = "From " + fromMonth + "," + toYearII + " To "
					+ toMonth + "," + toYearII;
		}
		return Action.SUCCESS;
	}

	public String getDataPieEachAsset() {
		ContactController();
		userNameLogin = (String) session.getAttribute("user");
		if (selectTime.trim().equals("1")) {
				percentAsset = analysisBuyAsset
						.getValuesPieEachAsset(customerId);
			dateSelect = "AllYear";
		} else if (selectTime.trim().equals("2")) {
				percentAsset = analysisBuyAsset.getValuesPieEachAsset(fromYear
						+ "01", toYear + "12", customerId);
			dateSelect = "From " + fromYear + " To " + toYear;
		} else if (selectTime.trim().equals("3")) {
				percentAsset = analysisBuyAsset.getValuesPieEachAsset(
						yearAndMonth(toYearII, Integer.parseInt(fromMonth)),
						yearAndMonth(toYearII, Integer.parseInt(toMonth)),
						customerId);
			dateSelect = "From " + fromMonth + "," + toYearII + " To "
					+ toMonth + "," + toYearII;
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

	public List<Double> getPercentCustomer() {
		return percentCustomer;
	}

	public List<Double> getPercentAsset() {
		return percentAsset;
	}

	public String getUserNameLogin() {
		return userNameLogin;
	}

	public String getDateSelect() {
		return dateSelect;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


}
