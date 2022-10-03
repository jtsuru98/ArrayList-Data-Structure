//Guidance Documentation (if interested)
//https://medium.com/swift2go/stacks-and-lifo-structures-implementation-and-use-cases-7ada8f8c400

public class JunStack
{
    private String[] stack;
    private int trackStackPosition;

    public JunStack() {
        //constructor that takes no parameter but initializes an empty list
        trackStackPosition = 0;
        stack = new String[1];
    }

    public void push(String value) {
        //creates list twice as big when necessary
        if (value.isEmpty()) {
            return;
        }
        
        if (trackStackPosition == stack.length) {
            String[] newStack = new String[stack.length * 2];
            //Lets not use helper methods like this, cheating in this case. Good practice for simpler code, but cheating
            // in this specific exercise
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            this.stack = newStack;
        }
        
        this.stack[trackStackPosition] = value;
        trackStackPosition += 1;
    }
    
    public String pop(){
        if (trackStackPosition > 0) {
           String toPop = this.stack[trackStackPosition - 1];

           this.stack[trackStackPosition - 1] = null;
           trackStackPosition -= 1;
           
           return toPop; 
        } else {
            return null;
        }
    }
    
    public boolean isEmpty(){
       return trackStackPosition == 0;
    }

    public String peep(){
        if (trackStackPosition > 0){
            return this.stack[trackStackPosition - 1];
        } else {
            return null;
        }
    }

    public void clear(){
        trackStackPosition = 0;
        stack = new String[1];
    }
}
