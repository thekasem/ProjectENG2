package com.dao.implement;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.dao.interfaces.IBuyAssetDao;
import com.entity.HibernateUtil;

public class BuyAssetDao implements IBuyAssetDao {

	public List<String> getListYear() {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<String> result = null;
		try {
			Query query = sessionB
					.createSQLQuery("select distinct(SUBSTR(AOCDATE,1,4))  from buyasset");
			result = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}
	
	private String commandSQLTypeAsset(String yearAndMonthFrom, String yearAndMonthTo, boolean allYear){
		String command = "";
		if(allYear){
			command = "SELECT SUM( buyasset.valueaoc ) , asset.typeassetid "
					+ "FROM buyasset INNER JOIN asset ON buyasset.assetid = asset.assetid "
					+ "GROUP BY asset.typeassetid "
					+ "ORDER BY asset.typeassetid ASC";
		}else{
			command = "SELECT SUM( buyasset.valueaoc ) , asset.typeassetid "
					+ "FROM buyasset INNER JOIN asset ON buyasset.assetid = asset.assetid "
					+ "WHERE aocdate BETWEEN  '"+yearAndMonthFrom+"01' AND  '"+yearAndMonthTo+"31' "
					+ "GROUP BY asset.typeassetid "
					+ "ORDER BY asset.typeassetid ASC";
		}
		return command;
	}

	public List<Object[]> getSumTypeAssetValues(String yearAndMonthFrom, String yearAndMonthTo, boolean allYear) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<Object[]> result = null;
		try {
			Query query = sessionB.createSQLQuery(commandSQLTypeAsset(yearAndMonthFrom, yearAndMonthTo, allYear));
			result = (List<Object[]>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}
	
	private String commandSQLTypeCustomer(String yearAndMonthFrom, String yearAndMonthTo, boolean allYear){
		String command = "";
		if(allYear){
			command = "SELECT SUM( buyasset.valueaoc ) , customer.typecustomerid "
					+ "FROM buyasset INNER JOIN customer ON buyasset.customerid = customer.customerid "
					+ "GROUP BY customer.typecustomerid "
					+ "ORDER BY customer.customerid ASC";
		}else{
			command = "SELECT SUM( buyasset.valueaoc ) , customer.typecustomerid "
					+ "FROM buyasset INNER JOIN customer ON buyasset.customerid = customer.customerid "
					+ "WHERE aocdate BETWEEN  '"+yearAndMonthFrom+"01' AND  '"+yearAndMonthTo+"31' "
					+ "GROUP BY customer.typecustomerid "
					+ "ORDER BY customer.customerid ASC";
		}
		return command;
	}

	public List<Object[]> getSumTypeCustomerValues(String yearAndMonthFrom,
			String yearAndMonthTo, boolean allYear) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<Object[]> result = null;
		try {
			Query query = sessionB.createSQLQuery(commandSQLTypeCustomer(yearAndMonthFrom, yearAndMonthTo, allYear));
			result = (List<Object[]>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}
	
	

}
