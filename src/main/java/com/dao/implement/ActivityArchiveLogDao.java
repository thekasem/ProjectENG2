package com.dao.implement;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.dao.interfaces.IActivityArchiveLogDao;
import com.entity.HibernateArchiveUtil;
import com.entity.archive.ArchiveActivityLogMini;

public class ActivityArchiveLogDao implements IActivityArchiveLogDao {

	public String createCriteriaSearch(ArchiveActivityLogMini obj,
			boolean isOrdering, boolean isAscending, boolean isCount) {
		boolean where = true;
		String command = "";
		try {
			if (isCount) {
				command += "SELECT COUNT(*) FROM ArchiveActivityLogMini ";
			} else {
				command += "FROM ArchiveActivityLogMini ";
			}

			if (obj.getLogDate() != null && !obj.getLogDate().trim().equals("")) {
				if (where) {
					command += " WHERE logDate = '" + obj.getLogDate().trim()
							+ "'";
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

			if (obj.getLogId() != 0) {
				if (where) {
					command += " WHERE logId = " + obj.getLogId();
					where = false;
				}
			}

			if (obj.getActionClass() != null
					&& !obj.getActionClass().trim().equals("")) {
				if (where) {
					command += " WHERE UPPER(actionClass) LIKE UPPER('%"
							+ obj.getActionClass().toUpperCase().trim() + "%')";
					where = false;

				} else
					command += " AND UPPER(actionClass) LIKE UPPER('%"
							+ obj.getActionClass().toUpperCase().trim() + "%')";
			}
			if (obj.getClientIP() != null
					&& !obj.getClientIP().trim().equals("")) {
				if (where) {
					command += " WHERE UPPER(clientIP) LIKE UPPER('%"
							+ obj.getClientIP().toUpperCase().trim() + "%')";
					where = false;

				} else
					command += " AND UPPER(clientIP) LIKE UPPER('%"
							+ obj.getClientIP().toUpperCase().trim() + "%')";
			}

			if (obj.getAction() != null && !obj.getAction().trim().equals("")) {
				if (where) {
					command += " WHERE UPPER(action) LIKE UPPER('%"
							+ obj.getAction().toUpperCase().trim() + "%')";
					where = false;

				} else
					command += " AND UPPER(action) LIKE UPPER('%"
							+ obj.getAction().toUpperCase().trim() + "%')";
			}

			if (obj.getScreencode() != null
					&& !obj.getScreencode().trim().equals("")) {
				if (where) {
					command += " WHERE UPPER(screencode) LIKE UPPER('%"
							+ obj.getScreencode().toUpperCase().trim() + "%')";
					where = false;

				} else
					command += " AND UPPER(screencode) LIKE UPPER('%"
							+ obj.getScreencode().toUpperCase().trim() + "%')";
			}

			if (obj.getScreenname() != null
					&& !obj.getScreenname().trim().equals("")) {
				if (where) {
					command += " WHERE UPPER(screenname) LIKE UPPER('%"
							+ obj.getScreenname().toUpperCase().trim() + "%')";
					where = false;

				} else
					command += " AND UPPER(screenname) LIKE UPPER('%"
							+ obj.getScreenname().toUpperCase().trim() + "%')";
			}

			if (obj.getClientIP() != null
					&& !obj.getClientIP().trim().equals("")) {
				if (where) {
					command += " WHERE UPPER(clientIP) LIKE UPPER('%"
							+ obj.getClientIP().toUpperCase().trim() + "%')";
					where = false;

				} else
					command += " AND UPPER(clientIP) LIKE UPPER('%"
							+ obj.getClientIP().toUpperCase().trim() + "%')";
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
						command += " ORDER BY dateArchive ASC , logId ASC ";
					else
						command += " ORDER BY dateArchive DESC , logId DESC ";
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return command;
	}

	public List<ArchiveActivityLogMini> getListByCriteriaSearch(
			ArchiveActivityLogMini criteriaSearch, boolean isOrdering,
			boolean isAscending, int firstResult, int maxResult) {
		Session sessionA = HibernateArchiveUtil.getSessionFactory()
				.openSession();
		sessionA.beginTransaction();
		List<ArchiveActivityLogMini> result = null;
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

	public int getCountByCriteriaSearch(ArchiveActivityLogMini criteriaSearch) {
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

	public ArchiveActivityLogMini getObjectById(int eventId) {
		Session sessionA = HibernateArchiveUtil.getSessionFactory()
				.openSession();
		sessionA.beginTransaction();
		ArchiveActivityLogMini archiveActivityLogMini = new ArchiveActivityLogMini();
		sessionA.load(archiveActivityLogMini, eventId);
		sessionA.getTransaction().commit();
		return archiveActivityLogMini;
	}

	public void save(ArchiveActivityLogMini entity) {
		Session sessionA = HibernateArchiveUtil.getSessionFactory().openSession();
		sessionA.beginTransaction();
		sessionA.save(entity);
		sessionA.getTransaction().commit();
	}

	public void delete(ArchiveActivityLogMini entity) {
		Session sessionA = HibernateArchiveUtil.getSessionFactory().openSession();
		sessionA.beginTransaction();
		sessionA.delete(entity);
		sessionA.getTransaction().commit();
	}
}
