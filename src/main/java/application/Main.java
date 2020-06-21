package application;

import common.Values;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Form.fxml"));
			primaryStage.setTitle(Values.APP_TITLE);
			Scene scene = new Scene(root);

			//画像の設定
			Image image = new Image("application/haguruma.png");
	        ImageView imageView = new ImageView(image);
	        imageView.setImage(image);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	//public static void main(String[] args) {
	//	launch(args);
	//}
}
