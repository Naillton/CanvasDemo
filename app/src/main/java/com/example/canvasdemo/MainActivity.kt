package com.example.canvasdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.canvasdemo.ui.theme.CanvasDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CanvasDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

/**
 * Criando desenhos com canvas
 */

@Composable
fun MainScreen() {
    // DrawLine()
    DrawRect()
}

// desenhando linhas
@Composable
private fun DrawLine() {
    Canvas(modifier = Modifier.size(300.dp)) {
        val height = size.height
        val width = size.width

        drawLine(
            start = Offset(x = 0f, y = 0f),
            end = Offset(x = width, y = height),
            color = Color.Blue,
            strokeWidth = 16.0f,
            // deixando a drawLine com um tracejado, usando o path effect
            pathEffect = PathEffect.dashPathEffect(
                floatArrayOf(30f, 10f, 10f, 10f),
                phase = 0f
            )
        )
    }
}

// desenhando retangulos
@Composable
private fun DrawRect() {
    Canvas(modifier = Modifier.size(300.dp)) {
        val size = Size(600f, 250f)
        // usando inset para modificar limites do retangulo
        inset(100f, 200f) {
            drawRect(
                color = Color.Blue,
                size = size
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    CanvasDemoTheme {
        MainScreen()
    }
}