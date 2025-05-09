package ie.setu.artisan1.ui.components.record

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDownCircle
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.BackHand
import androidx.compose.material.icons.filled.Cottage
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Eco
import androidx.compose.material.icons.filled.Brush
import androidx.compose.material.icons.filled.BubbleChart
import androidx.compose.material.icons.filled.Cake
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.Casino
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.CleanHands
import androidx.compose.material.icons.filled.Compost
import androidx.compose.material.icons.filled.CropLandscape
import androidx.compose.material.icons.filled.CrueltyFree
import androidx.compose.material.icons.filled.Diamond
import androidx.compose.material.icons.filled.DonutSmall
import androidx.compose.material.icons.filled.Draw
import androidx.compose.material.icons.filled.EmojiFoodBeverage
import androidx.compose.material.icons.filled.FaceRetouchingNatural
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.FilterVintage
import androidx.compose.material.icons.filled.FormatColorFill
import androidx.compose.material.icons.filled.GridGoldenratio
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.LineStyle
import androidx.compose.material.icons.filled.NaturePeople
import androidx.compose.material.icons.filled.OilBarrel
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Person3
import androidx.compose.material.icons.filled.PersonPin
import androidx.compose.material.icons.filled.PinDrop
import androidx.compose.material.icons.filled.Print
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.filled.RoundaboutLeft
import androidx.compose.material.icons.filled.SelfImprovement
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.ShoppingBasket
import androidx.compose.material.icons.filled.Soap
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material.icons.filled.SpaceDashboard
import androidx.compose.material.icons.filled.Spoke
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarOutline
import androidx.compose.material.icons.filled.Stream
import androidx.compose.material.icons.filled.TheaterComedy
import androidx.compose.material.icons.filled.Timeline
import androidx.compose.material.icons.filled.Wash
import androidx.compose.material.icons.filled.Watch
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material.icons.filled.Waves
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ie.setu.artisan1.R
import ie.setu.artisan1.ui.theme.Artisan1Theme
import java.text.DateFormat
import java.util.Date

