package com.murodjon_sattorov.tictactoe.ai;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.murodjon_sattorov.tictactoe.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class AiFriendActivity extends AppCompatActivity {

    private static final String TAG = "TTTAiFriendActivity";

    private TextView firstPersonName, secondPersonName, countP1, countP2;
    private ImageView image00, image01, image02, image10, image11, image12, image20, image21, image22;
    private String player, playerName;

    boolean PLAYER_X = true;
    int TURN_COUNT = 0;
    int[][] boardStatus = new int[3][3];

    private int countPerson1;
    private int countPerson2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(1);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        setContentView(R.layout.activity_game_ai);

        initComponents();

        player = getIntent().getStringExtra("player");
        playerName = getIntent().getStringExtra("firstPlayerName");
        firstPersonName.setText(playerName);
        secondPersonName.setText("AI");
        Log.d(TAG, "onCreate: " + player);
        Log.d(TAG, "onCreate: " + playerName);

        initializeBoardStatus();

    }

    private void initComponents() {
        image00 = findViewById(R.id.image00);
        image01 = findViewById(R.id.image01);
        image02 = findViewById(R.id.image02);
        image10 = findViewById(R.id.image10);
        image11 = findViewById(R.id.image11);
        image12 = findViewById(R.id.image12);
        image20 = findViewById(R.id.image20);
        image21 = findViewById(R.id.image21);
        image22 = findViewById(R.id.image22);

        countP1 = findViewById(R.id.countP1);
        countP2 = findViewById(R.id.countP2);
        firstPersonName = findViewById(R.id.first_person_name);
        secondPersonName = findViewById(R.id.second_person_name);

    }

    private void initializeBoardStatus() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardStatus[i][j] = -1;
            }
        }
    }

    private void setInfo(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void playButtonClick(View view) {
        Log.d(TAG, "Inside onClick");

        if (player.equals("X")) {
            clickXImg(view);

        } else if (player.equals("O")) {
//            clickOImg(view);

        }
    }
    Random random = new Random();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void clickXImg(View view) {
        switch (view.getId()) {
            case R.id.image00:
                if (PLAYER_X) {
                    image00.setImageDrawable(getDrawable(R.drawable.x_latter));
                    boardStatus[0][0] = 1;
                }
        }
    }




}
