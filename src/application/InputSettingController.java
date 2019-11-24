package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class InputSettingController implements Initializable{

	@FXML
	private Text qstSuiminJikan;

	@FXML
	private Text qstSuimin;

	@FXML
	private Text qstAlcohol;

	@FXML
	private Text qstShokuseikatsu1;

	@FXML
	private Text qstShokuseikatsu2;

	@FXML
	private Text qstShokuseikatsu3;

	@FXML
	private Text qstShokuseikatsu4;

	@FXML
	private Text qstShokuseikatsu5;

	@FXML
	private Text qstGekkanEvent;

	@FXML
	private Button saveButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	//ボタン押下時
	public void save() {
		//保存しましたとメッセージ表示
	}

	public Text getQstSuiminJikan() {
		return qstSuiminJikan;
	}

	public void setQstSuiminJikan(Text qstSuiminJikan) {
		this.qstSuiminJikan = qstSuiminJikan;
	}

	public Text getQstSuimin() {
		return qstSuimin;
	}

	public void setQstSuimin(Text qstSuimin) {
		this.qstSuimin = qstSuimin;
	}

	public Text getQstAlcohol() {
		return qstAlcohol;
	}

	public void setQstAlcohol(Text qstAlcohol) {
		this.qstAlcohol = qstAlcohol;
	}

	public Text getQstShokuseikatsu1() {
		return qstShokuseikatsu1;
	}

	public void setQstShokuseikatsu1(Text qstShokuseikatsu1) {
		this.qstShokuseikatsu1 = qstShokuseikatsu1;
	}

	public Text getQstShokuseikatsu2() {
		return qstShokuseikatsu2;
	}

	public void setQstShokuseikatsu2(Text qstShokuseikatsu2) {
		this.qstShokuseikatsu2 = qstShokuseikatsu2;
	}

	public Text getQstShokuseikatsu3() {
		return qstShokuseikatsu3;
	}

	public void setQstShokuseikatsu3(Text qstShokuseikatsu3) {
		this.qstShokuseikatsu3 = qstShokuseikatsu3;
	}

	public Text getQstShokuseikatsu4() {
		return qstShokuseikatsu4;
	}

	public void setQstShokuseikatsu4(Text qstShokuseikatsu4) {
		this.qstShokuseikatsu4 = qstShokuseikatsu4;
	}

	public Text getQstShokuseikatsu5() {
		return qstShokuseikatsu5;
	}

	public void setQstShokuseikatsu5(Text qstShokuseikatsu5) {
		this.qstShokuseikatsu5 = qstShokuseikatsu5;
	}

	public Text getQstGekkanEvent() {
		return qstGekkanEvent;
	}

	public void setQstGekkanEvent(Text qstGekkanEvent) {
		this.qstGekkanEvent = qstGekkanEvent;
	}

	public Button getSaveButton() {
		return saveButton;
	}

	public void setSaveButton(Button saveButton) {
		this.saveButton = saveButton;
	}

}
