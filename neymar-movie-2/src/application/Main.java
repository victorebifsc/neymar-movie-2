package application;
	
import controller.ViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//loader fxml
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/View.fxml"));
			Parent fxmlArchive = loader.load();
			
			//set css
			fxmlArchive.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
			
			//set fxml to scene
			Scene scene = new Scene(fxmlArchive);
			
			//stage configs
			primaryStage.setTitle("Neymar Games");
			primaryStage.resizableProperty().setValue(Boolean.FALSE);
			primaryStage.setScene(scene);
			
			//controller
			ViewController viewController = loader.getController();
			
			//set close request
			primaryStage.setOnCloseRequest(e->{
				if (viewController.onCloseQuery()) {
					System.exit(0);
				} else {
					e.consume();
				}
			});
			
			//show window
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
