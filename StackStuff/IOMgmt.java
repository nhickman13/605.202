package StackStuff;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IOMgmt {

    public static String Converter(String filePath) throws FileNotFoundException {
        String output = "";
        //Scanning through lines in file.
        File inputFile = new File(filePath);
        Scanner myReader = new Scanner(inputFile);

        PrintWriter outputFile = new PrintWriter("output.txt");

        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            switch (data.substring(0,4)) {
                case "poin":
                    output = Conversions.postfixToInfix(data.substring(5));
                    outputFile.println("Input in Postfix: " + data.substring(5));
                    outputFile.println("Output in Infix: " + output + "\n");
                    break;
                case "popr":
                    output = Conversions.postfixToPrefix(data.substring(5));
                    outputFile.println("Input in Postfix: " + data.substring(5));
                    outputFile.println("Output in Prefix: " + output + "\n");
                    break;
                case "prin":
                    outputFile.println("Case 3: " + data + "\n");
                    break;
                case "prpo":
                    outputFile.println("Case 4: " + data + "\n");
                    break;
                case "inpr":
                    output = Conversions.infixToPrefix(data.substring(5));
                    outputFile.println("Input in Infix: " + data.substring(5));
                    outputFile.println("Output in Prefix: " + output + "\n");
                    break;
                default:
                    output = "Error: Improper process code used. Please use poin, popr," +
                            " prin, prpo, or inpr.";
                    outputFile.println(output + "\n");
            }
        }
        outputFile.close();
        return null;
    }

}
