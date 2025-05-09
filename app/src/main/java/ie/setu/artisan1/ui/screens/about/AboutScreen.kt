package ie.setu.artisan1.ui.screens.about

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.graphicsLayer
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
        Image(
            painter = painterResource(id = R.drawable.artisan_welcome),
            contentDescription = "Artisan Banner",
            modifier = Modifier.size(280.dp))

        PulsingGlowText("Welcome to Artisan Shop!")

        // 🔹 Mission Statement
        InfoCard(
            title = "💕🛍️ About Us",
            content = "At this Artisan Shop, we have lots of products and categories to choose from including Jams, Soaps, Pottery, Textiles Painting, you name it we have it. " +
                    "All items and products and items, collections are handcrafted by talented creators, all goods more accessible for everyone. " +
                    "Discover unique items and explore a curated collection built just for you!"
        )


        TimelineSection()



        FAQSection()

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

// 🔹 Timeline Section
@Composable
fun TimelineSection() {
    Text(
        text = "👣 Our Journey",
        style = MaterialTheme.typography.headlineSmall,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary
    )

    val milestones = listOf(
        "💭 Concept (2022)" to "The Artisan Shop was set up a small local Waterford Business for homecrafters to share ideas and connect with others.",
        "🎨 Design Phase (2023)" to "Kick-Start of Designing and Development due to high popularity.",
        "📱 App Development (2024)" to "Implemented core features to add crafters products and refined the user experience.",
        "🛍️ Official Launch (2025)" to "Artisan Shop application is now live to track products and items!",
        "🌞 Future Vision (2026+)" to "Expanding with more features and user based recommendations."
    )

    Column(modifier = Modifier.fillMaxWidth()) {
        milestones.forEach { milestone ->
            var isExpanded by remember { mutableStateOf(false) }

            ExpandableCard(
                title = milestone.first,
                expanded = isExpanded,
                onToggle = { isExpanded = !isExpanded },
                content = listOf(milestone.second)
            )
        }
    }
}

// 🔹 Pulsing Glow Text Effect
@Composable
fun PulsingGlowText(text: String) {
    val pulseAnimation = rememberInfiniteTransition()

    val scale by pulseAnimation.animateFloat(
        initialValue = 1.0f,
        targetValue = 1.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    val glowColor by pulseAnimation.animateColor(
        initialValue = Color.White,
        targetValue = Color.Cyan,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 2000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Text(
        text = text,
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier.graphicsLayer(scaleX = scale, scaleY = scale),
        style = MaterialTheme.typography.headlineMedium.copy(
            shadow = Shadow(color = glowColor, blurRadius = 20f)
        ),
        color = MaterialTheme.colorScheme.primary
    )
}

// 🔹 InfoCard Component
@Composable
fun InfoCard(title: String, content: String) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary),
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
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

// 🔹 Expandable FAQ Section With Search Bar
@Composable
fun FAQSection() {
    var searchQuery by remember { mutableStateOf("") }

    val faqCategories = listOf(
        "💖 General Questions" to listOf(
            "What is the Artisan Shop?" to "Artisan Shop is a handcrafted shop were creators add showcase and sell all types of homemade products making it accessible for " +
                    "everyone and collectors worldwide.",
            "Is the Artisan Shop Application free to use?" to "Yes! this application completely free."
        ),
        "🧭 Features & Navigation" to listOf(
            "How do I add an item?" to "Navigate to the item add button add a description and the item will appear as a product on the record screen.",
            "Can I change between light and dark mode?" to "Yes! Just hit the button switch to Dark/Light mode for your choice."
        )
    )

    val filteredCategories = faqCategories.map { category ->
        category.first to category.second.filter { faq ->
            faq.first.contains(searchQuery, ignoreCase = true) ||
                    faq.second.contains(searchQuery, ignoreCase = true)
        }
    }.filter { it.second.isNotEmpty() }

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "🤔 Frequently Asked Questions",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        // 🔹 Search Bar
        TextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("🔍 Search FAQs...") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        )

        filteredCategories.forEach { category ->
            var isExpanded by remember { mutableStateOf(false) }

            ExpandableCard(
                title = category.first,
                expanded = isExpanded,
                onToggle = { isExpanded = !isExpanded },
                content = category.second.map { "**☁️ ${it.first}**\n${it.second}" }
            )
        }
    }
}

// 🔹 Expandable Card Component
@Composable
fun ExpandableCard(title: String, expanded: Boolean, onToggle: () -> Unit, content: List<String>) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiary),
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
        onClick = onToggle
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

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
