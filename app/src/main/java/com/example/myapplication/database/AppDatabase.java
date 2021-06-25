package com.example.myapplication.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {DataUser.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DataUserDAO dataUserDAO();
    private static AppDatabase appDatabase;

    public static AppDatabase iniDb(Context context){
        if (appDatabase == null){
            appDatabase = Room.databaseBuilder(context, AppDatabase.class, "dbUser")
                    .allowMainThreadQueries()
                    .build();
        }
        return appDatabase;
    }
    public static void destroyInstance(){
        appDatabase = null;
    }
}
