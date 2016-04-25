package com.dao.implement;

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
			Query query = sessionB.createSQLQuery("SELECT SUM( buyasset.valueaoc ) , asset.typeassetid "
					+ "FROM buyasset left outer JOIN asset ON asset.assetid = buyasset.assetid "
					+ "WHERE aocdate BETWEEN  '20080101' AND  '20080131' " 
					+ "GROUP BY asset.typeassetid ORDER BY asset.typeassetid ASC");
			
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
			Query query = sessionB.createQuery("select  sum(typeAssetId)  from AssetMini");
			result = Double.parseDouble(query.uniqueResult().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionB.getTransaction().commit();
		return result;
	}

	public static void main(String[] args) {
		List<Object[]> list = getListByDate();
		double result = getcount();
		System.out
				.println("++++++++++++++++++++++++++++ test browser ++++++++++++++++++++++++++++++++");
		System.out.println("count list : " + list.size());
		float i = 0;
		for (Object[] te : list) {
			System.out.println(te[0]+" \t"+te[1]);
		}
       System.out.println("total count record : "+ result +" record");
		
	}

}
