package com.example.wordsearch

class WordSearchGame {
    val gridSize = 5
    val wordToFind = "KOTLIN"
    private val words = listOf("KOTLIN", "JAVA", "ANDROID", "XML", "LAYOUT")
    private val positionsSelected = mutableSetOf<Int>()

    var grid: MutableList<Char> = MutableList(gridSize * gridSize) { ' ' }

    fun initializeGame() {
        // Preenche o grid com letras aleatórias
        for (i in grid.indices) {
            grid[i] = ('A'..'Z').random()
        }

        // Coloca a palavra no grid
        placeWord(wordToFind)
    }

    private fun placeWord(word: String) {
        // Coloca a palavra na primeira linha (para simplificar)
        for (i in word.indices) {
            grid[i] = word[i]
        }
    }

    fun selectLetter(position: Int) {
        positionsSelected.add(position)
    }

    fun isWordFound(): Boolean {
        return positionsSelected.containsAll(wordToFind.indices.toList())
    }
}