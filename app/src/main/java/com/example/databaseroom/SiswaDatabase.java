package com.example.databaseroom;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


/**
 * Created by Azhar Rivaldi on 06/05/2020.
 */

@Database(entities = {KelasModel.class, SiswaModel.class}, version = 2)
public abstract class SiswaDatabase extends RoomDatabase {

    public abstract KelasDao kelasDao();

    private static SiswaDatabase INSTANCE;

    // Membuat method return untuk membuat database
    public static SiswaDatabase createDatabase(Context context){
        synchronized (SiswaDatabase.class){
            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context, SiswaDatabase.class, "db_siswa")
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }
        return INSTANCE;
    }
}
