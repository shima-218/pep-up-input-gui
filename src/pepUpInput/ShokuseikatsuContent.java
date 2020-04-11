package pepUpInput;

import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;

import common.*;

public class ShokuseikatsuContent extends Content{

	//singleton
	private static ShokuseikatsuContent shokuseikatsuContent = new ShokuseikatsuContent();
	private ShokuseikatsuContent() {};
	public static ShokuseikatsuContent getInstance() {
		return shokuseikatsuContent;
	};

	private final int number = Values.SHOKUSEIKATSU_NUMBER;

	public void input(WebDriver driver,Actions actions) {
		super.input(driver, actions, number);
	}

	//チェックボックスクリック
	public void dayInput(WebDriver driver) {
		//List<WebElement> questions = driver.findElements(By.xpath("//input[contains(@class,'ycydyz-8 eBsNfa')]"));
		List<WebElement> questions = driver.findElements(By.xpath("//div[@role='presentation']/div[3]/div[3]/div/label/input"));
		for(int questionNumber=0;questionNumber<=4;questionNumber++) {
			if(!questions.get(questionNumber).isSelected()) {
				questions.get(questionNumber).click();
			}
		}
	}

	//閉じる
	public void popUpClose(WebDriver driver) {
		//driver.findElement(By.xpath("//button[contains(@class,'ycydyz-11 hgdJxW')]")).click();
		driver.findElement(By.xpath("//div[@role='presentation']/div[3]/div[3]/div[6]/button")).click();
	}

}