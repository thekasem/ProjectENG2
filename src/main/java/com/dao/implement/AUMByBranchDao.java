package com.dao.implement;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.dao.interfaces.IAUMByBranchDao;
import com.entity.HibernateUtil;
import com.entity.bonanza.AUMByBranchMini;

public class AUMByBranchDao implements IAUMByBranchDao{

	public String createCriteriaSearch(AUMByBranchMini obj, boolean isOrdering,
			boolean isAscending, boolean isCount) {
		boolean where = true;
		String command = "";
		try {
			if (isCount) {
				command += "SELECT COUNT(*) FROM AUMByBranchMini ";
			} else {
				command += "FROM AUMByBranchMini ";
			}

			if (obj.getAumByBranchId() != 0) {
				if (where) {
					command += " WHERE aumByBranchId = " + obj.getAumByBranchId();
					where = false;
				}
			}

			if (obj.getCustomerNameEn() != null) {
				if (where) {
					command += " WHERE customerNameEn = '" + obj.getCustomerNameEn().trim() + "'";
					where = false;
				}
			}

			if (obj.getBranchCode() != null) {
				if (where) {
					command += " WHERE branchName = '" + obj.getBranchCode().trim() + "'";
					where = false;
				}
			}

			if (obj.getAumDate() != null && !obj.getAumDate().trim().equals("")) {
				if (where) {
					command += " WHERE aumDate = '" + obj.getAumDate().trim() + "'";
					where = false;
				}
			}

			if (obj.getAumMarketValue() != 0) {
				if (where) {
					command += " WHERE aumMarketValue = " + obj.getAumMarketValue() + "";
					where = false;
				}
			}



			if (!isCount) {
				if (isOrdering) {
					if (isAscending)
						command += " ORDER BY aumDate ASC , aumByBranchId ASC ";
					else
						command += " ORDER BY aumDate DESC , aumByBranchId DESC ";
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return command;
	}
	

	public List<AUMByBranchMini> getListByDate(String date, String condition) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<AUMByBranchMini> result = null;
		try{
		Query query = sessionB.createQuery("from AUMByBranchMini where aumDate "+condition+" '"+date+"'");
		query.setFirstResult(0);
		query.setMaxResults(500);
		result = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}


	public List<AUMByBranchMini> getListByCriteriaSearch(
			AUMByBranchMini criteriaSearch, boolean isOrdering,
			boolean isAscending, int firstResult, int maxResult) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<AUMByBranchMini> result = null;
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

	public int getCountByCriteriaSearch(AUMByBranchMini criteriaSearch) {
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

	public AUMByBranchMini getObjectById(int eventId) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		AUMByBranchMini aumByBranchMini = new AUMByBranchMini();
		sessionB.load(aumByBranchMini, eventId);
		sessionB.getTransaction().commit();
		return aumByBranchMini;
	}

	public void save(AUMByBranchMini entity) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		sessionB.save(entity);
		sessionB.getTransaction().commit();
	}

	public void delete(AUMByBranchMini entity) {
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
			Query query = sessionB.createQuery("select  sum(aumMarketValue)  from AUMByBranchMini where aumDate between '"+yearAndMonth+"01' and '"+yearAndMonth+"31'");
			result = Double.parseDouble(query.uniqueResult().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}
	
	

}
