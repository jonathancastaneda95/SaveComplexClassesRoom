package com.revature.savecomplexclassesroom

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.revature.savecomplexclassesroom.ui.Room.Answer
import com.revature.savecomplexclassesroom.ui.Room.Question
import com.revature.savecomplexclassesroom.ui.Room.Quiz
import com.revature.savecomplexclassesroom.ui.Room.QuizRepository
import com.revature.savecomplexclassesroom.ui.theme.SaveComplexClassesRoomTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SaveComplexClassesRoomTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val quiz= Quiz(title = "Title", shortDescription = "short")
                    val question=Question(question = "question example")
                    val answer= Answer(sAnswer = "sample answer")
                    question.answers.add(answer)
                    quiz.questionList.add(question)
                    quiz.tagList.add("tag")
                    quiz.tagList.add("list")
                    val q = QuizRepository(this.application)
                    val scope= rememberCoroutineScope()
                    var a =q.fetchAllQuiz.observeAsState()
                    Column() {
                        Greeting("Android")
                        Button(onClick = {scope.launch {q.insertQuiz(quiz)  } }) {
                            Text(text = "Add")
                        }
                        Button(onClick = {

                         }) {
                            Text(text = "Get")
                        }
                        Button(onClick = {
                            Log.d("jcstn","${a}")
                        }) {
                            Text(text = "Log")
                        }

                    }


                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SaveComplexClassesRoomTheme {
        Greeting("Android")
    }
}