package com.kesimilim.tictactoe.game_mode

import com.kesimilim.tictactoe.GameUtils
import com.kesimilim.tictactoe.GameUtils.PLAYER_O
import com.kesimilim.tictactoe.GameUtils.PLAYER_X
import com.kesimilim.tictactoe.GameUtils.isBoardFull
import com.kesimilim.tictactoe.GameUtils.isGameWon

class SingleGameMode: BaseGameMode() {

    override fun computerMoveX() {
        if (!isBoardFull(board) && !isGameWon(board, PLAYER_O)) {
            val nextMove = GameUtils.computerMove(board)

            board = ArrayList(board.toMutableList().also {
                it[nextMove] = PLAYER_X
            })
        }
        currentPlayer = PLAYER_O
    }

    override fun computerMoveO() {
        if (!isBoardFull(board) && !isGameWon(board, PLAYER_X)) {
            val nextMove = GameUtils.computerMove(board)

            board = ArrayList(board.toMutableList().also {
                it[nextMove] = PLAYER_O
            })
        }
        currentPlayer = PLAYER_X
    }
}