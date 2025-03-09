package ie.setu.artisan1.ui.screens.details

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.rememberScrollState
import androidx.hilt.navigation.compose.hiltViewModel
import ie.setu.artisan1.ui.components.details.ReadOnlyTextField
import ie.setu.artisan1.ui.theme.Artisan1Theme

//Adding a title to the Description Details page
@Composable
fun DetailsScreenText() {
    Text(
        text = "Item Details",
        style = MaterialTheme.typography.headlineLarge,
        modifier = Modifier.padding(16.dp)
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailsScreen(
    modifier: Modifier = Modifier,
    detailViewModel: DetailsViewModel = hiltViewModel()
) {
    var product by detailViewModel.product
    var description by rememberSaveable { mutableStateOf(product.description) }
    var onMessageChanged by rememberSaveable { mutableStateOf(false) }
    var isEmptyError by rememberSaveable { mutableStateOf(false) }
    var isShortError by rememberSaveable { mutableStateOf(false) }

    fun validate(text: String) {
        isEmptyError = text.isEmpty()
        isShortError = text.length < 2
        onMessageChanged = !(isEmptyError || isShortError)
    }

    //Added in vertical scroll to show all fields to view them all, fixed code layout
    Column(
        modifier = modifier
            .padding(start = 24.dp, end = 24.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        //Set the new fields as Read-Only updated the comments
        DetailsScreenText()
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 10.dp, end = 10.dp),
        ) {
            // Read-Only Item Type Field
            ReadOnlyTextField(
                value = product.itemType,
                label = "Item Type"
            )
            // Read-Only Item Amount Field
            ReadOnlyTextField(
                value = "🛍️" + product.itemAmount.toString(),
                label = "Item Amount"
            )
            // Read-Only Date Added Field
            ReadOnlyTextField(
                value = product.dateAdded.toString(),
                label = "Date Added"
            )
            // Read-Only Price Field
            ReadOnlyTextField(
                value = product.price.toString(),
                label = "Price"
            )
            // Read-Only Category Field
            ReadOnlyTextField(
                value = product.category,
                label = "Category"
            )
            // Read-Only Rating Field
            ReadOnlyTextField(
                value = product.rating.toString(),
                label = "Rating"
            )
            // Read-Only Availability Field
            ReadOnlyTextField(
                value = if (product.availability) "Available" else "Not Available",
                label = "Availability"
            )
            // Editable Description Field
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = description,
                onValueChange = {
                    description = it
                    validate(description)
                },
                maxLines = 2,
                label = { Text(text = "Message") },
                isError = isEmptyError || isShortError,
                supportingText = {
                    if (isEmptyError) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Message Cannot be Empty...",
                            color = MaterialTheme.colorScheme.error
                        )
                    } else if (isShortError) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Message must be at least 2 characters",
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                },
                trailingIcon = {
                    if (isEmptyError || isShortError)
                        Icon(Icons.Filled.Warning, "error", tint = MaterialTheme.colorScheme.error)
                    else
                        Icon(
                            Icons.Default.Edit, contentDescription = "add/edit",
                            tint = Color.Black
                        )
                },
                //Updated text as description
                keyboardActions = KeyboardActions { validate(description) },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = MaterialTheme.colorScheme.secondary,
                )
            )

            Spacer(modifier = Modifier.height(24.dp)) // Added space before the button
            Button(
                onClick = {
                    detailViewModel.updateProduct(product.copy(description = description))
                    onMessageChanged = false
                },
                elevation = ButtonDefaults.buttonElevation(20.dp),
                enabled = onMessageChanged,
                modifier = Modifier.padding(bottom = 48.dp) // Added padding below the button
            ) {
                Icon(Icons.Default.Save, contentDescription = "Save")
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Save",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    Artisan1Theme {
        DetailsScreen()
    }
}
