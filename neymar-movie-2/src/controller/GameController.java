package controller;



import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameController {
	

	private static final int COLS = 10, ROWS = 10;
    private GridPane grid;

	
	private Pane makeGrid() {

        grid = new GridPane();
        for(int rowIndex = 0; rowIndex < ROWS ; rowIndex++) {
            //an array to hold buttons of one row
            Node[] nodes = new Node[COLS];
            for(int colIndex = 0; colIndex < COLS ; colIndex++) {
                Button node= new Button(rowIndex+""+colIndex);
                node.setOnAction(e->buttonCliked(node)); //add action listener
                nodes[colIndex]= node;
            }
            grid.addRow(rowIndex, nodes);
        }
        return grid;
    }
	
	private void buttonCliked(Button button) {

        System.out.println(button.getText());

    }



	public void start(Stage stage, Scene scene, AnchorPane root) {
		root.getChildren().add(makeGrid());
		
	}
	
}
