package com.revature.savecomplexclassesroom.ui.Room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface QuizDao {
    @Query("SELECT * FROM quiz")
    fun fetchAllQuiz(): LiveData<List<Quiz>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuiz(quiz: Quiz):Long
    @Query("DELETE FROM quiz WHERE id=:id")
    suspend fun deleteQuiz(id:Int)

}