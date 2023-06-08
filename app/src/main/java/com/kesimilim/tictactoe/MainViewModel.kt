package com.kesimilim.tictactoe

import androidx.lifecycle.ViewModel
import com.kesimilim.tictactoe.game_mode.GameMode
import com.kesimilim.tictactoe.game_mode.MultiGameMode
import com.kesimilim.tictactoe.game_mode.SingleGameMode

class MainViewModel : ViewModel() {

    var gameMode: GameMode = SingleGameMode()
    val singlePlayer: Boolean
        get () = gameMode is SingleGameMode

    fun updatePlayerMode(singlePlayer: Boolean) {
        gameMode.reset()
        gameMode = if (singlePlayer) SingleGameMode() else MultiGameMode()
    }
}