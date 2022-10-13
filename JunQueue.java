import java.util.Arrays;

public class JunQueue {
    private String[] queue;
    private int trackQueuePosition;


    public JunQueue() {
        //constructor that takes no parameter but initializes an empty list
        trackQueuePosition = 0;
        queue = new String[1];
    }

    public JunQueue(String[] initial) {
        trackQueuePosition = initial.length;
        queue = initial;
    }

    public void enqueue(String value) {
        if (value.isEmpty()) {
            return;
        }

        //creates list twice as big when necessary
        if (trackQueuePosition == queue.length) {
            String[] newQueue = new String[queue.length * 2];
            for (int i = 0; i < queue.length; i++) {
                newQueue[i] = this.queue[i];
            }
            this.queue = newQueue;
        }

        this.queue[trackQueuePosition] = value;
        trackQueuePosition += 1;
    }

    public String dequeue() {
        String upNext = this.queue[0];
        if (trackQueuePosition > 0) {
            for (int i = 0; i < trackQueuePosition - 1; i++) {
                this.queue[i] = this.queue[i + 1];
            }
            trackQueuePosition -= 1;
            this.queue[trackQueuePosition] = null;
            return upNext;
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return trackQueuePosition == 0;
    }

    public String peek() {
        if (trackQueuePosition > 0) {
            return this.queue[0];
        } else {
            return null;
        }
    }

    public void clear() {
        trackQueuePosition = 0;
        this.queue = new String[1]; // prints null

    }
}