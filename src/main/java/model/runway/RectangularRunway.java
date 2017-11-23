package model.runway;

/**
 * A regular runway for any kind of airplane.
 */
public class RectangularRunway extends AbstractRunway {

    /**
     * Initializes a new RectangularRunway instance.
     * @param id The id of the runway. Should be unique.
     * @param length The length of the runway (immutable after initialization)
     * @param width The width of the runway (immutable after initialization)
     */
    public RectangularRunway(int id, int length, int width) {
        super("R0" + id, length, width);
    }
}
