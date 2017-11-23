package model.runway;

/**
 * Defines the runway status which can either be free or occupied.
 */
public enum Status {
    FREE("Free"), OCCUPIED("Occupied");

    /** The status term **/
    private String term = null;

    /**
     * Sets the status term.
     * @param term the status term.
     */
    private Status(String term) {
        this.term = term;
    }

    /**
     * Getter for the status term.
     * @return the status term.
     */
    public String getTerm() {
        return this.term;
    }
}
