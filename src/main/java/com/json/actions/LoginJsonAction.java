package com.json.actions;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class LoginJsonAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4937366360808612638L;
	private List<Integer> numberArrayI = new ArrayList<Integer>();
	private List<Integer> numberArrayII = new ArrayList<Integer>();
	
	private int[] numberarray1 = { 1005, 1436, 2063, 3057, 4618, 6444, 9822,
			15468, 20434, 24126, 27387, 29459, 31056, 31982, 32040, 31233,
			29224, 27342, 26662, 26956, 27912, 28999, 28965, 27826, 25579,
			25722, 24826, 24605, 24304, 23464, 23708 };
	private int[] numberarray2 = { 6, 10, 30, 110, 230, 360, 640, 1005, 1436,
			2063, 3057, 4618, 6444, 9822, 15468, 20434, 24126, 24600, 24300,
			23400, 23708, 2005, 10, 0, 0, 0, 10871, 10824, 10577, 10527 ,5893};

	public String execute() {
		return Action.SUCCESS;
	}

	public int[] getNumberarray1() {
		return numberarray1;
	}

	public void setNumberarray1(int[] numberarray1) {
		this.numberarray1 = numberarray1;
	}

	public int[] getNumberarray2() {
		return numberarray2;
	}

	public void setNumberarray2(int[] numberarray2) {
		this.numberarray2 = numberarray2;
	}

}
