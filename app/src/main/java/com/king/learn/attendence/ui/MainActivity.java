package com.king.learn.attendence.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.king.learn.attendence.R;

public class MainActivity extends AppCompatActivity {

    static final int LOGIN_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("MainActivity", "MainActivity is created!");
        super.onCreate(savedInstanceState);
        setTitle("MainActivity");
        setContentView(R.layout.activity_main);
        if(isLogin() == false) {
            Log.i("MainActivity", "No login");
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivityForResult(intent, LOGIN_REQUEST);
        }
    }

    @Override
    protected void onResume() {
        Log.i("MainActivity", "MainActivity is resumed!");
        super.onResume();
        if(isLogin() == false) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivityForResult(intent, LOGIN_REQUEST);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode != MainActivity.LOGIN_REQUEST) {
            return;
        }
        String username = data.getStringExtra("username");
        TextView text = (TextView) findViewById(R.id.main_text);
        text.setText("Hello " + username);
    }


    private Boolean isLogin() {
        String username = null;
        SharedPreferences sp = getSharedPreferences("login", Context.MODE_PRIVATE);
        username = sp.getString("username", null);
        if(username == null) {
            return false;
        } else {
            return true;
        }
    }
}
