package com.example.pratica2_compose_tutorial

import android.os.Bundle
import android.view.Display
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pratica2_compose_tutorial.ui.theme.Pratica2compose_tutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pratica2compose_tutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Display(
                        stringResource(R.string.tutorial_title),
                        stringResource(R.string.tutorial_subtitle),
                        stringResource (R.string.tutorial_description))
                }
            }
        }
    }
}

@Composable
fun Display(title: String, subtitle: String, tutorialDescription: String, modifier: Modifier = Modifier) {
    val tutorialImage = painterResource(R.drawable.bg_compose_background)
    Column {
        Image(
            painter = tutorialImage,
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = modifier
                .padding(16.dp)
        )
        Text(
            text = subtitle,
            textAlign = TextAlign.Justify,
            modifier = modifier
                .padding(16.dp)
        )
        Text(
            text = tutorialDescription,
            textAlign = TextAlign.Justify,
            modifier = modifier
                .padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Pratica2compose_tutorialTheme {
        Display(
            stringResource(R.string.tutorial_title),
            stringResource(R.string.tutorial_subtitle),
            stringResource (R.string.tutorial_description))
    }
}