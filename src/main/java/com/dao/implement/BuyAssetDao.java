package com.dao.implement;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.dao.interfaces.IBuyAssetDao;
import com.entity.HibernateUtil;

public class BuyAssetDao implements IBuyAssetDao{

	public List<String> getListYear() {
			Session sessionB = HibernateUtil.getSessionFactory().openSession();
			sessionB.beginTransaction();
			List<String> result = null;
			try {
				Query query = sessionB.createSQLQuery("select distinct(SUBSTR(AOCDATE,1,4))  from buyasset");
				result = query.list();
			} catch (Exception e) {
				e.printStackTrace();
			}
			sessionB.getTransaction().commit();
			return result;
	}

}
