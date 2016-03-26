package com.dao.implement;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.dao.interfaces.IBranchCustomerDao;
import com.entity.HibernateUtil;
import com.entity.bonanza.BranchCustomerMini;

public class BranchCustomerDao implements IBranchCustomerDao {

	public String createCriteriaSearch(BranchCustomerMini obj,
			boolean isOrdering, boolean isAscending, boolean isCount) {
		boolean where = true;
		String command = "";
		try {
			if (isCount) {
				command += "SELECT COUNT(*) FROM BranchCustomerMini ";
			}else {
				command += "FROM BranchCustomerMini";
			}
			if (obj.getRmId() != 0) {
				if (where) {
					command += "WHERE rmId = "+ obj.getRmId();
					where= false;
				}
			}
			if (obj.getFirstNameEn() != null && obj.getFirstNameEn().trim().equals("")) {
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
						command += " ORDER BY customerId ASC ";
					else
						command += " ORDER BY customerId DESC ";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return command;
	}

	public List<BranchCustomerMini> getListByCriteriaSearch(BranchCustomerMini criteriaSearch, boolean isOrdering, boolean isAscending, int firstResult, int maxResult) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<BranchCustomerMini> result = null;
		try {
			Query query = sessionB.createQuery(createCriteriaSearch(criteriaSearch, isOrdering, isAscending, false));
			query.setFirstResult(firstResult);
			query.setMaxResults(maxResult);
			result = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}

	public int getCountByCriteriaSearch(BranchCustomerMini criteriaSearch) {
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

	public BranchCustomerMini getObjectById(int eventId) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		BranchCustomerMini branchCustomerMini = new BranchCustomerMini();
		sessionB.load(branchCustomerMini, eventId);
		sessionB.getTransaction().commit();
		return branchCustomerMini;
	}

	public void save(BranchCustomerMini entity) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		sessionB.save(entity);
		sessionB.getTransaction().commit();
		
	}

	public void delete(BranchCustomerMini entity) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		sessionB.delete(entity);
		sessionB.getTransaction().commit();
	}

	public int getDataCustomer(String yearAndMonth) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		int result = 0;
		try {
			Query query = sessionB.createQuery("select count(createDate)  from BranchCustomerMini where createDate between '"+yearAndMonth+"01' and '"+yearAndMonth+"31'");
			result = Integer.parseInt(query.uniqueResult().toString());
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
			Query query = sessionB.createSQLQuery("select distinct(SUBSTR(createdate,1,4))  from branchcustomer");
			result = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}

}
