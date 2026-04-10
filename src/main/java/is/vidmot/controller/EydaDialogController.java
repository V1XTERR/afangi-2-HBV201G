package is.vidmot.controller;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

/**
 * Controller fyrir staðfestingardialog við eyðingu kvikmyndar.
 */
public class EydaDialogController {

    /** Titill kvikmyndarinnar sem á að eyða. */
    private final String titill;

    /**
     * Smiður fyrir EydaDialogController.
     * @param titill titill kvikmyndarinnar sem á að eyða
     */
    public EydaDialogController(String titill) {
        this.titill = titill;
    }

    /**
     * Sýnir staðfestingardialog og skilar true ef notandi staðfestir eyðingu.
     * @return true ef eyða, false ef hætt við
     */
    public boolean sýnaDialog() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Staðfesta eyðingu");
        alert.setHeaderText("Ertu viss um að þú viljir eyða þessari kvikmynd?");
        alert.setContentText("Kvikmynd: " + titill);

        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == ButtonType.OK;
    }
}
