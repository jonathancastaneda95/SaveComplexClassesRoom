package com.revature.savecomplexclassesroom.ui.Room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quiz")
data class Quiz(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,

    val questionList: MutableList<Question> = mutableListOf<Question>(),

    val resourceList: MutableList<String> = mutableListOf<String>(),

    val tagList: MutableList<String> = mutableListOf<String>(),

    var title: String ="",

    var shortDescription: String ="",

    var longDescription: String ="",
)