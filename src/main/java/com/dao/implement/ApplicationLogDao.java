package com.dao.implement;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.dao.interfaces.IApplicationLogDao;
import com.entity.HibernateUtil;
import com.entity.bonanza.ActivityLogMini;
import com.entity.bonanza.ApplicationLogMini;

public class ApplicationLogDao implements IApplicationLogDao {

	public List<ApplicationLogMini> getListByDate(String date, String condition) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<ApplicationLogMini> result = null;
		try{
			Query query = sessionB.createQuery("from ApplicationLogMini where logDate "+condition+" '"+date+"'");
			query.setFirstResult(0);
			query.setMaxResults(500);
			result = query.list();			
		}catch(Exception e){
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}

	public String createCriteriaSearch(ApplicationLogMini obj,
			boolean isOrdering, boolean isAscending, boolean isCount) {
		boolean where = true;
		String command = "";
		try {
			
			if (isCount) {
				command += "SELECT COUNT(*) FROM ApplicationLogMini ";
			} else {
				command += "FROM ApplicationLogMini ";
			}
			
			if (obj.getLogDate() != null && !obj.getLogDate().trim().equals("")) {
				if (where) {
					command += " WHERE logDate = '" + obj.getLogDate().trim() + "'";
					where = false;
				}
			}
			
			if (obj.getLogTime() != null && !obj.getLogTime().trim().equals("")) {
				if (where) {
					command += " WHERE LogTime = '" + obj.getLogTime().trim() + "'";
					where = false;
				}
			}
			
			if (obj.getLevel() != null && !obj.getLevel().trim().equals("")) {
				if (where) {
					command += " WHERE UPPER(level) LIKE UPPER('%" + obj.getLevel().toUpperCase().trim() + "%')";
					where = false;

				} else
					command += " AND UPPER(level) LIKE UPPER('%" + obj.getLevel().toUpperCase().trim() + "%')";
			}


			if (obj.getMode() != null && !obj.getMode().trim().equals("")) {
				if (where) {
					command += " WHERE UPPER(mode) LIKE UPPER('%" + obj.getMode().toUpperCase().trim() + "%')";
					where = false;

				} else
					command += " AND UPPER(mode) LIKE UPPER('%" + obj.getMode().toUpperCase().trim() + "%')";
			}

			if (obj.getEntityClass() != null && !obj.getEntityClass().trim().equals("")) {
				if (where) {
					command += " WHERE UPPER(entityClass) LIKE UPPER('%" + obj.getEntityClass().toUpperCase().trim() + "%')";
					where = false;

				} else
					command += " AND UPPER(entityClass) LIKE UPPER('%" + obj.getEntityClass().toUpperCase().trim() + "%')";
			}
			
			
			if (!isCount) {
				if (isOrdering) {
					if (isAscending) {
						command += " ORDER BY logDate ASC  ";
				} else {
						command += " ORDER BY logDate DESC ";
					}
				}
			}
			
		} catch (Exception ex){
			ex.printStackTrace();
		}
		
		return command;
	}

	public List<ApplicationLogMini> getListByCriteriaSearch(
			ApplicationLogMini criteriaSearch, boolean isOrdering,
			boolean isAscending, int firstResult, int maxResult) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<ApplicationLogMini> result = null;
		try {
			Query query = sessionB.createQuery(createCriteriaSearch(
					criteriaSearch, isOrdering, isAscending, false));
			query.setFirstResult(firstResult);
			query.setMaxResults(maxResult);

			result = query.list();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}

	public int getCountByCriteriaSearch(ApplicationLogMini criteriaSearch) {
		int result = 0;
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		try {
			Query query = sessionB.createQuery(createCriteriaSearch(criteriaSearch, false, false, true));
			result = Integer.parseInt(query.uniqueResult().toString());
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}

	public ApplicationLogMini getObjectById(int eventId) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		ApplicationLogMini applicationLogMini = new ApplicationLogMini();
		sessionB.load(applicationLogMini, eventId);
		sessionB.getTransaction().commit();
		return applicationLogMini;
	}

	public void save(ApplicationLogMini entity) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		sessionB.save(entity);
		sessionB.getTransaction().commit();
	}

	public void delete(ApplicationLogMini entity) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		sessionB.delete(entity);
		sessionB.getTransaction().commit();
	}
	
	

}
