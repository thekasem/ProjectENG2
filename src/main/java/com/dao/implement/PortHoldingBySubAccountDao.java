package com.dao.implement;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.dao.interfaces.IPortHoldingBySubAccountDao;
import com.entity.HibernateUtil;
import com.entity.bonanza.PortHoldingBySubAccountMini;

public class PortHoldingBySubAccountDao implements IPortHoldingBySubAccountDao {

	public List<PortHoldingBySubAccountMini> getListByDate(String date,
			String condition) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<PortHoldingBySubAccountMini> result = null;
		Query query = sessionB.createQuery("from PortHoldingBySubAccountMini where aumDate "+condition+" '"+date+"'");
		query.setFirstResult(0);
		query.setMaxResults(500);
		result = query.list();
		sessionB.getTransaction().commit();
		return result;
	}

	public String createCriteriaSearch(PortHoldingBySubAccountMini obj,
			boolean isOrdering, boolean isAscending, boolean isCount) {
		boolean where = true;
		String command = "";
		try {
			if (isCount) {
				command += "SELECT COUNT(*) FROM PortHoldingBySubAccountMini ";
			} else {
				command += "FROM PortHoldingBySubAccountMini ";
			}

			if (obj.getPortHoldingId() != 0) {
				if (where) {
					command += " WHERE portHoldingId = " + obj.getPortHoldingId();
					where = false;
				}
			}
			
			if (obj.getSubAccountId() != 0) {
				if (where) {
					command += " WHERE subAccountId = " + obj.getSubAccountId();
					where = false;
				}
			}
			
			if (obj.getSubAccountNO() != null && !obj.getSubAccountNO().trim().equals("")) {
				if (where) {
					command += " WHERE subAccountNO = '" + obj.getSubAccountNO().trim() + "'";
					where = false;
				}
			}
			
			if (obj.getAccountId() != 0) {
				if (where) {
					command += " WHERE accountId = " + obj.getAccountId();
					where = false;
				}
			}
			
			if (obj.getAccountName() != null && !obj.getAccountName().trim().equals("")) {
				if (where) {
					command += " WHERE accountName = '" + obj.getAccountName().trim() + "'";
					where = false;
				}
			}
			
			if (obj.getProductNameEn() != null && !obj.getProductNameEn().trim().equals("")) {
				if (where) {
					command += " WHERE productNameEn = '" + obj.getProductNameEn().trim() + "'";
					where = false;
				}
			}
			
			if (obj.getProductTypeNameOther() != null && !obj.getProductTypeNameOther().trim().equals("")) {
				if (where) {
					command += " WHERE productTypeNameOther = '" + obj.getProductTypeNameOther().trim() + "'";
					where = false;
				}
			}

			if (!isCount) {
				if (isOrdering) {
					if (isAscending)
						command += " ORDER BY portHoldingId ASC ";
					else
						command += " ORDER BY portHoldingId DESC ";
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return command;
	}

	public List<PortHoldingBySubAccountMini> getListByCriteriaSearch(
			PortHoldingBySubAccountMini criteriaSearch, boolean isOrdering,
			boolean isAscending, int firstResult, int maxResult) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<PortHoldingBySubAccountMini> result = null;
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

	public int getCountByCriteriaSearch(
			PortHoldingBySubAccountMini criteriaSearch) {
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

	public PortHoldingBySubAccountMini getObjectById(int eventId) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		PortHoldingBySubAccountMini portHoldingBySubAccountMini = new PortHoldingBySubAccountMini();
		sessionB.load(portHoldingBySubAccountMini, eventId);
		sessionB.getTransaction().commit();
		return portHoldingBySubAccountMini;
	}

	public void save(PortHoldingBySubAccountMini entity) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		sessionB.save(entity);
		sessionB.getTransaction().commit();
	}

	public void delete(PortHoldingBySubAccountMini entity) {
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
			Query query = sessionB.createQuery("select  sum(marketValue)  from PortHoldingBySubAccountMini where aumDate between '"+yearAndMonth+"01' and '"+yearAndMonth+"31'");
			result = Double.parseDouble(query.uniqueResult().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}

	
}
