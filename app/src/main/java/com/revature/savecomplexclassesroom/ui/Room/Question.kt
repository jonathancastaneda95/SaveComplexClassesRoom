package com.revature.savecomplexclassesroom.ui.Room

data class Question(

     var nType:Int=0,
     var question:String="",
     var answers:MutableList<Answer> =mutableListOf() )