package com.controller.implement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.controller.interfaces.ILoginController;
import com.dao.interfaces.ILoginDao;
import com.entity.bonanza.MemberMini;

public class LoginController implements ILoginController {
      private ILoginDao loginDao;

	public ILoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(ILoginDao loginDao) {
		this.loginDao = loginDao;
	}

	private String checkFault(MemberMini checkLogIn){
		String result = "Not user or Not permission";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			Date loginTime = sdf.parse(checkLogIn.getTimeLogin());
			loginTime.setHours(loginTime.getHours()+1);
			Date timeCurrent = sdf.parse(sdf.format(new Date()));
			if(loginTime.before(timeCurrent)){
				loginDao.updateTimeLogin(checkLogIn.getMemberId(), 1, sdf.format(new Date()));
				result ="success"; 
			}else{
				result = "Please login agian your login more than three times.";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String checkLoginUser(String user, String password) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String result = "Not user or Not permission";
		MemberMini checkLogIn =  loginDao.checkLoginUser(user, password,true);
		if(checkLogIn.getLoginName()!=null && checkLogIn.getStatus()=='S'){
			if(checkLogIn.getLoginFault()<4){
				loginDao.updateTimeLogin(checkLogIn.getMemberId(), 1, sdf.format(new Date()));
				result ="success";
			}else if(checkLogIn.getLoginFault()>3){
				result = checkFault(checkLogIn);
			}
		}else{
			checkLogIn =  loginDao.checkLoginUser(user, password,false);
			if(checkLogIn.getLoginName()!=null && checkLogIn.getStatus()=='S'){
			loginDao.updateTimeLogin(checkLogIn.getMemberId(),checkLogIn.getLoginFault()+1, sdf.format(new Date()));
			}
		}
		return result;
	}


	public List<String> getListYear() {
		return loginDao.getListYear();
	}
      
      
}
