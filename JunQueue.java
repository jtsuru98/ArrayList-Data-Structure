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
            String[] temporaryQueue = new String[queue.length * 2];
            for (int i = 0; i < queue.length; i++) {
                temporaryQueue[i] = queue[i];
            }
            queue = temporaryQueue;
        }

        queue[trackQueuePosition] = value;
        trackQueuePosition += 1;
    }

    public String dequeue() {
        String upNext = queue[0];
        if (trackQueuePosition > 0) {
            for (int i = 0; i < trackQueuePosition - 1; i++) {
                queue[i] = queue[i + 1];
            }
            trackQueuePosition -= 1;
            queue[trackQueuePosition] = null;
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
            return queue[0];
        } else {
            return null;
        }
    }

    public void clear() {
        trackQueuePosition = 0;
        queue = new String[1]; // prints null

    }
}