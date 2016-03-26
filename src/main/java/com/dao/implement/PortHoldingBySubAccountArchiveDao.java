package com.dao.implement;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.dao.interfaces.IPortHoldingBySubAccountArchiveDao;
import com.entity.HibernateArchiveUtil;
import com.entity.archive.ArchivePortHoldingBySubAccountMini;

public class PortHoldingBySubAccountArchiveDao implements IPortHoldingBySubAccountArchiveDao {

	public String createCriteriaSearch(ArchivePortHoldingBySubAccountMini obj,
			boolean isOrdering, boolean isAscending, boolean isCount) {
		boolean where = true;
		String command = "";
		try {
			if (isCount) {
				command += "SELECT COUNT(*) FROM ArchivePortHoldingBySubAccountMini ";
			} else {
				command += "FROM ArchivePortHoldingBySubAccountMini ";
			}
			if (obj.getAumDate() != null && !obj.getAumDate().trim().equals("")) {
				if (where) {
					command += " WHERE aumDate = '" + obj.getAumDate().trim() + "'";
					where = false;
				}
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
			
			if (obj.getDateArchive() != null && !obj.getDateArchive().trim().equals("")) {
				if (where) {
					command += " WHERE dateArchive = '" + obj.getDateArchive().trim() + "'";
					where = false;
				}
			}

			if (obj.getUserArchive() != null && !obj.getUserArchive().trim().equals("")) {
				if (where) {
					command += " WHERE UPPER(userArchive) LIKE UPPER('%" + obj.getUserArchive().toUpperCase().trim() + "%')";
					where = false;

				} else
					command += " AND UPPER(userArchive) LIKE UPPER('%" + obj.getUserArchive().toUpperCase().trim() + "%')";
			}

			if (!isCount) {
				if (isOrdering) {
					if (isAscending)
						command += " ORDER BY dateArchive ASC , portHoldingId ASC ";
					else
						command += " ORDER BY dateArchive DESC , portHoldingId DESC ";
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return command;
	}

	public List<ArchivePortHoldingBySubAccountMini> getListByCriteriaSearch(
			ArchivePortHoldingBySubAccountMini criteriaSearch,boolean isOrdering, boolean isAscending, int firstResult,int maxResult) {
		Session sessionA = HibernateArchiveUtil.getSessionFactory().openSession();
		sessionA.beginTransaction();
		List<ArchivePortHoldingBySubAccountMini> result = null;
		try {
			Query query = sessionA.createQuery(createCriteriaSearch(
					criteriaSearch, isOrdering, isAscending, false));
			query.setFirstResult(firstResult);
			query.setMaxResults(maxResult);

			result = query.list();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		sessionA.getTransaction().commit();
		return result;
	}

	public int getCountByCriteriaSearch(ArchivePortHoldingBySubAccountMini criteriaSearch) {
		int result = 0;
		Session sessionA = HibernateArchiveUtil.getSessionFactory().openSession();
		sessionA.beginTransaction();
		try {
			Query query = sessionA.createQuery(createCriteriaSearch(criteriaSearch, false, false, true));
			result = Integer.parseInt(query.uniqueResult().toString());
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}
		sessionA.getTransaction().commit();
		return result;
	}

	public ArchivePortHoldingBySubAccountMini getObjectById(int eventId) {
		Session sessionA = HibernateArchiveUtil.getSessionFactory().openSession();
		sessionA.beginTransaction();
		ArchivePortHoldingBySubAccountMini archiveMini = new ArchivePortHoldingBySubAccountMini();
		sessionA.load(archiveMini, eventId);
		sessionA.getTransaction().commit();
		return archiveMini;
	}

	public void save(ArchivePortHoldingBySubAccountMini entity) {
		Session sessionA = HibernateArchiveUtil.getSessionFactory().openSession();
		sessionA.beginTransaction();
		sessionA.save(entity);
		sessionA.getTransaction().commit();
	}

	public void delete(ArchivePortHoldingBySubAccountMini entity) {
		Session sessionA = HibernateArchiveUtil.getSessionFactory().openSession();
		sessionA.beginTransaction();
		sessionA.delete(entity);
		sessionA.getTransaction().commit();
	}

	
}
