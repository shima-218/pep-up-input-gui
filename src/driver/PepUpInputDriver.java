package driver;

import pepUpInput.Option;
import pepUpInput.PepUpInput;

public class PepUpInputDriver {

	public static void main(String[]args) {
		Option option = new Option();
		option.setUserId("");
		option.setPassword("");
		option.setInputYearMonth("2019年10月");
		PepUpInput.AccessToInput(option);
	};

}
