# Artisan App

![img_9.png](img_9.png)

The Artisan App is designed for homemakers to add and manage various categories of items, 
such as soaps, candles, and jams, through an easy-to-use interface.
These new features are displayed across various screens, 
including the Details Screen, Record Screen, Items Card, List, and Item Screen, 
enhancing the overall functionality and user experience.

The app contains new new fields such as price, category, rating, and
availability to add value to each product.
It includes a search feature to help users filter and find specific items.
Users can view detailed information about each product and edit descriptions as needed.

The app also features a delete function with a confirmation alert and setup for updating and 
editing items, ensuring efficient management of products and explanation for each one.
Additionally, the app adapts accordingly to color scheme to maintain a visually appealing interface 
either in dark or light mode.


## State Features
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

## Navigation Features
- **NavHostProvider**: Sets up the navigation host for the app, defining the start destination and routes to different screens.
- **TopAppBarProvider**: Provides the top app bar with navigation and action buttons, including a back button and a drop-down menu.
- **BottomAppBarProvider**: Provides the bottom app bar with navigation buttons to switch between different sections of the app.
- **Room Database**: Used for local storage to store all of the artisan products.
- **Model**: Represents the data layer (Room entities, DAO interfaces).
- **View**: Represents the UI layer (Activities, Fragments).
- **ViewModels**: Refactoring the project to address managing UI-related data in the application.
- **Hilt**: Dependency injection.

## Delete & Update Features
- **Delete**: Remove an item with confirmation screen.
-**Message Field**: Updating a message or description in the card list.
-**Alert Warning**: A field needs to be filled in for the card to be saved.


## Customization  Features
- **Price**: Added a price for a product.
- **Category**: Give the product a category.
- **Rating**: Add a rating to the product.
- **Record List**: Displays a list of products.
- **Detail Screen**: Displays each item details such as item type, item amount, date added, price, category, rating, and availability.
  The fields `price`, `category`, `rating`, and `availability` are read-only, while the description field is editable.
- **Search and Filter**: Search through the products and filter items by type.
  Users can search for products using the search field. Selecting a product navigates to the `DetailsScreen`. when the user clicks Show More... .


## Colours and Themes Features
- **Colours**: Updating the primary,secondary and tertiary scheme for applying to light and dark mode.
- **Themes**: Setting those changes with the application.



## Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/emily172/MAD2-Artisan.git


## State References - Date Accessed Feb 20 and 28 2025 & Mar 2 2025
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


## Navigation References - Date Accessed Feb 28 2025 & Mar 2 and 3 2025
https://tutors.dev/topic/mobile-app-dev-2-2025/topic-04-navigation

https://www.freepik.com/free-vector/hand-drawn-thrift-store-illustration_37452108.htm#fromView=search&page=1&position=24&uuid=9722dd10-7475-4c16-9a87-0ab8d7d21cc1&query=homemade+shop


## MVVM, Hilt,Room,Mode, View, View Models References - Date Accessed Mar 4, 5, 6 and 7 2025
https://tutors.dev/topic/mobile-app-dev-2-2025/topic-05-architecture

https://miro.medium.com/v2/resize:fit:624/0*6mf2j-nPShT3_Pd4.png


## Delete & Update References - Date Accessed Mar 2, 3, 4 and 7 2025
https://tutors.dev/lab/mobile-app-dev-2-2025/topic-05-architecture/unit-01/book-c-donationx-v3/04

https://www.freepik.com/free-vector/illustration-trash-bin-icon_2606118.htm#fromView=search&page=1&position=36&uuid=c84d870e-8acc-4fae-9457-f6b509121d3e&query=delete

https://tutors.dev/lab/mobile-app-dev-2-2025/topic-05-architecture/unit-01/book-c-donationx-v3/05

https://www.freepik.com/free-vector/update-concept-illustration_7741838.htm#fromView=search&page=1&position=0&uuid=4fa1cd47-4883-4b35-89ab-b7d1899d5208&query=update


## Customization References - Date Accessed Mar 8 and 9 2025
https://developer.android.com/develop/ui/compose/modifiers-list

https://stackoverflow.com/questions/78389915/boolean-becomes-false-after-passing-it-to-pointerinput

https://developer.android.com/compose

https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/to-double-or-null.html

https://www.tutorialspoint.com/kotlin/kotlin_string_todoubleornull_function.html

https://kotlinlang.org/docs/null-safety.html#nullable-types-and-non-nullable-types

