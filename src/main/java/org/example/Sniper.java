package org.example;
import java.util.ArrayList;
public class Sniper extends Shooters {



    public Sniper(String name, int strength, int speed, int sleight, int stamina, int determination, int defense, int vulnerability, int damage, int x, int y, String state, int firing_range, int arrays){
        super(name, strength, speed, sleight, stamina, determination, defense, vulnerability, damage, x, y, state, firing_range, arrays);

    }

    public Sniper(String name, int x, int y){
        super(name, 10, 8, 10, 8, 8, 8, 8, 1, x, y, "Stand", 10, 10 );


    }

    @Override
    public String toString(){
        return String.format("Снайпер name: %s \nstrength: %d \nsleight: %d \ndamage: %d \nx: %d \ny: %d \narrays: %d ", name, strength, sleight, damage, coordinate.x, coordinate.y, arrays);
    }


    public int destractionSingleTargets(){ //уничтожение одиночных целей
        strength +=1;
        return strength;
    }

    public int useAmmunition(){ //использование патронов
        arrays -=1;
        return arrays;
    }

    @Override
    public String getInfo(){
        return "Снайпер" + " " + name + " " + "x: " + coordinate.x + " " +"y: " + coordinate.y+ " " + "инициатива" + " " + sleight;
    }

    @Override
    public void step(ArrayList <Unit> list1, ArrayList <Unit> list2) {
        System.out.println("Ходит" + " " + getInfo());
        if (getStrength() == 0 || arrays == 0) {
            System.out.println(getName() + " израсходовал силы или стрелы " + "состояние " + state);
            return;
        }
        Unit currentEnemy = findClosestEnemy(list2);
        if (currentEnemy.getState() == "Dead"){
            System.out.println("Ближайший враг мертв " + currentEnemy.getName());
            return;
        }
        System.out.println(getInfo() + " атакует " + currentEnemy.getInfo() + " " + currentEnemy.state);
        doAttack(currentEnemy);
        state = "Attack";

        for (Unit unit: list1){
            if(unit instanceof Countryman && unit.state == "Stand"){
                arrays+=1;
                unit.state = "Busy";
                System.out.println(getInfo() + " получил стрелы от " + unit.getInfo() + " крестьянин "  + unit.state);
                return;
            }


        }
        arrays--;
        System.out.println("Количесиво стрел " + arrays);
    }

}