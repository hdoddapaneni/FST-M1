package activities;

import java.util.HashMap;

public class Activity11 {
    public static void main(String[] args){
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"green");
        map.put(2,"red");
        map.put(3,"yellow");
        map.put(4,"white");
        map.put(5,"black");
        System.out.println(map);
        map.remove(4);
        System.out.println(map);
        if(map.containsValue("white")){
            System.out.println("value is present");
        }
        else {
            System.out.println("color is not present");
        }
        System.out.println("Size of the map"+map.size());
    }
}
