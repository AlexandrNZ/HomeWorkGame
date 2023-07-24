package org.example;

public class Spearman extends Infantrys {


    public Spearman(String name, int strength, int speed, int sleight, int stamina, int determination, int defense, int vulnerability, int damage, int x, int y, String state, int mobility){
        super(name, strength, speed, sleight, stamina, determination, defense, vulnerability, damage, x, y, state, mobility);

    }

    public Spearman(String name, int x, int y){
        super(name, 10, 8, 9, 7, 7, 7, 7, 1, x, y," Stand", 8);

    }

    @Override
    public String toString(){
        return String.format("Копейщик name: %s \nstrength: %d \nsleight: %d \ndamage: %d \nx: %d \ny: %d ", name, strength, sleight, damage, coordinate.x, coordinate.y);
    }


    public int doCrusialHit(){ //критический удар
        return strength;
    }

    @Override
    public String getInfo(){
        return "Копейщик" + " " + name + " " + "x: " + coordinate.x + " " +"y: " + coordinate.y+ " " + "инициатива" + " " + sleight;
    }







}