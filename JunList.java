public class JunList {
    private int[] list;
    private int trackListPosition;

    public JunList() {
        //constructor that takes no parameter but initializes an empty list
        trackListPosition = 0;
        list = new int[1];
    }

    public JunList(int[] initial) {
        trackListPosition = initial.length;
        list = initial;
    }

    public void append(int value) {
        //creates list twice as big when necessary
        if (trackListPosition == list.length) {
            int[] newList = new int[list.length * 2];
            for (int i = 0; i < list.length; i++) {
                newList[i] = this.list[i];
            }
            this.list = newList;
        }
        this.list[trackListPosition] = value;
        trackListPosition += 1;
    }

    public int get(int index) {
        return this.list[index];
    }

    public void add(int position, int value) {
        //creates list twice as big when necessary
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
            for (int i = 0; i < list.length + 1; i++) {
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
        for (int i = position; i < list.length - 1; i++) {
            list[i] = list[i + 1];
        }
        list[list.length - 1] = 0;
        trackListPosition -= 1;
    }

    public void empty() {
        this.list = new int[1];
        trackListPosition = 0;
    }

    //return size of list
    public int size() {
        return trackListPosition;
    }

    //check if list contains value
    public boolean contains(int value) {
        for (int i : list) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }

    //check position of first appearance of value. return -1 if not found in list
    public int indexOf(int value) {
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



