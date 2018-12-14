package com.ascap.common;

import java.util.HashMap;
//import gherkin.formatter.model.DataTableRow;

import cucumber.api.DataTable;

public class DataUtils {

	public static HashMap<String, String> getDataFromCucumberTable(DataTable table) {
		HashMap<String, String> dataMap;
		dataMap = new HashMap<String, String>();
		//for (DataTableRow row : table.getGherkinRows()) {
			//dataMap.put(row.getCells().get(0).toString().trim(), row.getCells().get(1).toString().trim());
		//}
		return dataMap;
	}
}
