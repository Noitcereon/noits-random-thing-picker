package me.noitcereon.functionality;

import java.util.ArrayList;
import java.util.List;

public class TestData {
    public static List<String> getEvenAmountNamesWithoutDuplicates(){
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
    public static List<String> getOddAmountNamesWithoutDuplicates(){
        List<String> names = new ArrayList<>();
        names.add("Susanne");
        names.add("Michael");
        names.add("Hjalte");
        names.add("Kari");
        names.add("Thomas");
        names.add("Freja");
        names.add("Noah");
        names.add("Jacob");
        names.add("Henry");
        return names;
    }
}
