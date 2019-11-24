package pepUpInput;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import dataInOut.PropertiesReadWrite;

public class WalkingContent extends Content {

	//singleton
	private static WalkingContent walkingContent = new WalkingContent();
	private WalkingContent() {};
	public static WalkingContent getInstance() {
		return walkingContent;
	};

	private final int number = 2;

	public void input(WebDriver driver,Actions actions) {
		super.input(driver, actions, number);
	}

	//歩数入力
	public void dayInput(WebDriver driver) {
		WebElement form = driver.findElement(By.xpath("//input[contains(@class,'ScskMileageModalComponents__ScskMileageModalForm-ycydyz-5 fENdUQ')]"));
		form.clear();
		form.sendKeys("8000");
	}

	//記録
	public void popUpClose(WebDriver driver) {
		driver.findElement(By.xpath("//button[contains(@class,'ScskMileageModalComponents__ScskMileageModalSubmitButton-ycydyz-12 gEBqNI')]")).click();
		//スリープをかけないと次のボタンが押せない
		try {
			Thread.sleep(Integer.parseInt(PropertiesReadWrite.ReadProperties().getProperty("waitTime")));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
