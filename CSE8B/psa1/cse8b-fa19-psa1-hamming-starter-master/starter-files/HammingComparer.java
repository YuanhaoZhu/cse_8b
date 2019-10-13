import java.io.*;
import java.util.*;
public class HammingComparer {
  public static void main(String[] args) throws IOException {
    final int num = 1000;      
    if (args[0].equalsIgnoreCase("randomLowerCaseString")) {
      Hamming.randomLowercaseString(num);
    }
    if (args[0].equalsIgnoreCase("randomLowerCaseStringII")) {
      Hamming.randomLowercaseStringII(num);
    }
  }
}
