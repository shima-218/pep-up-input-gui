package pepUpInput;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;

import common.*;

public class AlcoholContent extends CheckboxContent{

	//singleton
	private static AlcoholContent alcoholContent = new AlcoholContent();
	private AlcoholContent() {};
	public static AlcoholContent getInstance() {
		return alcoholContent;
	};

	private final int number = Values.ALCOHOL_NUMBER;

	public void input(WebDriver driver,Actions actions) {
		super.input(driver, actions, number);
	}

}