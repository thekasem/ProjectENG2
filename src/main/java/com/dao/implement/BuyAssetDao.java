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
	
	private String commandSQLTypeAsset(String yearAndMonthFrom, String yearAndMonthTo, boolean allYear, char each , String id, String customerId){
		String command = "";
		if(allYear){
			command = "SELECT SUM( buyasset.valueaoc ) , asset.typeassetid "
                    + "FROM buyasset left outer JOIN asset ON buyasset.assetid = asset.assetid "
					+ " GROUP BY asset.typeassetid ORDER BY asset.typeassetid ASC";
					
		}else{
			command = "SELECT y.sum, t.typeassetid FROM typeasset AS t "
					+ "LEFT JOIN ( SELECT SUM( buyasset.valueaoc ) AS sum, asset.typeassetid "
					+ "FROM asset LEFT OUTER JOIN buyasset ON asset.assetid = buyasset.assetid "
					+ "WHERE aocdate BETWEEN  '"+yearAndMonthFrom+"01' AND  '"+yearAndMonthTo+"31'";
			if (each=='1'){
				command = command + " and buyasset.customerid = "+ customerId;
			}else if(each == '2'){
				command = command + " and asset.typeassetid = "+ id;
			}else if(each == '0'){
				command = command + " and buyasset.customerid = "+ customerId;
				command = command + " and asset.typeassetid = "+ id;
			}
			command = command + " GROUP BY asset.typeassetid ORDER BY asset.typeassetid ASC ) AS y ON t.typeassetid = y.typeassetid ";
		}
		
		return command;
	}

	public List<Object[]> getSumTypeAssetValues(String yearAndMonthFrom, String yearAndMonthTo, boolean allYear, String id, char mode) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<Object[]> result = null;
		try {
			Query query = sessionB.createSQLQuery(commandSQLTypeAsset(yearAndMonthFrom, yearAndMonthTo, allYear,mode,id,""));
			result = (List<Object[]>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}
	
	private String commandSQLTypeCustomer(String yearAndMonthFrom, String yearAndMonthTo, boolean allYear, char each, String id, String assetId){
		String command = "";
		if(allYear){
			command = "SELECT SUM( buyasset.valueaoc ) , customer.typecustomerid "
					+ "FROM buyasset left outer JOIN customer ON buyasset.customerid = customer.customerid "
					+ "GROUP BY customer.typecustomerid ORDER BY customer.customerid ASC";
		}else{
			command = "SELECT y.sum, t.typecustomerid FROM typecustomer AS t "
					+ "LEFT JOIN ( SELECT SUM( buyasset.valueaoc ) AS sum, customer.typecustomerid "
					+ "FROM customer LEFT OUTER JOIN buyasset ON customer.customerid = buyasset.customerid "
					+ "WHERE aocdate BETWEEN  '"+yearAndMonthFrom+"01' AND  '"+yearAndMonthTo+"31'";
			if (each == '1'){
				command = command + " and buyasset.assetid = "+ assetId;
			}else if(each == '2'){
				command = command + " and customer.typecustomerid = " + id;
			}else if(each == '0'){
				command = command + " and customer.typecustomerid = " + id;
				command = command + " and buyasset.assetid = "+ assetId;
			}
			 command = command + " GROUP BY customer.typecustomerid ORDER BY customer.typecustomerid ASC ) AS y ON t.typecustomerid = y.typecustomerid";
		}
		
		
		return command;
	}

	public List<Object[]> getSumTypeCustomerValues(String yearAndMonthFrom,
			String yearAndMonthTo, boolean allYear, String id, char mode) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<Object[]> result = null;
		try {
			Query query = sessionB.createSQLQuery(commandSQLTypeCustomer(yearAndMonthFrom, yearAndMonthTo, allYear,mode,id,""));
			result = (List<Object[]>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}

	public List<Object[]> getSumValuesByCustomer(String yearAndMonthFrom, String yearAndMonthTo, boolean allYear,String assetId,String id, char mode) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<Object[]> result = null;
		try {
			Query query = sessionB.createSQLQuery(commandSQLTypeCustomer(yearAndMonthFrom, yearAndMonthTo, allYear,mode,id,assetId));
			result = (List<Object[]>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}

	public List<Object[]> getSumValuesByAsset(String yearAndMonthFrom, String yearAndMonthTo, boolean allYear, String customerId, String id, char mode) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<Object[]> result = null;
		try {
			Query query = sessionB.createSQLQuery(commandSQLTypeAsset(yearAndMonthFrom, yearAndMonthTo, allYear,mode,id,customerId));
			result = (List<Object[]>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}

	
	

}
