package com.example.wordsearch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WordSearchAdapter(
    private val grid: List<Char>,
    private val onLetterSelected: (Int) -> Unit
) : RecyclerView.Adapter<WordSearchAdapter.LetterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_letter, parent, false)
        return LetterViewHolder(view)
    }

    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        val letter = grid[position]
        holder.bind(letter)

        holder.itemView.setOnClickListener {
            onLetterSelected(position)
        }
    }

    override fun getItemCount(): Int = grid.size

    class LetterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val letterTextView: TextView = itemView.findViewById(R.id.letterTextView)

        fun bind(letter: Char) {
            letterTextView.text = letter.toString()
        }
    }
}