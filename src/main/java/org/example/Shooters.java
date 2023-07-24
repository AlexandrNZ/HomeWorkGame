package org.example;
import java.util.ArrayList;

public abstract class Shooters extends Unit {
    public int firing_range; //дальность стрельбы
    public int arrays;


    public Shooters(String name, int strength, int speed, int sleight, int stamina, int determination, int defense, int vulnerability, int damage, int x, int y, String state, int firing_range, int arrays){
        super(name, strength, speed, sleight, stamina, determination, defense, vulnerability, damage, x, y, state );
        this.firing_range = firing_range;
        this.arrays = arrays;
    }


    @Override
    public void step(ArrayList <Unit> list1, ArrayList <Unit> list2) {
        System.out.println("Ходит" + " " + getInfo());
        if (getStrength() == 0 || arrays == 0) {
            System.out.println(getName() + " израсходовал силы или стрелы " + "состояние " + state);
            return;
        }
        Unit currentEnemy = findClosestEnemy(list1);
        if (currentEnemy.getState() == "Dead"){
            System.out.println("Ближайший враг мертв " + currentEnemy.getName());
            return;
        }
        System.out.println(getInfo() + " атакует " + currentEnemy.getInfo() + " " + currentEnemy.state);
        doAttack(currentEnemy);
        state = "Attack";

        for (Unit unit: list2){
            if(unit instanceof Countryman && unit.state == "Stand"){
                arrays+=1;
                unit.state = "Busy";
                System.out.println(getInfo() + " получил стрелы от " + unit.getInfo() + " "  + unit.state);
                return;
            }


        }
        arrays--;
        System.out.println("Количесиво стрел " + arrays);
    }


    public String getInfo(){
        return super.getInfo() + " Количесиво стрел " + arrays;
    }


}