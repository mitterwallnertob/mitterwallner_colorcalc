import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/*******************************
 * @author: Tobias Mitterwallner
 * @date: 26.01.2021
 * @version: 1.0
 * @class: Main.java
 ******************************/

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("controllerview/sample.fxml"));
        primaryStage.setTitle("12 - Color Calculator");
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("/res/icon.jpg"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        //launches the JavaFX Application
        launch(args);
    }
}
