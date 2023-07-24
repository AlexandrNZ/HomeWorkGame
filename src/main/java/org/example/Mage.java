package org.example;

public class Mage extends Magicians {

    public Mage(String name, int strength, int speed, int sleight, int stamina, int determination, int defense, int vulnerability, int damage, int x, int y, String state, int mana, int knowledge){
        super(name, strength, speed, sleight, stamina, determination, defense, vulnerability, damage,x, y, state, mana, knowledge);

    }

    public Mage(String name, int x, int y){
        super(name, 10, 5, 5, 3, 3, 3, 3, 1, x, y, "Stand", 10, 10);
    }

    @Override
    public String toString(){
        return String.format("Маг name: %s \nstrength: %d \nsleight: %d \ndamage: %d \nx: %d \ny: %d ", name, strength, speed, sleight, stamina, determination, defense, vulnerability, damage, coordinate.x, coordinate.y, mana, knowledge);
    }

    public int destructiveMantra(){ // разрушающее заклинание
        return strength;
    }

    public String getInfo(){
        return "Маг" + " " + name + " " + "x: " + coordinate.x + " " +"y: " + coordinate.y+ " " + "инициатива" + " " + sleight;
    }

}