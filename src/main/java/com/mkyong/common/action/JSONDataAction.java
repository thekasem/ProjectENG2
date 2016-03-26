package com.mkyong.common.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Action;

public class JSONDataAction {

	private String string1 = "A";
	private String[] stringarray1 = { "A1", "B1" };
	private int number1 = 123456789;
	private int[] numberarray1 = { 0, 24357, 12144, 0, 0, 6, 11, 32, 110, 235, 369,
			640, 1005, 1436, 2063, 3057, 4618, 6444, 9822, 15468, 20434, 24126,
			27387, 29459, 31056, 31982, 32040, 31233, 29224, 27342, 26662,
			26956, 27912, 28999, 28965, 27826, 25579, 25722, 24826, 24605,
			24304, 23464, 23708, 24099, 24357, 10000, 24401, 24344, 23586,
			22380, 21004, 17287, 14747, 13076, 12555, 12144, 11009, 10950,
			10871, 10824, 10577, 10527 };
	private List<String> lists = new ArrayList<String>();
	private Map<String, String> maps = new HashMap<String, String>();

	// no getter method, will not include in the JSON
	private String string2 = "B";

	public JSONDataAction() {
		lists.add("list1");
		lists.add("list2");
		lists.add("list3");
		lists.add("list4");
		lists.add("list5");

		maps.put("key1", "value1");
		maps.put("key2", "value2");
		maps.put("key3", "value3");
		maps.put("key4", "value4");
		maps.put("key5", "value5");
	}

	public String execute() {
		return Action.SUCCESS;
	}

	public String getString1() {
		return string1;
	}

	public void setString1(String string1) {
		this.string1 = string1;
	}

	public String[] getStringarray1() {
		return stringarray1;
	}

	public void setStringarray1(String[] stringarray1) {
		this.stringarray1 = stringarray1;
	}

	public int getNumber1() {
		return number1;
	}

	public void setNumber1(int number1) {
		this.number1 = number1;
	}

	public int[] getNumberarray1() {
		return numberarray1;
	}

	public void setNumberarray1(int[] numberarray1) {
		this.numberarray1 = numberarray1;
	}

	public List<String> getLists() {
		return lists;
	}

	public void setLists(List<String> lists) {
		this.lists = lists;
	}

	public Map<String, String> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, String> maps) {
		this.maps = maps;
	}

}