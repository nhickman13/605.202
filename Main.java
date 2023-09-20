import StackStuff.Stack;
import StackStuff.Conversions;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner terminal = new Scanner(System.in);
    String filePath = "/Users/nickhickman/Projects/Java/605.202/input.txt";
    String output = "";


//Input of file path.
    System.out.println("Enter file path: ");
    String terminalInput = terminal.nextLine();

    //Scanning through lines in file.
    File inputFile = new File(filePath);
    Scanner myReader = new Scanner(inputFile);

    //Setting up file output -- in progress
    try {
      File outputFile = new File("output.txt");
      if (outputFile.createNewFile()) {
        System.out.println("File created: " + outputFile.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    while (myReader.hasNextLine()) {
      String data = myReader.nextLine();
      switch (data.substring(0,4)) {
        case "poin":
          output = Conversions.postfixToInfix(data.substring(5));
          System.out.println(output);
          break;
        case "popr":
          output = Conversions.postfixToPrefix(data.substring(5));
          System.out.println(output);
          break;
        case "prin":
          System.out.println("Case 3");
          break;
        case "prpo":
          System.out.println("Case 4");
          break;
        case "inpr":
          output = Conversions.infixToPrefix(data.substring(5));
          System.out.println(output);
          break;
      }
    }






  }
}