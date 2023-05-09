package java11;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JavaCollections {
    public static void main(String[] args) {
        //Immutable Collections:
        // Empty List
        List.of();

        // Easy initialisation of list, array-based List
        // implementation (if more than 2 elements, check out the docs )
        final List<String> immutableList = List.of("String1", "String2");
        // The line below would throw the exception: Exception in thread
        // "main" java.lang.UnsupportedOperationException:
        // immutableList.add("String3");

        // Empty map
        Map.of();

        // Easy initialisation of map, array-based Map implementation
        Map.of("My key1", 1, "My Key2", 2);

        // Mutable Collections
        // Not great, this way might end up creating up to 3 arrays
        List<String> mutableList = new ArrayList<>(List.of("String1"));

        // This will work
        mutableList.add("String4");
    }
}