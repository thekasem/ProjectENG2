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

	private String timeLoginToCheck(String h, String m){
		int hour = Integer.parseInt(h);
		int mins = Integer.parseInt(m);
		if(mins+15 >= 60){
			hour++;
			mins =(mins+15)%60;
		}else{
			mins= mins+15;
		}
		String date ="";
		if(mins<10){
			date =hour+"0"+mins;
		}else{
			date = hour+""+mins;
		}
		return date;
	}
	
	private String checkFault(String checkLogIn){
		String result = "Not user or Not permission";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateCurrent = sdf.format(new Date());
		int datelogin = Integer.parseInt(checkLogIn.substring(0, 4)+checkLogIn.substring(5, 7)+checkLogIn.substring(8, 10));
		int datecurrent =Integer.parseInt(dateCurrent.substring(0, 4)+dateCurrent.substring(5, 7)+dateCurrent.substring(8, 10));
		int timelogin = Integer.parseInt(timeLoginToCheck(checkLogIn.substring(11, 13),checkLogIn.substring(14, 16))+checkLogIn.substring(17, 19));
		int timecurrent = Integer.parseInt(dateCurrent.substring(11, 13)+dateCurrent.substring(14, 16)+dateCurrent.substring(17, 19));
		System.out.println(datelogin+"\n"+datecurrent+"\n"+timelogin+"\n"+timecurrent);
		if(datecurrent >= datelogin && timecurrent > timelogin){
			result ="success"; 
		}else{
			result = "Please login agian your login more than three times.";
		}
			
		return result;
	}

	
	public String checkLoginUser(String user, String password) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String result = "Not user or Not permission";
		MemberMini checkLogIn =  loginDao.checkLoginUser(user, password,true);
		if(checkLogIn.getLoginName()!=null && checkLogIn.getStatus()=='S'){
			if(checkLogIn.getLoginFault()<4){
				loginDao.updateTimeLogin(checkLogIn.getMemberId(), 1, sdf.format(new Date()));
				result ="success";
			}else if(checkLogIn.getLoginFault()>3){
				result = checkFault(checkLogIn.getTimeLogin());
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
