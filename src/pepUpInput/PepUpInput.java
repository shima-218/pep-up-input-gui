package pepUpInput;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import dataInOut.PropertiesReadWrite;

public class PepUpInput {

	public static void AccessToInput(Option option) {

		//変数の設定
		String userId = option.getUserId();
		String password = option.getPassword();
		String inputYearMonth = option.getInputYearMonth();
		boolean[] inputOrNotArray = option.getInputOrNotArray();

		// WebDriverの設定
		System.setProperty("webdriver.chrome.driver",
				".\\exe\\chromedriver.exe");

		try {
			WebDriver driver = new ChromeDriver();
			driver.manage().window().setSize(new Dimension(1250, 768));
			//スクロール用のインスタンス生成
			Actions actions = new Actions(driver);

			//ウェブぺージを開く
			driver.get("https://pepup.life/users/sign_in");

			//ログイン
			WebElement userIdBox = driver.findElement(By.id("sender-email"));
			userIdBox.sendKeys(userId);
			WebElement passwordBox = driver.findElement(By.id("user-pass"));
			passwordBox.sendKeys(password);
			WebElement loginButton = driver.findElement(By.name("commit"));
			loginButton.sendKeys(Keys.ENTER);

			//わくわくマイル選択
			driver.findElement(By.partialLinkText("わくわくマイレージ")).click();
			driver.findElement(By.partialLinkText("わくわくマイレージの入力はこちら")).click();

			//月選択
			//driver.findElement(By.xpath("//select[contains(@class,'cdl733-10 bGLZj')]"))
			//.sendKeys(inputYearMonth);
			driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div/div[2]/div/div/div[3]/select"))
			.sendKeys(inputYearMonth);

			//入力
			//歩数
			if(inputOrNotArray[0]) {
				WalkingContent.getInstance().input(driver,actions);
			}
			//睡眠時間
			if(inputOrNotArray[1]) {
				SuiminJikanContent.getInstance().input(driver,actions);
			}
			//睡眠
			if(inputOrNotArray[2]) {
				SuiminContent.getInstance().input(driver,actions);
			}
			//アルコール
			if(inputOrNotArray[3]) {
				AlcoholContent.getInstance().input(driver,actions);
			}
			//食生活
			if(inputOrNotArray[4]) {
				ShokuseikatsuContent.getInstance().input(driver,actions);
			}
			//月間イベント
			if(inputOrNotArray[5]) {
				GekkanEventContent.getInstance().input(driver,actions);
			}

			//ブラウザを閉じる
			if(Boolean.valueOf(PropertiesReadWrite.ReadProperties().getProperty("browserQuit"))) {
				driver.close();
			}

		}finally {
			//ドライバーを閉じる
			Runtime rt = Runtime.getRuntime();
			try {
				rt.exec("taskkill /im chromedriver.exe /f");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
