package com.example.myapplication.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface DataUserDAO {
    @Insert
    Long insertDataUser(DataUser DataUser);

    /*@Query("SELECT * FROM user_db")
    List<DataUser> getAllDataUser();

    @Query("SELECT * FROM user_db WHERE id = :id")
    DataUser selectUser(int id);*/

    @Query("SELECT * FROM user_db WHERE email = :email")
    DataUser checkUser(String email);

    @Query("SELECT * FROM user_db WHERE email = :email AND password = :password")
    DataUser checkLogin(String email, String password);

    @Update
    int updateDataUser(DataUser DataUser);

    @Query("DELETE FROM user_db WHERE email = :email")
    void deleteDataUser(String email);
}
