package com.example.rockpaperscissors

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import kotlin.random.Random

class SecondActivity: AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val returnButton = findViewById<Button>(R.id.returnButton)
        returnButton.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        val bundle = intent.extras
        val selectedOrdinal = bundle?.getInt(Selected::class.java.simpleName)
        selectedOrdinal ?: return
        val selected: Selected = Selected.values()[selectedOrdinal]
        val randomSelected = Selected.values()[Random.nextInt(Selected.values().size)]
        setChoiceLabel(findViewById(R.id.yourChoice), selected)
        setChoiceLabel(findViewById(R.id.randomChoice), randomSelected)
        val result = findViewById<TextView>(R.id.resultMessage)
        val main = findViewById<ConstraintLayout>(R.id.secondActivityMain)
        if (selected == randomSelected) {
            result.text = getString(R.string.no_one_won_message)
            main.setBackgroundColor(ContextCompat.getColor(this, R.color.no_one_won))
        } else if ((selected == Selected.ROCK && randomSelected == Selected.SCISSORS) ||
            (selected == Selected.PAPER && randomSelected == Selected.ROCK) ||
            (selected == Selected.SCISSORS && randomSelected == Selected.PAPER)) {
            result.text = getString(R.string.victory_message)
            main.setBackgroundColor(ContextCompat.getColor(this, R.color.victory_color))
        } else {
            result.text = getString(R.string.loss_message)
            main.setBackgroundColor(ContextCompat.getColor(this, R.color.loss_color))
        }
    }

    private fun setChoiceLabel(textView: TextView, selected: Selected) {
        when (selected) {
            Selected.ROCK -> {
                textView.text = getString(R.string.rock_label)
            }
            Selected.PAPER -> {
                textView.text = getString(R.string.paper_label)
            }
            Selected.SCISSORS -> {
                textView.text = getString(R.string.scissors_label)
            }
        }
    }
}