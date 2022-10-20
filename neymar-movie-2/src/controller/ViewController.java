package controller;

import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewController {
	

	public void clickGame(ActionEvent event) throws IOException {
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Game.fxml"));
		AnchorPane root = (AnchorPane) loader.load();
		GameController controller = (GameController)loader.getController();
		
		Scene scene = new Scene(root);
		controller.start(stage, scene, root);
		stage.setScene(scene);
		
		stage.show();
	}

    

    
    
    
    
    
	//close query
    public boolean onCloseQuery() {
    	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    	alert.setTitle("Deseja mesmo sair?");
    	ButtonType btnNo = ButtonType.NO;
    	ButtonType btnYes = ButtonType.YES;
    	
    	alert.getButtonTypes().setAll(btnYes, btnNo);
    	Optional<ButtonType> optionSelected = alert.showAndWait();
    	
    	return optionSelected.get() == btnYes ? true : false;
    }
}
