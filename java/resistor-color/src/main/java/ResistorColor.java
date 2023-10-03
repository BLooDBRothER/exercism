import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

class ResistorColor {
    ArrayList<String> colors = new ArrayList<>(Arrays.asList("black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"));
    int colorCode(String color) {
        return colors.indexOf(color);
    }

    String[] colors() {
        return colors.toArray(new String[1]);
    }
}
