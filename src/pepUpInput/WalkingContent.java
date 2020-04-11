package pepUpInput;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;

import common.*;
import dataInOut.*;

public class WalkingContent extends Content {

	//singleton
	private static WalkingContent walkingContent = new WalkingContent();
	private WalkingContent() {};
	public static WalkingContent getInstance() {
		return walkingContent;
	};

	private final int number = Values.WALKING_NUMBER;

	public void input(WebDriver driver,Actions actions) {
		super.input(driver, actions, number);
	}

	//歩数入力
	public void dayInput(WebDriver driver) {
		WebElement form = driver.findElement(By.xpath(Values.TAGPATH_INPUT_FORM));
		form.clear();
		form.sendKeys(PropertiesReadWrite.ReadProperties().getProperty("walking"));
	}

	//記録
	public void popUpClose(WebDriver driver) {
		driver.findElement(By.xpath(Values.TAGPATH_CLOSE_FORM)).click();
		//スリープをかけないと次のボタンが押せない
		try {
			Thread.sleep(Integer.parseInt(PropertiesReadWrite.ReadProperties().getProperty("waitTime")));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
