package com.revature.savecomplexclassesroom.ui.Room

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData

class QuizRepository(application: Application) {
    private var quizDao: QuizDao

    init {
        var dataBase= AppDataBase.getDataBase(application)
        quizDao=dataBase.quizDao()
    }
    suspend fun deleteQuiz(id:Int){
        quizDao.deleteQuiz(id)
    }
    suspend fun insertQuiz(quiz: Quiz):Long{
        return quizDao.insertQuiz(quiz)
        Log.d("jcstn","Inside insert quiz :$quiz")
    }
    val fetchAllQuiz:LiveData<List<Quiz>> = quizDao.fetchAllQuiz()
}