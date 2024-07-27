package com.uom.financialodssey

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uom.financialodssey.screens.QuizScreen
import com.uom.financialodssey.screens.ResultScreen
import com.uom.financialodssey.screens.StartScreen
import com.uom.financialodssey.theme.FinancialOdysseyTheme
import com.uom.financialodssey.viewmodel.GameViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val gameViewModel: GameViewModel = viewModel()

            FinancialOdysseyTheme {
                NavHost(navController, startDestination = "start") {
                    composable("start") { StartScreen(navController, gameViewModel) }
                    composable("quiz") { QuizScreen(navController, gameViewModel) }
                    composable("result") { ResultScreen(navController, gameViewModel) }
                }
            }
        }
    }
}