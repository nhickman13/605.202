import StackStuff.IOMgmt;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
  public static void main(String[] args) throws FileNotFoundException {
    //Create Scanner object to hold terminal input.
    Scanner terminal = new Scanner(System.in);

    //Input of file path.
    System.out.println("Enter file path: ");
    //Default filepath /Users/nickhickman/Projects/Java/605.202/input.txt
    String terminalInput = terminal.nextLine();

    //Calls method to convert all inputs from input text file.
    IOMgmt.Converter(terminalInput);
  }
}
