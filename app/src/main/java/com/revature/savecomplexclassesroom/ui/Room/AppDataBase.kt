package com.revature.savecomplexclassesroom.ui.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Quiz::class],version=2, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDataBase: RoomDatabase() {
    abstract fun quizDao(): QuizDao

    companion object{
        @Volatile
        private var INSTANCE: AppDataBase?=null
        fun getDataBase(context: Context): AppDataBase {
            var instance = INSTANCE
            if(instance!=null){
                return instance
            }

            synchronized(this)
            {
                val tempinstance= Room.databaseBuilder(context.applicationContext,
                    AppDataBase::class.java,"QUIZDATA").fallbackToDestructiveMigration().build()
                INSTANCE =tempinstance
                return tempinstance
            }
        }
    }

}