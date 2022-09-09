package com.example.xoo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private boolean isItO = false, finished = false, isWon = false;
    private Button[] btn;
    private TextView resetText;
    private AlertDialog.Builder ad;
    private int counter = 0;
    private PositionsArray xPositions, oPositions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xPositions = new PositionsArray();
        oPositions = new PositionsArray();
        RtoXML();
        onClickListeners();

    }

    private void RtoXML() {
        resetText = findViewById(R.id.reset);
        resetText.setVisibility(View.GONE);
        btn = new Button[9];
        btn[0] = findViewById(R.id.button);
        btn[1] = findViewById(R.id.button1);
        btn[2] = findViewById(R.id.button2);
        btn[3] = findViewById(R.id.button3);
        btn[4] = findViewById(R.id.button4);
        btn[5] = findViewById(R.id.button5);
        btn[6] = findViewById(R.id.button6);
        btn[7] = findViewById(R.id.button7);
        btn[8] = findViewById(R.id.button8);
    }

    private void onClickListeners() {
        resetText.setOnClickListener(view -> reset());

        for (int x = 0; x < 3; x++)
            for (int y = 0; y < 3; y++) {
                int n = Position.getButtonNumber(x, y);
                int finalX = x;
                int finalY = y;
                btn[n].setOnClickListener(view -> btnClick(new Position(finalX, finalY), btn));
            }
    }

    public void reset() {

        ad = new AlertDialog.Builder(MainActivity.this);
        ad.setMessage("do you want to reset the game ?");
        ad.setTitle("alert !");
        ad.setCancelable(true);
        ad.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                counter = 0;
                isItO = false;
                isWon = false;
                finished = false;
                for (int i = 0; i < 9; i++) {
                    btn[i].setText(String.valueOf(i + 1));
                }
                xPositions = new PositionsArray();
                oPositions = new PositionsArray();

                resetText.setVisibility(View.GONE);

            }
        });


        ad.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog = ad.create();
        dialog.show();


    }

    public void btnClick(Position position, Button[] btn) {

        try {
            int n = position.getButtonNumber();
            int IntegerValueOfText = (int) btn[n].getText().toString().charAt(0);
            boolean buttonIsNotClickedBefore = IntegerValueOfText < 58;

            if (!finished && buttonIsNotClickedBefore && !isWon) {

                String XO = isItO ? "o" : "X";
                btn[n].setText(XO);
                if (isItO) oPositions.add(position);
                else xPositions.add(position);
                counter++;

                if (won(btn, isItO)) {
                    resetText.setVisibility(View.VISIBLE);
                    if (isItO) Toast.makeText(this, "O won", Toast.LENGTH_LONG).show();
                    else Toast.makeText(this, "X won", Toast.LENGTH_LONG).show();
                } else if (finished()) {
                    resetText.setVisibility(View.VISIBLE);
                    Toast.makeText(this, "the game just finished", Toast.LENGTH_LONG).show();
                }
                isItO = !isItO;

            } else if (!(buttonIsNotClickedBefore || finished || isWon)) {
                Toast.makeText(this, "this card has been taken", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception c) {
            Toast.makeText(this, c.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    public boolean finished() {
        finished = counter == 9;
        return finished;
    }

    public boolean won(Button[] btn, boolean isItO) {

        if (counter < 5) return false;
        isWon = isItO ? oPositions.isWon() : xPositions.isWon();
        return isWon;
    }
}