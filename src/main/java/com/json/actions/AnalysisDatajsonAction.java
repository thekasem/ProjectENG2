package com.json.actions;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.contact.action.ContactAnalysisBuyAsset;
import com.contact.action.ContactBuyAsset;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class AnalysisDatajsonAction extends ActionSupport {

	private String selectTime;
	private String fromYear;
	private String toYear;
	private String fromMonth;
	private String toMonth;
	private String toYearII;

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

	public String getDataPieCustomer() {
		ContactController();
		userNameLogin = (String) session.getAttribute("user");
		if (selectTime.trim().equals("1")) {
			percentCustomer = analysisBuyAsset.getValuesPieCustomer();
			percentAsset = analysisBuyAsset.getValuesPieAsset();
			dateSelect = "AllYear";
		} else if (selectTime.trim().equals("2")) {
			percentCustomer = analysisBuyAsset.getValuesPieCustomer(fromYear
					+ "01", toYear + "12");
			percentAsset = analysisBuyAsset.getValuesPieAsset(fromYear + "01",
					toYear + "12");
			dateSelect = "From " + fromYear + " To " + toYear;
		} else if (selectTime.trim().equals("3")) {
			percentCustomer = analysisBuyAsset.getValuesPieCustomer(
					yearAndMonth(toYearII, Integer.parseInt(fromMonth)),
					yearAndMonth(toYearII, Integer.parseInt(toMonth)));
			percentAsset = analysisBuyAsset.getValuesPieAsset(
					yearAndMonth(toYearII, Integer.parseInt(fromMonth)),
					yearAndMonth(toYearII, Integer.parseInt(toMonth)));
			dateSelect = "From "
					+ yearAndMonth(toYearII, Integer.parseInt(fromMonth))
					+ " To "
					+ yearAndMonth(toYearII, Integer.parseInt(toMonth));
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

}
