package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpace(modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun ArtSpace(modifier: Modifier) {
    var artImage by remember {
        mutableIntStateOf(R.drawable.image1)
    }

    var artTitle by remember {
        mutableIntStateOf(R.string.title1)
    }

    var artArtist by remember {
        mutableIntStateOf(R.string.artist1)
    }

    fun changeImage() {
        println((1..2).random())
    }

    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ArtImage(artImage, modifier = Modifier)
        Spacer(modifier.height(32.dp))
        ArtInfo(artTitle, artArtist, modifier = Modifier)
        Spacer(modifier.height(32.dp))
        Row(
            modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            SelectImageButton(
                R.string.button_previous,
                changeImage = {
                    changeImage()
                },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier.width(32.dp))
            SelectImageButton(
                R.string.button_next,
                changeImage = {
                    changeImage()
                },
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun ArtImage(@DrawableRes image: Int, modifier: Modifier) {
    Column(
        modifier
            .padding(horizontal = 16.dp)
            .shadow(2.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null
            )
        }
    }
}

@Composable
fun ArtInfo(@StringRes title: Int, @StringRes artist: Int, modifier: Modifier) {
    Card(
        modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp)
    ) {
        Text(
            text = stringResource(id = title),
            modifier
                .padding(horizontal = 32.dp)
                .padding(bottom = 8.dp)
                .padding(top = 16.dp),
            lineHeight = 24.sp,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = stringResource(id = artist),
            modifier
                .padding(horizontal = 32.dp)
                .padding(bottom = 16.dp)
        )
    }
}

@Composable
fun SelectImageButton(@StringRes buttonLabel: Int, changeImage: (Int) -> Unit, modifier: Modifier) {
    Button(onClick = { /*TODO*/ }, modifier) {
        Text(text = stringResource(id = buttonLabel))
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpace(modifier = Modifier)
    }
}