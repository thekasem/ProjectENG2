package com.dao.implement;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.dao.interfaces.ILoginDao;
import com.entity.HibernateArchiveUtil;
import com.entity.HibernateUtil;
import com.entity.bonanza.MemberMini;

import freemarker.log.Logger;


public class LoginDao implements ILoginDao {
//	private static Logger log = Logger.getLogger(LoginDao.class.getName());
//    private static Session sessionA = HibernateArchiveUtil.getSessionFactory().openSession();
    

	public  boolean checkLoginUser(String user, String password) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		boolean result = false;
		sessionB.beginTransaction();
		MemberMini userLogin = new MemberMini();
		try {
			userLogin = (MemberMini) sessionB.createQuery("from MemberMini where loginName='" + user	+ "' and password = '" + password + "'").list().get(0);
			if(userLogin != null&& userLogin.getMemberId() != 0){
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<String> getListYear() {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<String> result = null;
		try {
			Query query = sessionB.createSQLQuery("select distinct(SUBSTR(logdate,1,4))  from cm_activitylog");
			result = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}
	/*
	public static void main(String args[]){
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		User user = new User();
		sessionB.load(user, 7);
		System.out.println(user.getUserId()+"  "+user.getFirstName()+" "+user.getPassword()+"  "+user.getCity());
		
		sessionB.getTransaction().commit();
	}*/

}
