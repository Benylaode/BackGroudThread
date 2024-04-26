package com.example.tugaspraktikum5fahmi;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ProgressBar;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageView ivProfile = findViewById(R.id.iv_profile);
        TextView tvName = findViewById(R.id.tv_name);
        TextView tvUsername = findViewById(R.id.tv_username);
        ProgressBar progressBar = findViewById(R.id.progressBar);

        Intent intent = getIntent();
        MamaliaPurba instagram = intent.getParcelableExtra("mamalia");

        ivProfile.setImageResource(instagram.getFotoProfile());
        tvName.setText(instagram.getName());
        tvUsername.setText(instagram.getUsername());
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.GONE);

                        ivProfile.setVisibility(View.VISIBLE);
                        tvName.setVisibility(View.VISIBLE);
                        tvUsername.setVisibility(View.VISIBLE);

                        Intent intent = getIntent();
                        MamaliaPurba mamalia = intent.getParcelableExtra("mamalia");

                        ivProfile.setImageResource(instagram.getFotoProfile());
                        tvName.setText(instagram.getName());
                        tvUsername.setText(instagram.getUsername());
                    }
                });
            }
        });

    }
}
