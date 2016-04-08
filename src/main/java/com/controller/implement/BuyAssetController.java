package com.controller.implement;

import java.util.List;

import com.controller.interfaces.IBuyAssetController;
import com.dao.interfaces.IBuyAssetDao;

public class BuyAssetController implements IBuyAssetController{
	
	IBuyAssetDao buyAssetDao;
	

	public IBuyAssetDao getBuyAssetDao() {
		return buyAssetDao;
	}


	public void setBuyAssetDao(IBuyAssetDao buyAssetDao) {
		this.buyAssetDao = buyAssetDao;
	}


	public List<String> getListYear() {
		return buyAssetDao.getListYear();
	}
	
	

}
