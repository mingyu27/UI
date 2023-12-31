package com.example.hayden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.hayden.databinding.ActivityDialogBinding;
import com.example.hayden.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySecondBinding binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.fromMainActivityTextView.setText(getIntent().getStringExtra("extra"));



        binding.finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        binding.finishWithResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this, ThirdActivity.class).addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT));
            }
        });


    }
}