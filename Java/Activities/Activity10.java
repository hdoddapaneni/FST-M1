package activities;

import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args){
        HashSet<String> hs = new HashSet<>();
        hs.add("Name1");
        hs.add("Name2");
        hs.add("Name3");
        hs.add("Name4");
        hs.add("Name5");
        System.out.println(hs.size());
        hs.remove("Name1");
        hs.remove("Name6");
        if(hs.contains("Name3"))
        {
            System.out.println("It is present in the set");
        }
        else {
            System.out.println("It is not present in the set");
        }
        for(String name : hs){
            System.out.println(name);
        }
    }
}