// Function to dynamically assign an icon based on the item's category
fun getCategoryIcon(category: String) = when (category) {
    //Soap Category
    "Soap" -> Icons.Filled.Soap
    "Beauty" -> Icons.Filled.Stream
    "Face" -> Icons.Filled.FaceRetouchingNatural
    "Body" -> Icons.Filled.Person
    "Face & Body" -> Icons.Filled.SelfImprovement
    "Vegan" -> Icons.Filled.CrueltyFree
    "Homemade" -> Icons.Filled.Cottage
    "Gentle" -> Icons.Filled.Wash
    "Cleansing" -> Icons.Filled.CleanHands
    "Bubbly" -> Icons.Filled.BubbleChart


    //Candle Category
    "Candle" -> Icons.Filled.LightMode
    "Organic" -> Icons.Filled.Compost
    "Fruit" -> Icons.Filled.Spa
    "Wood" -> Icons.Filled.NaturePeople
    "Scented" -> Icons.Filled.BubbleChart
    "UnScented" -> Icons.Filled.WaterDrop
    "Colour" -> Icons.Filled.Palette
    "Novelty" -> Icons.Filled.TheaterComedy
    "Luxury" -> Icons.Filled.Casino
    "Symbolic" -> Icons.Filled.AttachMoney


    //Textile Category
    "Textile" -> Icons.Filled.FormatColorFill
    "Yarn" -> Icons.Filled.Waves
    "Silk" -> Icons.Filled.Waves
    "Cotton" -> Icons.Filled.Waves
    "Calico" -> Icons.Filled.Waves
    "Denim" -> Icons.Filled.Waves
    "Leather" -> Icons.Filled.Waves
    "Linen" -> Icons.Filled.Waves
    "Cashmere" -> Icons.Filled.Waves
    "Velvet" -> Icons.Filled.Waves

    //Jam Category
    "Jelly" -> Icons.Filled.FavoriteBorder
    "Plum" -> Icons.Filled.FavoriteBorder
    "Strawberry" -> Icons.Filled.FavoriteBorder
    "Marmalade" -> Icons.Filled.FavoriteBorder
    "Peach" -> Icons.Filled.FavoriteBorder
    "Raspberry" -> Icons.Filled.FavoriteBorder
    "Blueberry" -> Icons.Filled.FavoriteBorder
    "Apricot" -> Icons.Filled.FavoriteBorder
    "Blackcurrent" -> Icons.Filled.FavoriteBorder
    "Gooseberry" -> Icons.Filled.FavoriteBorder


    //Pottery Category
    "Clay" -> Icons.Filled.Spoke
    "China" -> Icons.Filled.EmojiFoodBeverage
    "Porcelain" -> Icons.Filled.Brush
    "Terracotta" -> Icons.Filled.Brush
    "Ceramic" -> Icons.Filled.Eco
    "Mug" -> Icons.Filled.EmojiFoodBeverage
    "Bowl" -> Icons.Filled.Spoke
    "Plate" -> Icons.Filled.Spoke
    "Beads" -> Icons.Filled.Spoke
    "Jewellery" -> Icons.Filled.Spoke


    //Weaving Category
    "Basket" -> Icons.Filled.ShoppingBasket
    "Plain" -> Icons.Filled.CropLandscape
    "Tapestry" -> Icons.Filled.CropLandscape
    "3D Print" -> Icons.Filled.Print
    "Rib" -> Icons.Filled.ArrowDropDownCircle
    "Basic" -> Icons.Filled.Circle
    "Twill" -> Icons.Filled.RoundaboutLeft
    "Cloth" -> Icons.Filled.SpaceDashboard
    "Herringbone" -> Icons.Filled.ChevronLeft
    "Dobby" -> Icons.Filled.RemoveRedEye
    "Loom" -> Icons.Filled.LineStyle
    "Finger" -> Icons.Filled.BackHand
    "Rya" -> Icons.Filled.GridGoldenratio
    "Knot" -> Icons.Filled.Circle
    "Peg" -> Icons.Filled.PinDrop

    //Painting Category
    "Fresco" -> Icons.Filled.Person
    "Glass" -> Icons.Filled.FilterVintage
    "Abstract" -> Icons.Filled.Brush
    "Spray" -> Icons.Filled.Timeline
    "Oil" -> Icons.Filled.OilBarrel
    "Watercolour" -> Icons.Filled.WaterDrop
    "Digital" -> Icons.Filled.Camera
    "Pastel" -> Icons.Filled.Draw
    "Portrait" -> Icons.Filled.Person
    "Realism" -> Icons.Filled.Person3


    //Jewellery Category
    "Earrings" -> Icons.Filled.StarOutline
    "Ring" -> Icons.Filled.StarOutline
    "Bracelet" -> Icons.Filled.StarOutline
    "Necklace" -> Icons.Filled.StarOutline
    "Modern" -> Icons.Filled.LightMode
    "Gold" -> Icons.Filled.LightMode
    "Silver" -> Icons.Filled.LightMode
    "Shiny" -> Icons.Filled.LightMode
    "Anklet" -> Icons.Filled.StarOutline
    "Diamond" -> Icons.Filled.Diamond
    "Watch" -> Icons.Filled.Watch
    "Bridal" -> Icons.Filled.Cake
    "BirthStone" -> Icons.Filled.Diamond
    "Antique" -> Icons.Filled.Star
    "Brooch" -> Icons.Filled.Diamond
    "Religious" -> Icons.Filled.LightMode
    "Pendant" -> Icons.Filled.Diamond
    "Personalised" -> Icons.Filled.PersonPin
    "Dainty" -> Icons.Filled.DonutSmall
    "Crystal" -> Icons.Filled.Diamond
    "Fashion" -> Icons.Filled.ShoppingBag

    //Other Category
    "Home" -> Icons.Filled.Home
    "Scent" -> Icons.Filled.FilterVintage
    "Embroidery" -> Icons.Filled.FilterVintage
    "Knit" -> Icons.Filled.StarOutline
    "Crochet" -> Icons.Filled.StarOutline
    else -> Icons.Filled.Cottage
}

