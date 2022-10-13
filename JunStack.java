public class JunStack {
    private String[] stack;
    private int trackStackPosition;

    public JunStack() {
        //constructor that takes no parameter but initializes an empty list
        trackStackPosition = 0;
        stack = new String[1];
    }

    public JunStack(String[] initial) {
        trackStackPosition = initial.length;
        stack = initial;
    }

    public void push(String value) {
        //creates list twice as big when necessary
        if (trackStackPosition == stack.length) {
            String[] temporaryStack = new String[stack.length * 2];
            for (int i = 0; i < stack.length; i++) {
                temporaryStack[i] = stack[i];

            }
            stack = temporaryStack;
        }
        stack[trackStackPosition] = value;
        trackStackPosition += 1;
    }

    public String pop() {
        if (trackStackPosition > 0) {
            String toPop = stack[trackStackPosition - 1];

            stack[trackStackPosition - 1] = null;
            trackStackPosition -= 1;

            return toPop;
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return trackStackPosition == 0;
    }

    public String peep() {
        if (trackStackPosition > 0) {
            return stack[trackStackPosition - 1];
        } else {
            return null;
        }
    }

    public void clear() {
        trackStackPosition = 0;
        stack = new String[1];
    }
}

