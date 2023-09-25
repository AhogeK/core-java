/**
 * This program displays a greeting for the reader.
 *
 * @author Cay Horstmann
 * @version 1.30 2014-02-27
 */
public class Welcome {
    public static void main(String[] args) {
        String greeting = "Welcome to Core Java!";
        System.out.println(greeting);
        // for (int i = 0; i < greeting.length(); i++)
        //     System.out.print("=");
        // Just try JDK21 new feature repeat.
        System.out.print("=".repeat(greeting.length()));
        System.out.println();
    }
}
