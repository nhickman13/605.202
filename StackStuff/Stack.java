package StackStuff;
import java.util.ArrayList; // import the ArrayList class

public class Stack {
    ArrayList<String> stack = new ArrayList<String>();
    Integer stackLength = 0;
    String temp = new String();
    Boolean isEmpty = true;
    
    public Stack() {
      return;
    }

    public ArrayList<String> push(String item) {
        stack.add(item);
        ++stackLength;
        return stack;
    }

    public String pop() {
        if (stackLength <= 0) {
            return ("Error: Stack is empty.");
        }
        temp = stack.get(stackLength - 1);
        stack.remove(stackLength - 1);
        --stackLength;
        return temp;
    }

    public String peek() {
        return stack.get(stackLength - 1);
    }

    public Boolean isEmpty() {
        isEmpty = (stackLength > 0) ? false : true;
        return isEmpty;
    }

    public Integer length() {
        return stackLength;
    }
}
