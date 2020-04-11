package application;

import java.net.*;
import java.util.*;

import dataInOut.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.text.*;

public class SettingController implements Initializable{

	@FXML
	private Text saveUserIdText;

	@FXML
	private CheckBox saveUserId;

	@FXML
	private Text browserQuitText;

	@FXML
	private CheckBox browserQuit;

	@FXML
	private Text waitTimeText;

	@FXML
	private TextField waitTimeBox;

	@FXML
	private Text waitTimeUnitText;

	@FXML
	private Text suiminJikanText;

	@FXML
	private TextField suiminJikanBox;

	@FXML
	private Text suiminJikanUnitText;

	@FXML
	private Text warning;

	@FXML
	private Button saveButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//初期表示
		Properties properties = PropertiesReadWrite.ReadProperties();
		if(Boolean.valueOf(properties.getProperty("saveUserId"))) {
			saveUserId.setSelected(true);
		}
		if(Boolean.valueOf(properties.getProperty("browserQuit"))) {
			browserQuit.setSelected(true);
		}
		waitTimeBox.setText(properties.getProperty("waitTime"));
		suiminJikanBox.setText(properties.getProperty("suiminJikan"));
	}

	public void save() {
		//入力値チェック
		if("".equals(waitTimeBox.getText())||"".equals(suiminJikanBox.getText())) {
			warning.setText("入力必須項目が未入力です");
			return;
		}
		//保存
		Properties properties = PropertiesReadWrite.ReadProperties();
		properties.setProperty("saveUserId", String.valueOf(saveUserId.isSelected()));
		properties.setProperty("browserQuit", String.valueOf(browserQuit.isSelected()));
		properties.setProperty("waitTime", waitTimeBox.getText());
		properties.setProperty("suiminJikan", suiminJikanBox.getText());
		PropertiesReadWrite.WriteProperties(properties);
		//閉じる
		 saveButton.getScene().getWindow().hide();
	}

	public Text getSaveUserIdText() {
		return saveUserIdText;
	}

	public void setSaveUserIdText(Text saveUserIdText) {
		this.saveUserIdText = saveUserIdText;
	}

	public CheckBox getSaveUserId() {
		return saveUserId;
	}

	public void setSaveUserId(CheckBox saveUserId) {
		this.saveUserId = saveUserId;
	}

	public Text getBrowserQuitText() {
		return browserQuitText;
	}

	public void setBrowserQuitText(Text browserQuitText) {
		this.browserQuitText = browserQuitText;
	}

	public CheckBox getBrowserQuit() {
		return browserQuit;
	}

	public void setBrowserQuit(CheckBox browserQuit) {
		this.browserQuit = browserQuit;
	}

	public Text getWaitTimeText() {
		return waitTimeText;
	}

	public void setWaitTimeText(Text waitTimeText) {
		this.waitTimeText = waitTimeText;
	}

	public TextField getWaitTimeBox() {
		return waitTimeBox;
	}

	public void setWaitTimeBox(TextField waitTimeBox) {
		this.waitTimeBox = waitTimeBox;
	}

	public Text getWaitTimeUnitText() {
		return waitTimeUnitText;
	}

	public void setWaitTimeUnitText(Text waitTimeUnitText) {
		this.waitTimeUnitText = waitTimeUnitText;
	}

	public Button getSaveButton() {
		return saveButton;
	}

	public void setSaveButton(Button saveButton) {
		this.saveButton = saveButton;
	}

	public Text getWarning() {
		return warning;
	}

	public void setWarning(Text warning) {
		this.warning = warning;
	}

}

