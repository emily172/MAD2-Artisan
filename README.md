# Artisan App

![img.png](img.png)

This is the initial build up state for the artisan shop application.
The Artisan App is created for homemakers to to add various categories such as soaps, candles, jams etc.
It provides an easy-to-use interface for managing these items on a records of goods lists.


## State & Features

### State
The first step is to set up the state and the basic features of the application to give a feel and look.
After building this state, it gives a clear guideline of other features to include later into the application.
All of the state and features are create using Jetpack Composables management and storage data to manage the user input, inventory list and list of items stored in strings.xml.
Two screens have been implemented for ‘Item’ Option, where the user adds a new item once added can be viewed on the  a ‘donation’ from the user
‘Record’ Option, which lists the items added by the made by the user therefore they can switch between two menus.

### Features
- **Item Type**: Updates with a different items are selected from the radio group button options.
- **Item Amount**: Adjusts the amount of items permitted by amount.
- **Item Picker**: Selects the amount of inventory amount in 10s once reached 100 limit exceeded.
- **Item Description**: Write a message about the product for example strawberry candle.
- **Item Inventory**: View the total number of items in the inventory and track the progress.
- **Calculate Total Items**: total items + inventory = sumOf function on each item added.
- **Search and Filter**: Search through the inventory and filter items by type.
- **Updating Inventory List**: Controlled using the SnapshotStateList to store all the items added by the user which triggers a recomposition of the UI to reflect the changes.
- **Handling User Interactions**: Add button triggered item inventory bar increases each new item added to list.
- **Toast Notification**: Receive a toast notification when the total items exceed 100 to say limit exceeded.


## Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/emily172/MAD2-Artisan.git


## References
https://tutors.dev/topic/mobile-app-dev-2-2025/topic-03-state
https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/package-summary
https://stackoverflow.com/questions/75436717/error-with-color-attribute-in-kotlin-compose
https://muratgny06.medium.com/how-to-create-custom-graphics-with-jetpack-compose-and-kotlin-on-android-710fa84ebca8
https://developer.android.com/reference/kotlin/androidx/compose/ui/unit/package-summary
https://developer.android.com/develop/ui/compose/tooling/relay/mapping-styles-to-compose-theme
https://developer.android.com/develop/ui/compose/text/fonts
https://stackoverflow.com/questions/78675499/must-i-use-materialtheme-typography-when-using-jetpack-compose-or-are-there-any
https://medium.com/@riztech.dev/theming-and-styling-in-jetpack-compose-with-materialtheme-c0c8254d8404
https://developer.android.com/develop/ui/compose/designsystems/material3
https://stackoverflow.com/questions/67696294/jetpack-compose-onsurface-color-not-working
https://developer.android.com/s/results/?q=Typography
https://developer.android.com/reference/kotlin/androidx/compose/material/Typography?hl=en
https://m3.material.io/styles/typography/overview
https://github.com/material-components/material-components-android/blob/master/docs/theming/Typography.md
https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary?hl=en
https://developer.android.com/reference/kotlin/androidx/compose/material3/MaterialTheme?hl=en
https://developer.android.com/develop/ui/compose/modifiers
https://developer.android.com/develop/ui/compose/modifiers-list
https://stackoverflow.com/questions/73276689/vertical-scroll-affecting-the-modifier-weight-in-jetpack-compose
https://developer.android.com/develop/ui/compose/touch-input/pointer-input/scroll
https://www.geeksforgeeks.org/concept-of-padding-in-android/
https://developer.android.com/reference/kotlin/androidx/compose/material/icons/Icons.Filled
https://developer.android.com/develop/ui/compose/components/badges
https://medium.com/@theAndroidDeveloper/jetpack-compose-trick-the-hidden-secret-of-the-weight-modifier-640daf63b151
https://medium.com/@ahmetbostanciklioglu/common-mistakes-and-misuses-of-lazycolumn-in-jetpack-compose-9d2ce483e20e
https://ibrahimcanerdogan.medium.com/scrollable-in-jetpack-compose-cb2d639fe2cd
https://dev.to/atsuko/exploring-the-impact-of-verticalscroll-on-fillmaxheight-modifier-in-android-compose-cgo
https://composables.com/foundation/verticalscroll
https://www.freepik.com/free-vector/happy-people-street-season-flea-market_9175266.htm#from_element=detail_alsolike
https://developer.android.com/reference/kotlin/androidx/compose/runtime/snapshots/SnapshotStateList
https://medium.com/@tangkegaga/snapshot-concept-in-jetpack-compose-6c62dabdb143
https://stackoverflow.com/questions/74967044/how-to-update-the-original-list-when-snapshotstatelist-is-updated
https://medium.com/@suraj.raj/improve-android-app-performance-using-snapshotstatelist-in-jetpack-compose-7c7b709a4fa3