# 📰 Demo News App

A simple Android app built with **Kotlin** and **Jetpack Compose** to fetch and display news using the [NewsAPI](https://newsapi.org/).

---

## 🚀 Setup

To run this project, you need to add your own `AppConstants.kt` file with your NewsAPI key.

### 📄 Create `AppConstants.kt`

1. Go to:
   ```
   app/src/main/java/com/example/demonewsapp/data/
   ```
2. Create a file named:
   ```
   AppConstants.kt
   ```
3. Paste the following into it:

   ```kotlin
   object AppConstants {
       const val APP_BASE_URL = "https://newsapi.org/"
       const val FIRST_COUNTRY = "us"
       const val API_KEY = "YOUR_API_KEY_HERE"
   }
   ```

4. Replace `"YOUR_API_KEY_HERE"` 

---

## 🛠 Tech Stack

- Kotlin
- Jetpack Compose
- Retrofit
- Hilt (Dependency Injection)
- NewsAPI

---

## 📩 Questions?

Feel free to open an issue or drop a message if you're trying to run the app and need help.
