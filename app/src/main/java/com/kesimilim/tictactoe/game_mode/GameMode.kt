package com.kesimilim.tictactoe.game_mode

interface GameMode {
    val isGameOver: Boolean
    val winner: String
    val board: ArrayList<String>

    fun play(move: Int)
    fun computerMoveX()
    fun computerMoveO()
    fun reset()
}