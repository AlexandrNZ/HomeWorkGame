package org.example;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Infantrys extends Unit {

    public int mobility; //мобильность

    public Infantrys(String name, int strength, int speed, int sleight, int stamina, int determination, int defense, int vulnerability, int damage, int x,  int y, String state, int mobility){
        super(name, strength, speed, sleight, stamina, determination, defense, vulnerability, damage, x, y, state);
        this.mobility = mobility;
    }

    public String getMobility(){
        return String.format("Сurrent mobility indicator: %d", mobility);
    }

    public int doInfighting(){ // ближний бой
        return damage;
    }


    public int doStun(){ // оглушение
        return strength;
    }


    public int doDeflexure(){ //уклонение
        return damage;
    }

    public int doRecce(){ //разведка
        return damage;
    }

    @Override
    public void step(ArrayList <Unit> list1, ArrayList <Unit> list2) {
        System.out.println("Ходит" + " " + getInfo());
        if (getStrength() == 0 ) {
            System.out.println(getInfo() + " израсходовал силы " + " состояние " + state);
            return;
        }
        Unit currentEnemy = findClosestEnemy(list2);
        if (Objects.equals(currentEnemy.getState(), "Dead")){
            System.out.println("Ближайший враг мертв " + currentEnemy.getName());
            currentEnemy.coordinate.getX();
        }
        System.out.println(getInfo() + " атакует " + currentEnemy.getInfo() + " " + currentEnemy.state  );
        doAttack(currentEnemy);
        state = "Attack";

    }
}