public class JunList {
    private Integer[] list;
    private int trackListPosition;

    public JunList() {
        //constructor that takes no parameter but initializes an empty list
        trackListPosition = 0;
        list = new Integer[1];
    }

    public JunList(Integer[] initial) {
        trackListPosition = initial.length;
        list = initial;
    }

    public void append(int value) {
        //creates list twice as big when necessary
        if (trackListPosition == list.length) {
            Integer[] temporaryList = new Integer[trackListPosition * 2];
            for (int i = 0; i < trackListPosition; i++) {
                temporaryList[i] = list[i];
            }
            list = temporaryList;
        }
        list[trackListPosition] = value;
        trackListPosition += 1;
    }

    public int get(int index) {
        if (index > trackListPosition || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            return list[index];
        }
    }

    public void add(int position, int value) {
        if (trackListPosition == list.length) {
            Integer[] temporaryList = new Integer[trackListPosition * 2];
            for (int i = 0; i < list.length + 1; i++) {
                if (i < position) {
                    temporaryList[i] = list[i];
                } else if (i == position) {
                    temporaryList[i] = value;
                } else {
                    temporaryList[i] = list[i - 1];
                }
            }
            list = temporaryList;
        } else {
            for (int i = trackListPosition; i > position; i--) {
                list[i] = list[i - 1];
            }
            list[position] = value;
        }
        trackListPosition += 1;
    }

    public void prepend(int value) {
        //creates list twice as big when necessary
        if (trackListPosition == list.length) {
            Integer[] temporaryList = new Integer[trackListPosition * 2];
            for (int i = 0; i < trackListPosition + 1; i++) {
                if (i == 0) {
                    temporaryList[i] = value;
                } else {
                    temporaryList[i] = list[i - 1];
                }
            }
            list = temporaryList;
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
        if (list[position] == null) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = position; i < trackListPosition; i++) {
            list[i] = list[i + 1];
        }
        list[trackListPosition] = null;
        trackListPosition -= 1;
    }

    public void empty() {
        list = new Integer[1];
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
        for (int i = 0; i < trackListPosition; ++i) {
            if (list[i] == value) {
                position = i;
                break;
            }
        }
        return position;
    }
}



