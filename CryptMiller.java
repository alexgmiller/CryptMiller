
/*
 * 
 * 
 * This program performs a "Caesar cipher," which is a shift of characters in
 * a message by a given number of letters.  It provides a crude form of
 * encoding to pass along a secret message.
 * The program serves as an example of Strings and the type char.
 * 
 *  
 */
import java.util.*;

public class CryptMiller {
  public static void main(String[] args) {
    Scanner kb = new Scanner(System.in);
    go(kb);
  }

  public static void go(Scanner kb) {
    System.out.println("How many times would you like to use the app?");
    int times = kb.nextInt();
    for (int i = times; i > 0; i--) {
      menu();
      System.out.println("Your choice?");
      char c = kb.nextLine().charAt(0);
      char letter = c;
      if (letter == 'e') {
        System.out.println("Enter a message.");
        String message = kb.nextLine();
        System.out.println("Enter a key.");
        int key = kb.nextInt();
        encrypt(message, key);
      } else if (letter == 'd') {
        System.out.println("Enter a message.");
        String message = kb.nextLine();
        System.out.println("Enter a key.");
        int key = kb.nextInt();
        decrypt(message, key);
      } else {
        System.out.println("Invalid choice. Please choose either \"e\" or \"d\".");
      }
    }
  }

  /*
   * Returns a new string with the letters of the given string shifted
   * forward or backward by the amount equal to the given key.
   * For example, shift("hello", 3) returns "khoor".
   */
  public static String encrypt(String message, int key) {
    String upper = message.toUpperCase();
    String encrypted = "";
    for (int i = upper.length(); i > 0; i--) {
      char letter = upper.charAt(i);
      if (letter >= (int) 'A' && letter <= (int) 'Z') {
        letter = (char) (letter + key);
      } else if (letter > 'Z') {
        letter -= 26;
      } else {
        letter += 26;
      }
      encrypted = encrypted + i;
    }
    System.out.print("The encrypted message is : ");
    return encrypted; // modify it
  }

  /*
   * decrypts the encrypted string using the same key value.
   * For example, decrypt("khoor", 3) returns "hello".
   */
  public static String decrypt(String message, int key) {
    String decrypted = "";
    for (int i = message.length(); i >= 1; i--) {
      char letter = message.charAt(i);
      if (letter >= (int) 'A' && letter <= (int) 'Z') {
        letter = (char) (letter - key);
      } else if (letter > (int) 'A') {
        int difference = 'A' - letter;
        letter = (char) (('A' + difference + 1));
      } else if (letter == (int) ':') {
        decrypted = decrypted + " ";
      } else {
        int difference = 'Z' - letter;
        letter = (char) (('A' + difference + 1));
      }
      decrypted = decrypted + i;
    }
    return decrypted; // modify this line
  }

  /* This method display the menu for the user. refer to the sample output */
  public static void menu() {
    System.out.println("***********************************");
    System.out.println("Enter \"e\" to encrypt your message.");
    System.out.println("Enter \"d\" to decrypt your message.");
    System.out.println("***********************************");
  }
}
