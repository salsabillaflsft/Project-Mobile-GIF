package com.example.myapplication.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.activity.LoginActivity;
import com.example.myapplication.activity.RegisterActivity;
import com.example.myapplication.activity.UpdateActivity;
import com.example.myapplication.database.AppDatabase;
import com.example.myapplication.database.DataUser;
import com.example.myapplication.database.DataUserDAO;
import com.google.android.material.textfield.TextInputEditText;

public class AccFragment extends Fragment {
    private TextView tvName, tvEmail;
    private Button btnChange, btnLogout, btnDelete;
    //private TextInputEditText etUsername, etName, etPassword1, etPassword2;

    public AccFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_acc, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedPreferences getPreferences = getActivity().getSharedPreferences("SAVED_LOGIN", Context.MODE_PRIVATE);
        String email = getPreferences.getString("EMAIL","DEFAULT");

        AppDatabase appDatabase = AppDatabase.iniDb(getContext());
        DataUserDAO dataUserDAO = appDatabase.dataUserDAO();
        DataUser dataUser = dataUserDAO.checkUser(email);

        tvName = view.findViewById(R.id.tv_name);
        tvName.setText(dataUser.getName());
        tvEmail = view.findViewById(R.id.tv_email);
        tvEmail.setText(dataUser.getEmail());

        btnChange = view.findViewById(R.id.btn_change);
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), UpdateActivity.class);
                startActivity(intent);
            }
        });

        btnDelete = view.findViewById(R.id.btn_terminate);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataUserDAO.deleteDataUser(email);
                SharedPreferences.Editor editor = getPreferences.edit();
                editor.putBoolean("LOGGED",false);
                editor.putString("EMAIL","DEFAULT");
                editor.apply();

                Intent intent = new Intent(v.getContext(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        btnLogout = view.findViewById(R.id.btn_logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getPreferences.edit();
                editor.putBoolean("LOGGED",false);
                editor.putString("EMAIL","DEFAULT");
                editor.apply();

                Intent intent = new Intent(v.getContext(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
    }

    private Boolean validation(DataUser dataUser){
        if (!dataUser.getName().isEmpty()
                && !dataUser.getEmail().isEmpty()
                && ! dataUser.getPassword().isEmpty()
        ){
            AppDatabase appDatabase = AppDatabase.iniDb(this.getContext());
            DataUserDAO dataUserDAO = appDatabase.dataUserDAO();

            DataUser validateUsername = dataUserDAO.checkUser(dataUser.getEmail());
            if (validateUsername !=null){
                Toast.makeText(this.getContext(), "Username has been registered", Toast.LENGTH_SHORT).show();
                return false;
            }else{
                return true;
            }
        }else{
            Toast.makeText(this.getContext(), "Fill all fields", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

}
