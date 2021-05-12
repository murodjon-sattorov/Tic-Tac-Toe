package com.murodjon_sattorov.tictactoe.ai;

import android.util.Log;
import android.widget.ImageView;

public class ImagesAndScores {
    int score;
    ImageView iv;
    String name;
    String TAG = "ImagesANDScores";

    ImagesAndScores(int score, ImageView iv, String name) {
        this.score = score;
        Log.d(TAG, "Score: " + score + "Box : " + name);
        this.iv = iv;
        this.name = name;
    }
}
