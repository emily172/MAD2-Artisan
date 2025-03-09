package ie.setu.artisan1.ui.components.record

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cottage
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
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
    onClickProductDetails: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 2.dp)
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
            onClickProductDetails = onClickProductDetails
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
    onClickProductDetails: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var showDeleteConfirmDialog by remember { mutableStateOf(false) }

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
                Icon(
                    imageVector = Icons.Filled.Cottage,
                    contentDescription = "Item Status",
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
            //Updated to handle composable functions displaying additional information item expanded to view
            if (expanded) {
                Text(modifier = Modifier.padding(vertical = 16.dp), text = description)
                Text(text = "Price: $price", style = MaterialTheme.typography.bodySmall)
                Text(text = "Category: $category", style = MaterialTheme.typography.bodySmall)
                Text(text = "Rating: $rating", style = MaterialTheme.typography.bodySmall)
                Text(text = "Available: ${if (availability) "Yes" else "No"}", style = MaterialTheme.typography.bodySmall)
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
