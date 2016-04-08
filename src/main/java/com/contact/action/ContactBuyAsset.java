package com.contact.action;

import java.util.List;

import com.controller.interfaces.IBuyAssetController;

public class ContactBuyAsset implements IBuyAssetController {

	IBuyAssetController buyAssetController;

	public IBuyAssetController getBuyAssetController() {
		return buyAssetController;
	}

	public void setBuyAssetController(IBuyAssetController buyAssetController) {
		this.buyAssetController = buyAssetController;
	}

	public List<String> getListYear() {
		return buyAssetController.getListYear();
	}

}
