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

import com.controller.interfaces.IAUMByCIFArchiveController;
import com.dao.interfaces.IAUMByCIFArchiveDao;
import com.dao.interfaces.IAUMByCIFDao;
import com.entity.HibernateArchiveUtil;
import com.entity.archive.ArchiveAUMByCIFMini;
import com.entity.bonanza.AUMByCIFMini;

public class AUMByCIFArchiveController implements IAUMByCIFArchiveController {
	
	IAUMByCIFArchiveDao aumByCIFArchiveDao;
	IAUMByCIFDao aumByCIFDao;
	
	

	public IAUMByCIFDao getAumByCIFDao() {
		return aumByCIFDao;
	}

	public void setAumByCIFDao(IAUMByCIFDao aumByCIFDao) {
		this.aumByCIFDao = aumByCIFDao;
	}

	public IAUMByCIFArchiveDao getAumByCIFArchiveDao() {
		return aumByCIFArchiveDao;
	}

	public void setAumByCIFArchiveDao(IAUMByCIFArchiveDao aumByCIFArchiveDao) {
		this.aumByCIFArchiveDao = aumByCIFArchiveDao;
	}

	public int getCount(ArchiveAUMByCIFMini criteriaSearch) {
		return aumByCIFArchiveDao.getCountByCriteriaSearch(criteriaSearch);
	}

	public List<ArchiveAUMByCIFMini> getList(
			ArchiveAUMByCIFMini criteriaSearch, Boolean isOrdering,
			Boolean isAscending, Integer firstResult, Integer maxResult) {
		
		List<ArchiveAUMByCIFMini> result = new ArrayList<ArchiveAUMByCIFMini>();
		List<ArchiveAUMByCIFMini> list = aumByCIFArchiveDao.getListByCriteriaSearch(criteriaSearch, isOrdering, isAscending, firstResult, maxResult);
		for(ArchiveAUMByCIFMini entity: list){
			entity.setAumDate(convertDate(entity.getAumDate()));
			entity.setCreateDate(convertDate(entity.getCreateDate()));
			entity.setDateArchive(convertDate(entity.getDateArchive()));
			result.add(entity);
		}
		return result;
	}

	public ArchiveAUMByCIFMini getObjectById(int eventId) {
		return aumByCIFArchiveDao.getObjectById(eventId);
	}

	public void addArchive(String date, String condition) {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		List<AUMByCIFMini> listB;
		String dateToday = dateFormat.format(new Date());
		HttpSession session = ServletActionContext.getRequest().getSession();
		Session sessionA = HibernateArchiveUtil.getSessionFactory().openSession();
		sessionA.beginTransaction();
		try {
			do {
				listB = aumByCIFDao.getListByDate(date, condition);
				for(AUMByCIFMini entityB : listB ){
					ArchiveAUMByCIFMini entityA = new ArchiveAUMByCIFMini();
					BeanUtils.copyProperties(entityA, entityB);
					entityA.setDateArchive(dateToday);
					entityA.setCoditionArhcive("Date "+condition+" "+convertDate(date));
					entityA.setUserArchive((String)session.getAttribute("user"));
					aumByCIFArchiveDao.save(entityA);
					aumByCIFDao.delete(entityB);
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
