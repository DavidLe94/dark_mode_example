package com.haule.darkmode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnLightMode, btnDarkMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.FeedActivityThemeDark);
        }else{
            setTheme(R.style.FeedActivityThemeLight);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    private void initEvent() {
        btnLightMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                restartApp();
            }
        });

        btnDarkMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                restartApp();
            }
        });
    }

    private void restartApp() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private void initView() {
        btnLightMode = findViewById(R.id.btn_light_mode);
        btnDarkMode = findViewById(R.id.btn_dark_mode);
    }
}
