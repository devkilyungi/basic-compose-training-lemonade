package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme
import com.example.lemonade.ui.theme.LightCyan
import com.example.lemonade.ui.theme.Yellow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LemonadeApp() {
    HomeScreen()
}

@Composable
fun HomeScreen() {
    Column {
        AppBar(
            modifier = Modifier
                .fillMaxWidth()
                .background(Yellow)
        )

        MainContent(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(align = Alignment.Center)
        )
    }
}

@Composable
fun AppBar(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.height(48.dp)
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun MainContent(modifier: Modifier = Modifier) {
    var currentScreen by remember { mutableStateOf(1) }

    val imageResource = when (currentScreen) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val textResource = when (currentScreen) {
        1 -> R.string.step_1
        2 -> R.string.step_2
        3 -> R.string.step_3
        else -> R.string.step_4
    }

    val contentDescription = when (currentScreen) {
        1 -> R.string.lemon_tree_content_description
        2 -> R.string.lemon_content_description
        3 -> R.string.glass_of_lemonade_content_description
        else -> R.string.empty_glass_content_description
    }

    val timesToSqueeze = (2..4).random()
    var squeezes = 0

    Column(modifier = modifier) {
        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(LightCyan),
            shape = RoundedCornerShape(16.dp),
            onClick = {
                when (currentScreen) {
                    2 -> {
                        squeezes++
                        // if squeezes == timesToSqueeze go to next screen
                        // otherwise remain in same screen
                        if (squeezes == timesToSqueeze) currentScreen++ else currentScreen = 2
                    }
                    // if we're in the last screen,
                    // reset the screens to the first one
                    4 -> currentScreen = 1
                    // go to next screen for screens 1 and 3
                    else -> currentScreen++
                }
            }
        ) {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = stringResource(id = contentDescription)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = stringResource(id = textResource), fontSize = 16.sp
        )
    }

}