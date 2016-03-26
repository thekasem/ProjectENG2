package com.controller.implement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.controller.interfaces.IApplicationArchiveLogController;
import com.dao.interfaces.IApplicationArchiveLogDao;
import com.dao.interfaces.IApplicationLogDao;
import com.entity.HibernateArchiveUtil;
import com.entity.archive.ArchiveApplicationLogMini;
import com.entity.bonanza.ApplicationLogMini;

public class ApplicationArchiveLogController implements
		IApplicationArchiveLogController {

	IApplicationArchiveLogDao applicationArchiveLogDao;
	IApplicationLogDao applicationLogDao;

	public IApplicationLogDao getApplicationLogDao() {
		return applicationLogDao;
	}

	public void setApplicationLogDao(IApplicationLogDao applicationLogDao) {
		this.applicationLogDao = applicationLogDao;
	}

	public IApplicationArchiveLogDao getApplicationArchiveLogDao() {
		return applicationArchiveLogDao;
	}

	public void setApplicationArchiveLogDao(
			IApplicationArchiveLogDao applicationArchiveLogDao) {
		this.applicationArchiveLogDao = applicationArchiveLogDao;
	}

	public int getCount(ArchiveApplicationLogMini criteriaSearch) {
		return applicationArchiveLogDao
				.getCountByCriteriaSearch(criteriaSearch);
	}

	public List<ArchiveApplicationLogMini> getList(
			ArchiveApplicationLogMini criteriaSearch, Boolean isOrdering,
			Boolean isAscending, Integer firstResult, Integer maxResult) {
		List<ArchiveApplicationLogMini> result = new ArrayList<ArchiveApplicationLogMini>();
		List<ArchiveApplicationLogMini> list = applicationArchiveLogDao
				.getListByCriteriaSearch(criteriaSearch, isOrdering,
						isAscending, firstResult, maxResult);
		for (ArchiveApplicationLogMini entity : list) {
			entity.setDateArchive(convertDate(entity.getDateArchive()));
			entity.setLogDate(convertDate(entity.getLogDate()));
			result.add(entity);
		}
		return result;
	}

	public ArchiveApplicationLogMini getObjectById(int eventId) {
		return applicationArchiveLogDao.getObjectById(eventId);
	}

	public void addArchive(String date, String condition) {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		List<ApplicationLogMini> listB;
		String dateToday = dateFormat.format(new Date());
		HttpSession session = ServletActionContext.getRequest().getSession();
		Session sessionA = HibernateArchiveUtil.getSessionFactory()
				.openSession();
		sessionA.beginTransaction();
		try {
			do {
				listB = applicationLogDao.getListByDate(date, condition);
				for (ApplicationLogMini entityB : listB) {
					ArchiveApplicationLogMini entityA = new ArchiveApplicationLogMini();
					BeanUtils.copyProperties(entityA, entityB);
					entityA.setDateArchive(dateToday);
					entityA.setCoditionArchive("Date " + condition + " "
							+ convertDate(date));
					entityA.setUserArchive((String) session
							.getAttribute("user"));
					applicationArchiveLogDao.save(entityA);
					applicationLogDao.delete(entityB);
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
