package com.dao.implement;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.dao.interfaces.IApplicationArchiveLogDao;
import com.entity.HibernateArchiveUtil;
import com.entity.archive.ArchiveApplicationLogMini;

public class ApplicationArchiveLogDao implements IApplicationArchiveLogDao {

	public String createCriteriaSearch(ArchiveApplicationLogMini obj,
			boolean isOrdering, boolean isAscending, boolean isCount) {
		boolean where = true;
		String command = "";
		try {
			
			if (isCount) {
				command += "SELECT COUNT(*) FROM ArchiveApplicationLogMini ";
			} else {
				command += "FROM ArchiveApplicationLogMini ";
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

			if (obj.getActivityLogId() != null && !obj.getActivityLogId().trim().equals("")) {
				if (where) {
					command += " WHERE UPPER(activityLogId) LIKE UPPER('%" + obj.getActivityLogId().toUpperCase().trim() + "%')";
					where = false;

				} else
					command += " AND UPPER(activityLogId) LIKE UPPER('%" + obj.getActivityLogId().toUpperCase().trim() + "%')";
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
			
			if (obj.getUserArchive() != null && !obj.getUserArchive().trim().equals("")) {
				if (where) {
					command += " WHERE UPPER(userArchive) LIKE UPPER('%" + obj.getUserArchive().toUpperCase().trim() + "%')";
					where = false;
					
				} else
					command += " AND UPPER(userArchive) LIKE UPPER('%" + obj.getUserArchive().toUpperCase().trim() + "%')";
			}
			
			if (obj.getDateArchive() != null && !obj.getDateArchive().trim().equals("")) {
				if (where) {
					command += " WHERE dateArchive = '" + obj.getDateArchive().trim() + "'";
					where = false;
				}
			}
			
			if (!isCount) {
				if (isOrdering) {
					if (isAscending) {
						command += " ORDER BY dateArchive ASC , logDate ASC , logTime ASC ";
				} else {
						command += " ORDER BY dateArchive DESC , logDate DESC , logTime DESC ";
					}
				}
			}
			
		} catch (Exception ex){
			ex.printStackTrace();
		}
		
		return command;
	}

	public List<ArchiveApplicationLogMini> getListByCriteriaSearch(	ArchiveApplicationLogMini criteriaSearch, boolean isOrdering,
			boolean isAscending, int firstResult, int maxResult) {
		Session sessionA = HibernateArchiveUtil.getSessionFactory().openSession();
		sessionA.beginTransaction();
		List<ArchiveApplicationLogMini> result = null;
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

	public int getCountByCriteriaSearch(ArchiveApplicationLogMini criteriaSearch) {
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

	public ArchiveApplicationLogMini getObjectById(int eventId) {
		Session sessionA = HibernateArchiveUtil.getSessionFactory().openSession();
		sessionA.beginTransaction();
		ArchiveApplicationLogMini archiveApplicationLogMini = new ArchiveApplicationLogMini();
		sessionA.load(archiveApplicationLogMini, eventId);
		sessionA.getTransaction().commit();
		return archiveApplicationLogMini;
	}

	public void save(ArchiveApplicationLogMini entity) {
		Session sessionA = HibernateArchiveUtil.getSessionFactory().openSession();
		sessionA.beginTransaction();
		sessionA.save(entity);
		sessionA.getTransaction().commit();
	}

	public void delete(ArchiveApplicationLogMini entity) {
		Session sessionA = HibernateArchiveUtil.getSessionFactory().openSession();
		sessionA.beginTransaction();
		sessionA.delete(entity);
		sessionA.getTransaction().commit();
	}
}
