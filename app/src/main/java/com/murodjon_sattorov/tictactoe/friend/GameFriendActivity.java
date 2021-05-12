package com.murodjon_sattorov.tictactoe.friend;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.murodjon_sattorov.tictactoe.R;

public class GameFriendActivity extends AppCompatActivity {

    private static final String TAG = "TTTGameAiActivity";
    private String player, firstPlayerName, secondPlayerName;
    private TextView firstPersonNameText, secondPersonNameText, countP1, countP2;
    private ImageView image00, image01, image02, image10, image11, image12, image20, image21, image22;

    boolean PLAYER_X = true;
    int TURN_COUNT = 0;
    int[][] boardStatus = new int[3][3];

    private int countPerson1;
    private int countPerson2;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

        player = (String) getIntent().getCharSequenceExtra("player");
        firstPlayerName = (String) getIntent().getCharSequenceExtra("firstPlayerName");
        secondPlayerName = (String) getIntent().getCharSequenceExtra("secondPlayerName");

        loadUi();
        firstPersonNameText.setText(firstPlayerName);
        secondPersonNameText.setText(secondPlayerName);
        initializeBoardStatus();

        countPerson1 = getIntent().getIntExtra("countP1", countPerson1);
        countPerson2 = getIntent().getIntExtra("countP2", countPerson2);
        countP1.setText(String.valueOf(countPerson1));
        countP2.setText(String.valueOf(countPerson2));

    }

    private void loadUi() {
        firstPersonNameText = findViewById(R.id.first_person_name);
        secondPersonNameText = findViewById(R.id.second_person_name);
        countP1 = findViewById(R.id.countP1);
        countP2 = findViewById(R.id.countP2);
        image00 = findViewById(R.id.image00);
        image01 = findViewById(R.id.image01);
        image02 = findViewById(R.id.image02);
        image10 = findViewById(R.id.image10);
        image11 = findViewById(R.id.image11);
        image12 = findViewById(R.id.image12);
        image20 = findViewById(R.id.image20);
        image21 = findViewById(R.id.image21);
        image22 = findViewById(R.id.image22);
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

    private void checkWinnerX() {

        Log.d(TAG, "Inside checkWinner");

        //Horizontal --- rows
        for (int i = 0; i < 3; i++) {
            if (boardStatus[i][0] == boardStatus[i][1] && boardStatus[i][0] == boardStatus[i][2]) {
                if (boardStatus[i][0] == 1) {
                    countPerson1++;
                    setInfo("Player X winner");
                    saveCount();
                    break;
                } else if (boardStatus[i][0] == 0) {
                    countPerson2++;
                    setInfo("Player 0 winner");
                    saveCount();
                    break;
                }
            }
        }

        //Vertical --- columns
        for (int i = 0; i < 3; i++) {
            if (boardStatus[0][i] == boardStatus[1][i] && boardStatus[0][i] == boardStatus[2][i]) {
                if (boardStatus[0][i] == 1) {
                    countPerson1++;
                    setInfo("Player X winner");
                    saveCount();
                    break;
                } else if (boardStatus[0][i] == 0) {
                    countPerson2++;
                    setInfo("Player O winner");
                    saveCount();
                    break;
                }
            }
        }

        //First diagonal
        if (boardStatus[0][0] == boardStatus[1][1] && boardStatus[0][0] == boardStatus[2][2]) {
            if (boardStatus[0][0] == 1) {
                countPerson1++;
                setInfo("Player X winner");
                saveCount();
            } else if (boardStatus[0][0] == 0) {
                countPerson2++;
                setInfo("Player 0 winner");
                saveCount();
            }
        }

        //Second diagonal
        if (boardStatus[0][2] == boardStatus[1][1] && boardStatus[0][2] == boardStatus[2][0]) {
            if (boardStatus[0][2] == 1) {
                countPerson1++;
                setInfo("Player X winner");
                saveCount();
            } else if (boardStatus[0][2] == 0) {
                countPerson2++;
                setInfo("Player 0 winner");
                saveCount();
            }
        }
    }

    private void checkWinnerO() {

        Log.d(TAG, "Inside checkWinner");

        //Horizontal --- rows
        for (int i = 0; i < 3; i++) {
            if (boardStatus[i][0] == boardStatus[i][1] && boardStatus[i][0] == boardStatus[i][2]) {
                if (boardStatus[i][0] == 1) {
                    countPerson2++;
                    setInfo("Player O winner");
                    saveCount();

                    break;
                } else if (boardStatus[i][0] == 0) {
                    countPerson1++;
                    setInfo("Player X winner");
                    saveCount();
                    break;
                }
            }
        }

        //Vertical --- columns
        for (int i = 0; i < 3; i++) {
            if (boardStatus[0][i] == boardStatus[1][i] && boardStatus[0][i] == boardStatus[2][i]) {
                if (boardStatus[0][i] == 1) {
                    countPerson2++;
                    setInfo("Player O winner");
                    saveCount();
                    break;
                } else if (boardStatus[0][i] == 0) {
                    countPerson1++;
                    setInfo("Player X winner");
                    saveCount();
                    break;
                }
            }
        }

        //First diagonal
        if (boardStatus[0][0] == boardStatus[1][1] && boardStatus[0][0] == boardStatus[2][2]) {
            if (boardStatus[0][0] == 1) {
                countPerson2++;
                setInfo("Player O winner");
                saveCount();
            } else if (boardStatus[0][0] == 0) {
                countPerson1++;
                setInfo("Player X winner");
                saveCount();
            }
        }

        //Second diagonal
        if (boardStatus[0][2] == boardStatus[1][1] && boardStatus[0][2] == boardStatus[2][0]) {
            if (boardStatus[0][2] == 1) {
                countPerson2++;
                setInfo("Player O winner");
                saveCount();
            } else if (boardStatus[0][2] == 0) {
                countPerson1++;
                setInfo("Player X winner");
                saveCount();
            }
        }
    }

    private void saveCount(){
        intent = new Intent(this, GameFriendActivity.class);
        intent.putExtra("countP1", countPerson1);
        intent.putExtra("countP2", countPerson2);
        intent.putExtra("player", player);
        intent.putExtra("firstPlayerName", firstPlayerName);
        intent.putExtra("secondPlayerName", secondPlayerName);
        Log.d(TAG, "saveCount: " + countPerson1);
        Log.d(TAG, "saveCount: " + countPerson2);
        startActivity(intent);
        finish();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void playButtonClick(View view) {
        Log.d(TAG, "Inside onClick");

        if (player.equals("X")) {
            clickXImg(view);

            TURN_COUNT++;
            PLAYER_X = !PLAYER_X;

            if (TURN_COUNT == 9) {
                setInfo("Game Draw");
                recreate();
            }

            checkWinnerX();

        } else if (player.equals("O")) {
            clickOImg(view);

            TURN_COUNT++;
            PLAYER_X = !PLAYER_X;

            if (TURN_COUNT == 9) {
                setInfo("Game Draw");
                recreate();
            }

            checkWinnerO();

        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void clickXImg(View view) {
        switch (view.getId()) {
            case R.id.image00:
                if (PLAYER_X) {
                    //image00.setText("X");
                    image00.setImageDrawable(getDrawable(R.drawable.x_latter));
                    boardStatus[0][0] = 1;
                } else {
                    //image00.setText("0");
                    image00.setImageDrawable(getDrawable(R.drawable.o_latter));
                    boardStatus[0][0] = 0;
                }
                image00.setEnabled(false);
                break;

            case R.id.image01:
                if (PLAYER_X) {
                    //image01.setText("X");
                    image01.setImageDrawable(getDrawable(R.drawable.x_latter));
                    boardStatus[0][1] = 1;
                } else {
                    //image01.setText("0");
                    image01.setImageDrawable(getDrawable(R.drawable.o_latter));
                    boardStatus[0][1] = 0;
                }
                image01.setEnabled(false);
                break;

            case R.id.image02:
                if (PLAYER_X) {
                    //image02.setText("X");
                    image02.setImageDrawable(getDrawable(R.drawable.x_latter));
                    boardStatus[0][2] = 1;
                } else {
                    //image02.setText("0");
                    image02.setImageDrawable(getDrawable(R.drawable.o_latter));
                    boardStatus[0][2] = 0;
                }
                image02.setEnabled(false);
                break;

            case R.id.image10:
                if (PLAYER_X) {
                    //image10.setText("X");
                    image10.setImageDrawable(getDrawable(R.drawable.x_latter));
                    boardStatus[1][0] = 1;
                } else {
                    //image10.setText("0");
                    image10.setImageDrawable(getDrawable(R.drawable.o_latter));
                    boardStatus[1][0] = 0;
                }
                image10.setEnabled(false);
                break;

            case R.id.image11:
                if (PLAYER_X) {
                    //image11.setText("X");
                    image11.setImageDrawable(getDrawable(R.drawable.x_latter));
                    boardStatus[1][1] = 1;
                } else {
                    //image11.setText("0");
                    image11.setImageDrawable(getDrawable(R.drawable.o_latter));
                    boardStatus[1][1] = 0;
                }
                image11.setEnabled(false);
                break;

            case R.id.image12:
                if (PLAYER_X) {
                    //image12.setText("X");
                    image12.setImageDrawable(getDrawable(R.drawable.x_latter));
                    boardStatus[1][2] = 1;
                } else {
                    //image12.setText("0");
                    image12.setImageDrawable(getDrawable(R.drawable.o_latter));
                    boardStatus[1][2] = 0;
                }
                image12.setEnabled(false);
                break;

            case R.id.image20:
                if (PLAYER_X) {
                    //image20.setText("X");
                    image20.setImageDrawable(getDrawable(R.drawable.x_latter));
                    boardStatus[2][0] = 1;
                } else {
                    //image20.setText("0");
                    image20.setImageDrawable(getDrawable(R.drawable.o_latter));
                    boardStatus[2][0] = 0;
                }
                image20.setEnabled(false);
                break;

            case R.id.image21:
                if (PLAYER_X) {
                    //image21.setText("X");
                    image21.setImageDrawable(getDrawable(R.drawable.x_latter));
                    boardStatus[2][1] = 1;
                } else {
                    //image21.setText("0");
                    image21.setImageDrawable(getDrawable(R.drawable.o_latter));
                    boardStatus[2][1] = 0;
                }
                image21.setEnabled(false);
                break;

            case R.id.image22:
                if (PLAYER_X) {
                    //image22.setText("X");
                    image22.setImageDrawable(getDrawable(R.drawable.x_latter));
                    boardStatus[2][2] = 1;
                } else {
                    //image22.setText("0");
                    image22.setImageDrawable(getDrawable(R.drawable.o_latter));
                    boardStatus[2][2] = 0;
                }
                image22.setEnabled(false);
                break;

            default:
                break;

        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void clickOImg(View view) {
        switch (view.getId()) {
            case R.id.image00:
                if (PLAYER_X) {
                    //image00.setText("X");
                    image00.setImageDrawable(getDrawable(R.drawable.o_latter));
                    boardStatus[0][0] = 1;
                } else {
                    //image00.setText("0");
                    image00.setImageDrawable(getDrawable(R.drawable.x_latter));
                    boardStatus[0][0] = 0;
                }
                image00.setEnabled(false);
                break;

            case R.id.image01:
                if (PLAYER_X) {
                    //image01.setText("X");
                    image01.setImageDrawable(getDrawable(R.drawable.o_latter));
                    boardStatus[0][1] = 1;
                } else {
                    //image01.setText("0");
                    image01.setImageDrawable(getDrawable(R.drawable.x_latter));
                    boardStatus[0][1] = 0;
                }
                image01.setEnabled(false);
                break;

            case R.id.image02:
                if (PLAYER_X) {
                    //image02.setText("X");
                    image02.setImageDrawable(getDrawable(R.drawable.o_latter));
                    boardStatus[0][2] = 1;
                } else {
                    //image02.setText("0");
                    image02.setImageDrawable(getDrawable(R.drawable.x_latter));
                    boardStatus[0][2] = 0;
                }
                image02.setEnabled(false);
                break;

            case R.id.image10:
                if (PLAYER_X) {
                    //image10.setText("X");
                    image10.setImageDrawable(getDrawable(R.drawable.o_latter));
                    boardStatus[1][0] = 1;
                } else {
                    //image10.setText("0");
                    image10.setImageDrawable(getDrawable(R.drawable.x_latter));
                    boardStatus[1][0] = 0;
                }
                image10.setEnabled(false);
                break;

            case R.id.image11:
                if (PLAYER_X) {
                    //image11.setText("X");
                    image11.setImageDrawable(getDrawable(R.drawable.o_latter));
                    boardStatus[1][1] = 1;
                } else {
                    //image11.setText("0");
                    image11.setImageDrawable(getDrawable(R.drawable.x_latter));
                    boardStatus[1][1] = 0;
                }
                image11.setEnabled(false);
                break;

            case R.id.image12:
                if (PLAYER_X) {
                    //image12.setText("X");
                    image12.setImageDrawable(getDrawable(R.drawable.o_latter));
                    boardStatus[1][2] = 1;
                } else {
                    //image12.setText("0");
                    image12.setImageDrawable(getDrawable(R.drawable.x_latter));
                    boardStatus[1][2] = 0;
                }
                image12.setEnabled(false);
                break;

            case R.id.image20:
                if (PLAYER_X) {
                    //image20.setText("X");
                    image20.setImageDrawable(getDrawable(R.drawable.o_latter));
                    boardStatus[2][0] = 1;
                } else {
                    //image20.setText("0");
                    image20.setImageDrawable(getDrawable(R.drawable.x_latter));
                    boardStatus[2][0] = 0;
                }
                image20.setEnabled(false);
                break;

            case R.id.image21:
                if (PLAYER_X) {
                    //image21.setText("X");
                    image21.setImageDrawable(getDrawable(R.drawable.o_latter));
                    boardStatus[2][1] = 1;
                } else {
                    //image21.setText("0");
                    image21.setImageDrawable(getDrawable(R.drawable.x_latter));
                    boardStatus[2][1] = 0;
                }
                image21.setEnabled(false);
                break;

            case R.id.image22:
                if (PLAYER_X) {
                    //image22.setText("X");
                    image22.setImageDrawable(getDrawable(R.drawable.o_latter));
                    boardStatus[2][2] = 1;
                } else {
                    //image22.setText("0");
                    image22.setImageDrawable(getDrawable(R.drawable.x_latter));
                    boardStatus[2][2] = 0;
                }
                image22.setEnabled(false);
                break;
            default:
                break;

        }
    }

}