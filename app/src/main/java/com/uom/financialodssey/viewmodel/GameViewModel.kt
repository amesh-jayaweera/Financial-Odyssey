package com.uom.financialodssey.viewmodel

import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    private val scenarios = listOf(
        GameScenario(
            title = "Part-Time Job & Laptop (January)",
            description = "It's January, and you find a part-time, remote job that requires a new laptop...",
            choices = listOf(
                Choice("Take out a personal loan for LKR 80,000 with a 12% annual interest rate, to be paid back in 12 months (monthly payment: LKR 7,032).  Accept the job. (Net monthly income: LKR 12,968 after loan payment)", "You start earning right away but will have debt for the next year."),
                Choice("Delay taking the job and save for the laptop over 4 months, using your disposable income (LKR 40,000). Then start the job. (Net monthly income: LKR 20,000 after 4 months)", "You avoid debt but delay your income potential for several months.")
            )
        ),
        // Add other scenarios here
    )

    private var scenarioIndex = 0
    val currentScenario: GameScenario
        get() = scenarios[scenarioIndex]

    var savingsGoal = 0
        private set

    private val playerStatus = PlayerStatus(
        monthlySalary = 100000F,
        monthlyExpenses = 65000F,
        bonus = 20000F,
        initialSavings = 0F,
        savingsGoal = 0F
    )

    private val choicesMade = mutableListOf<Pair<GameScenario, Int>>()

    fun setSavingsGoal(goal: Int) {
        savingsGoal = goal
    }

    fun saveChoice(scenario: GameScenario, choiceIndex: Int) {
        choicesMade.add(scenario to choiceIndex)
    }

    fun hasNextScenario(): Boolean {
        return scenarioIndex < scenarios.size - 1
    }

    fun nextScenario() {
        if (hasNextScenario()) {
            scenarioIndex++
        }
    }

    fun calculateTotalSavings(): Float {
        // Implement the logic to calculate total savings based on choices made
        return playerStatus.initialSavings
    }
}