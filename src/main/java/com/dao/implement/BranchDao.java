package com.dao.implement;

import java.util.List;




import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import com.dao.interfaces.IBranchDao;
import com.entity.HibernateUtil;
import com.entity.bonanza.BranchMini;

public class BranchDao implements IBranchDao {

	public String createCriteriaSearch(BranchMini obj, boolean isOrdering,
			boolean isAscending, boolean isCount) {
		boolean where = true;
		String command ="";
		try {
			if(isCount){
				command += "SELECT COUNT(*) FROM BranchMini";
			}else{
				command += "FROM BranchMini";
			}
			if (obj.getBranchId() != 0) {
				if (where) {
					command += "WHERE branchId = "+obj.getBranchId();
					where = false;
				}
			}
			if (obj.getNameEn() != null && obj.getNameEn().equals("")) {
				if (where) {
					command += "WHERE UPPER(nameEn) LIKE UPPER('%"+obj.getNameEn().toUpperCase().trim()+"%')";
					where = false;
				}else {
					command += "AND UPPER(nameEn) LIKE UPPER('%"+obj.getNameEn().toUpperCase().trim()+"%')";
				}
			}
			if (!isCount) {
				if (isOrdering) {
					if (isAscending)
						command += " ORDER BY branchId ASC ";
					else
						command += " ORDER BY branchId DESC ";
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return command;
	}

	public List<BranchMini> getListByCriteriaSearch(BranchMini criteriaSearch,
			boolean isOrdering, boolean isAscending, int firstResult,
			int maxResult) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<BranchMini> result = null;
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

	public int getCountByCriteriaSearch(BranchMini criteriaSearch) {
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

	public BranchMini getObjectById(int eventId) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		BranchMini branchMini = new BranchMini();
		sessionB.load(branchMini,eventId);
		sessionB.getTransaction().commit();
		return branchMini;
	}

	public void save(BranchMini entity) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		sessionB.save(entity);
		sessionB.getTransaction().commit();
	}

	public void delete(BranchMini entity) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		sessionB.delete(entity);
		sessionB.getTransaction().commit();
	}

}
