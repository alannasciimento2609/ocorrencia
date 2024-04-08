package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            TelaPrincipal()

        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun TelaPrincipal(modifier: Modifier = Modifier) {
        var textoUsuario by remember { mutableStateOf(TextFieldValue("")) }
        var textoSenha by remember { mutableStateOf(TextFieldValue("")) }

        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.mediumTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = { Text(text = "Login Aluno") }
                )
            },
            bottomBar = {
                BottomAppBar {
                    Text(text = "Bottom Bar")
                }
            },
        ) { contentPadding ->
            Column(
                modifier = modifier
                    .padding(contentPadding)
                    .background(Color.Blue)
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Usuário: ${textoUsuario.text}",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 20.sp,
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = textoUsuario,
                    onValueChange = { textoUsuario = it },
                    label = { Text("Usuário") }
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = textoSenha,
                    onValueChange = { textoSenha = it },
                    label = { Text("Senha") },
                    visualTransformation = PasswordVisualTransformation(),
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        // Implemente a lógica de login aqui
                        // Você pode acessar o texto digitado pelo usuário em 'textoUsuario' e 'textoSenha'
                    },
                    modifier = Modifier.width(IntrinsicSize.Max)
                ) {
                    Text("Login")
                }
            }
        }
    }

    @Preview
    @Composable
    fun TelaPrincipalPreview() {
        TelaPrincipal()
    }
}