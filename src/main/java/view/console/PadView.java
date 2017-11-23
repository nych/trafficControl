package view.console;

import model.Model;
import model.runway.Pad;
import view.Listener;

/**
 * Prints a console representation of a Pad Instance.
 */
public class PadView implements Listener {

    public PadView() {}

    @Override
    public void update(Model model) {
        Pad pad = (Pad) model;
        StringBuilder sb = new StringBuilder();
        int n = 0;

        sb.append("                   * * * * * * * * * * ** * * * * * * * * * *\n");
        sb.append("                   *                   **                   *\n");
        sb.append("                   *                   **      * * * *      *\n");
        sb.append("                   *                   **    *         *    *\n");

        sb.append("                   * Pad:    ");
        sb.append(pad.getId());
        n = 10 - pad.getId().length();
        for(int i = 0; i < n; i++) {
            sb.append(" ");
        }
        sb.append("**   *   #   #   *   *\n");

        sb.append("                   * Status: ");
        sb.append(pad.getStatus().getTerm());
        n = 10 - pad.getStatus().getTerm().length();
        for(int i = 0; i < n; i++) {
            sb.append(" ");
        }
        sb.append("**   *   #####   *   *\n");

        sb.append("                   * Side:   ");
        sb.append(pad.getWidth());
        n = 10 - Integer.toString(pad.getWidth()).length();
        for(int i = 0; i < n; i++) {
            sb.append(" ");
        }
        sb.append("**   *   #   #   *   *\n");

        sb.append("                   *                   **    *         *    *\n");
        sb.append("                   *                   **      * * * *      *\n");
        sb.append("                   *                   **                   *\n");
        sb.append("                   * * * * * * * * * * ** * * * * * * * * * *\n");

        System.out.println(sb.toString());
    }
}
