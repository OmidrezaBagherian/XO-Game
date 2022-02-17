package ir.omidrezabagherian.xogame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import ir.omidrezabagherian.xogame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var round = 1
    private var runGame = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)


        setContentView(binding.root)

        setInput()

        binding.buttonResetGame.setOnClickListener { resetGame() }

    }

    fun setInput() {
        binding.textMainOne.setOnClickListener {
            onBoxClicked(binding.textMainOne, round)
        }
        binding.textMainTwo.setOnClickListener {
            onBoxClicked(binding.textMainTwo, round)
        }
        binding.textMainThree.setOnClickListener {
            onBoxClicked(binding.textMainThree, round)
        }
        binding.textMainFour.setOnClickListener {
            onBoxClicked(binding.textMainFour, round)
        }
        binding.textMainFive.setOnClickListener {
            onBoxClicked(binding.textMainFive, round)
        }
        binding.textMainSix.setOnClickListener {
            onBoxClicked(binding.textMainSix, round)
        }
        binding.textMainSeven.setOnClickListener {
            onBoxClicked(binding.textMainSeven, round)
        }
        binding.textMainEight.setOnClickListener {
            onBoxClicked(binding.textMainEight, round)
        }
        binding.textMainNine.setOnClickListener {
            onBoxClicked(binding.textMainNine, round)
        }
    }

    private fun resetGame() {
        binding.textMainOne.text = ""
        binding.textMainTwo.text = ""
        binding.textMainThree.text = ""
        binding.textMainFour.text = ""
        binding.textMainFive.text = ""
        binding.textMainSix.text = ""
        binding.textMainSeven.text = ""
        binding.textMainEight.text = ""
        binding.textMainNine.text = ""
        binding.textMainResult.text = ""
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
        if (binding.textMainOne.text == word && binding.textMainTwo.text == word && binding.textMainThree.text == word) {
            binding.textMainResult.text = "$word is winner"
            runGame = false
        } else if (binding.textMainFour.text == word && binding.textMainFive.text == word && binding.textMainSix.text == word) {
            binding.textMainResult.text = "$word is winner"
            runGame = false
        } else if (binding.textMainSeven.text == word && binding.textMainEight.text == word && binding.textMainNine.text == word) {
            binding.textMainResult.text = "$word is winner"
            runGame = false
        } else if (binding.textMainOne.text == word && binding.textMainFour.text == word && binding.textMainSeven.text == word) {
            binding.textMainResult.text = "$word is winner"
            runGame = false
        } else if (binding.textMainTwo.text == word && binding.textMainFive.text == word && binding.textMainEight.text == word) {
            binding.textMainResult.text = "$word is winner"
            runGame = false
        } else if (binding.textMainThree.text == word && binding.textMainSix.text == word && binding.textMainNine.text == word) {
            binding.textMainResult.text = "$word is winner"
            runGame = false
        } else if (binding.textMainOne.text == word && binding.textMainFive.text == word && binding.textMainNine.text == word) {
            binding.textMainResult.text = "$word is winner"
            runGame = false
        } else if (binding.textMainThree.text == word && binding.textMainFive.text == word && binding.textMainSeven.text == word) {
            binding.textMainResult.text = "$word is winner"
            runGame = false
        } else {
            if (round >= 9) {
                binding.textMainResult.text = "Draw!"
                runGame = false
            }
        }
    }

}