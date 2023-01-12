package com.example.myapplication

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
             myapplication()
            }
        }
    }
}

@Composable
fun myapplication(){
    var countDoller by remember {
        mutableStateOf(0)
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFb2dfdb)

    ) {
        Column(modifier = Modifier, verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "$ "+"$countDoller", modifier = Modifier,
                fontWeight = FontWeight.Bold,fontSize = 40.sp) //Text(text = "$100",Modifier.padding(10.dp))
            Spacer(modifier = Modifier.height(50.dp))
            CreateCircle(countDoller){
                    newValue->
                countDoller=newValue
            }
            if(countDoller>5) {
                Spacer(modifier = Modifier .height(25.dp))
                Text(text = "Siuuuuuu",fontSize = 20.sp, modifier = Modifier, fontWeight = FontWeight.Bold, color = Color.Red )
            }
            Spacer(modifier = Modifier.height(50.dp))
            Reset(countDoller){
                            countDoller=0
            }

        }

    }
}


//@Preview
@Composable
fun CreateCircle(moneycount:Int=0,updateCountDoller:(Int)->Unit){

    Card(modifier = Modifier
        .padding(3.dp)
        .size(120.dp)
        ,
        backgroundColor = Color(0xFF81c784), elevation = 20.dp, shape = CircleShape ) {
        Box(modifier =Modifier.clickable {
            updateCountDoller(moneycount + 1)
        }, contentAlignment = Alignment.Center ) {
            Text(text = "+", modifier = Modifier, fontSize = 50.sp, fontWeight = FontWeight.Bold)

        }

    }








}
@Composable
fun Reset(dollerValue1:Int =0,resetToZero:(Int)->Unit){
    Card(modifier = Modifier
        .padding(3.dp)
        .size(70.dp)
        ,
        backgroundColor = Color(0xFFb71c1c), elevation = 20.dp, shape = CircleShape ) {
        Box(modifier =Modifier.clickable {
            resetToZero(dollerValue1)
        }, contentAlignment = Alignment.Center ) {
            Text(text = "Reset", modifier = Modifier, fontSize = 20.sp, color = Color.White, fontWeight = FontWeight.Bold)

        }

    }

}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
    myapplication()
    }
}