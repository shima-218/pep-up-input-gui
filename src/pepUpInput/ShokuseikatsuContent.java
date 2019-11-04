package pepUpInput;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ShokuseikatsuContent extends Content{

	//singleton
	private static ShokuseikatsuContent shokuseikatsuContent = new ShokuseikatsuContent();
	private ShokuseikatsuContent() {};
	public static ShokuseikatsuContent getInstance() {
		return shokuseikatsuContent;
	};

	private final int number = 6;

	public void input(WebDriver driver,Actions actions) {
		super.input(driver, actions, number);
	}

	//チェックボックスクリック
	//TODO 質問項目が５つ
	public void dayInput(WebDriver driver) {
		List<WebElement> questions = driver.findElements(By.xpath("//input[contains(@class,'ScskMileageModalComponents__ScskMileageModalCheckBox-ycydyz-8 bwykYp')]"));
		for(int questionNumber=0;questionNumber<=4;questionNumber++) {
			if(!questions.get(questionNumber).isSelected()) {
				questions.get(questionNumber).click();
			}
		}
	}

	//閉じる
	public void popUpClose(WebDriver driver) {
		driver.findElement(By.xpath("//button[contains(@class,'ScskMileageModalComponents__ScskMileageActFactModalCloseButton-ycydyz-11 MdANq')]")).click();
	}

}