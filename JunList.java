public class JunList {
    private int[] list;
    private int trackListPosition;

    public JunList() {
        //constructor that takes no parameter but initializes an empty list
        trackListPosition = 0;
        list = new int[1];
    }

    /*
    Take in an array then use that to define the list
     */
    public JunList(int[] initial) {

    }

    public void append(int value) {
        //creates list twice as big when necessary
        if (trackListPosition == list.length) {
            int[] newList = new int[list.length * 2];
            //Find another way to do this, maybe implement your own method?
            System.arraycopy(list, 0, newList, 0, list.length);
            this.list = newList;
        }
        this.list[trackListPosition] = value;
        trackListPosition += 1;
    }

    public void add(int position, int value) {
        //creates list twice as big when necessary
        //Nice comment above, sensible, informative
        if (trackListPosition == list.length) {
            int[] newList = new int[list.length * 2];
            for (int i = 0; i < list.length; ++i) {
                if (i < position) {
                    newList[i] = list[i];
                } else if (position == i) {
                    newList[i] = value;
                } else {
                    newList[i] = list[i - 1];
                }
            }
            this.list = newList;
        } else {
            for (int i = trackListPosition; i > position; i--) {
                list[i] = list[i - 1];
            }
            this.list[position] = value;
        }
        trackListPosition += 1;
    }

    public void prepend(int value) {
        //creates list twice as big when necessary
        if (trackListPosition == list.length) {
            int[] newList = new int[list.length * 2];
            for (int i = 0; i < list.length; i++) {
                if (i == 0) {
                    newList[i] = value;
                } else {
                    newList[i] = list[i - 1];
                }
            }
            this.list = newList;
        } else {
            for (int i = trackListPosition; i >= 0; i--) {
                if (i == 0) {
                    list[i] = value;
                } else {
                    list[i] = list[i - 1];
                }
            }
        }
        trackListPosition += 1;
    }

    public void remove(int position) {
        //this approach is o(n/2) speed if removal position is randomly distributed
        //sidenote on the efficiency, constants don't matter in O(n) only exponents, as in that's o(n), not n/2
        for (int i = position; i < list.length - 1; i++) {
            list[i] = list[i + 1];
        }
        list[list.length - 1] = 0;
        trackListPosition -= 1;
    }

    /*
    I won't remove the efficiency comments from your code, but it's unnecessary, remember this code is for others devs
    who can read and understand code, you don't need to be printing stuff out or giving obvious comments,
     */
    public void empty() {
        this.list = new int[1];
        trackListPosition = 0;
    }

    //return size of list
    public int size() {
        //this approach is o(1) speed and o(1) memory
        return trackListPosition;
    }

    //check if list contains value
    public boolean contains(int value) {
        //this approach is o(n) speed and o(1) memory
        for (int j : list) {
            if (j == value) {
                return true;
            }
        }
        return false;
    }

    //check position of first appearance of value. return -1 if not found in list
    public int indexOf(int value) {
        //this approach is o(n) speed and o(1) memory
        int position = -1;
        for (int i = 0; i < list.length; ++i) {
            if (list[i] == value) {
                position = i;
                break;
            }
        }
        return position;
    }
}


