package com.dao.implement;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.entity.HibernateUtil;

public class TestMethodHibernate {
	
	private List<String> dateTime;
	private List<Double> sumCost;
	
	
	public List<Object[]> getListByDate() {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<Object[]> result = null;
		try {
			Query query = sessionB.createSQLQuery("SELECT sum(cost*valueaoc), aocdate FROM buyasset WHERE aocdate like '2008%' group by aocdate"); 
			
			result = (List<Object[]>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}
	
	public void setData(List<Object[]> getListByDate){
		dateTime = new ArrayList<String>();
		sumCost = new ArrayList<Double>();
		
		for(Object[] value:getListByDate){
			sumCost.add((Double) value[0]);
			dateTime.add(value[1]+"");
		}
		
		
	}

	public List<String> getDateTime() {
		return dateTime;
	}

	public List<Double> getSumCost() {
		return sumCost;
	}
	
	
	

}
