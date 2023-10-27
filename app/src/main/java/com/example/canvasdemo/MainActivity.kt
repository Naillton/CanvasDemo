package com.example.canvasdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.canvasdemo.ui.theme.CanvasDemoTheme
import kotlin.math.PI
import kotlin.math.sin

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
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // DrawLine()
        // DrawRect()
        // DrawRoundRect()
        // DrawCircle()
        // DrawOval()
        // GradientFill()
        // RadiantFill()
        // ShadowCricle()
        // DrawArc()]
        // DrawPoints()
        DrawImage()
    }
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

// desenhando retangulos com bordas arredondadas
@Composable
private fun DrawRoundRect() {
  Canvas(modifier = Modifier.size(300.dp)) {
      val size = Size(100.dp.toPx(), 100.dp.toPx())
      // aplicando rotacao no elemento com a funcao rotate
      rotate(25f) {
          drawRoundRect(
              color = Color.Blue,
              size = size,
              topLeft = Offset(20f, 20f),
              // definindo tamanho da borda
              style = Stroke(
                  width = 8.dp.toPx()
              ),
              // definindo arredondamento das bordas nas posicoes x e y
              cornerRadius = CornerRadius(
                  x = 30.dp.toPx(),
                  y = 30.dp.toPx()
              )
          )
      }
  }
}

// desenhando circulos e ovais
@Composable
private fun DrawCircle() {
    Canvas(modifier = Modifier.size(300.dp)) {
        drawCircle(
            color = Color.Blue,
            center = center,
            radius = 120.dp.toPx()
        )
    }
}

@Composable
private fun DrawOval() {
    Canvas(modifier = Modifier.size(300.dp)) {
        val size = Size(300.dp.toPx(), 300.dp.toPx())
        drawOval(
            color = Color.Blue,
            topLeft = Offset(x = 25.dp.toPx(), y = 90.dp.toPx()),
            size = Size(
                width = size.width - 50.dp.toPx(),
                height = size.height / 2 - 50.dp.toPx()
            ),
            style = Stroke(width = 8.dp.toPx())
        )
    }
}

// desenhando gradients
@Composable
private fun GradientFill() {
    Canvas(modifier = Modifier.size(300.dp)) {
        val size = size
        val colorList: List<Color> = listOf(Color.Red, Color.Blue,
            Color.Magenta, Color.Yellow, Color.Green,
            Color.Cyan)

        val brush = Brush.horizontalGradient(
            colors = colorList,
            startX = 0f,
            endX = 300.dp.toPx(),
            tileMode = TileMode.Repeated
        )

        drawRect(
            brush = brush,
            size = size
        )
    }
}

@Composable
private fun RadiantFill() {
    Canvas(modifier = Modifier.size(300.dp)) {
        val radius = 150.dp.toPx()
        val colorList: List<Color> = listOf(Color.Red, Color.Blue,
            Color.Magenta, Color.Yellow, Color.Green,
            Color.Cyan)

        val brush = Brush.radialGradient(
            colors = colorList,
            center = center,
            radius = radius,
            tileMode = TileMode.Repeated
        )

        drawCircle(
            brush = brush,
            center = center,
            radius = radius
        )
    }
}

@Composable
private fun ShadowCricle() {
    Canvas(modifier = Modifier.size(300.dp)) {
        val radius = 150.dp.toPx()
        val colorList: List<Color> = listOf(Color.Blue, Color.Black)

        val brush = Brush.horizontalGradient(
            colors = colorList,
            startX = 0f,
            endX = 300.dp.toPx(),
            tileMode = TileMode.Repeated
        )

        drawCircle(
            brush = brush,
            center = center,
            radius = radius
        )
    }
}

// desenhando arcos
@Composable
private fun DrawArc() {
    Canvas(modifier = Modifier
        .size(300.dp)
        .background(Color.Green)) {
        drawArc(
            Color.Blue,
            startAngle = 20f,
            sweepAngle = 90f,
            useCenter = true,
            size = Size(250.dp.toPx(), 250.dp.toPx())
        )
    }
}

// desenhando pontos em linhas
@Composable
private fun DrawPoints() {
    Canvas(modifier = Modifier.size(300.dp)) {
        val size = size
        val points = mutableListOf<Offset>()
        for (x in 0..size.width.toInt()) {
            val y = (sin(x * (2f * PI / size.width)) * (size.height / 2)
                    + (size.height / 2)).toFloat()
            points.add(Offset(x.toFloat(), y))
        }

        drawPoints(
            points = points,
            strokeWidth = 3f,
            pointMode = PointMode.Points,
            color = Color.Blue
        )
    }
}

// desenhando imagem
@Composable
private fun DrawImage() {
    val image = ImageBitmap.imageResource(id = R.drawable.dgb)
    Canvas(modifier = Modifier.size(360.dp, 270.dp)) {
        drawImage(
            image = image,
            topLeft =  Offset(x = 0f, y = 0f)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    CanvasDemoTheme {
        MainScreen()
    }
}