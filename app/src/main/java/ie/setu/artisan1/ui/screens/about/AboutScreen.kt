package ie.setu.artisan1.ui.screens.about

import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import ie.setu.artisan1.R
import ie.setu.artisan1.ui.theme.Artisan1Theme

@Composable
fun AboutScreen(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    var expandedFeatures by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 🔹 Hero Section
        Image(
            painter = painterResource(id = R.drawable.artisan_welcome),
            contentDescription = "Artisan Banner",
            modifier = Modifier.size(280.dp)
        )

        Text(
            text = "Welcome to Artisan Shop!",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center
        )

        // 🔹 Mission Statement
        InfoCard(
            title = "💕🛍️ About Us",
            content = "At this Artisan Shop, we have lots of products and categories to choose from including Jams, Soaps, Pottery, Textiles Painting, you name it we have it. " +
                    "All items and products and items, collections are handcrafted by talented creators, all goods more accessible for everyone. " +
                    "Discover unique items and explore a curated collection built just for you!"
        )

        // 🔹 Features Section with Smooth Animation
        ExpandableCard(
            title = "🔮 Key Features",
            expanded = expandedFeatures,
            onToggle = { expandedFeatures = !expandedFeatures },
            content = listOf(
                "",
                "🗂️ Filtering & Search for each item",
                "🧮 Price range slider to suit your pricing budget",
                "🌗 Dark Mode Toggle",
                "📑 Sorted by all categories",
                "👀 View products from ratings, newest, oldest and price",
                "🔎 Search bar for your needs",
                "📜 Product description",
                "🖋️ CRUD options",
                "🫱 Swipe to delete",
                "🪇 Shake device undo delete changes",
                "📝 Add more Items to record list"
            )
        )

        // 🔹 Contact Section
        InfoCard(
            title = "📨 Contact & Support",
            content = "Have feedback or need help? Don't be shy to reach out at artisanshop@mail.com."
        )
    }
}

@Composable
fun InfoCard(title: String, content: String) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = content,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )
        }
    }
}

@Composable
fun ExpandableCard(title: String, expanded: Boolean, onToggle: () -> Unit, content: List<String>) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiary),
        modifier = Modifier.fillMaxWidth(),
        onClick = onToggle
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            // 🔹 Animated expansion for better user experience
            AnimatedVisibility(
                visible = expanded,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    content.forEach { feature ->
                        Text(text = feature, color = Color.White)
                    }
                }
            }

            if (!expanded) {
                Text(
                    text = "Tap to explore all features!",
                    fontSize = 14.sp,
                    color = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AboutScreenPreview() {
    Artisan1Theme {
        AboutScreen(modifier = Modifier)
    }
}
