package com.dao.implement;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.dao.interfaces.IAUMByBranchArchiveDao;
import com.entity.HibernateArchiveUtil;
import com.entity.archive.ArchiveAUMByBranchMini;

public class AUMByBranchArchiveDao implements IAUMByBranchArchiveDao {

	public String createCriteriaSearch(ArchiveAUMByBranchMini obj,
			boolean isOrdering, boolean isAscending, boolean isCount) {
		boolean where = true;
		String command = "";
		try {
			if (isCount) {
				command += "SELECT COUNT(*) FROM ArchiveAUMByBranchMini ";
			} else {
				command += "FROM ArchiveAUMByBranchMini ";
			}

			if (obj.getAumByBranchId() != 0) {
				if (where) {
					command += " WHERE aumByBranchId = "
							+ obj.getAumByBranchId();
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
			if (obj.getCustomerNameEn() != null) {
				if (where) {
					command += " WHERE customerNameEn = '"
							+ obj.getCustomerNameEn().trim() + "'";
					where = false;
				}
			}

			if (obj.getBranchCode() != null) {
				if (where) {
					command += " WHERE branchName = '"
							+ obj.getBranchCode().trim() + "'";
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

			if (obj.getAumMarketValue() != null
					&& !obj.getAumMarketValue().equals("")) {
				if (where) {
					command += " WHERE aumMarketValue = '"
							+ obj.getAumMarketValue() + "'";
					where = false;
				}
			}

			if (obj.getDateArchive() != null
					&& !obj.getDateArchive().trim().equals("")) {
				if (where) {
					command += " WHERE dateArchive = '"
							+ obj.getDateArchive().trim() + "'";
					where = false;
				}
			}

			if (obj.getUserArchive() != null
					&& !obj.getUserArchive().trim().equals("")) {
				if (where) {
					command += " WHERE UPPER(userArchive) LIKE UPPER('%"
							+ obj.getUserArchive().toUpperCase().trim() + "%')";
					where = false;

				} else
					command += " AND UPPER(userArchive) LIKE UPPER('%"
							+ obj.getUserArchive().toUpperCase().trim() + "%')";
			}

			if (!isCount) {
				if (isOrdering) {
					if (isAscending)
						command += " ORDER BY dateArchive ASC , aumByBranchId ASC ";
					else
						command += " ORDER BY dateArchive DESC , aumByBranchId DESC ";
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return command;
	}

	public List<ArchiveAUMByBranchMini> getListByCriteriaSearch(
			ArchiveAUMByBranchMini criteriaSearch, boolean isOrdering,
			boolean isAscending, int firstResult, int maxResult) {
		Session sessionA = HibernateArchiveUtil.getSessionFactory()
				.openSession();
		sessionA.beginTransaction();
		List<ArchiveAUMByBranchMini> result = null;
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

	public int getCountByCriteriaSearch(ArchiveAUMByBranchMini criteriaSearch) {
		int result = 0;
		Session sessionA = HibernateArchiveUtil.getSessionFactory()
				.openSession();
		sessionA.beginTransaction();
		try {
			Query query = sessionA.createQuery(createCriteriaSearch(
					criteriaSearch, false, false, true));
			result = Integer.parseInt(query.uniqueResult().toString());
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}
		sessionA.getTransaction().commit();
		return result;
	}

	public ArchiveAUMByBranchMini getObjectById(int eventId) {
		Session sessionA = HibernateArchiveUtil.getSessionFactory()
				.openSession();
		sessionA.beginTransaction();
		ArchiveAUMByBranchMini archiveAUMByBranchMini = new ArchiveAUMByBranchMini();
		sessionA.load(archiveAUMByBranchMini, eventId);
		sessionA.getTransaction().commit();
		return archiveAUMByBranchMini;
	}

	public void save(ArchiveAUMByBranchMini entity) {
		Session sessionA = HibernateArchiveUtil.getSessionFactory()
				.openSession();
		sessionA.beginTransaction();
		sessionA.save(entity);
		sessionA.getTransaction().commit();
	}

	public void delete(ArchiveAUMByBranchMini entity) {
		Session sessionA = HibernateArchiveUtil.getSessionFactory()
				.openSession();
		sessionA.beginTransaction();
		sessionA.delete(entity);
		sessionA.getTransaction().commit();
	}

}
