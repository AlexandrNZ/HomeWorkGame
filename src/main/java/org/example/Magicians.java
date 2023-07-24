package org.example;
import java.util.ArrayList;
public abstract class Magicians extends Unit {

    public int mana; //магия
    public int knowledge; //знания

    public Magicians(String name, int strength, int speed, int sleight, int stamina, int determination, int defense, int vulnerability, int damage, int x, int y, String state,  int mana, int knowledge){
        super(name, strength, speed, sleight, stamina, determination, defense, vulnerability, damage, x, y, state);
        this.mana = mana;
        this.knowledge = knowledge;
    }

    public String getMana(){
        return String.format("Сurrent mana indicator: %d", mana);
    }

    public String getKnowledge(){
        return String.format("Сurrent knowledge indicator: %d", knowledge);
    }

    public int magicAtack(){ //магическая атака
        return strength;
    }


    @Override
    public void step(ArrayList <Unit> list1, ArrayList <Unit> list2) {
        int minStrength = 5;
        Unit currentTeamMate =list1.get(0);
        System.out.println("Ходит" + " " + getInfo());
        if (getStrength() == 0 ) {
            System.out.println(getInfo() + " израсходовал силы " + "состояние " + state);
            return;
        }
        for (Unit unit: list1){
            if (unit.strength < minStrength){
                currentTeamMate = unit;
                System.out.println(getInfo() + " лечит " + currentTeamMate.getInfo());
                currentTeamMate.getDamage(-damage);
                state = "Healing";
                strength++;
                System.out.println(getInfo() + " состояние " + state);
                return;
            }

        }
        Unit currentEnemy = findClosestEnemy(list2);
        if (currentEnemy.getState() == "Dead"){
            System.out.println("Ближайший враг мертв " + currentEnemy.getName());
            return;
        }
        System.out.println(getInfo() + " атакует " + currentEnemy.getInfo() + " " + currentEnemy.state );
        doAttack(currentEnemy);
        state = "Attack";
    }

}