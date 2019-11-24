package application;

import java.net.URL;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

import common.Values;
import dataInOut.PropertiesReadWrite;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pepUpInput.Option;
import pepUpInput.PepUpInput;

public class FormController implements Initializable{

	@FXML
	private Text userIdText;

	@FXML
	private Text passwordText;

	@FXML
	private Text inputYearMonthText;

	@FXML
	private TextField userIdBox;

	@FXML
	private PasswordField passwordBox;

	@FXML
	private ChoiceBox<String> inputYearMonthBox;

	@FXML
	private Button inputSettingButton;

	@FXML
	private Button executeButton;

	@FXML
	private Button settingButton;

	@FXML
	private Text inputContentsText;

	@FXML
	private CheckBox walking;

	@FXML
	private CheckBox suiminJikan;

	@FXML
	private CheckBox suimin;

	@FXML
	private CheckBox alcohol;

	@FXML
	private CheckBox shokuseikatsu;

	@FXML
	private CheckBox gekkanEvent;

	@FXML
	private Text warning;

	//初期処理
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//現在の年月を取得
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		//前月の年月を取得
		int yearOfLastMonth = year;
		int LastMonth = month - 1;
		if(month==1) {
			yearOfLastMonth = year - 1;
			LastMonth = 12;
		}
		//月間イベント発生月の設定
		Integer[] array = {6,9,11,2};
		List<Integer> gekkanEventMonths = Arrays.asList(array);

		//ユーザーIDの初期値を設定
		userIdBox.setText(PropertiesReadWrite.ReadProperties().getProperty("userId"));

		//入力年月の候補値を設定
		inputYearMonthBox.getItems().add(year+"年"+month+"月");
		inputYearMonthBox.getItems().add(yearOfLastMonth+"年"+LastMonth+"月");
		inputYearMonthBox.setValue(year+"年"+month+"月");

		//チェックボックスの初期値を設定
		boolean[] checkBoxSetting = PropertiesReadWrite.ReadCheckBoxSetting();
		walking.setSelected(checkBoxSetting[0]);
		suiminJikan.setSelected(checkBoxSetting[1]);
		suimin.setSelected(checkBoxSetting[2]);
		alcohol.setSelected(checkBoxSetting[3]);
		shokuseikatsu.setSelected(checkBoxSetting[4]);
		if(gekkanEventMonths.contains(month)) {
			gekkanEvent.setSelected(checkBoxSetting[5]);
		}
	}

	//ボタン押下時
	@FXML
	public void inputSetting() {
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load((getClass().getResource("InputSetting.fxml")));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage stage = new Stage();
			stage.setTitle(Values.APP_TITLE);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.showAndWait();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void execute(){
		//入力チェック
		if(userIdBox.getText().equals("")|passwordBox.getText().equals("")|inputYearMonthBox.getValue().equals("")) {
			warning.setText("未入力の項目があります");
			return;
		}
		if(!(walking.isSelected()|suiminJikan.isSelected()|suimin.isSelected()
				|alcohol.isSelected()|shokuseikatsu.isSelected()|gekkanEvent.isSelected())) {
			warning.setText("1つ以上の入力項目を選択してください");
			return;
		}
		warning.setText("");

		//IFの準備
		Option option = new Option();
		option.setUserId(userIdBox.getText());
		option.setPassword(passwordBox.getText());
		option.setInputYearMonth(inputYearMonthBox.getValue());
		boolean[] inputOrNotArray = new boolean[6];
		inputOrNotArray[0] = walking.isSelected();
		inputOrNotArray[1] = suiminJikan.isSelected();
		inputOrNotArray[2] = suimin.isSelected();
		inputOrNotArray[3] = alcohol.isSelected();
		inputOrNotArray[4] = shokuseikatsu.isSelected();
		inputOrNotArray[5] = gekkanEvent.isSelected();
		option.setInputOrNotArray(inputOrNotArray);

		//ユーザーIDを保存
		if(Boolean.valueOf(PropertiesReadWrite.ReadProperties().getProperty("saveUserId"))) {
			PropertiesReadWrite.WriteUserId(userIdBox.getText());
		}else {
			PropertiesReadWrite.WriteUserId("");
		}
		//チェックボックスの状態を保存
		PropertiesReadWrite.WriteCheckBoxSetting(inputOrNotArray);

		//PepUpInputクラスに処理を渡す
		PepUpInput.AccessToInput(option);
	}

	@FXML
	public void setting() {
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load((getClass().getResource("Setting.fxml")));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage stage = new Stage();
			stage.setTitle("設定");
			stage.setScene(scene);
			stage.setResizable(false);
			stage.showAndWait();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public Text getUserIdText() {
		return userIdText;
	}

	public void setUserIdText(Text userIdText) {
		this.userIdText = userIdText;
	}

	public Text getPasswordText() {
		return passwordText;
	}

	public void setPasswordText(Text passwordText) {
		this.passwordText = passwordText;
	}

	public Text getInputYearMonthText() {
		return inputYearMonthText;
	}

	public void setInputYearMonthText(Text inputYearMonthText) {
		this.inputYearMonthText = inputYearMonthText;
	}

	public TextField getUserIdBox() {
		return userIdBox;
	}

	public void setUserIdBox(TextField userIdBox) {
		this.userIdBox = userIdBox;
	}

	public PasswordField getPasswordBox() {
		return passwordBox;
	}

	public void setPasswordBox(PasswordField passwordBox) {
		this.passwordBox = passwordBox;
	}

	public ChoiceBox<String> getInputYearMonthBox() {
		return inputYearMonthBox;
	}

	public void setInputYearMonthBox(ChoiceBox<String> inputYearMonthBox) {
		this.inputYearMonthBox = inputYearMonthBox;
	}

	public Button getInputSettingButton() {
		return inputSettingButton;
	}

	public void setInputSettingButton(Button inputSettingButton) {
		this.inputSettingButton = inputSettingButton;
	}

	public Button getExecuteButton() {
		return executeButton;
	}

	public void setExecuteButton(Button executeButton) {
		this.executeButton = executeButton;
	}

	public Button getSettingButton() {
		return settingButton;
	}

	public void setSettingButton(Button settingButton) {
		this.settingButton = settingButton;
	}

	public Text getInputContentsText() {
		return inputContentsText;
	}

	public void setInputContentsText(Text inputContentsText) {
		this.inputContentsText = inputContentsText;
	}

	public CheckBox getWalking() {
		return walking;
	}

	public void setWalking(CheckBox walking) {
		this.walking = walking;
	}

	public CheckBox getSuiminJikan() {
		return suiminJikan;
	}

	public void setSuiminJikan(CheckBox suiminJikan) {
		this.suiminJikan = suiminJikan;
	}

	public CheckBox getSuimin() {
		return suimin;
	}

	public void setSuimin(CheckBox suimin) {
		this.suimin = suimin;
	}

	public CheckBox getAlcohol() {
		return alcohol;
	}

	public void setAlcohol(CheckBox alcohol) {
		this.alcohol = alcohol;
	}

	public CheckBox getShokuseikatsu() {
		return shokuseikatsu;
	}

	public void setShokuseikatsu(CheckBox shokuseikatsu) {
		this.shokuseikatsu = shokuseikatsu;
	}

	public CheckBox getGekkanEvent() {
		return gekkanEvent;
	}

	public void setGekkanEvent(CheckBox gekkanEvent) {
		this.gekkanEvent = gekkanEvent;
	}

	public Text getWarning() {
		return warning;
	}

	public void setWarning(Text warning) {
		this.warning = warning;
	}

}
