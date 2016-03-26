package com.dao.implement;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.dao.interfaces.IRMProfileDao;
import com.entity.HibernateUtil;
import com.entity.bonanza.RMProfileMini;

public class RMProfileDao implements IRMProfileDao {

	public String createCriteriaSearch(RMProfileMini obj, boolean isOrdering,
			boolean isAscending, boolean isCount) {
		boolean where = true;
		String command ="";
		try {
			if(isCount){
				command += "SELECT COUNT(*) FROM RMProfileMini";
			}else{
				command += "FROM RMProfileMini";
			}
			if (obj.getRmId() != 0) {
				if (where) {
					command += "WHERE rmId = "+obj.getRmId();
					where = false;
				}
			}
			if (obj.getFirstNameEn() != null && obj.getFirstNameEn().equals("")) {
				if (where) {
					command += "WHERE UPPER(firstNameEn) LIKE UPPER('%"+obj.getFirstNameEn().toUpperCase().trim()+"%')";
					where = false;
				}else {
					command += "AND UPPER(firstNameEn) LIKE UPPER('%"+obj.getFirstNameEn().toUpperCase().trim()+"%')";
				}
			}
			if (!isCount) {
				if (isOrdering) {
					if (isAscending)
						command += " ORDER BY rmId ASC ";
					else
						command += " ORDER BY rmId DESC ";
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return command;
	}

	public List<RMProfileMini> getListByCriteriaSearch(
			RMProfileMini criteriaSearch, boolean isOrdering,
			boolean isAscending, int firstResult, int maxResult) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<RMProfileMini> result = null;
		try {
			Query query = sessionB.createQuery(createCriteriaSearch(criteriaSearch, isOrdering, isAscending, false));
			query.setMaxResults(maxResult);
			query.setMaxResults(maxResult);
			result = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}

	public int getCountByCriteriaSearch(RMProfileMini criteriaSearch) {
		int result = 0;
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		try {
			Query query = sessionB.createQuery(createCriteriaSearch(criteriaSearch, false, false, true));
			result = Integer.parseInt(query.uniqueResult().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}

	public RMProfileMini getObjectById(int eventId) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		RMProfileMini rmProfileMini = new RMProfileMini();
		sessionB.load(rmProfileMini, eventId);
		sessionB.getTransaction();
		return rmProfileMini;
	}

	public void save(RMProfileMini entity) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		sessionB.save(entity);
		sessionB.getTransaction().commit();
	}

	public void delete(RMProfileMini entity) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		sessionB.delete(entity);
		sessionB.getTransaction().commit();
	}

	

}
