package com.rommansabbir.composelearning.gridview

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rommansabbir.composelearning.gridview.ui.theme.ComposeLearningTheme

class GridViewActivity : ComponentActivity() {
    companion object {
        data class TestModel(val id: Int)
    }

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

fun getTestModels(): MutableList<GridViewActivity.Companion.TestModel> {
    val list = mutableListOf<GridViewActivity.Companion.TestModel>()
    for (item in 900..2000) {
        list.add(GridViewActivity.Companion.TestModel(item))
    }
    return list
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun EntryView() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .fillMaxHeight(),
        color = MaterialTheme.colors.background
    ) {
        val context = LocalContext.current
        val list: MutableList<GridViewActivity.Companion.TestModel> = getTestModels()
        val onItemClick: (GridViewActivity.Companion.TestModel) -> Unit = {
            Toast.makeText(context, it.id.toString(), Toast.LENGTH_SHORT).show()
        }
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 16.dp)
        ) {
            itemsIndexed(list) { item, index ->
                ShowTestModel(model = list[item], onItemClick)
            }
        }
    }
}

@Composable
fun ShowTestModel(
    model: GridViewActivity.Companion.TestModel,
    itemClick: (GridViewActivity.Companion.TestModel) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable(enabled = true) { itemClick.invoke(model) },
        shape = RoundedCornerShape(4.dp),
        backgroundColor = Color.Gray
    ) {
        Text(
            text = "TestModel Object, ID: " + model.id.toString(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            textAlign = TextAlign.Center,
            color = Color.Blue
        )
    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ComposeLearningTheme {
        EntryView()
    }
}