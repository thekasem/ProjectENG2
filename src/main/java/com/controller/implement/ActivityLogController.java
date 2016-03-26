package com.controller.implement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.controller.interfaces.IActivityLogController;
import com.dao.interfaces.IActivityLogDao;
import com.dao.interfaces.IMemberDao;
import com.entity.bonanza.ActivityLogMini;
import com.entity.bonanza.MemberMini;

public class ActivityLogController implements IActivityLogController {

	private IActivityLogDao activityLogDao;
	private IMemberDao memberDao;

	public IMemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(IMemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public IActivityLogDao getActivityLogDao() {
		return activityLogDao;
	}

	public void setActivityLogDao(IActivityLogDao activityLogDao) {
		this.activityLogDao = activityLogDao;
	}

	public List<String> getNameBrowsers(String name, String year) {
		return activityLogDao.getNameBrowsers(name, year);
	}

	public List<Float> getDataBrowsers(List<String> name, Boolean searchBy,
			String year) {
		List<Float> result = new ArrayList<Float>();
		for (String data : name) {
			float percent = calPercent(data, searchBy, year);
			result.add(percent);

		}
		return result;
	}

	private float calPercent(String name, Boolean searchBy, String year) {
		float countBrowser = activityLogDao.getDataBrowsers(name, searchBy,
				year);
		float countAll = activityLogDao.countAllByYear(year);
		float result = (countBrowser / countAll) * 100;
		return result;
	}

	public List<Integer> getDataAction(String name, String year) {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 1; i <= 12; i++) {
			result.add(activityLogDao
					.getDataAction(name, yearAndMonth(year, i)));
		}
		return result;
	}

	public List<String> getNameAction(String year) {
		return activityLogDao.getNameAction(year);
	}

	private String yearAndMonth(String year, int month) {
		String result = "";
		if (month < 10) {
			result = year + "0" + Integer.toString(month);
		} else {
			result = year + Integer.toString(month);
		}
		return result;
	}

	public int getCountByCriteriaSearch(ActivityLogMini criteriaSearch) {
		return activityLogDao.getCountByCriteriaSearch(criteriaSearch);
	}

	public List<Float> getListAverageTimeOnSite(String year) {
		List<Float> result = new ArrayList<Float>();
		for (int i = 1; i <= 12; i++) {
			result.add(calAverage(activityLogDao.getListSumTimeUsingSite(yearAndMonth(year, i), true, 0)));
		}
		return result;
	}

	private float calAverage(List<Integer> list) {

		float average = 0.0f;
		try {
			float result = 0.0f;
			if (list != null && list.size() != 0) {
				for (Object value : list) {
					result = result + Integer.parseInt(value.toString());
				}

				average = result / list.size();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return average;
	}

	public List<String> nameTopUser(String year) {
		List<String> result = new ArrayList<String>();
		List<Object[]> listTopUser = activityLogDao.getListTopUser(year);
		for (Object[] ob : listTopUser) {
			MemberMini memberMini = memberDao.getObjectById((Integer) ob[1]);
			result.add(memberMini.getLoginName());
		}

		return result;
	}

	public List<Float> getDataAverageTimeByUser(String year, int numberTop) {
		List<Float> result = new ArrayList<Float>();
		Object[]  topUser = activityLogDao.getListTopUser(year).get(numberTop-1);
		for (int i = 1; i <= 12; i++) {
			result.add(calAverage(activityLogDao.getListSumTimeUsingSite(yearAndMonth(year, i), false,(Integer) topUser[1])));
		}
		
		return result;
	}

}
