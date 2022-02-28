package com.example.xoo;

public class PositionsArray {

    private Position[] arr =new Position[5];;
    private int toAdd;

    public void add (Position position){
        arr[toAdd++]=position;
    }

    public boolean isWon(){
        int count=0;
        Position toCompare=arr[toAdd-1];

        // rows
        for (int i = 0; i < toAdd - 1; i++) {
            if (arr[i].getX()==toCompare.getX())count++;
        }
        if (count==2)return true;

        // columns
        count=0;
        for (int i = 0; i < toAdd - 1; i++) {
            if (arr[i].getY()==toCompare.getY())count++;
        }
        if (count==2)return true;

        //main diagonal
        count=0;
        boolean compareMainDiagonalCondition=toCompare.getX()==toCompare.getY();
        if (compareMainDiagonalCondition)
        for (int i = 0; i < toAdd - 1; i++) {
            if (arr[i].getY()==arr[i].getX())count++;
        }
        if (count==2)return true;

        //secondary diagonal
        count=0;
        boolean compareSecondaryDiagonalCondition=toCompare.getX()+toCompare.getY()==2;
        if (compareSecondaryDiagonalCondition)
            for (int i = 0; i < toAdd- 1; i++) {
                if (arr[i].getY()+arr[i].getX()==2)count++;
            }

        return count == 2;
    }
    public boolean addThenCheckWin(Position position){
        add(position);
        return isWon();
    }

}
