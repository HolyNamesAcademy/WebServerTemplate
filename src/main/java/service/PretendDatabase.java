package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PretendDatabase {
    private static Map<String, List<String>> categoryToMembers = Map.of(
            "fruits", List.of("apples", "bananas", "pears", "blueberries"),
            "veggies", List.of("broccoli", "spinach", "eggplant")
    );

    public static List<String> getFoodsByCategory(String category) {
        // normally we would reach out to the database here to get this info,
        // but for the sake of the demo we're just getting it from the hash map
        // we defined above.
        if (categoryToMembers.containsKey(category)) {
            return categoryToMembers.get(category);
        }

        return new ArrayList<>();
    }
}
