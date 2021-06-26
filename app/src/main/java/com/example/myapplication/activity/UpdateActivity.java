package com.example.myapplication.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.lang.UProperty;
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
import com.example.myapplication.fragment.AccFragment;

public class UpdateActivity extends AppCompatActivity {

    Button btnChangePass;
    EditText etOldPassword, etNewPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change);

        btnChangePass = findViewById(R.id.btn_changepass);

        etOldPassword = findViewById(R.id.et_oldpassword);
        etNewPassword = findViewById(R.id.et_newpassword);

        btnChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataUser dataUser = new DataUser();
                AppDatabase appDatabase = AppDatabase.iniDb(getApplicationContext());
                DataUserDAO dataUserDAO = appDatabase.dataUserDAO();

                if (!etOldPassword.getText().toString().isEmpty()
                        && !etNewPassword.getText().toString().isEmpty()
                ) {
                    //DataUser checkPass = dataUserDAO.checkPass(etPassword.getText().toString());
                    if (!dataUser.getPassword().equals(etOldPassword.getText().toString())){
                        Toast.makeText(getApplicationContext(), "Password doesn't match", Toast.LENGTH_SHORT).show();
                    }else {
                        if (dataUser.getPassword().equals(etOldPassword.getText().toString())) {
                            DataUser newDataUser = new DataUser();
                            newDataUser.setName(dataUser.getName());
                            newDataUser.setEmail(dataUser.getEmail());
                            newDataUser.setPassword(etNewPassword.getText().toString());
                            dataUserDAO.updateDataUser(newDataUser);
                            Toast.makeText(getApplicationContext(), "Password changed", Toast.LENGTH_SHORT).show();

                            /*Intent intent = new Intent(getApplicationContext(), AccFragment.class);
                            startActivity(intent);
                            finish();
                            //((MainActivity)get()).reload("acc");*/
                        }
                    }

                }else{
                    Toast.makeText(v.getContext(), "Fill All Fields!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
