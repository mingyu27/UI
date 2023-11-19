package com.example.hayden;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.hayden.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("SMG", "onCreate");
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult o) {
                Log.d("SMG", "onActivityResult() - callback");
                if (o.getResultCode() == RESULT_OK)
                    binding.resultTextView.setText(o.getData().getStringExtra("result"));
            }
        });





        binding.toDialogActivityButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, DialogActivity.class)));

        binding.toSecondActivityButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, SecondActivity.class)));

        binding.toSecondActivityWithExtraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class).putExtra("extra", "from main activity"));
            }
        });

        binding.toSecondActivityForResultButton.setOnClickListener(v -> {
//                startActivityForResult(new Intent(MainActivity.this, SecondActivity.class)
//                        .putExtra("extra", "from main activity"), 1000);

            launcher.launch(new Intent(MainActivity.this, SecondActivity.class)
                    .putExtra("extra", "from main activity").addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY));
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.d("SMG", "onActivityResult()");
        super.onActivityResult(requestCode, resultCode, data);

//        if(requestCode == 1000 && resultCode == RESULT_OK){
//            binding.resultTextView.setText(data.getStringExtra("result"));
//        }
    }


    @Override
    protected void onDestroy() {
        Log.d("SMG", "onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        Log.d("SMG", "onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("SMG", "onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("SMG", "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("SMG", "onStop");
        super.onStop();
    }



    @Override
    protected void onRestart() {
        Log.d("SMG", "onRestart");
        super.onRestart();
    }

//    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        Log.d("SMG", "onSaveInstanceState");
//        super.onSaveInstanceState(outState);
//        outState.putString("key", binding.inputEditText.getText().toString());
//
//    }
//
//    @Override
//    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//        Log.d("SMG", "onRestoreInstanceState");
//        super.onRestoreInstanceState(savedInstanceState);
//        binding.inputEditText.setText(savedInstanceState.getString("key").toString());
//    }


    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        Log.d("SMG", "onConfigurationChanged");
        //p385참고할것
        super.onConfigurationChanged(newConfig);
    }
}