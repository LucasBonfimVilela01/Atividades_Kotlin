package com.example.appcriatilpag2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appcriatilpag2.ui.theme.AppCriatilPag2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppCriatilPag2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Display()
                }
            }
        }
    }
}
val tauri = FontFamily(Font(R.font.tauri_regular))
@Composable
fun Display(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            Modifier
                .background(Color(4, 118, 217))
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,

            ) {
            var default by remember { mutableStateOf("Pesquisa") }
            Icon(
                Icons.Default.List,
                contentDescription = "Carrinho",
                tint = Color.White,
                modifier = modifier
                    .height(40.dp)
                    .width(40.dp)
            )
            TextField(
                value = default,
                onValueChange = { default = it },
                maxLines = 1,
                modifier = Modifier
                    .padding(16.dp)
                    .width(200.dp)
                    .height(55.dp),
                textStyle = TextStyle(color = Color.LightGray, fontFamily = tauri, fontSize = 16.sp),
                shape = RoundedCornerShape(32.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(244, 244, 244),
                    unfocusedContainerColor = Color.White,
                    cursorColor = Color.Blue
                )
            )
            Icon(
                Icons.Default.ShoppingCart,
                contentDescription = "Carrinho",
                tint = Color.White,
                modifier = modifier
                    .height(40.dp)
                    .width(40.dp)
            )
            Icon(
                Icons.Default.AccountCircle,
                contentDescription = "Carrinho",
                tint = Color.White,
                modifier = modifier
                    .height(40.dp)
                    .width(40.dp)
            )
        }
        Row {
            DisplayProduto()
        }
    }
}
@Composable
fun DisplayProduto(modifier: Modifier = Modifier){
    Column {
        Row (
            Modifier
                .padding(10.dp)
                .shadow(10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,){
            Image(painter = painterResource(R.drawable.ralsei), contentDescription = null)
        }
        Row(
            Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically){
            Text(
                text = "Pelúcia Ralsei",
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 25.sp
            )
        }
        Column(Modifier.padding(12.dp)) {
            Row {
                Text(
                    text = "4.7K",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 12.sp
                )

                repeat(5) {
                    Icon(
                        Icons.Default.Star,
                        contentDescription = "Carrinho",
                        tint = Color.Yellow,
                        modifier = modifier
                            .height(20.dp)
                            .width(20.dp)
                    )

                }
            }
            Text(
                text = "R$99,99",
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 24.sp
            )
        }
        Column (
            Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally){
            Button(onClick = {},modifier.fillMaxWidth(),colors = ButtonDefaults.buttonColors(containerColor = Color(4, 118, 217))) {
                Row {
                    Text(
                        text = "Adicionar ao Carrinho",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 24.sp
                    )
                    Icon(
                            Icons.Default.ShoppingCart,
                    contentDescription = "Carrinho",
                    tint = Color.White,
                    modifier = modifier
                        .height(40.dp)
                        .width(40.dp)
                    )
                }
            }
            Spacer(modifier.height(10.dp))
            Button(onClick = {},modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow)) {
                Row {
                    Text(
                        text = "Comprar agora!",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 30.sp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppCriatilPag2Theme {
        Display()
    }
}