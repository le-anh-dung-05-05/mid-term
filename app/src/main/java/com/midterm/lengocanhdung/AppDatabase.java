package com.midterm.lengocanhdung;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.midterm.lengocanhdung.dao.QuestionDao;
import com.midterm.lengocanhdung.model.Question;

@Database(entities = {Question.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract QuestionDao questionDao();
    private static AppDatabase instance;
    public static synchronized AppDatabase getInstance(Context context) {
        if(instance == null) {
            instance  = Room.databaseBuilder(context,
                    AppDatabase.class, "Question").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        }
        return instance;
    }
}
