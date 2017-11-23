package model.runway;

import view.Listener;
import model.Model;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Abstract super class implements most Runway functionality.
 */
public abstract class AbstractRunway implements Model, Runway {

    /** Lock used to synchronize access on status **/
    private Lock lock = null;

    /** The current owner of the runway. **/
    private String owner = null;

    /** Contains all registered listeners **/
    private Set<Listener> listeners = null;

    /** Runway id (R0X, P0X) **/
    private String id = null;

    /** Length of the runway **/
    private int length = 0;

    /** Width of the runway **/
    private int width = 0;

    /** The current status of the runway **/
    private volatile Status status = Status.FREE;

    /**
     * Initializes a new Runway instance.
     * @param id The id of the runway. Should be unique.
     * @param length The length of the runway (immutable after initialization)
     * @param width The width of the runway (immutable after initialization)
     */
    public AbstractRunway(String id, int length, int width) {
        this.lock = new ReentrantLock();
        this.listeners = new HashSet<Listener>();
        this.id = id;
        this.length = length;
        this.width = width;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public Status getStatus() {
        this.lock.lock();
        try {
            return this.status;
        } finally {
            this.lock.unlock();
        }
    }

    @Override
    public boolean requestRunway() {
        this.lock.lock();
        try {
            if(this.status.equals(Status.FREE)) {
                this.owner = Thread.currentThread().getName();
                this.status = Status.OCCUPIED;
                this.notifyListeners();
                return true;
            } else {
                return false;
            }
        } finally {
            this.lock.unlock();
        }
    }

    @Override
    public void releaseRunway() {
        this.releaseRunway(false);
    }

    @Override
    public void releaseRunway(boolean override) {
        this.lock.lock();
        try {
            if(this.owner.equals(Thread.currentThread().getName()) || override) {
                this.owner = null;
                this.status = Status.FREE;
                this.notifyListeners();
            } else {
                throw new IllegalAccessError("Runway " + this.id +  " is currently being used by Thread " +
                        this.owner + ". Runway can only be released by this thread or be overridden by setting the " +
                        "overridden flag.");
            }
        } finally {
            this.lock.unlock();
        }
    }

    @Override
    public void addListener(Listener listener) {
        this.listeners.add(listener);
    }

    @Override
    public void removeListener(Listener listener) {
        this.listeners.remove(listener);
    }

    @Override
    public void notifyListeners() {
        for(Listener listener : this.listeners) {
            listener.update(this);
        }
    }
}
