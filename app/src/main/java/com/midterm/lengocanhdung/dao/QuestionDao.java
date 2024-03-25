package com.midterm.lengocanhdung.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.midterm.lengocanhdung.model.Question;

import java.util.List;
@Dao
public interface QuestionDao {
    @Query("SELECT * FROM Question")
    List<Question> getAll();
    @Insert
    void insert(Question... questions) ; //Có thể truyền 1 hoặc nhiều contact
    @Query("DELETE FROM Question WHERE id = :questionId")
    void deleteById(int questionId);

    @Update
    void update(Question contact);
}
