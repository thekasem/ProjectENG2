package com.dao.implement;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.dao.interfaces.ILoginDao;
import com.entity.HibernateUtil;
import com.entity.bonanza.MemberMini;

public class LoginDao implements ILoginDao {
	// private static Logger log = Logger.getLogger(LoginDao.class.getName());
	// private static Session sessionA =
	// HibernateArchiveUtil.getSessionFactory().openSession();

	private String command(String user, String password , boolean mode) {
		String command = "";
		if (mode) {
			command = "from MemberMini where loginName='" + user+ "' and password = '" + password + "'";
		} else {
			command = "from MemberMini where loginName='" + user+ "'";
		}
		return command;
	}

	public MemberMini checkLoginUser(String user, String password ,boolean mode) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		MemberMini result = new MemberMini();
		sessionB.beginTransaction();
		try {
			result = (MemberMini) sessionB.createQuery(command(user, password, mode))
					.list().get(0);
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
			Query query = sessionB
					.createSQLQuery("select distinct(SUBSTR(logdate,1,4))  from cm_activitylog");
			result = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}

	public void updateTimeLogin(Integer userName, int fault) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		try {
			MemberMini member = (MemberMini) sessionB.get(MemberMini.class,
					userName);
			member.setLoginFault(fault);
			sessionB.update(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
	}

	public void updateTimeLogin(Integer userName, int fault, String dateLogin) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		try {
			MemberMini member = (MemberMini) sessionB.get(MemberMini.class,
					userName);
			member.setLoginFault(fault);
			member.setTimeLogin(dateLogin);
			sessionB.update(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
	}
	/*
	 * public static void main(String args[]){ Session sessionB =
	 * HibernateUtil.getSessionFactory().openSession();
	 * sessionB.beginTransaction(); User user = new User(); sessionB.load(user,
	 * 7);
	 * System.out.println(user.getUserId()+"  "+user.getFirstName()+" "+user.
	 * getPassword()+"  "+user.getCity());
	 * 
	 * sessionB.getTransaction().commit(); }
	 */

}
