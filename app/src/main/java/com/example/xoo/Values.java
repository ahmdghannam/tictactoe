package com.example.xoo;

import androidx.lifecycle.MutableLiveData;

public class Values {
    private static String firstName = "X";
    private static String secondName = "O";
    public static MutableLiveData<Integer> firstScore=new MutableLiveData<>(0);;
    public static MutableLiveData<Integer> secondScore=new MutableLiveData<>(0);

    public static String changeTheTitleScore() {
        String concatName = getWinner();
        String title = score(concatName);
        return title;
    }

    public static String score(String concatName) {
        String title =
                concatName +" "+ Math.max(firstScore.getValue(), secondScore.getValue()) + " : "+
                        Math.min(firstScore.getValue(), secondScore.getValue()) + "";
        return title;

    }

     public static String getWinner() {
       String winner;
         if (firstScore.getValue() > secondScore.getValue()) winner=firstName;
            else if (firstScore.getValue() < secondScore.getValue()) winner = secondName;
            else winner = "Draw";
        return winner;
    }
    public static void increaseFirstScore() {
        firstScore.setValue(firstScore.getValue()+1);
    }
    public static void increaseSecondScore() {
        secondScore.setValue(secondScore.getValue()+1);
    }


}


