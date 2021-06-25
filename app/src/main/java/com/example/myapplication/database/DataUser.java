package com.example.myapplication.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_db")
public class DataUser {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "password")
    private String password;

    public int getId() { return id; }

    public void setId(int id) {
            this.id = id;
        }

    public String getName() {
            return name;
        }

    public void setName(String name) {
            this.name = name;
        }

    public String getEmail() {
            return email;
        }
    public void setEmail(String email) {
            this.email = email;
        }
    public String getPassword() {
            return password;
        }
    public void setPassword(String password) {
            this.password = password;
        }
}

