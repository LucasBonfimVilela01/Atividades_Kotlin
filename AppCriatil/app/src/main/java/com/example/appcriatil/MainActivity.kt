package com.example.appcriatil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appcriatil.ui.theme.AppCriatilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "CatalogoActivity", builder ={
                composable("CatalogoActivity",){
                    CatalogoActivity(navController)
                }
                composable("ProdutoActivity",){
                    ProdutoActtivity(navController)
                }
            } )
            AppCriatilTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CatalogoActivity(navController)
                }
            }
        }
    }
}
data class Produto(
    @StringRes val stringNomeId: Int,
    @StringRes val stringPrecoId: Int,
    @DrawableRes val imageId: Int
)
fun loadProdutos(): List<Produto>{
    return listOf<Produto>(
        Produto(R.string.Nome1, R.string.preco1, R.drawable.ralsei),
        Produto(R.string.Nome2, R.string.preco2, R.drawable.uno_braille),
        Produto(R.string.Nome3, R.string.preco3, R.drawable.bluey),
        Produto(R.string.Nome4, R.string.preco4, R.drawable.amongus)
    )
}
val tauri = FontFamily(Font(R.font.tauri_regular))
@Composable
fun CardProduto(produto: Produto, modifier: Modifier = Modifier.padding(12.dp)){
    Modifier.padding(12.dp)
    Card(modifier = modifier.padding(horizontal = 24.dp)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(produto.imageId),
                contentDescription = LocalContext.current.getString(produto.stringNomeId),
                modifier
                    .fillMaxSize()
            )
            Text(
                text = LocalContext.current.getString(produto.stringNomeId),
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 25.sp
            )
            Text(
                text = LocalContext.current.getString(produto.stringPrecoId),
                fontSize = 20.sp
            )
            Button(onClick = {
            },modifier.shadow(10.dp, shape = CircleShape), colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow)) {
                Text(
                    text = "Comprar Agora",
                    color = Color.Black,
                    fontFamily = tauri,
                    fontSize = 25.sp,
                    modifier = modifier
                )
            }
        }
    }
}
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
            DisplayProdutos()
        }
    }
}
@Composable
fun DisplayProdutos(){
    ListProdutos(listProdutos = loadProdutos())
}
@Composable
fun ListProdutos(listProdutos: List<Produto>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(listProdutos) { Produto ->
            CardProduto(
                produto = Produto
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppCriatilTheme {
        Display()
    }
}