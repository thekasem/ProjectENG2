package com.dao.implement;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.dao.interfaces.IMemberDao;
import com.entity.HibernateUtil;
import com.entity.bonanza.MemberMini;

public class MemberDao implements IMemberDao {
	public String createCriteriaSearch(MemberMini obj, boolean isOrdering,
			boolean isAscending, boolean isCount) {
		boolean where = true;
		String command = "";
		try {
			if (isCount) {
				command += "SELECT COUNT(*) FROM MemberMini ";
			} else {
				command += "FROM MemberMini";
			}
			if (obj.getMemberId() != 0) {
				if (where) {
					command += "WHERE memberId = " + obj.getMemberId();
					where = false;
				}
			}
			if (obj.getFirstNameEn() != null
					&& obj.getFirstNameEn().trim().equals("")) {
				if (where) {
					command += "WHERE UPPER(firstNameEn) LIKE UPPER('%"
							+ obj.getFirstNameEn().toUpperCase().trim() + "%')";
					where = false;
				} else {
					command += "AND UPPER(firstNameEn) LIKE UPPER('%"
							+ obj.getFirstNameEn().toUpperCase().trim() + "%')";
				}
			}

			if (!isCount) {
				if (isOrdering) {
					if (isAscending)
						command += " ORDER BY memberId ASC ";
					else
						command += " ORDER BY memberId DESC ";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return command;
	}

	public List<MemberMini> getListByCriteriaSearch(MemberMini criteriaSearch,
			boolean isOrdering, boolean isAscending, int firstResult,
			int maxResult) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<MemberMini> result = null;
		try {
			Query query = sessionB.createQuery(createCriteriaSearch(
					criteriaSearch, isOrdering, isAscending, false));
			query.setFirstResult(firstResult);
			query.setMaxResults(maxResult);
			result = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}

	public int getCountByCriteriaSearch(MemberMini criteriaSearch) {
		int result = 0;
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		try {
			Query query = sessionB.createQuery(createCriteriaSearch(
					criteriaSearch, false, false, true));
			result = Integer.parseInt(query.uniqueResult().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}

	public MemberMini getObjectById(int eventId) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		MemberMini memberMini = new MemberMini();
		sessionB.load(memberMini, eventId);
		sessionB.getTransaction().commit();
		return memberMini;
	}

	public void save(MemberMini entity) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		sessionB.save(entity);
		sessionB.getTransaction().commit();
	}

	public void delete(MemberMini entity) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		sessionB.delete(entity);
		sessionB.getTransaction().commit();
	}

	private String commandQuery(String date, boolean allAndSome) {
		String command = "";
		if (allAndSome) {
			command = "select  count(createDate)  from MemberMini where createDate between '"
					+ date + "0101' and '" + date + "1231'";
		} else {
			command = "select  count(createDate)  from MemberMini where createDate between '"
					+ date + "01' and '" + date + "31'";
		}
		return command;
	}

	public float getNewUser(String date, boolean allAndSome) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		float result = 0.0f;
		try {
			Query query = sessionB.createQuery(commandQuery(date, allAndSome));
			result = Float.parseFloat(query.uniqueResult().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}

	public List<String> getListYear() {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<String> result = null;
		try {
			Query query = sessionB.createSQLQuery("select distinct(SUBSTR(createdate,1,4))  from cm_member");
			result = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}

	public MemberMini showProfile(String loginname) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		Criteria criteria = sessionB.createCriteria(MemberMini.class);
		criteria.add(Restrictions.eq("loginName",  loginname));
		
		MemberMini memberMini = (MemberMini) criteria.list().get(0);

		sessionB.getTransaction().commit();

		return memberMini;
	}

}
