package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    private TextView textView_joke;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        textView_joke = findViewById(R.id.textView_joke);
        Intent intent = getIntent();
        textView_joke.setText(intent.getStringExtra("joke"));
        // unpack the intent
        // put the joke into the text view
    }
}
