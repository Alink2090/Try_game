package type_0.game_0;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class acceuil extends Application {
    private static Scene scene_try;
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(acceuil.class.getResource("acceuil.fxml"));
        scene_try = new Scene( fxmlLoader.load() );
        stage.setTitle("Xenia");
        stage.setScene(scene_try);
        stage.show();
        stage.setResizable(false);
    }
    public static void setRacine(String fxml) throws Exception {
        scene_try.setRoot(loadFxml(fxml));
    }
    public static Parent loadFxml(String fxml) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(acceuil.class.getResource(fxml));
        return fxmlLoader.load();
    }
    public static void main(String[] args) {
        launch();
    }
}
