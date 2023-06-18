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

    override fun play(move: Int) {
        if (isGameOver) return

        if (board[move] == "") {
            if (currentPlayer == GameUtils.PLAYER_X) {
                board = ArrayList(board.toMutableList().also {
                    it[move] = GameUtils.PLAYER_X
                })
                currentPlayer = GameUtils.PLAYER_O

                computerMoveO()

            } else {
                board = ArrayList(board.toMutableList().also {
                    it[move] = GameUtils.PLAYER_O
                })
                currentPlayer = GameUtils.PLAYER_X

                computerMoveX()
            }
        }

        //calculate and show game result
        isGameOver = GameUtils.isGameWon(board, GameUtils.PLAYER_X) || GameUtils.isGameWon(
            board,
            GameUtils.PLAYER_O
        ) || GameUtils.isBoardFull(board)
        winner = GameUtils.gameResult(board, singleMode = true)
    }

    override fun computerMoveX() {}

    override fun computerMoveO() {}

    override fun reset() {
        isGameOver = false
        board = arrayListOf("", "", "", "", "", "", "", "", "")
    }
}