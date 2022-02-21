package com.example.xoo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public abstract class MainActivity extends AppCompatActivity {
     private boolean O =true,finished=false;
     Button btn[];
     TextView tv;
    private AlertDialog.Builder ad;
    int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RtoXML();
        onClickListeners();
    }
    private void RtoXML() {
        tv=findViewById(R.id.reset);
        tv.setVisibility(View.GONE);
        btn=new Button[9];
        btn[0]=findViewById(R.id.button);
        btn[1]=findViewById(R.id.button1);
        btn[2]=findViewById(R.id.button2);
        btn[3]=findViewById(R.id.button3);
        btn[4]=findViewById(R.id.button4);
        btn[5]=findViewById(R.id.button5);
        btn[6]=findViewById(R.id.button6);
        btn[7]=findViewById(R.id.button7);
        btn[8]=findViewById(R.id.button8);
    }
    private void onClickListeners() {
        tv.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   reset();

               }
           });
        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnClick(0,btn);
//                Toast.makeText(MainActivity.this, "it works", Toast.LENGTH_SHORT).show();
            }
        });
        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnClick(1,btn);
//                Toast.makeText(MainActivity.this, "it works", Toast.LENGTH_SHORT).show();
            }
        });
        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnClick(2,btn);
//                Toast.makeText(MainActivity.this, "it works", Toast.LENGTH_SHORT).show();
            }
        });
        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnClick(3,btn);
//                Toast.makeText(MainActivity.this, "it works", Toast.LENGTH_SHORT).show();
            }
        });
        btn[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnClick(4,btn);
//                Toast.makeText(MainActivity.this, "it works", Toast.LENGTH_SHORT).show();
            }
        });
        btn[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnClick(5,btn);
//                Toast.makeText(MainActivity.this, "it works", Toast.LENGTH_SHORT).show();
            }
        });
        btn[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnClick(6,btn);
//                Toast.makeText(MainActivity.this, "it works", Toast.LENGTH_SHORT).show();
            }
        });
        btn[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnClick(7,btn);
//                Toast.makeText(MainActivity.this, "it works", Toast.LENGTH_SHORT).show();
            }
        });
        btn[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnClick(8,btn);
//                Toast.makeText(MainActivity.this, "it works", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void reset() {

        ad=new AlertDialog.Builder(MainActivity.this);
        ad.setMessage("do you want to reset the game ?");
        ad.setTitle("alert !");
        ad.setCancelable(true);

        ad.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                counter=0;
                O =true;
                for (int i = 0; i < 9; i++) {
                    btn[i].setText(String.valueOf(i+1));
            }
                tv.setVisibility(View.GONE);
            }
        });


        ad.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog=ad.create();
        dialog.show();


        }
    public void btnClick(int n, Button[] btn){
        try{
        if(!btn[n].getText().toString().equalsIgnoreCase("x")&&!btn[n].getText().toString().equalsIgnoreCase("o")&&!finished()&&!won(btn)){
           if (O) {
               btn[n].setText("o");
               counter++;
           }
           else{
               btn[n].setText("X");
               counter++;
           }
            O =!O;
           if(counter>=5)
             if(won(btn)){
                 finished=true;
                 tv.setVisibility(View.VISIBLE);
                if (O) Toast.makeText(this, "X won", Toast.LENGTH_LONG).show();
                else Toast.makeText(this, "O won", Toast.LENGTH_LONG).show();

            }
            else if(finished()){
                finished=true;
                 tv.setVisibility(View.VISIBLE);
                Toast.makeText(this, "the game just finished", Toast.LENGTH_LONG).show();
            }
       }
        else
            if(!finished)
             Toast.makeText(this, "this card has been taken", Toast.LENGTH_SHORT).show();
       }catch (Exception c){
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
        }

    }
    public boolean finished() {
        return counter==9;
    }
    public boolean won(Button btn[]) {
//        char Character=btn[0].getText().toString().charAt(0);

        if((btn[0].getText().toString().equals(btn[1].getText().toString()) && btn[0].getText().toString().equals(btn[2].getText().toString())
        ||(btn[3].getText().toString().equals(btn[4].getText().toString()) && btn[3].getText().toString().equals(btn[5].getText().toString())
         ||(btn[6].getText().toString().equals(btn[7].getText().toString()) && btn[6].getText().toString().equals(btn[8].getText().toString())
          || btn[0].getText().toString().equals(btn[3].getText().toString()) && btn[0].getText().toString().equals(btn[6].getText().toString())
                ||(btn[1].getText().toString().equals(btn[4].getText().toString()) && btn[1].getText().toString().equals(btn[7].getText().toString())
                ||(btn[2].getText().toString().equals(btn[5].getText().toString()) && btn[2].getText().toString().equals(btn[8].getText().toString())
                ||(btn[0].getText().toString().equals(btn[4].getText().toString()) && btn[0].getText().toString().equals(btn[8].getText().toString())
                ||(btn[2].getText().toString().equals(btn[4].getText().toString()) && btn[2].getText().toString().equals(btn[6].getText().toString())
        )))))))){
//            Toast.makeText(this, "inside won", Toast.LENGTH_SHORT).show();
        return true;
        }
        else{
//        Toast.makeText(this, "inside won", Toast.LENGTH_SHORT).show();
            return false;
              }
    }

}