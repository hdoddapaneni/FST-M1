package activities;

public class Activity1 {
    public static void main(String[] args){
        Car Maruthi = new Car();
        Maruthi.doors=4;
        Maruthi.tyres=4;
        Maruthi.transmission="manual";
        Maruthi.make=2022;
        Maruthi.color="White";
        Maruthi.displayCharacteristics();
        Maruthi.accelerate();
        Maruthi.brake();
    }
}
