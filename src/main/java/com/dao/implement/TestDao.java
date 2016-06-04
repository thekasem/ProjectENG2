package com.dao.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;

import com.entity.AssetMini;
import com.entity.HibernateUtil;

public class TestDao {

//	public static List<Object[]> getListByDate() {
//		Session sessionB = HibernateUtil.getSessionFactory().openSession();
//		sessionB.beginTransaction();
//		List<Object[]> result = null;
//		try {
////			Query query = sessionB.createQuery("SELECT DISTINCT browser from ActivityLogMini ");   //select  sum(usigTime), memberId  from ActivityLogMini where logDate between '20150101' and '20150131' and memberId =1 Group by logDate, memberId 
//			Query query = sessionB.createSQLQuery("SELECT sum(cost), aocdate FROM buyasset WHERE aocdate like '2008%' group by aocdate"); 
//			
////			query.setFirstResult(0);
////			query.setMaxResults(8);
//			result = (List<Object[]>) query.list();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		sessionB.getTransaction().commit();
//		return result;
//	}
//	
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
//		TestMethodHibernate testMethod = new TestMethodHibernate();
//		List<Object[]> list = testMethod.getListByDate();
//		testMethod.setData(list);
//		List<String> date = testMethod.getDateTime();
//		List<Double> cost = testMethod.getSumCost();
//		double result = getcount();
//		System.out
//				.println("++++++++++++++++++++++++++++ test browser ++++++++++++++++++++++++++++++++");
//		System.out.println("count list : " + list.size());
//		float i = 0;
//		for (int t=0;t < list.size();t++) {
//			System.out.println(date.get(t)+" \t"+cost.get(t));
//		}
//       System.out.println("total sum value : "+ result +" record");
       
//		List<Double> temp = new ArrayList<Double>();
		
//		temp.add(null);
//		temp.add(9.12);
//		double result = temp.get(1)+1;
//		temp.add(result);
//		System.out.println("size array is : "+temp.size());
//		for(int i = 0 ; i<temp.size(); i++){
//			double res = 0;
//			if(temp.get(i)!=null){
//				res = temp.get(i);
//			}
//			System.out.println(res+ " "+ i);
//		}
		Random rand = new Random();

		
		for(int i = 0;i<342;i++){
		int  n = rand.nextInt(10 - 2 + 1) + 2;
		System.out.println(n);
		}
	}

}
