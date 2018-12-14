package com.ascap.maps;

import java.util.HashMap;
import java.util.Map;

public class DataMaps {

	public static final Map<String, String> url = new HashMap<>();
	public static final Map<String, String> errorMessages = new HashMap<>();
	public static final Map<String, String> messages = new HashMap<>();
	public static final Map<String, String> outputmap = new HashMap<>();

	static {
		url.put("QA", "https://Marketing:M@rketing155@qa.ascap.com/");
		url.put("DEV", "https://dev.ascap.com");
	}
	
	static {
		//outputmap.put("currentScenario", "scenario");
	}


	static {
		errorMessages.put("invalidError", "errormessages");
		errorMessages.put("invalidEmailError", "Please enter a valid email address");
	}

	static {
		messages.put("updateMessage", "Your info is updated successfully");
		messages.put("", "");
	}

}
