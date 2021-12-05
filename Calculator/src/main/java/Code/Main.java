package Code;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
	//
	private static Stage stage; // so that it can be updated from any where
	private int width = 325;
	private int length = 600;

	// String styleSheet;

	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			Parent root = FXMLLoader.load(getClass().getResource("/Scenes/BasicCalPage.fxml"));
			Scene scene = new Scene(root, width, length);
			// styleSheet =
			// this.getClass().getResource("/StyleSheets/StyleSheet.css").toExternalForm();
			// scene.getStylesheets().add(styleSheet);
			stage = primaryStage;
			primaryStage.setResizable(false);
			primaryStage.setTitle("Calculator");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e)
		{
			System.out.println("Exception " + e);
		}
	}

	public void changeScene(String newScene) throws Exception
	{
		Parent pane = FXMLLoader.load(getClass().getResource(newScene));
		stage.getScene().setRoot(pane);
	}

	public static void main(String args[])
	{
		launch(args);
	}
}
