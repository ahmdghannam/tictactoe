package com.example.xoo;

public class PositionsArray {

    private Position[] arr =new Position[5];;
    private int toAdd;

    public void add (Position position){
        arr[toAdd++]=position;
    }

    public boolean isWon(){

        int []count = {0,0,0,0};
        Position toCompare=arr[toAdd-1];

        // to check the needed buttons only when checking diagonals
        boolean compareMainDiagonalCondition=toCompare.getX()==toCompare.getY();
        boolean compareSecondaryDiagonalCondition=toCompare.getX()+toCompare.getY()==2;

        for (int i = 0; i < toAdd - 1; i++) {
            // rows
            if (arr[i].getX()==toCompare.getX())count[0]++;
            // columns
            if (arr[i].getY()==toCompare.getY())count[1]++;
            //main diagonal
            if (compareMainDiagonalCondition&&(arr[i].getY()==arr[i].getX()))count[2]++;
             //secondary diagonal
            if (compareSecondaryDiagonalCondition&&(arr[i].getY()+arr[i].getX()==2))count[3]++;
        }

        // if any circumstance of win match
        for (int c:count) if (c==2)return true;

        // if no winner yet
        return false;
    }
    public boolean addThenCheckWin(Position position){
        add(position);
        return isWon();
    }

}
