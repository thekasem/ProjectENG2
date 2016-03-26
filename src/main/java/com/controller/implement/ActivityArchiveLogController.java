package com.controller.implement;

import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.controller.interfaces.IActivityArchiveLogController;
import com.dao.interfaces.IActivityArchiveLogDao;
import com.dao.interfaces.IActivityLogDao;
import com.entity.HibernateArchiveUtil;
import com.entity.archive.ArchiveActivityLogMini;
import com.entity.bonanza.ActivityLogMini;

public class ActivityArchiveLogController implements
		IActivityArchiveLogController {

	private IActivityArchiveLogDao activityArchiveLogDao;
	private IActivityLogDao activityLogDao;

	public IActivityArchiveLogDao getActivityArchiveLogDao() {
		return activityArchiveLogDao;
	}

	public void setActivityArchiveLogDao(
			IActivityArchiveLogDao activityArchiveLogDao) {
		this.activityArchiveLogDao = activityArchiveLogDao;
	}

	public IActivityLogDao getActivityLogDao() {
		return activityLogDao;
	}

	public void setActivityLogDao(IActivityLogDao activityLogDao) {
		this.activityLogDao = activityLogDao;
	}

	public int getCount(ArchiveActivityLogMini criteriaSearch) {
		return activityArchiveLogDao.getCountByCriteriaSearch(criteriaSearch);
	}

	public List<ArchiveActivityLogMini> getList(
			ArchiveActivityLogMini criteriaSearch, Boolean isOrdering,
			Boolean isAscending, Integer firstResult, Integer maxResult) {
		List<ArchiveActivityLogMini> result = new ArrayList<ArchiveActivityLogMini>();
		List<ArchiveActivityLogMini> list = activityArchiveLogDao
				.getListByCriteriaSearch(criteriaSearch, isOrdering,
						isAscending, firstResult, maxResult);
		for (ArchiveActivityLogMini entity : list) {
			entity.setDateArchive(convertDate(entity.getDateArchive()));
			entity.setLogDate(convertDate(entity.getLogDate()));
			result.add(entity);
		}
		return result;
	}

	public ArchiveActivityLogMini getObjectById(int eventId) {

		return null;
	}

	public void addArchive(String date, String condition)
			throws IllegalAccessException, InvocationTargetException {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		List<ActivityLogMini> listB;
		String dateToday = dateFormat.format(new Date());
		HttpSession session = ServletActionContext.getRequest().getSession();
		Session sessionA = HibernateArchiveUtil.getSessionFactory()
				.openSession();
		sessionA.beginTransaction();
		try {
			do {
				listB = activityLogDao.getListByDate(date, condition);
				for (ActivityLogMini entityB : listB) {
					ArchiveActivityLogMini entityA = new ArchiveActivityLogMini();
					BeanUtils.copyProperties(entityA, entityB);
					entityA.setDateArchive(dateToday);
					entityA.setConditionArchive("Date " + condition + " "
							+ convertDate(date));
					entityA.setUserArchive((String) session
							.getAttribute("user"));
					activityArchiveLogDao.save(entityA);
					activityLogDao.delete(entityB);
				}
			} while (listB == null);
		} catch (Exception e) {
			e.printStackTrace();
		}

		sessionA.getTransaction().commit();
	}

	public String convertDate(String datetoconvert) {
		String dateResult = "";
		if (datetoconvert != null) {
			dateResult = datetoconvert.substring(6, 8) + "/"
					+ datetoconvert.substring(4, 6) + "/"
					+ datetoconvert.substring(0, 4);
		}
		return dateResult;
	}

}
