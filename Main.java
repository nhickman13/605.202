import StackStuff.Stack;

public class Main {
  public static void main(String[] args) {
    Stack myStack = new Stack();
    // Use myStack to perform various operations following this line
    System.out.println("Push:   " + myStack.push("a"));
    System.out.println("Push:   " + myStack.push("b"));
    System.out.println("Push:   " + myStack.push("c"));
    System.out.println("Push:   " + myStack.push("d"));
    System.out.println("Pop:    " + myStack.pop());
    System.out.println("Peek:   " + myStack.peek());
    System.out.println("Peek:   " + myStack.peek());
    System.out.println("Length: " + myStack.length());
    System.out.println("Empty:  " + myStack.isEmpty());
    System.out.println("Pop:    " + myStack.pop());
    System.out.println("Pop:    " + myStack.pop());
    System.out.println("Pop:    " + myStack.pop());
    System.out.println("Length: " + myStack.length());
    System.out.println("Empty:  " + myStack.isEmpty());

  
  }
}