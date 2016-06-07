package com.actions;

import java.util.List;







import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public abstract class ActionClass<T>  extends ActionSupport implements ModelDriven<T>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2973155945993034112L;

	
	protected static final String LIST = "list";
	protected static final String ADD = "add";
	protected static final String SEARCH = "search";

	protected List<T> list;
	protected String userNameLogin;
	protected T entity ;
	protected int page;
	protected String date = "";
	protected String condition = "";
	protected int count;
	protected int totalPage;

	public abstract void ContactController();

	public abstract String list();

	public abstract String addArchive();
	
	public T getModel() {
		// TODO Auto-generated method stub
		return entity;
	}

	public String add() {
		ContactController();
		return ADD;
	}
	public String search() {
		ContactController();
		return SEARCH;
	}
	
	public String searchArchive() {
		ContactController();
		list();
		return LIST;
	}
	
	
	
	
	public String getUserNameLogin() {
		return userNameLogin;
	}

	public void setUserNameLogin(String userNameLogin) {
		this.userNameLogin = userNameLogin;
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<T> getList() {
		return list;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public void session(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		userNameLogin = (String) session.getAttribute("user");
	}
	
	public int totalPage(int count, int record){
		int result = 0;
		if(count % record == 0){
			result = (count/record)-1;
		}else {
			result = (count/record);
		}
		return result;
	}
}
