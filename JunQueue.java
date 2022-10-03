import java.util.*;

//Guidance Documentation (if interested)
//https://www.tutorialandexample.com/queue-data-structure

public class JunQueue
{
    private String[] queue;
    private int trackQueuePosition;
    
    public static void main(String[] args) {
        System.out.println("Input memory for initial queue");
        
        Scanner userInput = new Scanner(System.in);
        int memory = userInput.nextInt(); // user memory input
        
        //logic to determine initial queue memory capacity and values
        if (memory == 0) {
            JunQueue userList = new JunQueue();
            System.out.println("Your starter queue is: " + Arrays.toString(userList.queue) + "\n");
            
            System.out.println("Let's dive in!");
            userList.queueCommands();
            
        } else if (memory > 0) {
            JunQueue userList = new JunQueue(memory);
            System.out.println("Your starter queue is: " + Arrays.toString(userList.queue) + "\n");
            
            System.out.println("Let's dive in!");
            userList.queueCommands();
            
        } else {
            System.out.println("Invalid memory capacity.");
            return;
        }
    }
    
    public JunQueue() {
        //constructor that takes no parameter but initializes an empty list
        trackQueuePosition = 0;
        queue = new String[1]; // prints null
        queue[0] = null;
    }

    public JunQueue(int memory) {
        //constructor that takes parameter argument
        Scanner userInput = new Scanner(System.in);

        trackQueuePosition = memory;
        queue = new String[memory * 2];
		int i = 0;

		//this shit needs to account for more than 1 or less than 1 character
        while (i < memory) {
            System.out.println("Please input 1 character per memory block in your array. We are at index " + i);
			String value = userInput.next().trim();
			
			if (value.length() == 1){
				queue[i] = value;
				i += 1;
			} else {
				System.out.println("Invalid input. Must be length 1. Try again."); 
			}
        }
    }
    
    public static void queueOperations(){
        System.out.println("Definition:");
        System.out.println("A queue is a data structure in programming. It is similar to the ticket queue outside a cinema hall,"); 
        System.out.println("where the first person entering the queue is the first person who gets the ticket."); 
        System.out.println("It is a FIFO data structure."); 
        System.out.println("Operations:");
        System.out.println("Enqueue: Add an element to the end of the queue.");
        System.out.println("Dequeue: Remove an element from the front of the queue.");
        System.out.println("IsEmpty: Check if the queue is empty.");
        System.out.println("IsFull: Check if the queue is full.");
        System.out.println("Peek: Get the value at the front of the queue without removing it.");
        System.out.println("Count: Count the number of values in the queue.");
        System.out.println("Display: Display all values in the queue.");
        System.out.println("TotalDequeue: Empty out the Queue.\n");
    }
    
    public void queueCommands(){
        System.out.println("Start manipulating your queue. Each command executes one time. You will have to refresh/give command after each command executes one time.");
        System.out.println("When done, input 'done' and the queue will pop to empty. If you need command specifications, input 'specs'.");
        
        
        Scanner userInput = new Scanner(System.in);
        boolean done = false;
        
        //this is the logic to manipulate the queue
        label:
        while (!done) {
            String command = userInput.next().toLowerCase().trim();
            
            if (trackQueuePosition <= queue.length / 4){ //garbage collection if array size is 4x as big as the # of values in it
                    garbageCollection();
                }
            
            switch (command) {
                case "done": // DONE
                    done = true;
                    break label;
                    
                case "specs": // DONE
                    queueOperations();
                    break;
                    
                case "enqueue": // DONE
                    System.out.println("Input character to add to front of the Queue.");
                    String value_to_add = userInput.next();
                    
                    enqueue(value_to_add);
                    System.out.println(Arrays.toString(this.queue));
                    break;
                    
                case "dequeue": // DONE
                    dequeue();
                    System.out.println(Arrays.toString(this.queue));
                    break;
                    
                case "isempty": // DONE
                    isEmpty();
                    System.out.println(isEmpty());
                    break;
                    
                case "isfull": // DONE
                    isFull();
                    System.out.println(isFull());
                    break;
                    
                case "peek": // DONE
                    peek(); 
                    System.out.println(peek());
                    break;

                case "count": // DONE
                    System.out.println(trackQueuePosition);
                    break;
                    
                case "display": // DONE
                    display(); 
                    break;
                
                case "totaldequeue": // DONE
                    totalDequeue();
                    break;
                
                default:
                    System.out.println("That is not an option. Please input 'specs' if you need clarification on what you can call.");
                    System.out.println("Remember each command executes only one time.");
                    break;
            }
        }
    }
    
	//________________________________THIS IS THE START OF THE QUEUE METHODS__________________________________________
    
    public void garbageCollection(){
        if (trackQueuePosition == 0){
            queue = new String[1]; // prints null
            queue[0] = null;
        }
        else{
            String[] newqueue = new String[trackQueuePosition * 2];
            System.arraycopy(queue, 0, newqueue, 0, trackQueuePosition);
            this.queue = newqueue;
            }
        }
    
    public void enqueue(String value) {
        //creates list twice as big when necessary
        if (value.length() != 1) {
            System.out.println("Not valid input. Must be 1 character only.");
            return;
        }
        
        if (trackQueuePosition == queue.length) {
            String[] newQueue = new String[queue.length * 2];
            System.arraycopy(queue, 0, newQueue, 0, queue.length);
            this.queue = newQueue;
        }
        
        this.queue[trackQueuePosition] = value;
        trackQueuePosition += 1;
    }
    
    public String dequeue(){
        String upNext = this.queue[0];
        if (trackQueuePosition > 0) {
           for (int i = 0; i < trackQueuePosition - 1; i++){
               this.queue[i] = this.queue[i + 1];
           }
           trackQueuePosition -= 1;
           this.queue[trackQueuePosition] = null;
           return upNext;
        } else {
            System.out.println("Queue is empty.");
            return "Queue is empty.";
        }
    }
    
    public boolean isEmpty(){
        if (trackQueuePosition == 0){
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isFull(){
        if (trackQueuePosition == queue.length){
            return true;
        } else {
            return false;
        }
    }
    
    public String peek(){
        if (trackQueuePosition > 0){
            return this.queue[0];
        } else {
            return "queue is empty.";
        }
    }
    
    public void display(){
        if (trackQueuePosition > 0) {
            for (int i = 0; i < trackQueuePosition; i++){
                System.out.println(this.queue[i]);
            } 
        } else {
            System.out.println("Can't display. queue is empty.");
        }
    }
    
    public void totalDequeue(){
        if (trackQueuePosition == 0){
            return;
        } else {
            for (int i = 0; i < trackQueuePosition; i++){
                System.out.println(this.queue[i]);
                }
            trackQueuePosition = 0;
            this.queue = new String[1]; // prints null
            this.queue[0] = null;
        }
    }
}