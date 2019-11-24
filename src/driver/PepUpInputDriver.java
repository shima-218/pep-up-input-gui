package driver;

import pepUpInput.Option;
import pepUpInput.PepUpInput;

public class PepUpInputDriver {

	public static void main(String[]args) {
		Option option = new Option();
		option.setUserId("shima.island.218@gmail.com");
		option.setPassword("11dkk4wkr");
		option.setInputYearMonth("2019年11月");
		boolean[] inputOrNotArray = new boolean[6];
		inputOrNotArray[0] = false;
		inputOrNotArray[1] = false;
		inputOrNotArray[2] = true;
		inputOrNotArray[3] = false;
		inputOrNotArray[4] = false;
		inputOrNotArray[5] = false;
		option.setInputOrNotArray(inputOrNotArray);
		PepUpInput.AccessToInput(option);
	};

}
