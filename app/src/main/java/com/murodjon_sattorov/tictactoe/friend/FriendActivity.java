package com.murodjon_sattorov.tictactoe.friend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.murodjon_sattorov.tictactoe.MainActivity;
import com.murodjon_sattorov.tictactoe.R;

public class FriendActivity extends AppCompatActivity {

    private EditText inputFirstName, inputSecondName;
    private Button continuee;

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
        setContentView(R.layout.activity_a_i);

        inputFirstName = findViewById(R.id.input_first_name);
        inputSecondName = findViewById(R.id.input_second_name);
        continuee = findViewById(R.id.with_a_friend);
        continuee.setOnClickListener(v->{
            if (inputFirstName.getText().toString().length() > 2 && inputSecondName.getText().toString().length() > 2){
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("inputFirstName", inputFirstName.getText().toString());
                intent.putExtra("inputSecondName", inputSecondName.getText().toString());
                startActivity(intent);
            }
        });

    }
}