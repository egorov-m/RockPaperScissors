package com.example.rockpaperscissors;

import androidx.annotation.IdRes

enum class Selected(@IdRes val resourceId: Int) {
    ROCK(R.id.ROCK),
    PAPER(R.id.PAPER),
    SCISSORS(R.id.SCISSORS)
}
