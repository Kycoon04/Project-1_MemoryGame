package Controlador;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/*José Manuel Valverde Valverde*/

public class Main extends Application {
    private final Image icon = new Image(getClass().getResourceAsStream("/img/logo.png"));
    @Override
    public void start(Stage primaryStage) throws IOException {
      try {
          
                Parent root = FXMLLoader.load(getClass().getResource("/Vista/VistaJuego.fxml"));
                Scene scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.setResizable(false);
                primaryStage.getIcons().add(icon);
                primaryStage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}