package com.entity.bonanza;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="CM_ACTIVITYLOG")
public class ActivityLogMini {
	
	@Id
	@GeneratedValue
	@Column(name = "LOGID")
	private int logId;
	
	@Column(name = "LOGDATE")
	private String logDate;
	
	@Column(name = "ACTION")
	private String action;
	
	@Column(name = "ACTIONCLASS")
	private String actionClass;
	
	@Column(name = "LEVEL")
	private String level;
	
	@Column(name = "USINGTIME")
	private int usigTime;
	
	@Column(name = "SCREENCODE")
	private String screencode;
	
	@Column(name = "SCREENNAME")
	private String screenname;
	
	@Column(name = "CLIENTIP")
	private String clientIP;
	
	@Column(name = "MEMBERID")
	private int memberId;
	
	@Column(name = "CAUSEEN")
	private String causeEn;
	
	@Column(name = "CAUSETH")
	private String causeTh;
	
	@Column(name = "BROWSER")
	private String browser;

	public int getLogId() {
		return logId;
	}

	public void setLogId(int logId) {
		this.logId = logId;
	}

	public String getLogDate() {
		return logDate;
	}

	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getActionClass() {
		return actionClass;
	}

	public void setActionClass(String actionClass) {
		this.actionClass = actionClass;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getScreencode() {
		return screencode;
	}

	public void setScreencode(String screencode) {
		this.screencode = screencode;
	}

	public String getScreenname() {
		return screenname;
	}

	public void setScreenname(String screenname) {
		this.screenname = screenname;
	}

	public String getClientIP() {
		return clientIP;
	}

	public void setClientIP(String clientIP) {
		this.clientIP = clientIP;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getCauseEn() {
		return causeEn;
	}

	public void setCauseEn(String causeEn) {
		this.causeEn = causeEn;
	}

	public String getCauseTh() {
		return causeTh;
	}

	public void setCauseTh(String causeTh) {
		this.causeTh = causeTh;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public int getUsigTime() {
		return usigTime;
	}

	public void setUsigTime(int usigTime) {
		this.usigTime = usigTime;
	}
	

}
