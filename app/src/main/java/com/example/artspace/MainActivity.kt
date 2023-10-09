package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Body()
                }
            }
        }
    }
}

@Composable
fun Body( modifier: Modifier = Modifier) {

    var tituloActual by remember{
        mutableStateOf("El nacimiento de Venus")
    }
    var fechaActual by remember{
        mutableStateOf("Sandro Boticcelli (1486)")
    }

    val primerCuadro = R.drawable.venus
    val segundoCuadro = R.drawable.atalanta
    val tercerCuadro = R.drawable.aquelarre
    val cuartoCuadro = R.drawable.vulcano
    val quintoCuadro = R.drawable.woman

    var cuadroActual by remember{
        mutableStateOf(primerCuadro)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
    ){
        Spacer(modifier = Modifier.height(100.dp))
        Image(
            painter = painterResource(cuadroActual),
            contentDescription = null,
            modifier = modifier
                .size(350.dp)
        )
        Spacer(modifier = Modifier.height(50.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxWidth()
        ){
            Text(
                text = tituloActual,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
            )
            Text(
                text = fechaActual,
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
            )
        }
        Spacer(modifier = Modifier.height(100.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(50.dp,Alignment.CenterHorizontally),
        ){
            Button(onClick = {
                when(cuadroActual){
                    primerCuadro -> {
                        cuadroActual=quintoCuadro
                        tituloActual="Mujer con sombrilla"
                        fechaActual="Claude Monet (1875)"
                    }
                    segundoCuadro -> {
                        cuadroActual=primerCuadro
                        tituloActual="El nacimiento de Venus"
                        fechaActual="Sandro Boticcelli (1486)"
                    }
                    tercerCuadro -> {
                        cuadroActual=segundoCuadro
                        tituloActual="Hipómenes y Atlanta"
                        fechaActual="Guido Remi (1625)"
                    }
                    cuartoCuadro -> {
                        cuadroActual=tercerCuadro
                        tituloActual="El aquelarre"
                        fechaActual="Francisco de Goya (1798)"
                    }
                    else ->{
                        cuadroActual=cuartoCuadro
                        tituloActual="La fragua de Vulcano"
                        fechaActual="Diego Velázquez (1630)"
                    }
                }
            }) {
                Text(
                    text = "Anterior",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                )
            }
            Button(onClick = {
                when(cuadroActual) {
                    primerCuadro -> {
                        cuadroActual=segundoCuadro
                        tituloActual="Hipómenes y Atlanta"
                        fechaActual="Guido Remi (1625)"
                    }
                    segundoCuadro -> {
                        cuadroActual=tercerCuadro
                        tituloActual="El aquelarre"
                        fechaActual="Francisco de Goya (1798)"
                    }
                    tercerCuadro -> {
                        cuadroActual=cuartoCuadro
                        tituloActual="La fragua de Vulcano"
                        fechaActual="Diego Velázquez (1630)"
                    }
                    cuartoCuadro -> {
                        cuadroActual=quintoCuadro
                        tituloActual="Mujer con sombrilla"
                        fechaActual="Claude Monet (1875)"
                    }
                    else ->{
                        cuadroActual=primerCuadro
                        tituloActual="El nacimiento de Venus"
                        fechaActual="Sandro Boticcelli (1486)"
                    }
                }
            }) {
                Text(
                    text = "Siguiente",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                )
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        Body()
    }
}