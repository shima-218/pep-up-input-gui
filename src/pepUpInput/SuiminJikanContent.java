package pepUpInput;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;

import common.*;
import dataInOut.*;

public class SuiminJikanContent extends Content{

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
		//WebElement form = driver.findElement(By.xpath("//input[contains(@class,'ycydyz-5 bYPBDf')]"));
		WebElement form = driver.findElement(By.xpath("//div[@role='presentation']/div[3]/div[2]/form/input"));
		form.clear();
		form.sendKeys(PropertiesReadWrite.ReadProperties().getProperty("suiminJikan"));
	}

	//記録
	public void popUpClose(WebDriver driver) {
		//driver.findElement(By.xpath("//button[contains(@class,'ycydyz-12 eUifyF')]")).click();
		driver.findElement(By.xpath("//div[@role='presentation']/div[3]/div[2]/form/div/button")).click();
		//スリープをかけないと次のボタンが押せない
		try {
			Thread.sleep(Integer.parseInt(PropertiesReadWrite.ReadProperties().getProperty("waitTime")));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}