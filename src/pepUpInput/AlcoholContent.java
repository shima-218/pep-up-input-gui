package pepUpInput;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AlcoholContent extends Content{

	//singleton
	private static AlcoholContent alcoholContent = new AlcoholContent();
	private AlcoholContent() {};
	public static AlcoholContent getInstance() {
		return alcoholContent;
	};

	private final int number = 5;

	public void input(WebDriver driver,Actions actions) {
		super.input(driver, actions, number);
	}

	//チェックボックスクリック
	public void dayInput(WebDriver driver) {
		WebElement question = driver.findElement(By.xpath("//input[contains(@class,'ScskMileageModalComponents__ScskMileageModalCheckBox-ycydyz-8 bwykYp')]"));
		if(!question.isSelected()) {
			question.click();
		}
	}

	//閉じる
	public void popUpClose(WebDriver driver) {
		driver.findElement(By.xpath("//button[contains(@class,'ScskMileageModalComponents__ScskMileageActFactModalCloseButton-ycydyz-11 MdANq')]")).click();
	}

}