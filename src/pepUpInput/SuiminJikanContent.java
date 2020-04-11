package pepUpInput;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;

import common.*;
import dataInOut.*;

public class SuiminJikanContent extends FormContent{

	//singleton
	private static SuiminJikanContent suiminJikanContent = new SuiminJikanContent();
	private SuiminJikanContent() {};
	public static SuiminJikanContent getInstance() {
		return suiminJikanContent;
	};

	private final int number = Values.SUIMINJIKAN_NUMBER;

	public void input(WebDriver driver,Actions actions) {
		super.input(driver, actions, number);
	}

	//睡眠時間入力
	public void dayInput(WebDriver driver) {
		WebElement form = driver.findElement(By.xpath(Values.TAGPATH_INPUT_FORM));
		form.clear();
		form.sendKeys(PropertiesReadWrite.ReadProperties().getProperty("suiminJikan"));
	}

}