@Composable
fun ItemCard(
    itemType: String,
    itemAmount: Int,
    description: String,
    dateCreated: String,
    price: Double,
    category: String,
    rating: Float,
    availability: Boolean,
    onClickDelete: () -> Unit,
    onClickProductDetails: () -> Unit,
    modifier: Modifier = Modifier // Added the modifier parameter
) {
    Card(
        modifier = modifier // Applying the modifier action here
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        ItemCardContent(
            itemType = itemType,
            itemAmount = itemAmount,
            description = description,
            dateCreated = dateCreated,
            price = price,
            category = category,
            rating = rating,
            availability = availability,
            onClickDelete = onClickDelete,
            onClickProductDetails = onClickProductDetails,
            modifier = modifier // 🔹 Pass the modifier down to ItemCardContent
        )
    }
}


@Composable
private fun ItemCardContent(
    itemType: String,
    itemAmount: Int,
    description: String,
    dateCreated: String,
    price: Double,
    category: String,
    rating: Float,
    availability: Boolean,
    onClickDelete: () -> Unit,
    onClickProductDetails: () -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    var showDeleteConfirmDialog by remember { mutableStateOf(false) }
    val priceColor = MaterialTheme.colorScheme.secondary
    val categoryColor = MaterialTheme.colorScheme.tertiary

    Row(
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(4.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                // Display category-based icon
                Icon(
                    imageVector = getCategoryIcon(category),
                    contentDescription = category,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    text = itemType,
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.ExtraBold
                    )
                )
                Spacer(Modifier.weight(1f))
                Text(
                    text = "🛍️$itemAmount",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.ExtraBold
                    )
                )
            }
            Text(
                text = dateCreated,
                style = MaterialTheme.typography.labelSmall
            )



            Text(
                text = "Price: €$price",
                style = MaterialTheme.typography.bodyMedium,
                color = priceColor // Highlighted price for better visibility
            )

            Text(
                text = "Category: $category",
                style = MaterialTheme.typography.bodyMedium,
                color = categoryColor //  Highlighted category for better visibility
            )


            // Updated expandable content with smoother animations
            Column(modifier = Modifier.animateContentSize()) {
                Button(onClick = { expanded = !expanded }) {
                    Text(if (expanded) "Hide Details" else "Show Details")
                }

                if (expanded) {
                    Text(modifier = Modifier.padding(vertical = 16.dp), text = description)
                    Divider(thickness = 2.dp, modifier = Modifier.padding(vertical = 10.dp))
                    Text(text = "Price: 🧮€$price", style = MaterialTheme.typography.bodyMedium)
                    Text(text = "Category: 🗂️$category", style = MaterialTheme.typography.bodyMedium)
                    Text(text = "Rating: ⭐$rating", style = MaterialTheme.typography.bodyMedium)
                    Text(text = "Available: 🎁${if (availability) "Yes" else "No"}", style = MaterialTheme.typography.bodyMedium)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        FilledTonalButton(onClick = onClickProductDetails) {
                            Text(text = "Show More...")
                        }
                        IconButton(onClick = { showDeleteConfirmDialog = true }) {
                            Icon(Icons.Filled.Delete, contentDescription = "Delete Item")
                        }
                        if (showDeleteConfirmDialog) {
                            showDeleteAlert(
                                onDismiss = { showDeleteConfirmDialog = false },
                                onDelete = onClickDelete
                            )
                        }
                    }
                }
            }
        }

        // 🔹 Expand/collapse button with animation
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = if (expanded) {
                    stringResource(R.string.show_less)
                } else {
                    stringResource(R.string.show_more)
                }
            )
        }
    }
}

@Composable
fun showDeleteAlert(
    onDismiss: () -> Unit,
    onDelete: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(stringResource(id = R.string.confirm_delete)) },
        text = { Text(stringResource(id = R.string.confirm_delete_message)) },
        confirmButton = {
            Button(onClick = {
                onDelete()
                onDismiss()
            }) {
                Text("Yes")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("No")
            }
        }
    )
}

@Preview
@Composable
fun ItemCardPreview() {
    Artisan1Theme {
        ItemCard(
            itemType = "Jam",
            itemAmount = 20,
            description = "A description of my issue...",
            dateCreated = DateFormat.getDateTimeInstance().format(Date()),
            price = 10.0,
            category = "Food",
            rating = 4.5f,
            availability = true,
            onClickDelete = {},
            onClickProductDetails = {}
        )
    }
}
