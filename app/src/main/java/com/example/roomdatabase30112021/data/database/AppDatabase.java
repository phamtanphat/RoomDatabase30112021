package com.example.roomdatabase30112021.data.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;

import com.example.roomdatabase30112021.data.model.entities.WorkEntity;

import java.util.List;
import java.util.Map;

@Database(entities = WorkEntity.class , version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract WordDao wordDao();
    private static AppDatabase instance = null;

    public static AppDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(
                    context,
                    AppDatabase.class,
                    "appDb"
            )
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
