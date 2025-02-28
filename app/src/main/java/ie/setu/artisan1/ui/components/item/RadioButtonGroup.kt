package ie.setu.artisan1.ui.components.item

import androidx.compose.foundation.layout.*
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.stringResource
import ie.setu.artisan1.R
import ie.setu.artisan1.ui.theme.Artisan1Theme

@Composable
fun RadioButtonGroup(modifier: Modifier = Modifier,
    onCategoryChange: (String) -> Unit) {
    val radioOptions = listOf(
        stringResource(R.string.soaps),
        stringResource(R.string.candles),
        stringResource(R.string.jams),
        stringResource(R.string.pottery),
        stringResource(R.string.weaving),
        stringResource(R.string.painting),
        stringResource(R.string.jewellery),
        stringResource(R.string.textile)

    )
    var selectedCategory by remember { mutableStateOf(radioOptions[0]) }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        radioOptions.forEach { category ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = (category == selectedCategory),
                    onClick = {
                        selectedCategory = category
                        onCategoryChange(selectedCategory)
                    }
                )
                Text(
                    text = category,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RadioButtonPreview() {
    Artisan1Theme {
        RadioButtonGroup(
            Modifier,
            onCategoryChange = {}
        )
    }
}
