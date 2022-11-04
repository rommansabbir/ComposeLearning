package com.rommansabbir.composelearning.dynamicview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rommansabbir.composelearning.ui.theme.ComposeLearningTheme

class DynamicViewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLearningTheme {
                // A surface container using the 'background' color from the theme
                EntryView()
            }
        }
    }
}

@Composable
private fun EntryView() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .fillMaxHeight(),
        color = MaterialTheme.colors.background
    ) {
        Greeting3("Android")
    }
}

@Composable
fun Greeting3(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    ComposeLearningTheme {
        Greeting3("Android")
    }
}