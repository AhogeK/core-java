package ahogek.corejava.demo;

import java.util.List;

/**
 * @author AhogeK ahogek@gmail.com
 * @since 2024-09-25 09:34:48
 */
public class CharDemo {

    public static void main(String[] args) {
        String emoji = "\uD83D\uDE0A"; // 😊
        System.out.println(emoji);
        char high = '\uD83D';
        char low = '\uDE0A';
        if (Character.isSurrogate(high) && Character.isSurrogate(low)) {
            int codePoint = Character.toCodePoint(high, low);
            System.out.println("Unicode code point: " + Integer.toHexString(codePoint).toUpperCase());
        }


        int codePoint = 0x1F600;

        if (codePoint >= 0x10000 && codePoint <= 0x10FFFF) {
            int highSurrogate = ((codePoint - 0x10000) >> 10) + 0xD800;
            int lowSurrogate = ((codePoint - 0x10000) & 0x3FF) + 0xDC00;

            System.out.printf("码点: U+%X\n", codePoint);
            System.out.printf("高代理: U+%X\n", highSurrogate);
            System.out.printf("低代理: U+%X\n", lowSurrogate);
        } else {
            System.out.println("码点不在代理范围内。");
        }

        printLength("Hello, World!");

        String name = "AhogeK";
        int age = 26;

        String message = STR."Hello, \{name}! You are \{age} years old.";
        System.out.println(message);
    }

    public static void printLength(Object obj) {
        switch (obj) {
            case String s -> System.out.println("字符串长度: " + s.length());
            case List<?> list -> System.out.println("列表长度: " + list.size());
            default -> System.out.println("不是字符串也不是列表");
        }
    }
}
