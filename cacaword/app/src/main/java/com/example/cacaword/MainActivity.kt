package com.example.wordsearch

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var wordSearchGame: WordSearchGame
    private lateinit var wordTextView: TextView
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: WordSearchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializando componentes da UI
        wordTextView = findViewById(R.id.wordTextView)
        recyclerView = findViewById(R.id.recyclerView)

        // Criando o jogo
        wordSearchGame = WordSearchGame()
        wordSearchGame.initializeGame()

        // Configurando a RecyclerView com um GridLayoutManager
        recyclerView.layoutManager = GridLayoutManager(this, wordSearchGame.gridSize)
        adapter = WordSearchAdapter(wordSearchGame.grid) { position ->
            onLetterSelected(position)
        }
        recyclerView.adapter = adapter

        // Mostrando a palavra a ser encontrada
        wordTextView.text = wordSearchGame.wordToFind
    }

    private fun onLetterSelected(position: Int) {
        wordSearchGame.selectLetter(position)
        adapter.notifyItemChanged(position)

        if (wordSearchGame.isWordFound()) {
            wordTextView.text = "Parabéns! Você encontrou a palavra!"
        }
    }
}