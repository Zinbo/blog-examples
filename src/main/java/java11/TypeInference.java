package java11;

public class TypeInference {

    public static void main(String[] args) {
        var hello = "Hello Stack to Basics!";
        // hello = 5; This will not work, hello's type has been inferred as string, it cannot be changed to int
        System.out.println(hello);
    }
}
