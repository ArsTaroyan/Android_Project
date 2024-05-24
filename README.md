# MobileMarket

MobileMarket is an Android application designed for a mobile phone store, allowing users to easily browse and order phones. The app is developed entirely in Kotlin using Android Studio, following the principles of Clean architecture, resulting in clean and maintainable code. All API data is retrieved from [dummyjson.com](https://dummyjson.com/docs).

## Key Features

- **Phone Ordering**: Users can easily browse through available phones and place orders.
- **AutoLogin**: The app supports automatic login for a seamless user experience.
- **Integration with OkHttp and Retrofit**: Utilizes OkHttp and Retrofit for efficient network communication.
- **JSON Parsing with Gson**: Gson library is used for JSON parsing to handle network responses.
- **Asynchronous Programming with Coroutines**: Employes Coroutines for managing asynchronous tasks and network calls.
- **Navigation Component**: Utilizes Android Navigation Component for navigation within the app.
- **Data Storage with Preferences DataStore**: Uses Preferences DataStore for storing user preferences.
- **Dependency Injection with Koin**: Implements dependency injection using Koin for better code maintainability.
- **Image Loading with Glide**: Glide library is used for efficient image loading and caching.

## Technologies and Libraries Used

- **OkHttp**: 
  - `implementation 'com.squareup.okhttp3:okhttp:5.0.0-alpha.2'`
  - `implementation 'com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2'`
- **Gson**: 
  - `implementation 'com.google.code.gson:gson:2.9.0'`
- **Coroutines**: 
  - `implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9'`
  - `implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9'`
- **Retrofit**: 
  - `implementation 'com.squareup.retrofit2:converter-gson:2.9.0'`
  - `implementation 'com.squareup.retrofit2:retrofit:2.9.0'`
- **Navigation**: 
  - `implementation "androidx.navigation:navigation-fragment-ktx:2.5.3"`
  - `implementation "androidx.navigation:navigation-ui-ktx:2.5.3"`
- **Preferences DataStore**: 
  - `implementation "androidx.datastore:datastore-preferences:1.0.0-alpha04"`
- **Koin**: 
  - `implementation 'io.insert-koin:koin-android:3.1.5'`
- **Glide**: 
  - `implementation 'com.github.bumptech.glide:glide:4.12.0'`

## Installation

1. **Clone the repository**
    ```bash
    git clone https://github.com/ArsTaroyan/MobileMarket.git
    cd Daily
    ```

2. **Open the project**
    Open the project in [Android Studio](https://developer.android.com/studio).

3. **Sync Gradle**
    The project uses Gradle to manage dependencies. Sync Gradle to download all required dependencies.

4. **Run the application**
    Connect your Android device or use an emulator to run the application.

## Project Structure

The project follows Clean Architecture principles, ensuring modularity and testability of the code. The main modules include:

- **data**: Contains data sources (API, SharedPreferences).
- **domain**: Contains business logic (use case, models).
- **presentation**: Contains the user interface (Activity, Fragment, ViewModel).

## Project Description

MobileMarket was developed to enable users to easily browse and order phones from a mobile phone store. It provides a simple and intuitive interface for users to place their orders hassle-free. The app supports automatic login for a seamless user experience. All data is fetched from dummyjson.com, making it easy to test and integrate new features.
