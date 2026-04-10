package is.vidmot.controller;

import is.vinnlsa.Kvikmynd;
import is.vinnlsa.Pantun;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.Optional;

/**
 * Controller fyrir pöntunardialog. Leyfir notanda að panta miða á kvikmynd.
 */
public class PantunDialogController {

    /** Kvikmyndin sem verið er að panta á. */
    private final Kvikmynd kvikmynd;

    /**
     * Smiður fyrir PantunDialogController.
     * @param kvikmynd kvikmyndin sem á að panta á
     */
    public PantunDialogController(Kvikmynd kvikmynd) {
        this.kvikmynd = kvikmynd;
    }

    /**
     * Sýnir pöntunardialog og skilar pöntun ef notandi staðfestir.
     * @return Pantun ef staðfest, null ef hætt við
     */
    public Pantun sýnaDialog() {
        Dialog<Pantun> dialog = new Dialog<>();
        dialog.setTitle("Panta miða");
        dialog.setHeaderText("Panta miða á: " + kvikmynd.getTitill());

        ButtonType pantaButtonType = new ButtonType("Panta", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(pantaButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new javafx.geometry.Insets(20, 150, 10, 10));

        TextField dagsetningField = new TextField();
        dagsetningField.setPromptText("dd.mm.yyyy");
        Spinner<Integer> fjoldiSpinner = new Spinner<>(1, 10, 1);

        grid.add(new Label("Dagsetning sýningar:"), 0, 0);
        grid.add(dagsetningField, 1, 0);
        grid.add(new Label("Fjöldi miða:"), 0, 1);
        grid.add(fjoldiSpinner, 1, 1);

        // Panta takki óvirkur þar til dagsetning er slegin inn
        javafx.scene.Node pantaButton = dialog.getDialogPane().lookupButton(pantaButtonType);
        pantaButton.setDisable(true);
        dagsetningField.textProperty().addListener((obs, old, nytt) -> {
            pantaButton.setDisable(nytt.trim().isEmpty());
        });

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == pantaButtonType) {
                String dagsetning = dagsetningField.getText().trim();
                if (dagsetning.isEmpty()) return null;
                return new Pantun(kvikmynd, dagsetning, fjoldiSpinner.getValue());
            }
            return null;
        });

        Optional<Pantun> result = dialog.showAndWait();
        return result.orElse(null);
    }
}
