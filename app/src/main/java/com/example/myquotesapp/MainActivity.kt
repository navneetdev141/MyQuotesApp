package com.example.myquotesapp

import android.R.attr.type
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myquotesapp.ui.theme.MyQuotesAppTheme
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        FirebaseApp.initializeApp(this)
        setContent {
            MyQuotesApp()
        }
    }
}

@Composable
fun MyQuotesApp() {
    val navController = rememberNavController()
    NavHost(navController ,startDestination = "display"){
        composable("display"){DisplayQuoteScreen(navController)}
        composable("add"){AddQuoteScreen(navController)}
        composable(route = "edit/{id}/{quote}/{book}/{author}/{page}",
            arguments = listOf(
                navArgument("id"){type= NavType.StringType},
                navArgument("quote"){type= NavType.StringType},
                navArgument ("book"){type= NavType.StringType},
                navArgument("author"){type= NavType.StringType},
                navArgument("page"){type= NavType.StringType},
            )){
            backStackEntry ->
            val args = backStackEntry.arguments!!
            EditQuoteScreen(navController, Quote(
                id = args.getString("id")?: "",
                quote = args.getString("quote")?: "",
                book = args.getString("book")?: "",
                author = args.getString("author")?: "",
                page = args.getString("page")?: "",
            ))
        }
    }
}
