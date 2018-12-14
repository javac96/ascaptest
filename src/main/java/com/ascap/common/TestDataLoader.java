package com.ascap.common;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class TestDataLoader {

	public String getTestData(String testDataSheet, String dataType) {
		String testData = null;
		JSONObject fullDataSheet = null;
		JSONParser parser = new JSONParser();
		String fileName = "src/main/resources-json/" + testDataSheet + ".json";
		try {
			fullDataSheet = (JSONObject) parser.parse(new FileReader(fileName));
			testData =   (String) fullDataSheet.get(dataType);
		} catch (Exception e) {
			throw new RuntimeException("Failed to read test data from " + fileName, e);
		}
		return testData;

	}
}
