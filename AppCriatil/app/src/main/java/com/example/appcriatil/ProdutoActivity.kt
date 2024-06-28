package com.example.appcriatil

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ProdutoActtivity(navController: NavController) {
    Button(
        onClick = {
            navController.navigate("CatalogoActivity")
        },
        Modifier
            .height(30.dp)
            .fillMaxWidth()
            .background(Color(4, 118, 217)),
        colors = ButtonDefaults.buttonColors(containerColor = Color(4, 118, 217)),
        shape = RoundedCornerShape(0.dp)
    ) {
        Text(text = "Voltar", fontSize = 12.sp)
    }
}
