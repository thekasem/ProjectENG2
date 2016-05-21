package com.json.actions;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.contact.action.ContactPredictionBuyAsset;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class PredictionDataJsonAction extends ActionSupport {

	private HttpSession session;
	private String userNameLogin;
	private ContactPredictionBuyAsset predictionBuyAsset;
	private String selectPrediction;
	private float alpha;
	private List<Double> listDataCurrentYear;
	private List<Double> listDataNextYear;
	
	private List<Double> listError;
	private double mad;
	private double mse;
	private double mape;


	private void ContactController() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringBeans.xml");
		predictionBuyAsset = (ContactPredictionBuyAsset) context
				.getBean("preditionbuyasset");
		session = ServletActionContext.getRequest().getSession();
		userNameLogin = (String) session.getAttribute("user");
	}

	public String getDataPredictionLine() {
		ContactController();
		listDataCurrentYear = predictionBuyAsset.getDataSumAllYear();
		if (selectPrediction.equals("1")) {
			listDataNextYear = predictionBuyAsset.getForecastNaive(listDataCurrentYear);
		} else if (selectPrediction.equals("2")) {
			listDataNextYear = predictionBuyAsset.getForecastExponential(listDataCurrentYear, alpha);
		}else if (selectPrediction.equals("3")){
			listDataNextYear = predictionBuyAsset.getForecastTrend(listDataCurrentYear);
		}
		listError = predictionBuyAsset.calError(listDataCurrentYear, listDataNextYear);
		mad = predictionBuyAsset.getMAD(listError);
		mse = predictionBuyAsset.getMSE(listError);
		mape = predictionBuyAsset.getMAPE(listError, listDataCurrentYear);
		
		return Action.SUCCESS;
	}

	public String getDataPredictionScatter() {
		ContactController();
		listDataCurrentYear = predictionBuyAsset.getDataSumAllYear();
		if (selectPrediction.equals("1")) {
			listDataNextYear = predictionBuyAsset.getForecastNaive(listDataCurrentYear);
		} else if (selectPrediction.equals("2")) {
			listDataNextYear = predictionBuyAsset.getForecastExponential(listDataCurrentYear, alpha);
		}else if (selectPrediction.equals("3")){
			listDataNextYear = predictionBuyAsset.getForecastTrend(listDataCurrentYear);
		}
		listError = predictionBuyAsset.calError(listDataCurrentYear, listDataNextYear);
		mad = predictionBuyAsset.getMAD(listError);
		mse = predictionBuyAsset.getMSE(listError);
		mape = predictionBuyAsset.getMAPE(listError, listDataCurrentYear);
		return Action.SUCCESS;
	}

	public String getDataPredictionColumn() {
		ContactController();
		listDataCurrentYear = predictionBuyAsset.getDataSumAllYear();
		if (selectPrediction.equals("1")) {
			listDataNextYear = predictionBuyAsset.getForecastNaive(listDataCurrentYear);
		} else if (selectPrediction.equals("2")) {
			listDataNextYear = predictionBuyAsset.getForecastExponential(listDataCurrentYear, alpha);
		}else if (selectPrediction.equals("3")){
			listDataNextYear = predictionBuyAsset.getForecastTrend(listDataCurrentYear);
		}
		listError = predictionBuyAsset.calError(listDataCurrentYear, listDataNextYear);
		mad = predictionBuyAsset.getMAD(listError);
		mse = predictionBuyAsset.getMSE(listError);
		mape = predictionBuyAsset.getMAPE(listError, listDataCurrentYear);
		return Action.SUCCESS;
	}

	public String getUserNameLogin() {
		return userNameLogin;
	}

	public List<Double> getListDataCurrentYear() {
		return listDataCurrentYear;
	}

	public List<Double> getListDataNextYear() {
		return listDataNextYear;
	}

	public void setSelectPrediction(String selectPrediction) {
		this.selectPrediction = selectPrediction;
	}

	public void setAlpha(float alpha) {
		this.alpha = alpha;
	}

	public List<Double> getListError() {
		return listError;
	}

	public double getMad() {
		return mad;
	}

	public double getMse() {
		return mse;
	}

	public double getMape() {
		return mape;
	}
	
	

}
