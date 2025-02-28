package ie.setu.artisan1.ui.components.item

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ie.setu.artisan1.R
import ie.setu.artisan1.data.ArtisanModel
import ie.setu.artisan1.data.fakeItems
import ie.setu.artisan1.ui.theme.Artisan1Theme

@Composable
fun ItemButton(
    modifier: Modifier = Modifier,
    item: ArtisanModel,
    items: SnapshotStateList<ArtisanModel>,
    onTotalItemsChange: (Int) -> Unit
) {
    var totalItems by remember { mutableIntStateOf(0) }

    Row {
        Button(
            onClick = {
                totalItems+=item.itemAmount
                onTotalItemsChange(totalItems)
                items.add(item)
            },
            elevation = ButtonDefaults.buttonElevation(20.dp)
        ) {
            Icon(Icons.Default.Add, contentDescription = "Add Item")
            Spacer(modifier.width(width = 4.dp))
            Text(
                text = stringResource(R.string.itemButton),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White
            )
        }

        Spacer(modifier.weight(1f))
        Text(

            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                ) {
                    append(stringResource(R.string.item_no) + " ")
                }


                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = MaterialTheme.colorScheme.secondary)
                ) {
                    append(totalItems.toString())
                }
            })
    }
}

@Preview(showBackground = true)
@Composable
fun Artisan1ButtonPreview() {
    Artisan1Theme {
        ItemButton(
            Modifier,
            ArtisanModel(),
            items = fakeItems.toMutableStateList()
        ) {}
    }
}
