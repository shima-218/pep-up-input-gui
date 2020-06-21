package pepUpInput;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;

import common.*;

public class GekkanEventContent extends CheckboxContent{

	//singleton
	private static GekkanEventContent gekkanEventContent = new GekkanEventContent();
	private GekkanEventContent() {};
	public static GekkanEventContent getInstance() {
		return gekkanEventContent;
	};

	private final int number = Values.GEKKANEVENT_NUMBER;

	public void input(WebDriver driver,Actions actions) {
		super.input(driver, actions, number);
	}

}