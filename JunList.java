import java.util.*;

public class JunList {
    private int[] list;
    private int trackListPosition;

    public static void main(String[] args) {
        System.out.println("Hello. You are now in JunWorld where you can create a JunList.");
        System.out.println("Let's start off with instruction specifications...\n");
        instructionSpecifications();

        Scanner userInput = new Scanner(System.in);

        System.out.println("You can now input specifications for your starting list.");
        System.out.println("Please give a number between 0 and 100 for number of values in starting list.");

        int memory = userInput.nextInt(); // user memory input

        //logic to determine if array can be made from user memory input
        if (memory > 100 || memory < 0) {
            System.out.println("Read the previous instruction head ass");
            System.exit(0);
        } else if (memory == 0) {
            JunList userList = new JunList();
            System.out.println("Thanks. Your starter list is: " + Arrays.toString(userList.list));
            System.out.println("Dive in and start manipulating your list!");
            userList.manipulateList(); //while loop to manipulate list however user decides
        } else {
            JunList userList = new JunList(memory);
            System.out.println("Thanks. Your starter list is: " + Arrays.toString(userList.list));
            System.out.println("Dive in and start manipulating your list!");
            userList.manipulateList(); //while loop to manipulate list however user decides
        }
    }

    public JunList() {
        //constructor that takes no parameter but initializes an empty list
        trackListPosition = 0;
        list = new int[1]; // prints null
    }

    public JunList(int memory) {
        //constructor that takes parameter argument
        Scanner userInput = new Scanner(System.in);

        trackListPosition = memory;
        list = new int[memory * 2];

        for (int i = 0; i < memory; i++) {
            System.out.println("Thank you. Now please input each value in your array starting from index " + i);
            list[i] = userInput.nextInt();
        }

    }

    public static void instructionSpecifications() {
        //list of instructions and how to input in manipulateList() method
        System.out.println("Here is a list of functionality you can pick from: ");
        System.out.println("- Append: you can add an element to the end of the list | Input 'append' and then int value to append");
        System.out.println("- Add: Add an element to specific position | Input 'add' and then int value to add");
        System.out.println("- Prepend: add an element to the beginning of the list | Input 'prepend' and then int value to prepend");
        System.out.println("- Remove: remove element at a specific position | Input 'remove' and then int position to remove");
        System.out.println("- Empty: Empties the entire array | Input 'empty'");
        System.out.println("- Size: Returns the length of the list | Input 'size'");
        System.out.println("- Contains:Returns whether or not the value exists in the list as a boolean | Input 'contains' and then int value to search for");
        System.out.println("- Position Of: Returns the index where value first occurs. Returns -1 if doesn't exist in list. |Input 'positionOf' and then int value to locate\n");
    }

    public void manipulateList() {
        System.out.println("If you need clarification on what you can (and can't do), input 'specs'.");
        System.out.println("When done, input 'done'.");

        Scanner userInput = new Scanner(System.in);
        boolean done = false;

        //this is the logic to manipulate list. each option calls a method unless it is a mistake
        label:
        while (!done) {
            String command = userInput.next().toLowerCase();
            switch (command) {
                case "done":
                    done = true;
                    break label;
                case "specs":
                    instructionSpecifications();
                    break;
                case "append":
                    System.out.println("Input int value to append");
                    int value_to_append = userInput.nextInt();
                    append(value_to_append);
                    System.out.println(Arrays.toString(this.list));
                    break;
                case "add":
                    System.out.println("Input int position to add value at");
                    int position_to_add_at = userInput.nextInt();
                    System.out.println("Input int value to add");
                    int value_to_add = userInput.nextInt();
                    add(position_to_add_at, value_to_add);
                    System.out.println(Arrays.toString(this.list));
                    break;
                case "prepend":
                    System.out.println("Input int value to prepend");
                    int value_to_prepend = userInput.nextInt();
                    prepend(value_to_prepend);
                    System.out.println(Arrays.toString(this.list));
                    break;
                case "remove":
                    System.out.println("Input int value to remove");
                    int value_to_remove = userInput.nextInt();
                    remove(value_to_remove);
                    System.out.println(Arrays.toString(this.list));
                    break;
                case "empty":
                    empty();
                    System.out.println(Arrays.toString(this.list));
                    break;
                case "size":
                    size();
                    System.out.println(size());
                    break;
                case "contains":
                    System.out.println("Input int value to search for");
                    int value_to_search = userInput.nextInt();
                    contains(value_to_search);
                    break;
                case "positionof":
                    System.out.println("Input int value to locate");
                    int value_to_locate = userInput.nextInt();
                    positionOf(value_to_locate);
                    break;
                default:
                    System.out.println("That is not an option. Please input 'specs' if you need clarification on what you can call.");
                    break;
            }
        }
    }

    //________________________________THIS IS THE START OF THE LIST METHODS__________________________________________
    public void append(int value) {
        //creates list twice as big when necessary
        if (trackListPosition == list.length) {
            int[] newList = new int[list.length * 2];
            System.arraycopy(list, 0, newList, 0, list.length);
            this.list = newList;
        }
        this.list[trackListPosition] = value;
        trackListPosition += 1;
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
        for (int i = position; i < list.length - 1; i++) {
            list[i] = list[i + 1];
        }
        list[list.length - 1] = 0;
        trackListPosition -= 1;
    }

    public void empty() {
        //this approach is o(1) speed and o(1) memory
        //empty list
        this.list = new int[1];
        trackListPosition = 0;
    }

    public int size() {
        //this approach is o(1) speed and o(1) memory
        //return size of list
        return list.length;
    }

    public boolean contains(int value) {
        //this approach is o(n) speed and o(1) memory
        //check if list contains value
        boolean found = false;
        for (int j : list) {
            if (j == value) {
                found = true;
                break;
            }
        }
        System.out.println(found);
        return found;
    }

    public int positionOf(int value) {
        //this approach is o(n) speed and o(1) memory
        //check position of first appearance of value. return -1 if not found in list
        int position = -1;
        for (int i = 0; i < list.length; ++i) {
            if (list[i] == value) {
                position = i;
                break;
            }
        }
        System.out.println(position);
        return position;
    }
}


