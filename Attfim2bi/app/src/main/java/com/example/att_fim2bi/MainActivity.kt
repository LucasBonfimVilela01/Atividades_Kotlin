package com.example.att_fim2bi/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.att_fim2bi.data.Datasource
import com.example.att_fim2bi.ui.theme.Attfim2BiTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Attfim2BiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProductsApp()
                }
            }
        }
    }
}
@Composable
fun ProductsApp() {
    val banner = painterResource(R.drawable.imagembanner)
    Column {
        Image(
            painter = banner,
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
    }
    Column {
        ProductsDisplay()
    }
}

@Composable
fun ProductsDisplay() {
    ProductsList(
        productList = Datasource().loadProducts(),
    )
}

@Composable
fun ProductCard(product: Product, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(product.imageResourceId),
                contentDescription = stringResource(product.stringNomeId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(product.stringNomeId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = LocalContext.current.getString(product.stringPrecoId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}
@Preview
@Composable
private fun AffirmationCardPreview() {
    ProductCard(Product(R.string.nome1, R.string.preco1,R.drawable.product1))
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductsList(productList: List<Product>, modifier: Modifier = Modifier) {
    LazyColumn(//columns = GridCells.Adaptive(minSize=150.dp),
                modifier = modifier) {
        stickyHeader{
            val banner = painterResource(R.drawable.imagembanner)
            Column {
                Image(
                    painter = banner,
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .shadow(10.dp, shape = RectangleShape, true)
                )

            }
        }
        items(productList) { product ->
            ProductCard(
                product = product,
                modifier = Modifier
                    .padding(8.dp)
                    .safeContentPadding()
            )
        }
    }
}