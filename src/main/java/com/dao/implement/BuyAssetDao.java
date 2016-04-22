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
	
	private String commandSQLTypeAsset(String yearAndMonthFrom, String yearAndMonthTo, boolean allYear, boolean each , String customerId){
		String command = "";
		if(allYear){
			command = "SELECT SUM( buyasset.valueaoc ) , asset.typeassetid "
					+ "FROM buyasset INNER JOIN asset ON buyasset.assetid = asset.assetid ";
					
		}else{
			command = "SELECT SUM( buyasset.valueaoc ) , asset.typeassetid "
					+ "FROM buyasset INNER JOIN asset ON buyasset.assetid = asset.assetid "
					+ "WHERE aocdate BETWEEN  '"+yearAndMonthFrom+"01' AND  '"+yearAndMonthTo+"31' ";
		}
		if (each){
			command = command + "and buyasset.customerid = "+ customerId;
		}
		command = command + " GROUP BY asset.typeassetid ORDER BY asset.typeassetid ASC";
		return command;
	}

	public List<Object[]> getSumTypeAssetValues(String yearAndMonthFrom, String yearAndMonthTo, boolean allYear) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<Object[]> result = null;
		try {
			Query query = sessionB.createSQLQuery(commandSQLTypeAsset(yearAndMonthFrom, yearAndMonthTo, allYear,false,""));
			result = (List<Object[]>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}
	
	private String commandSQLTypeCustomer(String yearAndMonthFrom, String yearAndMonthTo, boolean allYear, boolean each, String assetId){
		String command = "";
		if(allYear){
			command = "SELECT SUM( buyasset.valueaoc ) , customer.typecustomerid "
					+ "FROM buyasset INNER JOIN customer ON buyasset.customerid = customer.customerid ";
		}else{
			command = "SELECT SUM( buyasset.valueaoc ) , customer.typecustomerid "
					+ "FROM buyasset INNER JOIN customer ON buyasset.customerid = customer.customerid "
					+ "WHERE aocdate BETWEEN  '"+yearAndMonthFrom+"01' AND  '"+yearAndMonthTo+"31' ";
		}
		if (each){
			command = command + "and buyasset.assetid = "+ assetId;
		}
		 command = command + " GROUP BY customer.typecustomerid ORDER BY customer.customerid ASC";
		
		return command;
	}

	public List<Object[]> getSumTypeCustomerValues(String yearAndMonthFrom,
			String yearAndMonthTo, boolean allYear) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<Object[]> result = null;
		try {
			Query query = sessionB.createSQLQuery(commandSQLTypeCustomer(yearAndMonthFrom, yearAndMonthTo, allYear,false,""));
			result = (List<Object[]>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}

	public List<Object[]> getSumValuesByCustomer(String yearAndMonthFrom, String yearAndMonthTo, boolean allYear,String assetId) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<Object[]> result = null;
		try {
			Query query = sessionB.createSQLQuery(commandSQLTypeCustomer(yearAndMonthFrom, yearAndMonthTo, allYear,true,assetId));
			result = (List<Object[]>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}

	public List<Object[]> getSumValuesByAsset(String yearAndMonthFrom, String yearAndMonthTo, boolean allYear, String customerId) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<Object[]> result = null;
		try {
			Query query = sessionB.createSQLQuery(commandSQLTypeAsset(yearAndMonthFrom, yearAndMonthTo, allYear,true,customerId));
			result = (List<Object[]>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}

	
	

}
