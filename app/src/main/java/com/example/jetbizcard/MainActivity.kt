package com.example.jetbizcard

import android.icu.text.ListFormatter.Width
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetbizcard.ui.theme.JetBizCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            JetBizCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard() {
    val buttonClickedState = remember {
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(390.dp)
                .padding(12.dp),
            elevation = 4.dp,
            shape = RoundedCornerShape(CornerSize(15.dp)),
            backgroundColor = Color.White
        ) {

            Column(
                modifier = Modifier.height(300.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularImageView(
                    modifier = Modifier
                        .size(150.dp)
                        .padding(5.dp)
                )
                Divider()
                Info()
                Button(onClick = {
                    buttonClickedState.value = !buttonClickedState.value
                }) {
                    Text(
                        text = "Portfolio",
                        style = MaterialTheme.typography.button
                    )
                }

                if (buttonClickedState.value) {
                    Content()
                } else {
                    Box() {

                    }
                }
            }
        }
    }
}


@Composable
fun Portfolio(data: List<String>) {
    LazyColumn {
        items(data) { item ->

            Card(
                modifier = Modifier
                    .padding(13.dp)
                    .fillMaxWidth(),
                shape = RectangleShape,
                elevation = 4.dp
            ) {
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .background(MaterialTheme.colors.surface)
                        .padding(16.dp)
                ) {
                    CircularImageView(
                        modifier = Modifier
                            .size(100.dp)
                            .padding(5.dp)
                    )
                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                            .align(Alignment.CenterVertically)
                    ) {
                        Text(text = item, fontWeight = FontWeight.Bold)
                        Text(text = "A great project", style = MaterialTheme.typography.body2)
                    }
                }
            }

        }
    }

}

@Composable
fun Content() {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Surface(
            modifier = Modifier
                .padding(3.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            shape = RoundedCornerShape(corner = CornerSize(5.dp)),
            border = BorderStroke(width = 2.dp, color = Color.LightGray)
        ) {
            Portfolio(data = listOf("Porfolio 1", "Porfolio 2", "Porfolio 3"))
        }
    }
}

@Composable
private fun Info() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Miles p.",
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.primaryVariant
        )
        Text(
            text = "Android Compose Programmer",
            modifier = Modifier.padding(4.dp)
        )

        Text(
            text = "@themileCopose",
            modifier = Modifier.padding(4.dp),
            style = MaterialTheme.typography.subtitle1
        )
    }
}

@Composable
private fun CircularImageView(modifier: Modifier) {
    Surface(
        modifier = modifier,
        shape = CircleShape,
        border = BorderStroke(0.5.dp, color = Color.LightGray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.usr),
            contentDescription = "userimage",
            modifier = Modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )

    }
}

/*
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetBizCardTheme {
        CreateBizCard()
    }
}*/
