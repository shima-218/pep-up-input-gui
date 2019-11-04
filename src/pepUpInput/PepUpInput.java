package pepUpInput;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

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
		driver.findElement(By.xpath("//select[contains(@class,'ScskMileageHeader__DateSelectBox-cdl733-10 dOjJkS')]"))
		.sendKeys(inputYearMonth);

		//入力
		//歩数
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
		//各月追加機能
		if(inputOrNotArray[5]) {
			GekkanEventContent.getInstance().input(driver,actions);
		}

		/*つけるべき機能
		 * 　現在のものをver.1.0としてgit管理に置く
		 * 　　chromedriver立ち上がりっぱなしになるのをなんとかする
		 * 　①csvを読み込み、入力有無・数値を決められる機能
		 * 　②設定（ユーザーID保存、最後ブラウザ閉じるか否か）
		 * 　③exe化、配布
		 */

		//driver.quit();
	}
}
