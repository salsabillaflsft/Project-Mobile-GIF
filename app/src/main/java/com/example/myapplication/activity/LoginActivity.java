package com.example.myapplication.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.database.AppDatabase;
import com.example.myapplication.database.DataUser;
import com.example.myapplication.database.DataUserDAO;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {
    private Button btnLogin, btnRegister;
    private EditText etEmail,etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(intent);
                finish();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String email = etEmail.getText().toString();
                    String password = etPassword.getText().toString();
                    if (email.isEmpty() || password.isEmpty()){
                        if (email.isEmpty()){
                            etEmail.setError("Required");
                        }
                        if (password.isEmpty()){
                            etPassword.setError("Required");
                        }
                    }else{
                        AppDatabase appDatabase = AppDatabase.iniDb(getApplicationContext());
                        DataUserDAO dataUserDAO = appDatabase.dataUserDAO();
                        DataUser dataUser = dataUserDAO.checkLogin(email,password);
                        if (dataUser == null){
                            Toast.makeText(getApplicationContext(), "Email atau Password salah", Toast.LENGTH_SHORT).show();
                        }else{
                            SharedPreferences sharedPreferences = getSharedPreferences("SAVED_LOGIN",MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putBoolean("LOGGED",true);
                            editor.putString("EMAIL", email);
                            editor.apply();

                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            LoginActivity.this.startActivity(intent);
                            finish();
                        }
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}
