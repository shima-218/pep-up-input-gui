package pepUpInput;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import common.Values;

public class SuiminContent extends Content{

	//singleton
	private static SuiminContent suiminContent = new SuiminContent();
	private SuiminContent() {};
	public static SuiminContent getInstance() {
		return suiminContent;
	};

	private final int number = Values.SUIMIN_NUMBER;

	public void input(WebDriver driver,Actions actions) {
		super.input(driver, actions, number);
	}

	//チェックボックスクリック
	public void dayInput(WebDriver driver) {
		//WebElement question = driver.findElement(By.xpath("//input[contains(@class,'ycydyz-8 eBsNfa')]"));
		WebElement question = driver.findElement(By.xpath("//div[@role='presentation']/div[3]/div[3]/div/label/input"));
		if(!question.isSelected()) {
			question.click();
		}
	}

	//閉じる
	public void popUpClose(WebDriver driver) {
		//driver.findElement(By.xpath("//button[contains(@class,'ycydyz-11 hgdJxW')]")).click();
		driver.findElement(By.xpath("//div[@role='presentation']/div[3]/div[3]/div[2]/button")).click();
	}

}
