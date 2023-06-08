package com.kesimilim.tictactoe.game_mode

import android.util.Log
import com.kesimilim.tictactoe.GameUtils

class MultiGameMode: BaseGameMode() {

    override fun play(move: Int) {
        if (isGameOver) return

        if (board[move] == "") {
            if (currentPlayer == GameUtils.PLAYER_X) {
                board = ArrayList(board.toMutableList().also {
                    it[move] = GameUtils.PLAYER_X
                })
                currentPlayer = GameUtils.PLAYER_O
            } else {
                board = ArrayList(board.toMutableList().also {
                    it[move] = GameUtils.PLAYER_O
                })
                currentPlayer = GameUtils.PLAYER_X
            }
        }

        //calculate and show game result
        isGameOver = GameUtils.isGameWon(board, GameUtils.PLAYER_X) || GameUtils.isGameWon(
            board,
            GameUtils.PLAYER_O
        ) || GameUtils.isBoardFull(board)
        winner = GameUtils.gameResult(board, singleMode = false)

        Log.d(TAG, "$board")
    }

    companion object {
        private const val TAG = "MultiGameMode"
    }
}