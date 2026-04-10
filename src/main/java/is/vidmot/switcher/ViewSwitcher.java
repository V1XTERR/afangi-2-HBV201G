package is.vidmot.switcher;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * ViewSwitcher - gefið. Sér um skipti á milli viðmótsstrjáa í sama glugga.
 */
public class ViewSwitcher {

    /** Rótarpanel sem inniheldur virka viðmótsstrjáinn. */
    private static Pane root;

    /**
     * Setur rótarpanelinn sem notaður er til skipta.
     * @param p rótarpanell
     */
    public static void setRoot(Pane p) {
        root = p;
    }

    /**
     * Skiptar yfir í viðmótsstrjá sem tilgreindur er í FXML skrá.
     * @param fxml slóð á FXML skrá
     */
    public static void switchTo(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(ViewSwitcher.class.getResource(fxml));
            Pane p = loader.load();
            root.getChildren().setAll(p.getChildren());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
