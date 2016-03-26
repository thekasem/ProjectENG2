package com.controller.implement;

import com.controller.interfaces.IApplicationLogController;
import com.dao.interfaces.IApplicationLogDao;
import com.entity.bonanza.ApplicationLogMini;

public class ApplicationLogController implements IApplicationLogController {

	IApplicationLogDao applicationLogDao;

	public int getCountByCriteriaSearch(ApplicationLogMini criteriaSearch) {
		return applicationLogDao.getCountByCriteriaSearch(criteriaSearch);
	}

	public IApplicationLogDao getApplicationLogDao() {
		return applicationLogDao;
	}

	public void setApplicationLogDao(IApplicationLogDao applicationLogDao) {
		this.applicationLogDao = applicationLogDao;
	}
	
}