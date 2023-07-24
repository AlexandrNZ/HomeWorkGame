package org.example;

public class Coordinate {

    public int x;
    public int y;

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;

    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public double calculateDistance(Coordinate coordinates) {
        int deltaX = coordinates.getX() - this.x;
        int deltaY = coordinates.getY() - this.y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}