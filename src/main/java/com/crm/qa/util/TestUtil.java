package com.crm.qa.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
public class TestUtil {
	
	
	public static final String TESTDATA_FOLDER_PATH = "C:\\SeleniumSession\\PageObjectModel-master\\src\\main\\resources\\testdata\\";
	//Method to read test data for test case.
	/**
	 * 
	 * @param filePath : json file name e.g TestSerachProduct.json
	 * @param elementName : node inside json file e.g testAddProductToWishList
	 * @return
	 */
	
	public static Map<String,String> getTestData(String filePath, String elementName) {
		JsonElement root = null;
		try {
			root = new JsonParser().parse(new FileReader(TESTDATA_FOLDER_PATH+filePath));
		} catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JsonObject jsonObject = root.getAsJsonObject();
		JsonElement some = jsonObject.get(elementName);
		JsonObject testData = some.getAsJsonObject();
		Map<String, String> testDataMap = new LinkedHashMap<String, String>();
		for (Map.Entry<String, JsonElement> entry : testData.entrySet()) {
			testDataMap.put(entry.getKey().toString(), entry.getValue().getAsString());
		}
		return testDataMap;
	}
	
	public void getTestDataFromExcel() {
		
	}
	
}
