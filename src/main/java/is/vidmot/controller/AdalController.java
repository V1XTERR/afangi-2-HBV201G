package is.vidmot.controller;

import is.vidmot.switcher.ViewSwitcher;
import is.vinnlsa.Kvikmynd;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

/**
 * Controller fyrir aðalviðmótið. Sér um kvikmyndalistann og aðalaðgerðir.
 */
public class AdalController {

    /** ListView sem sýnir lista kvikmynda. */
    @FXML
    private ListView<Kvikmynd> kvikmyndaListi;

    /** Takki til að skoða valda kvikmynd. */
    @FXML
    private Button skoðaTakki;

    /** Takki til að eyða valdri kvikmynd. */
    @FXML
    private Button eydaTakki;

    /** Deildar gagnalisti kvikmynda milli controllera. */
    public static ObservableList<Kvikmynd> kvikmyndir = FXCollections.observableArrayList();

    /**
     * Upphafsstillir controllerin. Keyrist sjálfkrafa eftir að FXML er hlaðið.
     */
    @FXML
    public void initialize() {
        if (kvikmyndir.isEmpty()) {
            kvikmyndir.addAll(
                new Kvikmynd("Inception", "Christopher Nolan", 148, 2010, 8.8),
                new Kvikmynd("The Godfather", "Francis Ford Coppola", 175, 1972, 9.2),
                new Kvikmynd("Interstellar", "Christopher Nolan", 169, 2014, 8.6),
                new Kvikmynd("Parasite", "Bong Joon-ho", 132, 2019, 8.5),
                new Kvikmynd("The Dark Knight", "Christopher Nolan", 152, 2008, 9.0)
            );
        }
        kvikmyndaListi.setItems(kvikmyndir);
        kvikmyndaListi.setCellFactory(lv -> new ListCell<>() {
            @Override
            protected void updateItem(Kvikmynd k, boolean empty) {
                super.updateItem(k, empty);
                if (empty || k == null) {
                    setText(null);
                } else {
                    setText(k.getTitill() + "  (" + k.getUtgafuar() + ")  ★ " + k.getEinkunn());
                }
            }
        });

        // Takkar óvirkir þegar ekkert er valið
        skoðaTakki.setDisable(true);
        eydaTakki.setDisable(true);
        kvikmyndaListi.getSelectionModel().selectedItemProperty().addListener(
            (obs, gamalt, nytt) -> {
                boolean valið = nytt != null;
                skoðaTakki.setDisable(!valið);
                eydaTakki.setDisable(!valið);
            }
        );
    }

    /**
     * Opnar skoðunarglugga fyrir valda kvikmynd.
     */
    @FXML
    private void onSkoða() {
        Kvikmynd valin = kvikmyndaListi.getSelectionModel().getSelectedItem();
        if (valin == null) return;
        FerdController.setKvikmynd(valin);
        ViewSwitcher.switchTo("/is/vidmot/ferd-view.fxml");
    }

    /**
     * Eyðir valdri kvikmynd úr lista eftir staðfestingu.
     */
    @FXML
    private void onEyda() {
        Kvikmynd valin = kvikmyndaListi.getSelectionModel().getSelectedItem();
        if (valin == null) return;
        EydaDialogController dialog = new EydaDialogController(valin.getTitill());
        boolean staðfest = dialog.sýnaDialog();
        if (staðfest) {
            kvikmyndir.remove(valin);
        }
    }

    /**
     * Opnar dialog til að bæta við nýrri kvikmynd.
     */
    @FXML
    private void onBaetaVid() {
        NyKvikmyndDialogController dialog = new NyKvikmyndDialogController();
        Kvikmynd ny = dialog.sýnaDialog();
        if (ny != null) {
            kvikmyndir.add(ny);
        }
    }
}
