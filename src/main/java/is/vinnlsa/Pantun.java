package is.vinnlsa;

/**
 * Klasinn Pantun geymir upplýsingar um eina miðapöntun.
 */
public class Pantun {

    /** Kvikmyndin sem pöntuð er. */
    private Kvikmynd kvikmynd;

    /** Dagsetning sýningar. */
    private String dagsetning;

    /** Fjöldi miða í pöntun. */
    private int fjoldiMida;

    /**
     * Smiður fyrir Pantun.
     * @param kvikmynd kvikmyndin sem er pöntuð
     * @param dagsetning dagsetning sýningar
     * @param fjoldiMida fjöldi miða
     */
    public Pantun(Kvikmynd kvikmynd, String dagsetning, int fjoldiMida) {
        this.kvikmynd = kvikmynd;
        this.dagsetning = dagsetning;
        this.fjoldiMida = fjoldiMida;
    }

    /**
     * Skilar kvikmyndinni í pöntun.
     * @return kvikmynd
     */
    public Kvikmynd getKvikmynd() { return kvikmynd; }

    /**
     * Skilar dagsetningu sýningar.
     * @return dagsetning
     */
    public String getDagsetning() { return dagsetning; }

    /**
     * Setur dagsetningu sýningar.
     * @param dagsetning ný dagsetning
     */
    public void setDagsetning(String dagsetning) { this.dagsetning = dagsetning; }

    /**
     * Skilar fjölda miða í pöntun.
     * @return fjöldi miða
     */
    public int getFjoldiMida() { return fjoldiMida; }

    /**
     * Setur fjölda miða í pöntun.
     * @param fjoldiMida nýr fjöldi
     */
    public void setFjoldiMida(int fjoldiMida) { this.fjoldiMida = fjoldiMida; }

    /**
     * Skilar textaframsetningu á pöntun.
     * @return lýsing á pöntun
     */
    @Override
    public String toString() {
        return kvikmynd.getTitill() + " - " + dagsetning + " (" + fjoldiMida + " miðar)";
    }
}
