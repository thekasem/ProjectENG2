package com.dao.implement;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.dao.interfaces.IAUMByCIFDao;
import com.entity.HibernateUtil;
import com.entity.bonanza.AUMByCIFMini;

public class AUMByCIFDao implements IAUMByCIFDao {

	public List<AUMByCIFMini> getListByDate(String date, String condition) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<AUMByCIFMini> result = null;
		Query query = sessionB.createQuery("from AUMByCIFMini where aumDate "
				+ condition + " '" + date + "'");
		query.setFirstResult(0);
		query.setMaxResults(500);
		result = query.list();
		return result;
	}

	public String createCriteriaSearch(AUMByCIFMini obj, boolean isOrdering,
			boolean isAscending, boolean isCount) {
		boolean where = true;
		String command = "";
		try {
			if (isCount) {
				command += "SELECT COUNT(*) FROM AUMByCIFMini ";
			} else {
				command += "FROM AUMByCIFMini ";
			}

			if (obj.getAumbyCifId() != 0) {
				if (where) {
					command += " WHERE aumbyCifId = " + obj.getAumbyCifId();
					where = false;
				}
			}

			if (obj.getCustomerNameEn() != null) {
				if (where) {
					command += " WHERE customerNameEn = '"
							+ obj.getCustomerNameEn().trim() + "'";
					where = false;
				}
			}

			if (obj.getAumDate() != null && !obj.getAumDate().trim().equals("")) {
				if (where) {
					command += " WHERE aumDate = '" + obj.getAumDate().trim()
							+ "'";
					where = false;
				}
			}

			if (obj.getAumMarketValue()!=0) {
				if (where) {
					command += " WHERE aumMarketValue = "
							+ obj.getAumMarketValue() + "";
					where = false;
				}
			}

			if (!isCount) {
				if (isOrdering) {
					if (isAscending)
						command += " ORDER BY aumDate ASC , aumbyCifId ASC ";
					else
						command += " ORDER BY aumDate DESC , aumbyCifId DESC ";
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return command;
	}

	public List<AUMByCIFMini> getListByCriteriaSearch(
			AUMByCIFMini criteriaSearch, boolean isOrdering,
			boolean isAscending, int firstResult, int maxResult) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<AUMByCIFMini> result = null;
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

	public int getCountByCriteriaSearch(AUMByCIFMini criteriaSearch) {
		int result = 0;
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		try {
			Query query = sessionB.createQuery(createCriteriaSearch(
					criteriaSearch, false, false, true));
			result = Integer.parseInt(query.uniqueResult().toString());
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}

	public AUMByCIFMini getObjectById(int eventId) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		AUMByCIFMini aumByCIFMini = new AUMByCIFMini();
		sessionB.load(aumByCIFMini, eventId);
		sessionB.getTransaction().commit();
		return aumByCIFMini;
	}

	public void save(AUMByCIFMini entity) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		sessionB.save(entity);
		sessionB.getTransaction().commit();
	}

	public void delete(AUMByCIFMini entity) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		sessionB.delete(entity);
		sessionB.getTransaction().commit();
	}

	public double sumMarketValue(String yearAndMonth) {
		double result = 0;
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		try {
			Query query = sessionB.createQuery("select  sum(aumMarketValue)  from AUMByCIFMini where aumDate between '"+yearAndMonth+"01' and '"+yearAndMonth+"31'");
			result = Double.parseDouble(query.uniqueResult().toString());
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
			Query query = sessionB.createSQLQuery("select distinct(SUBSTR(aumdate,1,4))  from crm_aumbycif");
			result = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}
	
	

}
