package ahogek.corejava.demo;

enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

/**
 * @author AhogeK ahogek@gmail.com
 * @since 2024-09-25 16:50:02
 */
public class NewSwitchDemo {

    public static void main(String[] args) {
        // no fallthrough switch statement
        Day day = Day.SUNDAY;
        switch (day) {
            case MONDAY -> System.out.println("Mondays are bad.");
            case FRIDAY -> System.out.println("Fridays are better.");
            case SATURDAY, SUNDAY -> System.out.println("Weekends are best.");
            default -> System.out.println("Midweek days are so-so.");
        }

        // no fallthrough switch expression
        int numLetters = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> {
                System.out.println("Six letters.");
                yield 6;
            }
            case TUESDAY -> 7;
            case THURSDAY, SATURDAY -> 8;
            case WEDNESDAY -> 9;
        };
        System.out.println(numLetters);

        // fallthrough switch statement
        switch (day) {
            case MONDAY:
                System.out.println("Mondays are bad.");
                break;
            case FRIDAY:
                System.out.println("Fridays are better.");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Weekends are best.");
                break;
            default:
                System.out.println("Midweek days are so-so.");
        }

        // fallthrough switch expression
        numLetters = switch (day) {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                System.out.println("Six letters.");
                yield 6;
            case TUESDAY:
                System.out.println("Seven letters.");
                yield 7;
            case THURSDAY:
            case SATURDAY:
                System.out.println("Eight letters.");
                yield 8;
            case WEDNESDAY:
                System.out.println("Nine letters.");
                yield 9;
            default:
                throw new IllegalStateException("Invalid day: " + day);
        };
        System.out.println(numLetters);
    }
}