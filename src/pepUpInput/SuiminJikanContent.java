package pepUpInput;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SuiminJikanContent extends Content{

	//singleton
	private static SuiminJikanContent suiminJikanContent = new SuiminJikanContent();
	private SuiminJikanContent() {};
	public static SuiminJikanContent getInstance() {
		return suiminJikanContent;
	};

	private final int number = 3;

	public void input(WebDriver driver,Actions actions) {
		super.input(driver, actions, number);
	}

	//睡眠時間入力
	public void dayInput(WebDriver driver) {
		WebElement form = driver.findElement(By.xpath("//input[contains(@class,'ScskMileageModalComponents__ScskMileageModalForm-ycydyz-5 fENdUQ')]"));
		form.clear();
		form.sendKeys("7");
	}

	//記録
	public void popUpClose(WebDriver driver) {
		driver.findElement(By.xpath("//button[contains(@class,'ScskMileageModalComponents__ScskMileageModalSubmitButton-ycydyz-12 gEBqNI')]")).click();
		//スリープをかけないとなぜか次のボタンが押せない
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}