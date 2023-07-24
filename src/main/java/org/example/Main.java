package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static ArrayList <Unit> list1 = new ArrayList<>();
    public static ArrayList <Unit> list2 = new ArrayList<>();
    public static ArrayList <Unit> allHeroes = new ArrayList<>();
    public static void main(String[] args) {

        for(int i = 1; i <11; i++){
            switch (new Random().nextInt(1, 5)) {
                case 1 -> list1.add(new Sniper(getName(), 1, i));
                case 2 -> list1.add(new Mage(getName(), 1, i));
                case 3 -> list1.add(new Spearman(getName(), 1, i));
                case 4 -> list1.add(new Countryman(getName(), 1, i));
            }
        }

        for(int i = 0; i < list1.size(); i++){
            System.out.println("Команда 1: " + i + " " + list1.get(i).getInfo());
        }

        System.out.println();

        for(int i = 1; i <11; i++){
            switch (new Random().nextInt(1, 5)) {
                case 1 -> list2.add(new Crossbowman(getName(), 10, i));
                case 2 -> list2.add(new Monk(getName(), 10, i));
                case 3 -> list2.add(new Rover(getName(), 10, i));
                case 4 -> list2.add(new Countryman(getName(), 10, i));
            }
        }


        for(int i = 0; i < list2.size(); i++){
            System.out.println("Команда 2: " + i + " " + list2.get(i).getInfo());
        }

        System.out.println();

        allHeroes.addAll(list1);
        allHeroes.addAll(list2);

        allHeroes.sort((o1, o2) -> o2.getSleight() - o1.getSleight());
        for (Unit hero : allHeroes) {
            System.out.println(hero.getInfo());
        }

        Scanner in = new Scanner(System.in);
        while (true){
            View.view();
            in.nextLine();


            for (Unit heroes : allHeroes) {
                heroes.step(list1, list2);;
            }

            if(isTeamDie(list1)){
                System.out.println("Команда 2 выйграла!");
                break;
            }

            if(isTeamDie(list2)){
                System.out.println("Команда 1 выйграла!");
                break;
            }


        }


    }
    private static String getName(){
        return String.valueOf(Name.values()[new Random().nextInt(Name.values().length)]);
    }

    static boolean isTeamDie(ArrayList <Unit> list){
        for(Unit ignored : list){
            if (!Unit.isDied){
                return false;
            }

        }
        return true;
    }
}


