package is.vidmot.controller;

import is.vinnlsa.Kvikmynd;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.Optional;

/**
 * Controller fyrir dialog til að bæta við nýrri kvikmynd.
 */
public class NyKvikmyndDialogController {

    /**
     * Sýnir dialog til að bæta við kvikmynd og skilar nýrri kvikmynd ef staðfest.
     * @return Kvikmynd ef staðfest, null ef hætt við
     */
    public Kvikmynd sýnaDialog() {
        Dialog<Kvikmynd> dialog = new Dialog<>();
        dialog.setTitle("Bæta við kvikmynd");
        dialog.setHeaderText("Sláðu inn upplýsingar um nýja kvikmynd");

        ButtonType baetaButtonType = new ButtonType("Bæta við", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(baetaButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField titillField = new TextField();
        titillField.setPromptText("Titill");
        TextField leikstjoriField = new TextField();
        leikstjoriField.setPromptText("Leikstjóri");
        Spinner<Integer> lengdSpinner = new Spinner<>(1, 300, 90);
        Spinner<Integer> arSpinner = new Spinner<>(1900, 2026, 2020);
        Spinner<Double> einkunnSpinner = new Spinner<>(1.0, 10.0, 7.0, 0.1);

        grid.add(new Label("Titill:"), 0, 0);
        grid.add(titillField, 1, 0);
        grid.add(new Label("Leikstjóri:"), 0, 1);
        grid.add(leikstjoriField, 1, 1);
        grid.add(new Label("Lengd (mín):"), 0, 2);
        grid.add(lengdSpinner, 1, 2);
        grid.add(new Label("Útgáfuár:"), 0, 3);
        grid.add(arSpinner, 1, 3);
        grid.add(new Label("Einkunn:"), 0, 4);
        grid.add(einkunnSpinner, 1, 4);

        // Takki óvirkur þar til titill og leikstjóri eru fyllt inn
        Node baetaButton = dialog.getDialogPane().lookupButton(baetaButtonType);
        baetaButton.setDisable(true);
        Runnable athugaReit = () -> {
            baetaButton.setDisable(
                titillField.getText().trim().isEmpty() ||
                leikstjoriField.getText().trim().isEmpty()
            );
        };
        titillField.textProperty().addListener((o, g, n) -> athugaReit.run());
        leikstjoriField.textProperty().addListener((o, g, n) -> athugaReit.run());

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == baetaButtonType) {
                return new Kvikmynd(
                    titillField.getText().trim(),
                    leikstjoriField.getText().trim(),
                    lengdSpinner.getValue(),
                    arSpinner.getValue(),
                    einkunnSpinner.getValue()
                );
            }
            return null;
        });

        Optional<Kvikmynd> result = dialog.showAndWait();
        return result.orElse(null);
    }
}
