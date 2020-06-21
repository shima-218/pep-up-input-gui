package driver;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import inputData.InputValues;
import inputData.InputValuesReadWrite;
import pepUpInput.Option;
import pepUpInput.PepUpInput;

public class PepUpInputDriver {

	public static void main(String[]args) {
		//drivePepUpInput();
		readwriteXML();
	};


	public static void drivePepUpInput() {
		Option option = new Option();
		option.setUserId("");
		option.setPassword("");
		option.setInputYearMonth("2020年6月");
		boolean[] inputOrNotArray = new boolean[6];
		inputOrNotArray[0] = false;
		inputOrNotArray[1] = false;
		inputOrNotArray[2] = true;
		inputOrNotArray[3] = false;
		inputOrNotArray[4] = false;
		inputOrNotArray[5] = false;
		option.setInputOrNotArray(inputOrNotArray);
		PepUpInput.AccessToInput(option);
	}

	public static void readwriteXML() {

		try {
			InputValues iv = InputValuesReadWrite.readInputValuesFile();
			InputValuesReadWrite.writeInputValuesFile(iv);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
