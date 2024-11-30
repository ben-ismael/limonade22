package com.example.limonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.limonade.ui.theme.LimonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LimonadeTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun StepUIDesign(modifier: Modifier) {
    var currentIndex by remember { mutableStateOf(1) }
    var qeezetapcount by remember { mutableStateOf(1) }

    var step_text = when(currentIndex){
        1->R.string.instruction_tree
        2->R.string.instruction_lemon
        3->R.string.instruction_lemonade
        4->R.string.instruction_empty_glass
        else->R.string.instruction_lemon
    }
    var imageresourse = when(currentIndex){
        1->R.drawable.lemon_tree
        2->R.drawable.lemon_squeeze
        3->R.drawable.lemon_drink
        4->R.drawable.lemon_restart
        else->R.drawable.lemon_tree

    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id= imageresourse),

            modifier = Modifier.wrapContentSize() .background(color = Color(0xFF03DAC5)).clickable {
                  when(currentIndex){
                1-> {
                    qeezetapcount = (1..6).random()
                    currentIndex += 1
                }
                2->{
                   if(qeezetapcount==0){
                       currentIndex += 1
                   }

                else {
                    qeezetapcount--
                }
                }
                3->{
                    currentIndex += 1
                }

                4-> {
                    currentIndex=1
                }


                }


            },
                    contentDescription = "1",
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = stringResource(id = step_text))
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    LimonadeTheme {
        StepUIDesign(modifier = Modifier.fillMaxSize().wrapContentSize())
    }
}
