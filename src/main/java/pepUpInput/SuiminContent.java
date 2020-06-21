package pepUpInput;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;

import common.*;

public class SuiminContent extends CheckboxContent{

	//singleton
	private static SuiminContent suiminContent = new SuiminContent();
	private SuiminContent() {};
	public static SuiminContent getInstance() {
		return suiminContent;
	};

	private final int number = Values.SUIMIN_NUMBER;

	public void input(WebDriver driver,Actions actions) {
		super.input(driver, actions, number);
	}

}