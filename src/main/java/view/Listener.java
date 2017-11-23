package view;

import model.Model;

/**
 * Similar to Observer.
 */
public interface Listener {

    /**
     * Callback function.
     * @param model the updated model.
     */
    public void update(Model model);
}
