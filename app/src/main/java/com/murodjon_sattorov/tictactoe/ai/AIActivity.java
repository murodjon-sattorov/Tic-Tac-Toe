package com.murodjon_sattorov.tictactoe.ai;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.murodjon_sattorov.tictactoe.MainActivity;
import com.murodjon_sattorov.tictactoe.R;

public class AIActivity extends AppCompatActivity {

    private static final String TAG = "AIActivity";
    private TextView enterName;
    private EditText inputFirstName, inputSecondName;
    private TextInputLayout layout, layout2;
    private Button continuee;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_i);
        enterName = findViewById(R.id.enter_name);
        layout = findViewById(R.id.text);
        layout2 = findViewById(R.id.text2);
        continuee = findViewById(R.id.with_a_friend);
        inputFirstName = findViewById(R.id.input_first_name);
        inputSecondName = findViewById(R.id.input_second_name);
        Log.d(TAG, "onCreate: ");
        layout.setHint("Nickname");
        inputSecondName.setVisibility(View.GONE);
        layout2.setVisibility(View.GONE);
        enterName.setText("Enter your name");

        continuee.setOnClickListener(v -> {
            if (inputFirstName.getText().toString().length() > 2) {
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("inputFirstName", inputFirstName.getText().toString());
                intent.putExtra("inputSecondName", "null");
                startActivity(intent);
            }
        });


    }
}
