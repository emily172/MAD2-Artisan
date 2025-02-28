package ie.setu.artisan1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ie.setu.artisan1.data.ArtisanModel
import ie.setu.artisan1.ui.screens.ScreenItem
import ie.setu.artisan1.ui.theme.Artisan1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Artisan1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtisanApp(modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun ArtisanApp(modifier: Modifier = Modifier) {
    val items = remember { mutableStateListOf<ArtisanModel>() }

    ScreenItem(modifier = modifier, items = items)
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    Artisan1Theme {
        ArtisanApp(modifier = Modifier)
    }
}
