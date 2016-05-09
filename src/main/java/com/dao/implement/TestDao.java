package com.dao.implement;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.entity.AssetMini;
import com.entity.HibernateUtil;

public class TestDao {

	public static List<Object[]> getListByDate() {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		List<Object[]> result = null;
		try {
//			Query query = sessionB.createQuery("SELECT DISTINCT browser from ActivityLogMini ");   //select  sum(usigTime), memberId  from ActivityLogMini where logDate between '20150101' and '20150131' and memberId =1 Group by logDate, memberId 
			Query query = sessionB.createSQLQuery("SELECT SUM( buyasset.valueaoc ) , customer.typecustomerid "
					+ "FROM buyasset left outer JOIN customer ON buyasset.customerid = customer.customerid "
					+ "GROUP BY customer.typecustomerid ORDER BY customer.customerid ASC"); 
			
//			query.setFirstResult(0);
//			query.setMaxResults(8);
			result = (List<Object[]>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}
	
	public static double getcount() {
		Session sessionB = HibernateUtil.getSessionFactory().openSession();
		sessionB.beginTransaction();
		double result = 0;
		try {
//			Query query = sessionB.createQuery("SELECT  browser from ActivityLogMini where UPPER(browser) LIKE UPPER('%chrome%')");
//			result = query.list().size();
			Query query = sessionB.createSQLQuery("SELECT SUM( cost * valueaoc ) FROM buyasset WHERE aocdate BETWEEN  '20160101' AND  '20161231'");
			result = (Double) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}

	public static void main(String[] args) {
//		List<Object[]> list = getListByDate();
//		double result = getcount();
//		System.out
//				.println("++++++++++++++++++++++++++++ test browser ++++++++++++++++++++++++++++++++");
//		System.out.println("count list : " + list.size());
//		float i = 0;
//		for (Object[] te : list) {
//			System.out.println(te[0]+" \t"+te[1]);
//		}
//       System.out.println("total sum value : "+ result +" record");
		List<Double> temp = new ArrayList<Double>();
		temp.add(9.12);
		double result = temp.get(0)+1;
		temp.add(result);
		System.out.println("size array is : "+temp.size());
		for(int i = 0 ; i<=temp.size()-1; i++){
			
			System.out.println(temp.get(i)+ " "+ i);
		}
		
	}

}
