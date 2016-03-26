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

import com.controller.interfaces.IAUMByBranchArchiveController;
import com.dao.interfaces.IAUMByBranchArchiveDao;
import com.dao.interfaces.IAUMByBranchDao;
import com.entity.HibernateArchiveUtil;
import com.entity.archive.ArchiveAUMByBranchMini;
import com.entity.bonanza.AUMByBranchMini;

public class AUMByBranchArchiveController implements IAUMByBranchArchiveController {
	
	IAUMByBranchArchiveDao aumByBranchArchiveDao;
	IAUMByBranchDao aumByBranchDao;
	
	

	public IAUMByBranchArchiveDao getAumByBranchArchiveDao() {
		return aumByBranchArchiveDao;
	}

	public void setAumByBranchArchiveDao(
			IAUMByBranchArchiveDao aumByBranchArchiveDao) {
		this.aumByBranchArchiveDao = aumByBranchArchiveDao;
	}

	public IAUMByBranchDao getAumByBranchDao() {
		return aumByBranchDao;
	}

	public void setAumByBranchDao(IAUMByBranchDao aumByBranchDao) {
		this.aumByBranchDao = aumByBranchDao;
	}

	public int getCount(ArchiveAUMByBranchMini criteriaSearch) {
		return aumByBranchArchiveDao.getCountByCriteriaSearch(criteriaSearch);
	}

	public List<ArchiveAUMByBranchMini> getList(
			ArchiveAUMByBranchMini criteriaSearch, Boolean isOrdering,
			Boolean isAscending, Integer firstResult, Integer maxResult) {
		List<ArchiveAUMByBranchMini> result = new ArrayList<ArchiveAUMByBranchMini>();
		List<ArchiveAUMByBranchMini> list = aumByBranchArchiveDao.getListByCriteriaSearch(criteriaSearch, isOrdering, isAscending, firstResult, maxResult);
		for(ArchiveAUMByBranchMini entity : list){
			entity.setAumDate(convertDate(entity.getAumDate()));
			entity.setCreateDate(convertDate(entity.getCreateDate()));
			entity.setDateArchive(convertDate(entity.getDateArchive()));
			result.add(entity);
		}
		return result;
	}

	public ArchiveAUMByBranchMini getObjectById(int eventId) {
		return aumByBranchArchiveDao.getObjectById(eventId);
	}

	public void addArchive(String date, String condition) {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		List<AUMByBranchMini> listB;
		String dateToday = dateFormat.format(new Date());
		HttpSession session = ServletActionContext.getRequest().getSession();
		Session sessionA = HibernateArchiveUtil.getSessionFactory().openSession();
		sessionA.beginTransaction();
		try {
			do {
				listB = aumByBranchDao.getListByDate(date, condition);
				for(AUMByBranchMini entityB : listB){
					ArchiveAUMByBranchMini entityA = new ArchiveAUMByBranchMini();
					BeanUtils.copyProperties(entityA, entityB);
					entityA.setDateArchive(dateToday);
					entityA.setConditionArchive("Date "+condition+" "+ convertDate(date));
					entityA.setUserArchive((String)session.getAttribute("user"));
					aumByBranchArchiveDao.save(entityA);
					aumByBranchDao.delete(entityB);
				}
			} while (listB==null);
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
