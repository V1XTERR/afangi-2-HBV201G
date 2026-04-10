package is.vinnlsa;

/**
 * Klasinn Kvikmynd geymir upplýsingar um eina kvikmynd.
 */
public class Kvikmynd {

    /** Titill kvikmyndar. */
    private String titill;

    /** Leikstjóri kvikmyndar. */
    private String leikstjori;

    /** Lengd kvikmyndar í mínútum. */
    private int lengd;

    /** Útgáfuár kvikmyndar. */
    private int utgafuar;

    /** Einkunn kvikmyndar (1-10). */
    private double einkunn;

    /**
     * Smiður fyrir Kvikmynd.
     * @param titill titill kvikmyndar
     * @param leikstjori leikstjóri kvikmyndar
     * @param lengd lengd í mínútum
     * @param utgafuar útgáfuár
     * @param einkunn einkunn 1-10
     */
    public Kvikmynd(String titill, String leikstjori, int lengd, int utgafuar, double einkunn) {
        this.titill = titill;
        this.leikstjori = leikstjori;
        this.lengd = lengd;
        this.utgafuar = utgafuar;
        this.einkunn = einkunn;
    }

    /**
     * Skilar titli kvikmyndar.
     * @return titill
     */
    public String getTitill() { return titill; }

    /**
     * Setur titil kvikmyndar.
     * @param titill nýr titill
     */
    public void setTitill(String titill) { this.titill = titill; }

    /**
     * Skilar leikstjóra kvikmyndar.
     * @return leikstjóri
     */
    public String getLeikstjori() { return leikstjori; }

    /**
     * Setur leikstjóra kvikmyndar.
     * @param leikstjori nýr leikstjóri
     */
    public void setLeikstjori(String leikstjori) { this.leikstjori = leikstjori; }

    /**
     * Skilar lengd kvikmyndar í mínútum.
     * @return lengd
     */
    public int getLengd() { return lengd; }

    /**
     * Setur lengd kvikmyndar.
     * @param lengd lengd í mínútum
     */
    public void setLengd(int lengd) { this.lengd = lengd; }

    /**
     * Skilar útgáfuári kvikmyndar.
     * @return útgáfuár
     */
    public int getUtgafuar() { return utgafuar; }

    /**
     * Setur útgáfuár kvikmyndar.
     * @param utgafuar nýtt útgáfuár
     */
    public void setUtgafuar(int utgafuar) { this.utgafuar = utgafuar; }

    /**
     * Skilar einkunn kvikmyndar.
     * @return einkunn
     */
    public double getEinkunn() { return einkunn; }

    /**
     * Setur einkunn kvikmyndar.
     * @param einkunn ný einkunn
     */
    public void setEinkunn(double einkunn) { this.einkunn = einkunn; }

    /**
     * Skilar textaframsetningu á kvikmynd.
     * @return titill kvikmyndar
     */
    @Override
    public String toString() {
        return titill + " (" + utgafuar + ")";
    }
}
