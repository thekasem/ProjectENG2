package com.dao.implement;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.dao.interfaces.IAUMByCIFArchiveDao;
import com.entity.HibernateArchiveUtil;
import com.entity.archive.ArchiveAUMByCIFMini;

public class AUMByCIFArchiveDao implements IAUMByCIFArchiveDao {

	public String createCriteriaSearch(ArchiveAUMByCIFMini obj,
			boolean isOrdering, boolean isAscending, boolean isCount) {
		boolean where = true;
		String command = "";
		try {
			if (isCount) {
				command += "SELECT COUNT(*) FROM ArchiveAUMByCIFMini ";
			} else {
				command += "FROM ArchiveAUMByCIFMini ";
			}

			if (obj.getAumbyCifId() != 0) {
				if (where) {
					command += " WHERE aumbyCifId = " + obj.getAumbyCifId();
					where = false;
				}
			}
			if (obj.getAumDate() != null && !obj.getAumDate().trim().equals("")) {
				if (where) {
					command += " WHERE aumDate = '" + obj.getAumDate().trim() + "'";
					where = false;
				}
			}
			if (obj.getCustomerNameEn() != null) {
				if (where) {
					command += " WHERE customerNameEn = '" + obj.getCustomerNameEn().trim() +"'";
					where = false;
				}
			}
			
			if (obj.getAumDate() != null && !obj.getAumDate().trim().equals("")) {
				if (where) {
					command += " WHERE aumDate = '" + obj.getAumDate().trim() + "'";
					where = false;
				}
			}
			
			if (obj.getAumMarketValue() != null && !obj.getAumMarketValue().equals("")) {
				if (where) {
					command += " WHERE aumMarketValue = '" + obj.getAumMarketValue() + "'";
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
						command += " ORDER BY dateArchive ASC , aumbyCifId ASC ";
					else
						command += " ORDER BY dateArchive DESC , aumbyCifId DESC ";
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return command;
	}

	public List<ArchiveAUMByCIFMini> getListByCriteriaSearch(
			ArchiveAUMByCIFMini criteriaSearch, boolean isOrdering,
			boolean isAscending, int firstResult, int maxResult) {
		Session sessionA = HibernateArchiveUtil.getSessionFactory().openSession();
		sessionA.beginTransaction();
		List<ArchiveAUMByCIFMini> result = null;
		try {
			Query query = sessionA.createQuery(createCriteriaSearch(criteriaSearch, isOrdering, isAscending, false));
			query.setFirstResult(firstResult);
			query.setMaxResults(maxResult);

			result = query.list();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		sessionA.getTransaction().commit();
		return result;
	}

	public int getCountByCriteriaSearch(ArchiveAUMByCIFMini criteriaSearch) {
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

	public ArchiveAUMByCIFMini getObjectById(int eventId) {
		Session sessionA = HibernateArchiveUtil.getSessionFactory().openSession();
		sessionA.beginTransaction();
		ArchiveAUMByCIFMini archiveAUMByCIFMini = new ArchiveAUMByCIFMini();
		sessionA.load(archiveAUMByCIFMini, eventId);
		sessionA.getTransaction().commit();
		return archiveAUMByCIFMini;
	}

	public void save(ArchiveAUMByCIFMini entity) {
		Session sessionA = HibernateArchiveUtil.getSessionFactory().openSession();
		sessionA.beginTransaction();
		sessionA.save(entity);
		sessionA.getTransaction().commit();
	}

	public void delete(ArchiveAUMByCIFMini entity) {
		Session sessionA = HibernateArchiveUtil.getSessionFactory().openSession();
		sessionA.beginTransaction();
		sessionA.delete(entity);
		sessionA.getTransaction().commit();
	}

	
}
