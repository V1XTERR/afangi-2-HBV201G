package is.vidmot;

import is.vidmot.switcher.ViewSwitcher;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Aðalklasi kvikmyndahúskerfisin. Ræsir JavaFX forritið.
 */
public class KvikmyndahusApp extends Application {

    /**
     * Ræsir aðalglugga forritsins.
     * @param stage aðalglugginn
     * @throws IOException ef FXML skrá finnst ekki
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/is/vidmot/adal-view.fxml"));
        Pane root = loader.load();
        ViewSwitcher.setRoot(root);
        Scene scene = new Scene(root, 750, 550);
        scene.getStylesheets().add(getClass().getResource("/is/vidmot/styles.css").toExternalForm());
        stage.setTitle("Kvikmyndahús");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Aðalaðferð forritsins.
     * @param args skipanalínubreytur
     */
    public static void main(String[] args) {
        launch();
    }
}
