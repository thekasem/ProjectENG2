package com.dao.implement;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.dao.interfaces.ILoginDao;
import com.entity.HibernateArchiveUtil;
import com.entity.HibernateUtil;
import com.entity.User;
import com.entity.archive.UserTest;
import com.entity.bonanza.MemberMini;

import freemarker.log.Logger;


public class LoginDao implements ILoginDao {
	private static Logger log = Logger.getLogger(LoginDao.class.getName());
    private static Session sessionA = HibernateArchiveUtil.getSessionFactory().openSession();
    
	public  User checkLogin(String user, String password) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		Criteria criteria = sessionB.createCriteria(User.class);
		criteria.add(Restrictions.eq("userName", user));
		criteria.add(Restrictions.eq("password", password));

		User userLogin = (User) criteria.list().get(0);
		log.info(userLogin.toString());

		sessionB.getTransaction().commit();

		return userLogin;
	}

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
	public List<User> getUser() {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<User> list = null;
       try{
		 list = (List<User>) sessionB.createQuery("from User").list();
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println("User Data : " + list.get(i).getUserId());
				System.out.println("User First Name : "
						+ list.get(i).getFirstName());
				System.out.println("User Last Name : "
						+ list.get(i).getLastName());
				System.out.println("User Gender : " + list.get(i).getGender());
				System.out.println("User City : " + list.get(i).getCity());
			}
		}
       }catch(Exception e){
    	   e.printStackTrace();
       }
		sessionB.getTransaction().commit();
		return list;
	}

	public void testSent(List<User> list) throws IllegalAccessException, InvocationTargetException {
		sessionA.beginTransaction();
		for(User user:list){
			UserTest to = new UserTest();
			BeanUtils.copyProperties(to, user);
			to.setUserToadd("admin001");
			sessionA.save(to);
		}
		sessionA.getTransaction().commit();
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
