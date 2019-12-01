package pepUpInput;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public abstract class Content {

	public void input(WebDriver driver,Actions actions,int number) {
		//該当のエリアがあるか判定
		String areaXpath = "//div[@id='app']/div/div[2]/div/div[2]/div/div[" + number + "]";
		WebElement area = null;
		try {
			area = driver.findElement(By.xpath(areaXpath));
		}catch(NoSuchElementException e) {
			return;
		}
		//週のループ
		for(int weekloop=1;weekloop<=6;weekloop++) {
			//日のループ
			for(int dayloop=1;dayloop<=7;dayloop++) {
				//クリックすべきエリアにスクロール
				if(weekloop==1&dayloop==1) {
					actions.moveToElement(area);
					actions.perform();
				}
				//クリックすべき日付を探す
				String dayXpath = "//div[@id='app']/div/div[2]/div/div[2]/div/div[" + number + "]/div[2]/div/div[2]/div[2]/div[" + weekloop + "]/div[" + dayloop +"]/button";
				WebElement btn = null;
				try {
					btn = driver.findElement(By.xpath(dayXpath));
				}catch (NoSuchElementException e){
					continue;
				}
				//日付クリック
				btn.click();
				//入力
				this.dayInput(driver);
				//閉じるクリック
				this.popUpClose(driver);
			};
		};
	};

	//日ごとの入力
	public abstract void dayInput(WebDriver driver);

	//閉じる
	public abstract void popUpClose(WebDriver driver);

}
