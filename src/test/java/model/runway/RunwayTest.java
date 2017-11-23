package model.runway;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RunwayTest {

    private RectangularRunway runway1 = null;
    private RectangularRunway runway2 = null;
    private Pad pad1 = null;
    private Pad pad2 = null;

    @Before
    public void setUp() throws Exception {
        this.runway1 = new RectangularRunway(1, 150, 30);
        this.runway2 = new RectangularRunway(2, 90, 15);
        this.pad1 = new Pad(1, 10);
        this.pad2 = new Pad(2, 20);
    }

    @Test
    public void getId() throws Exception {
        assertEquals("R01", this.runway1.getId());
        assertEquals("R02", this.runway2.getId());
        assertEquals("P01", this.pad1.getId());
        assertEquals("P02", this.pad2.getId());
    }

    @Test
    public void getStatus() throws Exception {
        assertEquals(Status.FREE, this.runway1.getStatus());
        assertEquals(Status.FREE, this.runway2.getStatus());
        assertEquals(Status.FREE, this.pad1.getStatus());
        assertEquals(Status.FREE, this.pad2.getStatus());
    }

    @Test
    public void getWidth() throws Exception {
        assertEquals(30, this.runway1.getWidth());
        assertEquals(15, this.runway2.getWidth());
        assertEquals(10, this.pad1.getWidth());
        assertEquals(20, this.pad2.getWidth());
    }

    @Test
    public void getLength() throws Exception {
        assertEquals(90, this.runway2.getLength());
        assertEquals(150, this.runway1.getLength());
        assertEquals(10, this.pad1.getLength());
        assertEquals(20, this.pad2.getLength());
    }

    @Test
    public void requestRunway() throws Exception {
        assertTrue(this.runway1.requestRunway());
        assertFalse(this.runway1.requestRunway());
        assertEquals(Status.OCCUPIED, this.runway1.getStatus());
    }

    @Test
    public void releaseRunway() throws Exception {
        this.runway1.requestRunway();
        assertEquals(Status.OCCUPIED, this.runway1.getStatus());
        this.runway1.releaseRunway();
        assertEquals(Status.FREE, this.runway1.getStatus());
    }

    @Test
    public void releaseRunwayIllegalAccess() throws Exception {
        this.runway1.requestRunway();
        String threadName = Thread.currentThread().getName();
        Thread.currentThread().setName("another");

        try {
            this.runway1.releaseRunway();
        } catch(IllegalAccessError e) {
            assertEquals("Runway " + runway1.getId() +  " is currently being used by Thread " +
                    threadName + ". Runway can only be released by this thread or be " +
                    "overridden by setting the overridden flag.", e.getMessage());
        }

        Thread.currentThread().setName(threadName);
        this.runway1.releaseRunway();
    }

    @Test
    public void releaseRunwayOverride() throws Exception {
        this.requestRunway();
        String threadName = Thread.currentThread().getName();
        Thread.currentThread().setName("another");

        this.runway1.releaseRunway(true);
        assertEquals(Status.FREE, this.runway1.getStatus());
    }

}