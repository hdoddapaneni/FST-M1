package activities;

import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args){
        ArrayList<String> myList = new ArrayList<>();
        myList.add("Name1");
        myList.add("Name2");
        myList.add("Name3");
        myList.add("Name4");
        myList.add("Name5");
        for(String name : myList)
        {
            System.out.println(name);
        }
        if(myList.contains("Name2"))
        {
            System.out.println("List contains name");
        }
        else {
            System.out.println("list doesn't contain name");
        }
        System.out.println(myList.get(3));
        System.out.println("Size of the list" + myList.size());
        myList.remove(3);
        System.out.println("Size of the list" + myList.size());

    }
}
