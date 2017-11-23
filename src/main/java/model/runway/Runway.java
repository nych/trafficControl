package model.runway;

/**
 * The runway interface and its implementations are the central part of
 * this whole exercise.
 * It can be requested for landing and released afterwards. All operations
 * in the context of the status need to be synchronized.
 * For the scope of this exercise this is done in a very simple manner.
 */
public interface Runway {

    /**
     * Getter for the id of the runway.
     * @return the id of the runway.
     */
    public String getId();

    /**
     * Getter for the status of the runway.
     * @return the current status of the runway.
     */
    public Status getStatus();

    /**
     * Getter fpr the width of the runway.
     * @return width of the runway.
     */
    public int getWidth();

    /**
     * Getter for length of the runway.
     * @return length of the runway.
     */
    public int getLength();

    /**
     * Requests the runway. This is only possible if the current status of the
     * Runway is free.
     * @return true if the status was free and the runway was acquired
     * successfully, false otherwise.
     */
    public boolean requestRunway();

    /**
     * In my opinion only the instance, might be a person, who requested the
     * the runway should be allowed to release it again.
     * For the scope of this exercise the thread name is used for this purpose.
     * Only the thread which owns the runway successfully, can release it
     * again.
     *
     * This is not suitable for a real live scenario but it shows the general
     * idea.
     */
    public void releaseRunway() throws IllegalAccessError;

    /**
     * In case the owning instance is unable to release the runway, it can be
     * overridden by any instance by setting the override flag.
     * @param override
     */
    public void releaseRunway(boolean override);
}
