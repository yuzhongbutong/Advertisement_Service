package com.personal.ad.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GeneralOperation {
	private static Properties properties = new Properties();

	static {
		InputStream in = DataBaseConnection.class
				.getResourceAsStream(FinalConstant.DB_FILE);
		try {
			properties.load(in);
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getProperties(String key) {
		return properties.getProperty(key);
	}
}
