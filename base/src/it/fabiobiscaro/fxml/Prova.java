package it.fabiobiscaro.fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Prova extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent root;
		
		root = FXMLLoader.load(getClass().getResource("Finestra.fxml"));
		
		Scene scene = new Scene(root);
		Stage stage = primaryStage;
		primaryStage.setTitle("ciao");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
