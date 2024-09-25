package ahogek.corejava.demo;

/**
 * @author AhogeK ahogek@gmail.com
 * @since 2024-09-25 16:41:27
 */
public class BreakLabelDemo {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int target = 5;
        boolean found = false;

        search:
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt == target) {
                    found = true;
                    break search;
                }
            }
        }

        if (found) {
            System.out.println("Found!");
        } else {
            System.out.println("Not found!");
        }
    }
}
