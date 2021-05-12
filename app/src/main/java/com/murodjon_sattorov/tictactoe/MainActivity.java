package com.murodjon_sattorov.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;

import com.murodjon_sattorov.tictactoe.ai.AiFriendActivity;
import com.murodjon_sattorov.tictactoe.friend.GameFriendActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TTTMainActivity";
    private View player_o_visibility, player_x_visibility;
    private RadioButton playerO, playerX;
    private Button clickContinue;
    String player = "";
    String firstPlayerName, secondPlayerName;

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
        setContentView(R.layout.activity_main);

        firstPlayerName = getIntent().getStringExtra("inputFirstName");
        secondPlayerName = getIntent().getStringExtra("inputSecondName");

        loadUi();
        selectCategory();
        setClickContinue();

    }

    private void loadUi() {
        player_o_visibility = findViewById(R.id.player_o_visibility);
        player_x_visibility = findViewById(R.id.player_x_visibility);
        playerO = findViewById(R.id.playerO);
        playerX = findViewById(R.id.playerX);
        clickContinue = findViewById(R.id.click_continue);
    }

    private void selectCategory() {
        clickContinue.setClickable(false);
        playerO.setOnClickListener(v -> {
            player = "O";
            playerX.setChecked(false);
            player_x_visibility.setVisibility(View.VISIBLE);
            player_o_visibility.setVisibility(View.INVISIBLE);
            setClickContinue();
            clickContinue.setBackgroundResource(R.drawable.click_btn_ai);
            clickContinue.setTextColor(Color.WHITE);
            Log.d(TAG, "selectCategory: " + player);
        });
        playerX.setOnClickListener(v -> {
            player = "X";
            playerO.setChecked(false);
            player_o_visibility.setVisibility(View.VISIBLE);
            player_x_visibility.setVisibility(View.INVISIBLE);
            setClickContinue();
            clickContinue.setBackgroundResource(R.drawable.click_btn_ai);
            clickContinue.setTextColor(Color.WHITE);
            Log.d(TAG, "selectCategory: " + player);
        });
        player_o_visibility.setOnClickListener(v -> {
            player = "O";
            playerO.setChecked(true);
            playerX.setChecked(false);
            player_x_visibility.setVisibility(View.VISIBLE);
            player_o_visibility.setVisibility(View.INVISIBLE);
            setClickContinue();
            clickContinue.setBackgroundResource(R.drawable.click_btn_ai);
            clickContinue.setTextColor(Color.WHITE);
            Log.d(TAG, "selectCategory: " + player);
        });
        player_x_visibility.setOnClickListener(v -> {
            player = "X";
            playerX.setChecked(true);
            playerO.setChecked(false);
            player_o_visibility.setVisibility(View.VISIBLE);
            player_x_visibility.setVisibility(View.INVISIBLE);
            setClickContinue();
            clickContinue.setBackgroundResource(R.drawable.click_btn_ai);
            clickContinue.setTextColor(Color.WHITE);
            Log.d(TAG, "selectCategory: " + player);
            Log.d(TAG, "selectCategory: " + firstPlayerName);
            Log.d(TAG, "selectCategory: " + secondPlayerName);
        });

    }

    private void setClickContinue() {
        if (player.equals("")) {
            clickContinue.setClickable(false);
        } else {
            clickContinue.setOnClickListener(v -> {
                Intent intent;
                if (secondPlayerName.equals("null")){
                    intent = new Intent(this, AiFriendActivity.class);
                    intent.putExtra("player", player);
                    intent.putExtra("firstPlayerName", firstPlayerName);
                }else {
                    intent = new Intent(this, GameFriendActivity.class);
                    intent.putExtra("player", player);
                    intent.putExtra("firstPlayerName", firstPlayerName);
                    intent.putExtra("secondPlayerName", secondPlayerName);
                }
                startActivity(intent);
            });
        }
    }

}