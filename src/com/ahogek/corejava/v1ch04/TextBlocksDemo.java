package ahogek.corejava.v1ch04;

/**
 * @author AhogeK ahogek@gmail.com
 * @since 2023-10-04 14:42:46
 */
public class TextBlocksDemo {

    public static void main(String[] args) {
        // Using a literal string
        String dqName = "Ahoge Knight";
        System.out.println(dqName);
        // Using a text block
        String tbName = """
                Ahoge Knight""";
        System.out.println(tbName);

        System.out.println(dqName == tbName); // true

        String str = "The old";
        String tb = """
                the new   """;
        System.out.println(str + " and " + tb + "."); // the new back no whitespace

        System.out.println("""
                This is the first line
                  This is the second line
                This is the third line
                """); // a left indent will output
        System.out.println("上面会空两行");
    }
}
