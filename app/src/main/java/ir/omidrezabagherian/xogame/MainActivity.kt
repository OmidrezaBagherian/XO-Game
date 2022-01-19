package ir.omidrezabagherian.xogame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var cellOne: TextView
    private lateinit var cellTwo: TextView
    private lateinit var cellThree: TextView
    private lateinit var cellFour: TextView
    private lateinit var cellFive: TextView
    private lateinit var cellSix: TextView
    private lateinit var cellSeven: TextView
    private lateinit var cellEight: TextView
    private lateinit var cellNine: TextView

    private lateinit var result: TextView
    private lateinit var reset: Button

    private var round = 1
    private var runGame = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cellOne = findViewById(R.id.text_main_one)
        cellTwo = findViewById(R.id.text_main_two)
        cellThree = findViewById(R.id.text_main_three)
        cellFour = findViewById(R.id.text_main_four)
        cellFive = findViewById(R.id.text_main_five)
        cellSix = findViewById(R.id.text_main_six)
        cellSeven = findViewById(R.id.text_main_seven)
        cellEight = findViewById(R.id.text_main_eight)
        cellNine = findViewById(R.id.text_main_nine)

        result = findViewById(R.id.text_main_result)
        reset = findViewById(R.id.button_reset_game)

        setInput()

        reset.setOnClickListener { resetGame() }

    }

    fun setInput() {
        cellOne.setOnClickListener {
            onBoxClicked(cellOne, round)
        }
        cellTwo.setOnClickListener {
            onBoxClicked(cellTwo, round)
        }
        cellThree.setOnClickListener {
            onBoxClicked(cellThree, round)
        }
        cellFour.setOnClickListener {
            onBoxClicked(cellFour, round)
        }
        cellFive.setOnClickListener {
            onBoxClicked(cellFive, round)
        }
        cellSix.setOnClickListener {
            onBoxClicked(cellSix, round)
        }
        cellSeven.setOnClickListener {
            onBoxClicked(cellSeven, round)
        }
        cellEight.setOnClickListener {
            onBoxClicked(cellEight, round)
        }
        cellNine.setOnClickListener {
            onBoxClicked(cellNine, round)
        }
    }

    private fun resetGame() {
        cellOne.text = ""
        cellTwo.text = ""
        cellThree.text = ""
        cellFour.text = ""
        cellFive.text = ""
        cellSix.text = ""
        cellSeven.text = ""
        cellEight.text = ""
        cellNine.text = ""
        result.text = ""
        round = 1
        runGame = true
    }

    private fun onBoxClicked(txt: TextView, round: Int) {
        if (runGame) {
            when (txt.text) {
                "X" -> {
                    Toast.makeText(this, "No isn't empty", Toast.LENGTH_SHORT).show()
                }
                "O" -> {
                    Toast.makeText(this, "No isn't empty", Toast.LENGTH_SHORT).show()
                }
                "" -> {
                    if (round % 2 == 1) {
                        txt.text = "X"
                        winner("X")
                    } else {
                        txt.text = "O"
                        winner("O")
                    }
                    this.round = round + 1
                }
            }
        } else {
            Toast.makeText(this, R.string.text_button_reset, Toast.LENGTH_SHORT).show()
        }
    }

    fun winner(word: String) {
        if (cellOne.text == word && cellTwo.text == word && cellThree.text == word) {
            result.text = "$word is winner"
            runGame = false
        } else if (cellFour.text == word && cellFive.text == word && cellSix.text == word) {
            result.text = "$word is winner"
            runGame = false
        } else if (cellSeven.text == word && cellEight.text == word && cellNine.text == word) {
            result.text = "$word is winner"
            runGame = false
        } else if (cellOne.text == word && cellFour.text == word && cellSeven.text == word) {
            result.text = "$word is winner"
            runGame = false
        } else if (cellTwo.text == word && cellFive.text == word && cellEight.text == word) {
            result.text = "$word is winner"
            runGame = false
        } else if (cellThree.text == word && cellSix.text == word && cellNine.text == word) {
            result.text = "$word is winner"
            runGame = false
        } else if (cellOne.text == word && cellFive.text == word && cellNine.text == word) {
            result.text = "$word is winner"
            runGame = false
        } else if (cellThree.text == word && cellFive.text == word && cellSeven.text == word) {
            result.text = "$word is winner"
            runGame = false
        } else {
            if (round>=9){
                result.text = "Draw!"
                runGame = false
            }
        }
    }

}