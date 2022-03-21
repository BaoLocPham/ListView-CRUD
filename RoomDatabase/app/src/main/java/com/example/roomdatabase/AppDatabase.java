package com.example.roomdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Animal.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AnimalDAO animalDAO();

    private static AppDatabase INSTANCE;

    public static AppDatabase getDBInstance(Context context){
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "animal_db.db").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
}
