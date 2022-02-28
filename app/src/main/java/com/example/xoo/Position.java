package com.example.xoo;

public class Position {
    private int x;
    private int y;

    public Position() {
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public  int getButtonNumber(){
        return ((3*x)+y);
    }
    public static int getButtonNumber(int x,int y){
        return ((3*x)+y);
    }
    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
