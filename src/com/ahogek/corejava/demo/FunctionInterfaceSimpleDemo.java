package ahogek.corejava.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface StringProcessor {
    String process(String input);
}

/**
 * @author AhogeK ahogek@gmail.com
 * @since 2024-09-25 18:17:19
 */
public class FunctionInterfaceSimpleDemo {
    public static void processStrings(List<String> strings, StringProcessor processor) {
        strings.replaceAll(processor::process);
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Peter", "Paul", "Mary"));
        processStrings(names, String::toUpperCase);
        System.out.println(names);

        processStrings(names, s -> s.toLowerCase());
        System.out.println(names);

        names.stream().map(String::length).forEach(System.out::println);
    }
}
