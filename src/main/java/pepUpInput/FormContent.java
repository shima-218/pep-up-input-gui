package pepUpInput;

import org.openqa.selenium.*;

import common.*;
import dataInOut.*;

public abstract class FormContent extends Content {

	@Override
	public abstract void dayInput(WebDriver driver);

	@Override
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
