package com.app.notification;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApplication extends Application {

	int appLength = 800;
	int appHeight = 600;
	Button submitButton;
	TextArea stringToParse;
	TextArea parsedString;

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		initUI(primaryStage);
	}

	public void initUI(Stage primaryStage) {
		primaryStage.setTitle("Butler Notification to JSON parser");

		stringToParse = new TextArea("Enter the JSON to parse here");

		submitButton = new Button("PARSE NOTIFICATION");
		submitButton.setOnAction(e -> parsedString.setText(ParsingEngine.parseInputString(stringToParse.getText())));

		parsedString = new TextArea("{\n\tThis is your parsed JSON\n}");
		parsedString.setPrefHeight(400);

		// Spacing is space between nodes inside layout
		VBox layout = new VBox(10);
		// Padding is space of layout from border
		layout.setPadding(new Insets(15));
		layout.setAlignment(Pos.CENTER);

		layout.getChildren().add(stringToParse);
		layout.getChildren().add(submitButton);
		layout.getChildren().add(parsedString);
		VBox.setMargin(submitButton, new Insets(10, 50, 10, 50));

		Scene scene = new Scene(layout, appLength, appHeight);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

}
