package com.king.learn.attendence.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.king.learn.attendence.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("LoginActivity");
        final EditText usernameInput = (EditText) findViewById(R.id.username_input);
        final EditText passwordInput = (EditText) findViewById(R.id.password_input);
        Button loginButton = (Button) findViewById(R.id.login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameText = usernameInput.getText().toString();
                String passwordText = passwordInput.getText().toString();
                if(usernameText.equals("android") && passwordText.equals("1234")) {
                    SharedPreferences sp = getSharedPreferences("login", Context.MODE_PRIVATE);
                    sp.edit()
                            .putString("username", usernameText)
                            .apply();
                    Intent intent = new Intent();
                    intent.putExtra("username", usernameText);
                    setResult(MainActivity.LOGIN_REQUEST, intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Login failed! Your login name or password is wrong!", Toast.LENGTH_SHORT);
                }
            }
        });
    }
}
