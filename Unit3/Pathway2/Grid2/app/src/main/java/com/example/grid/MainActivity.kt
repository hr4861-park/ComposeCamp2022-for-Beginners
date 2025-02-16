package com.example.grid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.grid.ui.theme.GridTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    CourseGrid()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GridTheme {
        CourseGrid()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CourseGrid(
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2), modifier = modifier.padding(
            start = 4.dp, top = 4.dp, end = 4.dp, bottom = 4.dp
        )
    ) {
        items(DataSource.topics) { topic -> CourseCard(topic) }
    }
}

@Composable
fun CourseCard(
    topic: Topic, modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(4.dp), elevation = 4.dp
    ) {
        Row {
            Image(
                painter = painterResource(id = topic.imageResourceId),
                contentDescription = null,
                modifier = modifier.size(width = 68.dp, height = 68.dp),
                contentScale = ContentScale.Crop
            )
            Column() {
                Text(
                    text = stringResource(id = topic.titleResourceId),
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(
                        start = 16.dp, top = 16.dp, end = 16.dp, bottom = 8.dp
                    )
                )
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(
                                start = 16.dp
                            )
                            .size(15.dp)
                    )
                    Text(
                        text = topic.available.toString(),
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier.padding(
                            start = 8.dp
                        )
                    )
                }
            }
        }
    }
}