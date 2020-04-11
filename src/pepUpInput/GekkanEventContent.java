package pepUpInput;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;

import common.*;

public class GekkanEventContent extends Content{

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

	//チェックボックスクリック
	public void dayInput(WebDriver driver) {
		WebElement question = driver.findElement(By.xpath(Values.TAGPATH_INPUT_CHECKBOX));
		if(!question.isSelected()) {
			question.click();
		}
	}

	//閉じる
	public void popUpClose(WebDriver driver) {
		driver.findElement(By.xpath(Values.TAGPATH_CLOSE_CHECKBOX)).click();
	}

}
