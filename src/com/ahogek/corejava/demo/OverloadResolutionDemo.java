package ahogek.corejava.demo;

/**
 * @author AhogeK ahogek@gmail.com
 * @since 2024-10-01 14:17:48
 */
public class OverloadResolutionDemo {

    public static void main(String[] args) {
        OverloadResolutionDemo demo = new OverloadResolutionDemo();
        int i = 10;
        Integer integer = 10;
        demo.method(i); // 精确匹配
        demo.method(integer); // 精确匹配
        demo.method(30L); // 扩展转换
        demo.method(40, 50); // 可变参数
        demo.method("hello"); // 扩展转换
    }

    public void method(int a) {
        System.out.println("int");
    }

    public void method(Integer a) {
        System.out.println("Integer");
    }

    public void method(Object a) {
        System.out.println("Object");
    }

    public void method(int... a) {
        System.out.println("int...");
    }
}
