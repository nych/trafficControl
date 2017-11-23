package model;

import view.Listener;

/**
 * Similar to Observable.
 */
public interface Model {

    /**
     * Adds a listener to be notified in case of a model update.
     * @param listener the listener to be added.
     */
    public void addListener(Listener listener);

    /**
     * Removes a listener.
     * @param listener the listener to be removed.
     */
    public void removeListener(Listener listener);

    /**
     * Notifies all listeners about a model update.
     */
    public void notifyListeners();
}
