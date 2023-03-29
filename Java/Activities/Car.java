package activities;

 class Car {
    String color;
    String transmission;
    int make;
    int tyres;
    int doors;



public void displayCharacteristics()
{
    System.out.println("doors"+" "+doors);
    System.out.println("tyres"+" "+tyres);
    System.out.println("color"+" "+color);
    System.out.println("transmission"+" "+transmission);
    System.out.println("manufacturing year"+" "+make);
}

public void accelerate()
{
    System.out.println("The car is accelerating");
}

public void brake()
{
    System.out.println("Brake applied");
}

}