package me.noitcereon.fake.data;

import java.util.ArrayList;
import java.util.List;

public class FakeData {
    private FakeData(){
        // Hide the implicit public constructor.
    }
    public static List<String> getNames(){
        List<String> names = new ArrayList<>();
        names.add("Susanne");
        names.add("Michael");
        names.add("Hjalte");
        names.add("Kari");
        names.add("Thomas");
        names.add("Freja");
        names.add("Noah");
        names.add("Jacob");
        return names;
    }
}
