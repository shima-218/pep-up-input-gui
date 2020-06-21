package pepUpInput;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;

import common.*;

public abstract class Content {

	public void input(WebDriver driver,Actions actions,int number) {
		//該当のエリアがあるか判定
		String areaXpath =  Values.TAGPATH_CONTENTAREA_1 + number + Values.TAGPATH_CONTENTAREA_2;
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
				String dayXpath = Values.TAGPATH_DAYBUTTON_1 + number + Values.TAGPATH_DAYBUTTON_2 + weekloop
						+ Values.TAGPATH_DAYBUTTON_3 + dayloop + Values.TAGPATH_DAYBUTTON_4;
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
