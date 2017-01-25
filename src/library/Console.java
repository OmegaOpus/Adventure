package library;
import java.io.*;

public class Console {

  private static BufferedReader console =
    new BufferedReader(new InputStreamReader(System.in));

  public static void printPrompt(String prompt) {
    System.out.print(prompt + " ");
    System.out.flush();
  }
   
  public static String readLine() {
    String r = "";
    try {
      r = console.readLine();
    } catch(IOException e) { r = null; }
    return r;
  }

 public static String readLine(String prompt) {
   printPrompt(prompt);
   return readLine();
 }

 public static int readInt(String prompt) throws NumberFormatException {
   printPrompt(prompt);
   return Integer.valueOf(readLine().trim()).intValue();
 }

 public static double readDouble(String prompt) throws NumberFormatException {
   printPrompt(prompt);
   return Double.valueOf(readLine().trim()).doubleValue();
 }
}

