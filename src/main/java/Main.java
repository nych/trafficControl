import model.runway.Pad;
import model.runway.RectangularRunway;
import view.console.PadView;
import view.console.RunwayView;

public class Main {

    public static void main(String[] args) {

        RunwayView view1 = new RunwayView();
        PadView view2 = new PadView();

        // Wingspan of a A380 is ~ 80m, take off ~ 3000m
        RectangularRunway runway1 = new RectangularRunway(1, 3000, 100);
        runway1.addListener(view1);

        // Smaller planes
        RectangularRunway runway2 = new RectangularRunway(2, 1800, 60);
        runway1.addListener(view1);

        // Small helicopters
        Pad pad1 = new Pad(1, 10);
        pad1.addListener(view2);

        // Helicopters with a wingspan more than 15 (Apache Longbow)
        Pad pad2 = new Pad(2, 20);
        pad2.addListener(view2);

        view1.update(runway1);
        view1.update(runway2);
        view2.update(pad1);
        view2.update(pad2);

        System.out.println("Request runway R01");
        runway1.requestRunway();

        System.out.println("Request pad P01");
        pad1.requestRunway();

        System.out.println("Release runway R01");
        runway1.releaseRunway();

        System.out.println("Release pad P01");
        pad1.releaseRunway();
    }
}
