package model.runway;

/**
 * A pad is a runway with a square shape for helicopters or VTOL's like an
 * Osprey or a Harrier.
 */
public class Pad extends AbstractRunway {

    /**
     * Initializes a new pad instance with equal side lengths.
     * @param id The id of the pad. Should be unique.
     * @param sideLength The side length of the runway (immutable after
     *                   initialization)
     */
    public Pad(int id, int sideLength) {
        super("P0" + id, sideLength, sideLength);
    }
}
