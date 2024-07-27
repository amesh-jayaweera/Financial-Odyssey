package com.uom.financialodssey.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.uom.financialodssey.viewmodel.GameViewModel

@Composable
fun ResultScreen(navController: NavController, viewModel: GameViewModel) {
    val totalSavings = viewModel.calculateTotalSavings()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Results", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Total Savings: $totalSavings LKR")
        Spacer(modifier = Modifier.height(16.dp))
        if (totalSavings >= viewModel.savingsGoal) {
            Text("Congratulations! You have achieved your savings goal.", style = MaterialTheme.typography.h6)
        } else {
            Text("Try again to achieve your savings goal.", style = MaterialTheme.typography.h6)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("start") }) {
            Text("Play Again")
        }
    }
}