https://kotlinlang.org/docs/null-safety.html

https://stackoverflow.com/questions/48393968/value-of-null-in-double-should-print-0

https://www.baeldung.com/java-check-null-parse-double

https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/to-float-or-null.html

https://stackoverflow.com/questions/71215772/how-can-i-make-this-code-simpler-in-kotlin

https://medium.com/simform-engineering/kotlin-tips-and-tricks-for-efficient-programming-c4eefb27ea1b

https://developer.android.com/develop/ui/views/components/checkbox

https://developer.android.com/reference/android/widget/CheckBox

https://developer.android.com/develop/ui/compose/text/display-text

https://stackoverflow.com/questions/75882930/jetpack-compose-android-permanently-showing-outlinedtextfield-label-in-materia

https://developer.android.com/reference/kotlin/androidx/media3/common/Label

https://developer.android.com/reference/kotlin/androidx/media3/common/Label

https://medium.com/@ramadan123sayed/comprehensive-guide-to-textfields-in-jetpack-compose-f009c4868c54

https://stackoverflow.com/questions/71095436/what-is-this-kotlin-type-string-string

https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/

https://www.w3schools.com/kotlin/kotlin_data_types.php

https://stackoverflow.com/questions/56476447/kotlin-check-if-a-double-value-is-only-between-0-0-to-1-0-stepped-by-0-1

https://stackoverflow.com/questions/14302898/is-it-better-to-write-0-0-0-0f-or-0f-instead-of-simple-0-for-supposed-float-or

https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-double/

https://kotlinlang.org/docs/numbers.html#integer-types

https://kotlinlang.org/docs/booleans.html

https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/

https://kotlinlang.org/docs/strings.html

https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-float/

https://medium.com/@andyphiri92/using-text-in-jetpack-compose-0fb812118809

https://developer.android.com/reference/kotlin/androidx/compose/ui/text/TextStyle

https://stackoverflow.com/questions/16336500/kotlin-ternary-conditional-operator

https://kotlinlang.org/docs/control-flow.html

https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/to-string.html

https://stackoverflow.com/questions/40862207/kotlin-generate-tostring-for-a-non-data-class

https://bterczynski.medium.com/be-careful-of-tostring-on-nullable-types-in-kotlin-5c4955cf5e33

https://stackoverflow.com/questions/78104334/handling-initial-value-in-collectasstate-in-jetpack-compose

https://meetpatadia9.medium.com/efficient-search-with-lazy-layouts-in-jetpack-compose-0a6c3f219ff5

https://stackoverflow.com/questions/15824733/option-to-ignore-case-with-contains-method

https://stackoverflow.com/questions/14064189/how-to-ignorecase-when-using-string-text-contains/37705047

https://stackoverflow.com/questions/14064189/how-to-ignorecase-when-using-string-text-contains/37705047

https://www.kodeco.com/books/kotlin-apprentice/v3.0/chapters/20-exceptions

https://stackoverflow.com/questions/50198067/kotlin-equivalent-of-javas-equalsignorecase

https://stackoverflow.com/questions/49349674/case-sensitivity-kotlin-ignorecase

https://www.w3schools.com/java/ref_string_equalsignorecase.asp

https://developer.android.com/reference/kotlin/androidx/compose/foundation/text/KeyboardActions

https://tutors.dev/topic/mobile-app-dev-2-2025/topic-03-state

https://www.freepik.com/free-vector/illustration-antique-market-with-old-objects_13239321.htm#fromView=search&page=1&position=2&uuid=3ae8b65a-6333-4921-92e7-da7ec5a0582f&query=artisan+shop


## Colours & Themes References - Date Accessed Mar 9 2025
https://m3.material.io/styles/color/system/overview

https://m2.material.io/design/color/the-color-system.html

https://htmlcolorcodes.com/color-picker/

https://stackoverflow.com/questions/74988479/change-background-color-surface-light-dark-jetpack-compose

https://medium.com/@rowaido.game/setting-up-material-theme-color-schemes-in-jetpack-compose-39140ea2e66a

https://stackoverflow.com/questions/74988479/change-background-color-surface-light-dark-jetpack-compose

https://www.freepik.com/free-vector/colorful-flower_763057.htm#fromView=search&page=2&position=40&uuid=11ae178a-1024-4b00-b102-17b295ae56fa&query=color+wheel+

https://www.freepik.com/free-vector/flea-market-concept-illustration_12178777.htm#from_element=detail_alsolike
