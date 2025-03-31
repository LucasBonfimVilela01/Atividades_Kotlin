package com.example.exemplonavigation.data

val userDefalt = User(
    userId = "aluno",
    name = "Aluno DS",
    avatarUrl = null,
    age = 16,
    score = 75,
    registerDate = "20/03/2025",
    email = "aluno@etec.sp.gov.br",
    bio = "Estou aprendendo a passar parâmetros no JETPACK COMPOSE.."
)
val marcelo = User(
    userId = "Marcelo",
    name = "Marcelo",
    avatarUrl = null,
    age = 51,
    score = 90,
    registerDate = "15/05/1973",
    email = "marcelo.collado@etec.sp.gov.br",
    bio = "Passei os parâmetros de usuário."
)

fun getUserData(userId: String): User {
    return if (userId == "Marcelo") {
        marcelo
    } else {
        userDefalt
    }
}