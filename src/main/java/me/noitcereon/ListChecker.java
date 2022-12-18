package me.noitcereon;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListChecker {
    private ListChecker(){
        // Hide default constructor.
    }
    public static boolean containsDuplicates(List<String> list){
        Set<String> aSet = new HashSet<>();
        for(String listItem : list){
            if(!aSet.add(listItem)){
                return true;
            }
        }
        return false;
    }
}
