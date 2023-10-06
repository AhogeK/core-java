package ahogek.corejava.v1ch04;

/**
 * @author AhogeK ahogek@gmail.com
 * @since 2023-10-04 22:25:18
 */
public class SwitchDemo {

    public static void main(String[] args) {
        String seasonName = "Spring";
        int numLetters;

        // No Fallthrough
        switch (seasonName) {
            case "Spring" -> {
                System.out.println(
                        "spring time!");
                numLetters = 6;
            }
            case "Summer", "Winter" -> numLetters = 6;
            case "Fall" -> numLetters = 4;
            default -> numLetters = -1;
        }

        System.out.println(numLetters);

        // Fallthrough
        numLetters = switch (seasonName) {
            case "Spring":
                System.out.println(
                        "spring time!");
                yield 6;
            case "Summer", "Winter":
                yield 6;
            case "Fall":
                yield 4;
            default:
                yield -1;
        };
        System.out.println(numLetters);
    }
}
