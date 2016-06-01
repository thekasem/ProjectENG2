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
	
	private String commandSQLTypeAsset(String yearAndMonthFrom, String yearAndMonthTo, boolean allYear, char each , String customerId){
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
				System.out.println("Print line customerId is : "+customerId);
			}
			command = command + " GROUP BY asset.typeassetid ORDER BY asset.typeassetid ASC ) AS y ON t.typeassetid = y.typeassetid ";
		}
		
		return command;
	}

	public List<Object[]> getSumTypeAssetValues(String yearAndMonthFrom, String yearAndMonthTo, boolean allYear, char mode) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<Object[]> result = null;
		try {
			Query query = sessionB.createSQLQuery(commandSQLTypeAsset(yearAndMonthFrom, yearAndMonthTo, allYear,mode,""));
			result = (List<Object[]>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}
	
	private String commandSQLTypeCustomer(String yearAndMonthFrom, String yearAndMonthTo, boolean allYear, char each, String assetId){
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
			}
			 command = command + " GROUP BY customer.typecustomerid ORDER BY customer.typecustomerid ASC ) AS y ON t.typecustomerid = y.typecustomerid";
		}
		
		
		return command;
	}

	public List<Object[]> getSumTypeCustomerValues(String yearAndMonthFrom,
			String yearAndMonthTo, boolean allYear, char mode) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<Object[]> result = null;
		try {
			Query query = sessionB.createSQLQuery(commandSQLTypeCustomer(yearAndMonthFrom, yearAndMonthTo, allYear,mode,""));
			result = (List<Object[]>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}

	public List<Object[]> getSumValuesByCustomer(String yearAndMonthFrom, String yearAndMonthTo, boolean allYear,String assetId, char mode) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<Object[]> result = null;
		try {
			Query query = sessionB.createSQLQuery(commandSQLTypeCustomer(yearAndMonthFrom, yearAndMonthTo, allYear,mode,assetId));
			result = (List<Object[]>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}

	public List<Object[]> getSumValuesByAsset(String yearAndMonthFrom, String yearAndMonthTo, boolean allYear, String customerId, char mode) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<Object[]> result = null;
		try {
			Query query = sessionB.createSQLQuery(commandSQLTypeAsset(yearAndMonthFrom, yearAndMonthTo, allYear,mode,customerId));
			result = (List<Object[]>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}
	
	private String querySumCostAsset(String yearAndMonthFrom, String yearAndMonthTo, String typeAssetId){
		String command = "";
		if(typeAssetId.equals("")||typeAssetId==null){
			command = "SELECT SUM( cost * valueaoc ) "
					+ "FROM buyasset WHERE aocdate "
					+ "BETWEEN  '"+yearAndMonthFrom+"01' AND  '"+yearAndMonthTo+"31' ";
		}else {
			command = "SELECT SUM( buyasset.valueaoc * buyasset.cost ) "
					+ "FROM buyasset INNER JOIN asset "
					+ "ON buyasset.assetid = asset.assetid "
					+ "WHERE aocdate BETWEEN  '"+yearAndMonthFrom+"01' AND  '"+yearAndMonthFrom+"31' "
					+ "AND asset.typeassetid = "+typeAssetId+"";
		}
		return command;
	}

	public double getSumCostAsset(String yearAndMonthFrom,
			String yearAndMonthTo, String typeAssetId) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		double result = 0.0 ;
		try {
			Query query = sessionB.createSQLQuery(querySumCostAsset(yearAndMonthFrom, yearAndMonthTo, typeAssetId));
			result = (Double) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}
	 private String commandSumCostCustomer(String yearAndMonthFrom, String yearAndMonthTo, String typeCustomerId){
		 String command = "";
		 if(typeCustomerId.equals("")||typeCustomerId==null){
			 command = "SELECT SUM( cost * valueaoc ) "
						+ "FROM buyasset WHERE aocdate "
						+ "BETWEEN  '"+yearAndMonthFrom+"01' AND  '"+yearAndMonthTo+"31' ";
		 }else {
			 command = "SELECT SUM( buyasset.valueaoc * buyasset.cost ) "
			 		+ "FROM buyasset INNER JOIN customer "
			 		+ "ON buyasset.assetid = customer.customerid "
			 		+ "WHERE aocdate BETWEEN  '"+yearAndMonthFrom+"01' AND  '"+yearAndMonthFrom+"31' "
			 		+ "AND customer.typecustomerid ="+typeCustomerId+""; 
		 }
		 
		 return command;
	 }

	public double getSumCostCustomer(String yearAndMonthFrom,
			String yearAndMonthTo, String typeCustomerId) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		double result = 0.0 ;
		try {
			Query query = sessionB.createSQLQuery(commandSumCostCustomer(yearAndMonthFrom, yearAndMonthTo, typeCustomerId));
			result = (Double) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}

	public List<Object[]> getDataPrediction(String date) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<Object[]> result = null;
		try {
			Query query = sessionB.createSQLQuery("SELECT sum(cost*valueaoc), aocdate FROM buyasset WHERE aocdate like '"+date+"%' group by aocdate");
			result = (List<Object[]>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}
   
	private String commandEachPrediction(String date, String typeId,boolean type){
		String command = "";
		if(type){
			command = "SELECT sum(cost*valueaoc), aocdate FROM buyasset INNER JOIN customer ON buyasset.customerid = customer.customerid WHERE aocdate like '"+date+"%' and typecustomerid = "+typeId;
		}else{
			command = "SELECT sum(cost*valueaoc), aocdate FROM buyasset INNER JOIN asset ON buyasset.assetid = asset.assetid WHERE aocdate like '"+date+"%' and typeassetid = "+typeId;
		}
		    command = command + " group by aocdate";
		return command;
	}
	
	public List<Object[]> getDataEachPrediction(String date, String typeId,
			boolean type) {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<Object[]> result = null;
		try {
			Query query = sessionB.createSQLQuery(commandEachPrediction(date, typeId, type));
			result = (List<Object[]>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}

	
	

}
