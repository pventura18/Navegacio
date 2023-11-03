package com.example.navegacio.ui.Pantalles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.navegacio.TemaApp

/*
@Preview
@Composable
fun PreviewPantallaPrincipal()
{

    TemaApp {
        PantallaPrincipal(contraldorDeNavegacio)
    }



}
 */


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaPrincipal(contraldorDeNavegacio: NavHostController) {
    Scaffold (
        topBar ={
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Menu Principal")
                },
                navigationIcon= {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Pantalla Principal"
                        )


                    }
                }
            )
        },
        ){

        Column(
            modifier= Modifier
                .padding(it)
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                             contraldorDeNavegacio.navigate("numeros")
            },
                modifier= Modifier
                    .fillMaxWidth()

            )
            {
                Text(text = "Numeros",
                    style = MaterialTheme.typography.headlineLarge

                )

            }
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = {contraldorDeNavegacio.navigate("lletres")},
                modifier= Modifier
                    .fillMaxWidth()

            )
            {
                Text(text = "Lletres",
                    style = MaterialTheme.typography.headlineLarge

                )

            }

        }

        }

}