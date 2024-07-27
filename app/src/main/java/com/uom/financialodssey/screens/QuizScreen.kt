package com.uom.financialodssey.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.uom.financialodssey.viewmodel.GameViewModel

@Composable
fun QuizScreen(navController: NavController, viewModel: GameViewModel) {
    val currentScenario = viewModel.currentScenario
    var selectedChoiceIndex by remember { mutableStateOf(-1) }
    var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Feedback") },
            text = { Text(currentScenario.choices[selectedChoiceIndex].feedback) },
            confirmButton = {
                Button(onClick = {
                    showDialog = false
                    viewModel.saveChoice(currentScenario, selectedChoiceIndex)
                    if (viewModel.hasNextScenario()) {
                        viewModel.nextScenario()
                    } else {
                        navController.navigate("result")
                    }
                }) {
                    Text("Next")
                }
            }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(currentScenario.title, style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(8.dp))
        Text(currentScenario.description, style = MaterialTheme.typography.body1)
        Spacer(modifier = Modifier.height(16.dp))
        currentScenario.choices.forEachIndexed { index, choice ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = selectedChoiceIndex == index,
                    onClick = { selectedChoiceIndex = index }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(choice.choice)
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
        Button(
            onClick = { showDialog = true },
            enabled = selectedChoiceIndex != -1,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Next")
        }
    }
}
