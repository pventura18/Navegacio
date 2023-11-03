package com.example.navegacio.ui.Pantalles
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.navegacio.ui.Pantalles.common.Casella

/*
@Preview
@Composable
fun PreviewPantallaLletres()
{
    TemaApp {
        PantallaLletres(contraldorDeNavegacio)

    }

}

 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaLletres(contraldorDeNavegacio: NavHostController) {
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

        Lletres(it,contraldorDeNavegacio)
    }



}

@Composable
fun Lletres(paddingValues: PaddingValues, contraldorDeNavegacio: NavHostController) {
    val dades=('A' ..'Z').toList()

    Column (
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.secondary)
    )
    {
        Text(text = "Numeros",
            modifier= Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.secondary),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineLarge,
            color=MaterialTheme.colorScheme.onSecondary)
        LazyVerticalGrid(
            columns =GridCells.Adaptive(minSize = 92.dp),
            contentPadding = PaddingValues(4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)

        )
        {
            items(
                items = dades
            )
            {
                Casella(
                    text = it.toString(),
                    onClick = {
                        contraldorDeNavegacio.navigate("element/${it.toString()}"){
                            popUpTo("principal")
                        }})
            }

        }

    }

}

