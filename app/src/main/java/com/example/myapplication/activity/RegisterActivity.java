package com.example.myapplication.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.database.AppDatabase;
import com.example.myapplication.database.DataUser;
import com.example.myapplication.database.DataUserDAO;
import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterActivity extends AppCompatActivity {

    private Button btnLogin, btnRegister;
    private EditText etName, etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        btnRegister = findViewById(R.id.btn_register);

        etName = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataUser dataUser = new DataUser();
                dataUser.setName(etName.getText().toString());
                dataUser.setEmail(etEmail.getText().toString());
                dataUser.setPassword(etPassword.getText().toString());

                if (validation(dataUser)){
                    AppDatabase appDatabase = AppDatabase.iniDb(getApplicationContext());
                    DataUserDAO dataUserDAO = appDatabase.dataUserDAO();
                    dataUserDAO.insertDataUser(dataUser);

                    SharedPreferences sharedPreferences = getSharedPreferences("SAVED_LOGIN", MODE_PRIVATE);
                    SharedPreferences.Editor editor =sharedPreferences.edit();
                    editor.putBoolean("LOGGED",true);
                    editor.putString("USERNAME", etEmail.getText().toString());
                    editor.apply();

                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    RegisterActivity.this.startActivity(intent);
                    finish();
                }
            }
        });


    }


    private Boolean validation(DataUser dataUser){
        if (!dataUser.getName().isEmpty()
                && !dataUser.getEmail().isEmpty()
                && ! dataUser.getPassword().isEmpty()
        ){
            AppDatabase appDatabase = AppDatabase.iniDb(getApplicationContext());
            DataUserDAO dataUserDAO = appDatabase.dataUserDAO();

            DataUser validateEmail = dataUserDAO.checkUser(dataUser.getEmail());
            if (validateEmail !=null){
                Toast.makeText(getApplicationContext(), "Email registered", Toast.LENGTH_SHORT).show();
                return false;
            }else{
                return true;
            }
        }else{
            Toast.makeText(getApplicationContext(), "Fill all fields", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
