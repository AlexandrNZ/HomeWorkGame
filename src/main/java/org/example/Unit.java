
package org.example;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Random;
import java.util.Collections;



public abstract class Unit implements InGameInterface {

    public String name;
    public int strength; //сила
    public int speed; //скорость
    public int sleight; // ловкость
    public int stamina; // выносливость
    public int determination; //решительность
    public int defense; // защита
    public int vulnerability; //уязвимость
    public int damage; //максимальные повреждения
    public String state;

    public Coordinate coordinate;


    public static boolean isDied;

    public Unit(String name, int strength, int speed, int sleight, int stamina, int determination, int defense, int vulnerability, int damage, int x, int y, String state) {
        this.name = name;
        this.strength = strength;
        this.speed = speed;
        this.sleight = sleight;
        this.stamina = stamina;
        this.determination = determination;
        this.defense = defense;
        this.vulnerability = vulnerability;
        this.damage = damage;
        this.coordinate = new Coordinate(x, y);
        this.state = state;
    }

    public static boolean isDied() {
        return isDied;
    }

    public String getName() {
        return String.format("name: %s", name);
    }

    public int getStrength() {
        return strength;
        // return String.format("Сurrent strength indicator: %d", strength);
    }

    public String getSpeed() {
        return String.format("Сurrent speed indicator: %d", speed);
    }

    public int getSleight() {
        return sleight;
    }

    public String getStamina() {
        return String.format("Сurrent stamina indicator: %d", stamina);
    }

    public String getDetermination() {
        return String.format("Сurrent determination indicator: %d", determination);
    }

    public String getDefence() {
        return String.format("Сurrent defense indicator: %d", defense);
    }

    public String getVulnerability() {
        return String.format("Сurrent vulnerability indicator: %d", vulnerability);
    }

    public String getState() {
        return state;
    }


    public void doAttack(Unit target) {
        //int damage = 1;
        target.getDamage(damage);
    }

    public void getDamage(int damage) {
        if (this.strength - damage > 0) {
            this.strength -= damage;
            System.out.println("Остаток силы" + strength);
        } else {
            isDied = true;
            state = "Dead";
            strength = 0;
            System.out.println(getInfo() + "Состояние" + state);
        }
    }


    public String getInfo() {
        return name + " " + "x: " + coordinate.x + " " + "y: " + coordinate.y + " " + " инициатива " + " " + sleight;
    }


    public Unit findClosestEnemy(ArrayList<Unit> list) {
        double closestDistance = 1000;
        int index = 0;
        Unit closestEnemy = null;
        for (int i = 0; i < list.size(); i++) {

            if (coordinate.calculateDistance(list.get(i).coordinate) < closestDistance) {
                closestDistance = coordinate.calculateDistance(list.get(i).coordinate);
                index = i;
                closestEnemy = list.get(index);
            }
        }
        System.out.println("Ближайший враг " + list.get(index).name + " " + "индекс " + index + " " + "находящийся на дистанции " + closestDistance);
        return closestEnemy;
    }
}



    

    
    