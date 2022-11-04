package com.rommansabbir.composelearning.dynamicview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.rommansabbir.composelearning.CustomStaggeredVerticalGrid
import com.rommansabbir.composelearning.ui.theme.ComposeLearningTheme

class DynamicViewActivity : ComponentActivity() {
    object Models {
        sealed class DynamicModelID {
            object BASIC : DynamicModelID()
            object JOB_INFO : DynamicModelID()
            object SKILL_SET : DynamicModelID()
            object WEB_LINKS : DynamicModelID()
        }

        open class BaseDynamicModel(val id: DynamicModelID)
        data class DynamicViewModel1(
            val title: String,
            val description: String,
            val image: String
        ) : BaseDynamicModel(DynamicModelID.BASIC)

        data class DynamicViewModel2(val jobTitle: String, val currentCompany: String) :
            BaseDynamicModel(
                DynamicModelID.JOB_INFO
            )

        data class DynamicViewModel3(val skillsSet: MutableList<String>, val bio: String) :
            BaseDynamicModel(
                DynamicModelID.SKILL_SET
            )

        data class DynamicViewModel4(
            val linkedInProfile: String,
            val githubProfile: String,
            val website: String
        ) : BaseDynamicModel(DynamicModelID.WEB_LINKS)
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

@Composable
private fun EntryView() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .fillMaxHeight(),
        color = MaterialTheme.colors.background
    ) {
        Column(modifier = Modifier.fillMaxHeight().fillMaxHeight().background(Color(0xFFf0e7e5))) {
            ShowDynamicViews()
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShowDynamicViews() {
    val list = getDynamicViewMockedData()
    CustomStaggeredVerticalGrid(
        numColumns = 2,
        modifier = Modifier
            .wrapContentHeight()
    ) {
        list.forEachIndexed { index, baseDynamicModel ->
            Column(modifier = Modifier
                .padding(8.dp)
                .wrapContentHeight()) {
                when (index) {
                    0 -> DynamicView1(
                        model = getDynamicViewMockedData()[index] as DynamicViewActivity.Models.DynamicViewModel1
                    )
                    1 -> DynamicView2(
                        model = getDynamicViewMockedData()[index] as DynamicViewActivity.Models.DynamicViewModel2
                    )
                    2 -> DynamicView3(
                        model = getDynamicViewMockedData()[index] as DynamicViewActivity.Models.DynamicViewModel3
                    )
                    3 -> DynamicView4(
                        model = getDynamicViewMockedData()[index] as DynamicViewActivity.Models.DynamicViewModel4
                    )
                    else -> {
                        //ignore
                    }
                }
            }
        }
    }
}

@Composable
fun DynamicView4(model: DynamicViewActivity.Models.DynamicViewModel4) {
    Card(shape = RoundedCornerShape(10.dp)) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = model.linkedInProfile,
                fontSize = 12.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = model.githubProfile,
                fontSize = 12.sp,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = model.website,
                fontSize = 12.sp,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.size(16.dp))
        }
    }
}

@Composable
fun DynamicView2(model: DynamicViewActivity.Models.DynamicViewModel2) {
    Card(shape = RoundedCornerShape(10.dp)) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = model.currentCompany,
                fontSize = 14.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = model.jobTitle,
                fontSize = 12.sp,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Justify
            )
            Spacer(modifier = Modifier.size(16.dp))
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DynamicView3(model: DynamicViewActivity.Models.DynamicViewModel3) {
    Card(shape = RoundedCornerShape(10.dp)) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = model.bio,
                fontSize = 16.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.padding(16.dp))
            val list: MutableList<String> by remember {
                mutableStateOf(model.skillsSet)
            }
            Column {
                Card(modifier = Modifier.padding(8.dp), shape = RoundedCornerShape(8.dp)) {
                    Text(
                        text = list.toString(),
                        fontSize = 14.sp,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
fun DynamicView1(model: DynamicViewActivity.Models.DynamicViewModel1) {
    Card(shape = RoundedCornerShape(10.dp)) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = model.image),
                contentDescription = null,
                modifier = Modifier.size(128.dp)
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = model.title,
                fontSize = 20.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = model.description,
                fontSize = 12.sp,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Justify
            )
            Spacer(modifier = Modifier.size(16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    ComposeLearningTheme {
        EntryView()
    }
}