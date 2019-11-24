package dataInOut;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

import common.PepupUtilities;

public class PropertiesReadWrite {

	private static String pass = "setting.properties";

	public static Properties ReadProperties () {

		Properties properties = new Properties();

		try {
			InputStream istream = new FileInputStream(pass);
			properties.load(istream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

	public static void WriteProperties(Properties wkProperties) {

		Properties properties = new Properties();
		FileWriter file = null;

		try {
			file = new FileWriter(pass);
			properties.setProperty("saveUserId", wkProperties.getProperty("saveUserId"));
			properties.setProperty("userId", wkProperties.getProperty("userId"));
			properties.setProperty("browserQuit", wkProperties.getProperty("browserQuit"));
			properties.setProperty("waitTime", wkProperties.getProperty("waitTime"));
			properties.setProperty("checkBoxSetting", wkProperties.getProperty("checkBoxSetting"));
			properties.store(file,"settings");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(file != null) {
				try {
					file.close();
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

	public static void WriteUserId(String userId) {
		PropertiesReadWrite.WriteKey("userId", userId);
	}

	public static void WriteCheckBoxSetting(boolean[] checkBoxSettingBools) {
		String checkBoxSetting = Arrays.toString(checkBoxSettingBools);
		PropertiesReadWrite.WriteKey("checkBoxSetting", checkBoxSetting);
	}

	public static void WriteKey(String key,String value) {

		Properties wkProperties = PropertiesReadWrite.ReadProperties();
		wkProperties.setProperty(key, value);
		PropertiesReadWrite.WriteProperties(wkProperties);

	}

	public static boolean[] ReadCheckBoxSetting() {
		String valueStr = PropertiesReadWrite.ReadKey("checkBoxSetting");
		boolean[] value = PepupUtilities.StringToBooleans(valueStr);
		return value;
	}

	public static String ReadKey(String key) {
		String value = PropertiesReadWrite.ReadProperties().getProperty(key);
		return value;
	}

}
