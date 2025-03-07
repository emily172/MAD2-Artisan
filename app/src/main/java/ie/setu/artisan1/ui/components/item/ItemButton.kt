import android.widget.Toast
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ie.setu.artisan1.R
import ie.setu.artisan1.data.ArtisanModel
import ie.setu.artisan1.data.fakeItems
import ie.setu.artisan1.ui.screens.item.ItemViewModel
import ie.setu.artisan1.ui.screens.record.RecordViewModel
import ie.setu.artisan1.ui.theme.Artisan1Theme
import timber.log.Timber

@Composable
fun ItemButton(
    modifier: Modifier = Modifier,
    product: ArtisanModel,
    itemViewModel: ItemViewModel = hiltViewModel(),
    recordViewModel: RecordViewModel = hiltViewModel(),
    onTotalItemsChange: (Int) -> Unit
) {
    val products = recordViewModel.uiProducts.collectAsState().value
    val totalItems = products.sumOf { it.itemAmount }
    val context = LocalContext.current
    val description = stringResource(R.string.limitExceeded, product.itemAmount)

    Row {
        Button(
            onClick = {
                if (totalItems + product.itemAmount <= 100) {
                    onTotalItemsChange(totalItems)
                    itemViewModel.insert(product)
                    Timber.i("Item info: $product")
                    Timber.i("Item Inventory List info: ${products.toList()}")
                } else {
                    Toast.makeText(context, description, Toast.LENGTH_SHORT).show()
                }
            },
            elevation = ButtonDefaults.buttonElevation(20.dp),
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                Icons.Default.Add,
                contentDescription = "Add Item",
                tint = MaterialTheme.colorScheme.onPrimary
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = stringResource(R.string.itemButton),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }

        Spacer(modifier = Modifier.width(16.dp))
        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                ) {
                    append(stringResource(R.string.item_no) + "🛍️ ")
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                        color = MaterialTheme.colorScheme.secondary
                    )
                ) {
                    append(totalItems.toString())
                }
            },
            textAlign = TextAlign.End,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Artisan1ButtonPreview() {
    Artisan1Theme {
        PreviewItemButton(
            Modifier,
            ArtisanModel(),
            products = fakeItems.toMutableStateList()
        ) {}
    }
}

@Composable
fun PreviewItemButton(
    modifier: Modifier = Modifier,
    product: ArtisanModel,
    products: SnapshotStateList<ArtisanModel>,
    onTotalItemsChange: (Int) -> Unit
) {
    val totalItems = products.sumOf { it.itemAmount }
    val context = LocalContext.current
    val description = stringResource(R.string.limitExceeded, product.itemAmount)

    Row {
        Button(
            onClick = {
                if (totalItems + product.itemAmount <= 100) {
                    onTotalItemsChange(totalItems)
                    Timber.i("Item info: $product")
                    Timber.i("Item Inventory List info: ${products.toList()}")
                } else {
                    Toast.makeText(context, description, Toast.LENGTH_SHORT).show()
                }
            },
            elevation = ButtonDefaults.buttonElevation(20.dp),
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                Icons.Default.Add,
                contentDescription = "Add Item",
                tint = MaterialTheme.colorScheme.onPrimary
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = stringResource(R.string.itemButton),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }

        Spacer(modifier = Modifier.width(16.dp))
        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                ) {
                    append(stringResource(R.string.item_no) + "🛍️ ")
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                        color = MaterialTheme.colorScheme.secondary
                    )
                ) {
                    append(totalItems.toString())
                }
            },
            textAlign = TextAlign.End,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}
