package ahogek.corejava.v1ch04;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author AhogeK ahogek@gmail.com
 * @since 2023-10-04 18:10:19
 */
public class MyProg {

    public static void main(String[] args) throws IOException {
//        Scanner in = new Scanner(Path.of("myfile.txt"), StandardCharsets.UTF_8);
        Scanner in = new Scanner(System.in);
        if (in.hasNextLine()) {
            System.out.println(in.nextLine());
        }
        in.close();
    }
}
