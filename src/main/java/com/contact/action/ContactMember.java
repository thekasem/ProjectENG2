package com.contact.action;

import java.util.List;

import com.controller.interfaces.IMemberController;
import com.entity.bonanza.MemberMini;


public class ContactMember implements IMemberController {
	
	IMemberController memberController;

	public IMemberController getMemberController() {
		return memberController;
	}

	public void setMemberController(IMemberController memberController) {
		this.memberController = memberController;
	}

	public int countAllByYear(String year) {
		return memberController.countAllByYear(year);
	}

	public List<Float> getListAverageNewUser(String year) {
		return memberController.getListAverageNewUser(year);
	}

	public List<String> getListYear() {
		return memberController.getListYear();
	}

	public MemberMini showProfile(String loginname) {
		return memberController.showProfile(loginname);
	}

	public List<Float> getAverage(List<Float> datacurrentyear, List<Float> datalastyear) {
		return memberController.getAverage(datacurrentyear, datalastyear);
	}

}
