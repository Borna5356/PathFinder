package view;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Maze;

public class MazeGUI extends Application {

    private static final Image square = new Image("file:images/square.png");
    private Maze maze;


    private Label makeLabel(String text) {
        Label label = new Label(text);
        return label;
    }

    private Button makeButton(GridPane gridpane, TextField row, TextField col) {
        Button button = new Button("Create Board");

        button.setOnAction((e) -> {
            String num_of_rows = row.getText();
            String num_of_cols = col.getText();
            int rows = Integer.parseInt(num_of_rows);
            int cols = Integer.parseInt(num_of_cols);
            for (int current_row = 2; current_row < rows + 2; current_row += 1) {
                for (int current_col = 0; current_col < cols; current_col += 1) {
                    ImageView view = new ImageView(square);
                    gridpane.add(view, current_col, current_row);
                }
            }
            maze = new Maze(rows, cols);
            
            
        });
        return button;
    }
    @Override
    public void start(Stage stage) throws Exception {
        GridPane gridPane = new GridPane();
        gridPane.add(makeLabel("Number of rows: "), 0, 0);
        TextField row = new TextField();
        gridPane.add(row, 1, 0);
        gridPane.add(makeLabel("\t"), 2, 0);
        gridPane.add(makeLabel("Number of columns: "), 3, 0);
        TextField col = new TextField();
        gridPane.add(col, 4, 0);
        Button button = makeButton(gridPane, row, col);
        gridPane.add(button, 2, 1);
        Scene scene = new Scene(gridPane);

        stage.setTitle("Maze");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }    
}
