package com.kesimilim.tictactoe.game_mode

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.kesimilim.tictactoe.GameUtils

open class BaseGameMode: GameMode {

    override var isGameOver by mutableStateOf(false)
        internal set

    override var winner by mutableStateOf("")
        internal set

    override var board by mutableStateOf(arrayListOf("", "", "", "", "", "", "", "", ""))
        internal set

    internal var currentPlayer = GameUtils.PLAYER_X

    override fun play(move: Int) {}

    override fun reset() {
        isGameOver = false
        board = arrayListOf("", "", "", "", "", "", "", "", "")
    }
}