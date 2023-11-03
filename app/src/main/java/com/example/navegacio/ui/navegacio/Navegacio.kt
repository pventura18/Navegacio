package com.example.navegacio.ui.navegacio

import androidx.compose.runtime.Composable
import androidx.navigation.NavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navegacio.ui.Pantalles.PantallaLletres
import com.example.navegacio.ui.Pantalles.PantallaNumeros
import com.example.navegacio.ui.Pantalles.PantallaPrincipal
import com.example.navegacio.ui.Pantalles.Pantallaelement

@Composable
fun Navegacio()
{
    //Creem el navegador

    val contraldorDeNavegacio =  rememberNavController()

    NavHost(navController = contraldorDeNavegacio,
        startDestination = "principal")
    {
        composable("principal"){
            PantallaPrincipal(contraldorDeNavegacio)
        }
        composable("numeros"){
            PantallaNumeros(contraldorDeNavegacio)
        }
        composable("lletres"){
            PantallaLletres(contraldorDeNavegacio)
        }
        composable(
            route="element/{text}",
            arguments = listOf(
                navArgument("text"){type= NavType.StringType}
            )
        ){
            val text=it.arguments?.getString("text")
            requireNotNull(text,{"Error el text no pot ser null"})
            Pantallaelement(text=text)
        }

    }

}

