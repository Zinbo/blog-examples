package java11;

public class Emojis4J {
    public static void main(String[] args) {
        String bear = "🐻";
        int bearCodepoint = bear.codePointAt(bear.offsetByCodePoints(0, 0));
        char[] bearSurrogates = {Character.highSurrogate(bearCodepoint),
                Character.lowSurrogate(bearCodepoint)};
        System.out.println("Value of bearSurrogates: " +
                String.valueOf(bearSurrogates));
    }
}