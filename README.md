# MyQuotesApp — Favourite Quotes Manager

<div>

[![Platform](https://img.shields.io/badge/Platform-Android-brightgreen?style=for-the-badge&logo=android&logoColor=white)](https://github.com/navneetdev141/MyQuotesApp)
[![Language](https://img.shields.io/badge/Language-Kotlin-purple?style=for-the-badge&logo=kotlin&logoColor=white)](https://github.com/navneetdev141/MyQuotesApp)
[![UI](https://img.shields.io/badge/UI-Jetpack%20Compose-blue?style=for-the-badge&logo=jetpackcompose&logoColor=white)](https://github.com/navneetdev141/MyQuotesApp)
[![Backend](https://img.shields.io/badge/Backend-Firebase%20Realtime%20DB-orange?style=for-the-badge&logo=firebase&logoColor=white)](https://github.com/navneetdev141/MyQuotesApp)
[![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)](#-license)

</div>

A simple Android app for saving your favourite quotes from the books you read — along with the book title, author and page number — synced live through **Firebase Realtime Database**.

---

## ✨ Features

### 📖 Quote Feed
- Browse every saved quote in a scrollable list, streamed live from Firebase Realtime Database via a `ValueEventListener`
- Each card shows the quote text, the book it's from, the page number and the author
- Tap a card to open it straight in the edit screen

### ➕ Add Quote
- Simple form to capture the quote text, book title, author and page number
- Saves instantly to Firebase with a confirmation toast

### ✏️ Edit Quote
- Pre-filled form for updating any field of an existing quote
- Changes are written back to Firebase and reflected immediately in the feed

### 🗑️ Delete Quote
- One-tap delete icon on every quote card, removes it from Firebase instantly

### ☁️ Realtime Sync
- No local database — the feed is fully backed by Firebase Realtime Database, so it updates live if the data changes from anywhere
- No authentication layer — all quotes live under a single shared `quotes` node

### 🎨 UI
- Jetpack Compose with Material 3 building blocks
- Clean blue-accented theme across app bars and buttons
- Edge-to-edge layout

---

## 🏗️ Architecture

This app keeps things intentionally lightweight — there's no local database or ViewModel layer. Composable screens talk directly to a single `FirebaseRepository` object, which wraps all Realtime Database calls. UI state is held with Compose's `remember` / `mutableStateListOf`, refreshed through a `LaunchedEffect` tied to a live Firebase listener.

```
MyQuotesApp/
├── app/
│   ├── google-services.json         # Firebase project config
│   └── src/
│       ├── main/
│       │   ├── java/com/example/myquotesapp/
│       │   │   ├── Quote.kt                # Data model (id, quote, book, author, page)
│       │   │   ├── FirebaseRepository.kt   # Add, update, delete, listen — Realtime DB
│       │   │   ├── MainActivity.kt         # NavHost + Firebase init
│       │   │   ├── DisplayQuoteScreen.kt   # Quote feed
│       │   │   ├── AddQuoteScreen.kt       # Add-quote form
│       │   │   ├── EditQuoteScreen.kt      # Edit-quote form
│       │   │   └── ui/theme/               # Color.kt, Theme.kt, Type.kt
│       │   ├── res/                        # Icons, strings, themes
│       │   └── AndroidManifest.xml
│       ├── test/                           # Unit tests
│       └── androidTest/                    # Instrumented tests
├── gradle/
│   └── libs.versions.toml                  # Centralized dependency version catalog
├── build.gradle.kts
└── settings.gradle.kts
```

---

## 🛠️ Tech Stack

| Category      | Technology                         |
| -------------- | ----------------------------------- |
| Language        | Kotlin                              |
| UI              | Jetpack Compose + Material 3        |
| Remote DB       | Firebase Realtime Database          |
| Navigation      | Jetpack Navigation Compose          |
| Build           | Gradle (Kotlin DSL)                 |
| Min SDK         | 25 (Android 7.1)                    |
| Target SDK      | 36                                  |

---

## 🚀 Getting Started

### Prerequisites

- Android Studio (latest stable release)
- JDK 11+
- Android SDK 25+ (Android 7.1 or above)
- A Firebase project with **Realtime Database** enabled

### Setup

**1. Clone the repository**

```
git clone https://github.com/navneetdev141/MyQuotesApp.git
cd MyQuotesApp
```

**2. Firebase Setup**

This repo ships with a working `app/google-services.json`, so it will build and run out of the box. To point the app at your **own** Firebase project instead:

- Go to the [Firebase Console](https://console.firebase.google.com/) and create a project
- Add an Android app with package name `com.example.myquotesapp`
- Download your `google-services.json` and replace the one in `app/`
- Enable **Realtime Database** and set rules appropriate for your use case (the app currently reads/writes without authentication)

> **Note:** For a personal or production project, it's good practice to keep `google-services.json` out of version control (add it to `.gitignore`) rather than committing it, since it contains your project's API key.

**3. Build and Run**

Open in Android Studio and run on a device or emulator (API 25+).

---

## 🗄️ Database Structure

```
Firebase Realtime Database
└── quotes/
    └── {quoteId}/
        ├── id       String — same as the node key
        ├── quote    String — the quote text
        ├── book     String
        ├── author   String
        └── page     String
```

---

## 📄 License

```
MIT License — feel free to use this project as a reference or learning resource.
```

---

## 👨‍💻 Author

Built with ❤️ by **Navneet Kumar**

[![GitHub](https://img.shields.io/badge/GitHub-navneetdev141-black?style=flat&logo=github)](https://github.com/navneetdev141)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-Connect-blue?style=flat&logo=linkedin)](https://linkedin.com/in/navneet-kumar-70b678325)

---

⭐ Star this repo if you found it helpful!
