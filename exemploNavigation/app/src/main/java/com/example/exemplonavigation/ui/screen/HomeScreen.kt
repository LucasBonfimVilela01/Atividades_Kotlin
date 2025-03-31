package com.example.exemplonavigation.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exemplonavigation.data.User

@Composable
fun HomeScreen(user: User) {
    Column (horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        Text(text = "Você está na tela de Home", modifier = Modifier.padding(top = 16.dp))

        Text(
            text = "Olá,  ${user.name}!",
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 16.dp)
        )

        Text(
            text = "\"${user.bio}\"",
            modifier = Modifier
                .padding(top = 16.dp)
                .padding(horizontal = 24.dp),
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )

        Text(
            text = "E-mail: ${user.email}",
            modifier = Modifier.padding(top = 16.dp),
            fontSize = 16.sp
        )

        Text(
            text = "Pontuação: ${user.score}/100",
            modifier = Modifier.padding(top = 4.dp),
            fontSize = 16.sp
        )

        Text(
            text = "Idade: ${user.age}",
            modifier = Modifier.padding(top = 4.dp),
            fontSize = 16.sp
        )
    }
}