package com.example.rockpaperscissors

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.core.view.children

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val container = findViewById<LinearLayout>(R.id.container)
        for (k in container.children) {
            if (k is Button) {
                k.setOnClickListener(this)
            }
        }
    }

    override fun onClick(view: View?) {
        val button = view as? Button
        button ?: return
        var selected: Selected? = null
        for (i in Selected.values()) {
            if (button.id == i.resourceId) {
                selected = i
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra(Selected::class.java.simpleName, selected.ordinal)
                startActivity(intent)
                return
            }
        }
    }
}