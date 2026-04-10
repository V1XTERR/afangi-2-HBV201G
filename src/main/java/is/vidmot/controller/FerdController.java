package is.vidmot.controller;

import is.vidmot.switcher.ViewSwitcher;
import is.vinnlsa.Kvikmynd;
import is.vinnlsa.Pantun;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Controller fyrir ferd-view - skoðunargluggi fyrir einstaka kvikmynd.
 */
public class FerdController {

    /** Label sem sýnir titil kvikmyndar. */
    @FXML
    private Label titillLabel;

    /** Label sem sýnir leikstjóra. */
    @FXML
    private Label leikstjoriLabel;

    /** Label sem sýnir lengd kvikmyndar. */
    @FXML
    private Label lengdLabel;

    /** Label sem sýnir útgáfuár. */
    @FXML
    private Label utgafuarLabel;

    /** Label sem sýnir einkunn. */
    @FXML
    private Label einkunnLabel;

    /** Kvikmyndin sem verið er að skoða. */
    private static Kvikmynd kvikmynd;

    /**
     * Setur kvikmyndina sem á að skoða.
     * @param k kvikmyndin
     */
    public static void setKvikmynd(Kvikmynd k) {
        kvikmynd = k;
    }

    /**
     * Upphafsstillir controllerin og fyllir inn upplýsingar um kvikmyndina.
     */
    @FXML
    public void initialize() {
        if (kvikmynd != null) {
            titillLabel.setText(kvikmynd.getTitill());
            leikstjoriLabel.setText(kvikmynd.getLeikstjori());
            lengdLabel.setText(kvikmynd.getLengd() + " mínútur");
            utgafuarLabel.setText(String.valueOf(kvikmynd.getUtgafuar()));
            einkunnLabel.setText("★ " + kvikmynd.getEinkunn() + " / 10");
        }
    }

    /**
     * Fer aftur á aðalviðmótið.
     */
    @FXML
    private void onTilbaka() {
        ViewSwitcher.switchTo("/is/vidmot/adal-view.fxml");
    }

    /**
     * Opnar pöntunardialog fyrir kvikmyndina.
     */
    @FXML
    private void onPanta() {
        PantunDialogController dialog = new PantunDialogController(kvikmynd);
        Pantun p = dialog.sýnaDialog();
        if (p != null) {
            // Pöntun tókst - sýna staðfestingu
            javafx.scene.control.Alert alert = new javafx.scene.control.Alert(
                javafx.scene.control.Alert.AlertType.INFORMATION
            );
            alert.setTitle("Pöntun staðfest");
            alert.setHeaderText("Takk fyrir pöntunina!");
            alert.setContentText(p.toString());
            alert.showAndWait();
        }
    }
}
