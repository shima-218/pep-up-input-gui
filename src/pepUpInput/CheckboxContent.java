package pepUpInput;

import org.openqa.selenium.*;

import common.*;

public abstract class CheckboxContent extends Content {

	@Override
	public void dayInput(WebDriver driver) {
		WebElement question = driver.findElement(By.xpath(Values.TAGPATH_INPUT_CHECKBOX));
		if(!question.isSelected()) {
			question.click();
		}
	}

	@Override
	public void popUpClose(WebDriver driver) {
		driver.findElement(By.xpath(Values.TAGPATH_CLOSE_CHECKBOX)).click();
	}

}
