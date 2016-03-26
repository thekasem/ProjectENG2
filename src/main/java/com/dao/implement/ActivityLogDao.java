package com.dao.implement;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.dao.interfaces.IActivityLogDao;
import com.entity.HibernateUtil;
import com.entity.bonanza.ActivityLogMini;

public class ActivityLogDao implements IActivityLogDao {

	public List<ActivityLogMini> getListByDate(String date, String condition) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<ActivityLogMini> result = null;
		try {
			Query query = sessionB
					.createQuery("from ActivityLogMini where logDate "
							+ condition + " '" + date + "'");
			query.setFirstResult(0);
			query.setMaxResults(500);
			result = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}

	public String createCriteriaSearch(ActivityLogMini obj, boolean isOrdering,
			boolean isAscending, boolean isCount) {
		boolean where = true;
		String command = "";
		try {
			if (isCount) {
				command += "SELECT COUNT(*) FROM ActivityLogMini ";
			} else {
				command += "FROM ActivityLogMini ";
			}

			if (obj.getLogDate() != null && !obj.getLogDate().trim().equals("")) {
				if (where) {
					command += " WHERE logDate = '" + obj.getLogDate().trim()
							+ "'";
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

			if (!isCount) {
				if (isOrdering) {
					if (isAscending)
						command += " ORDER BY logDate ASC , logId ASC ";
					else
						command += " ORDER BY logDate DESC , logId DESC ";
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return command;
	}

	public List<ActivityLogMini> getListByCriteriaSearch(
			ActivityLogMini criteriaSearch, boolean isOrdering,
			boolean isAscending, int firstResult, int maxResult) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<ActivityLogMini> result = null;
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

	public int getCountByCriteriaSearch(ActivityLogMini criteriaSearch) {
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

	public ActivityLogMini getObjectById(int eventId) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		ActivityLogMini activityLogMini = new ActivityLogMini();
		sessionB.load(activityLogMini, eventId);
		sessionB.getTransaction().commit();
		return activityLogMini;
	}

	public void save(ActivityLogMini entity) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		sessionB.save(entity);
		sessionB.getTransaction().commit();

	}

	public void delete(ActivityLogMini entity) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		sessionB.delete(entity);
		sessionB.getTransaction().commit();

	}

	private String criteriaGetDataBrowsers(String name, Boolean searchBy,
			String year) {
		String command = "";
		if (searchBy) {
			command = "SELECT  COUNT(browser) from ActivityLogMini where UPPER(browser) LIKE UPPER('%"
					+ name
					+ "%') and logDate between '"
					+ year
					+ "0101' and '"
					+ year + "1231' ";
		} else {
			command = "SELECT  COUNT(browser) from ActivityLogMini where browser = '"
					+ name
					+ "' and logDate between '"
					+ year
					+ "0101' and '"
					+ year + "1231'";
		}
		return command;
	}

	public int getDataBrowsers(String name, Boolean searchBy, String year) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		int result = 0;
		try {
			Query query = sessionB.createQuery(criteriaGetDataBrowsers(name,
					searchBy, year));
			result = Integer.parseInt(query.uniqueResult().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}

	public List<String> getNameBrowsers(String name, String year) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<String> result = null;
		try {
			Query query = sessionB
					.createQuery("SELECT DISTINCT browser from ActivityLogMini where UPPER(browser) LIKE UPPER('%"
							+ name
							+ "%') and logDate between '"
							+ year
							+ "0101' and '" + year + "1231' ");
			result = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}

	public List<String> getNameAction(String year) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<String> result = null;
		try {
			Query query = sessionB
					.createQuery("SELECT  actionClass from ActivityLogMini where logDate between '"
							+ year
							+ "0101' and '"
							+ year
							+ "1231' group by actionClass order by count(actionClass) desc ");
			query.setFirstResult(0);
			query.setMaxResults(5);
			result = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}

	public int getDataAction(String name, String year) { // year sent xxxxXX
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		int result = 0;
		try {
			Query query = sessionB
					.createQuery("SELECT  COUNT(actionClass) from ActivityLogMini where logDate between '"
							+ year
							+ "01' and '"
							+ year
							+ "31' and actionClass = '" + name + "'");
			result = Integer.parseInt(query.uniqueResult().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private String commandQuery(String yearAndMonth, boolean modeSearch,
			int memberId) {
		String command = "";
		if (modeSearch) {
			command = "select  sum(usigTime)  from ActivityLogMini where logDate between '"
					+ yearAndMonth
					+ "01' and '"
					+ yearAndMonth
					+ "31' Group by logDate, memberId ";
		} else {
			command = "select  sum(usigTime) from ActivityLogMini where logDate between '"
					+ yearAndMonth
					+ "01' and '"
					+ yearAndMonth
					+ "31' and memberId ="
					+ memberId
					+ " Group by logDate, memberId";
		}
		return command;
	}

	public List<Integer> getListSumTimeUsingSite(String yearAndMonth,
			boolean modeSearch, int memberId) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<Integer> result = null;
		try {
			Query query = sessionB.createQuery(commandQuery(yearAndMonth,
					modeSearch, memberId));
			result = (List<Integer>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}

	public List<Object[]> getListTopUser(String year) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<Object[]> result = null;
		try {
			Query query = sessionB
					.createQuery("select  sum(usigTime), memberId  from ActivityLogMini where logDate between '"
							+ year
							+ "0101' and '"
							+ year
							+ "1231' Group by memberId order by sum(usigTime) desc  ");
			query.setFirstResult(0);
			query.setMaxResults(5);
			result = (List<Object[]>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}

	public int countAllByYear(String year) {
		int result = 0;
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		try {
			Query query = sessionB.createQuery("SELECT  COUNT(browser) from ActivityLogMini where logDate between '"
					+ year
					+ "0101' and '"
					+ year + "1231' ");
			result = Integer.parseInt(query.uniqueResult().toString());
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}

}
