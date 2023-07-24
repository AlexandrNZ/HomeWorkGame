package org.example;
import java.util.ArrayList;
public class Countryman extends Infantrys {

    public Countryman(String name, int strength, int speed, int sleight, int stamina, int determination, int defense, int vulnerability, int damage, int x, int y, String state, int mobility){
        super(name, strength, speed, sleight, stamina, determination, defense, vulnerability, damage, x, y, state, mobility);

    }

    public Countryman(String name, int x, int y){
        super(name, 10, 5, 3, 3, 1, 1, 8, 2, x, y, "Stand", 5);

    }

    public String toString(){
        return String.format("крестьянин name: %s \nstrength: %d \nsleight: %d \ndamage: %d \nx: %d \ny: %d ", name, strength, sleight, damage, coordinate.x, coordinate.y);
    }


    public int bringLance(){ //принести копье
        return strength;
    }

    @Override
    public String getInfo(){
        return "Крестьянин" + " " + name + " " + "x: " + coordinate.x + " " +"y: " + coordinate.y+ " " + "инициатива" + " " + sleight;
    }

    @Override
    public void step(ArrayList <Unit> list1, ArrayList <Unit> list2) {
        System.out.println("Ходит" + " " + getInfo());
        if (getStrength() == 0 ) {
            System.out.println(getInfo() + " израсходовал силы " + " состояние " + state);
            return;
        }
        if(state == "Busy"){
            state = "Stand";
            System.out.println((getInfo() + " выполнил работу " + "состояние " + state));
        }


    }


}