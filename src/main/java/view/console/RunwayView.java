package view.console;

import model.Model;
import model.runway.RectangularRunway;
import view.Listener;

/**
 * Prints a console representation of a RectangularRunway Instance.
 */
public class RunwayView implements Listener {

    @Override
    public void update(Model model) {
        RectangularRunway runway = (RectangularRunway) model;
        StringBuilder sb = new StringBuilder();
        int n = 0;

        sb.append("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
        sb.append("* ###                                                                     *** *\n");

        sb.append("* ###     ###                    Runaway: ");
        sb.append(runway.getId());
        n = 24 - runway.getId().length();
        for(int i = 0; i < n; i++) {
            sb.append(" ");
        }
        sb.append("###     ### *\n");

        sb.append("* ###     ###        ###         Status:  ");
        sb.append(runway.getStatus().getTerm());
        n = 13 - runway.getStatus().getTerm().length();
        for(int i = 0; i < n; i++) {
            sb.append(" ");
        }
        sb.append("###        ###     ### *\n");

        sb.append("*******************************************************************************\n");

        sb.append("* ###     ###        ###         Length:  ");
        sb.append(runway.getLength());
        n = 13 - Integer.toString(runway.getLength()).length();
        for(int i = 0; i < n; i++) {
            sb.append(" ");
        }
        sb.append("###        ###     ### *\n");

        sb.append("* ###     ###                    Width:   ");
        sb.append(runway.getWidth());
        n = 24 - Integer.toString(runway.getWidth()).length();
        for(int i = 0; i < n; i++) {
            sb.append(" ");
        }
        sb.append("###     ### *\n");
        sb.append("* ###                                                                     ### *\n");
        sb.append("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");

        System.out.println(sb.toString());
    }
}
