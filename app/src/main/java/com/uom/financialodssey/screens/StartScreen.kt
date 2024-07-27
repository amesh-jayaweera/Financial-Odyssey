package com.uom.financialodssey.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.uom.financialodssey.viewmodel.GameViewModel

@Composable
fun StartScreen(navController: NavController, viewModel: GameViewModel) {
    var savingsGoal by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Financial Odyssey", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Your character setup", style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.height(8.dp))
        Text("Monthly Salary - 100,000 LKR")
        Text("Monthly Expenses - 65,000 LKR")
        Text("Bonus - 20% of basic salary for two times a year.")
        Text("Initial Savings - 0 LKR")
        Spacer(modifier = Modifier.height(16.dp))
        Text("Enter expected minimum savings at the end of the year:")
        TextField(
            value = savingsGoal,
            onValueChange = { savingsGoal = it },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            viewModel.setSavingsGoal(savingsGoal.text.toFloatOrNull() ?: 0F)
            navController.navigate("quiz")
        }) {
            Text("Game Start")
        }
    }
}
