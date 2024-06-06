package com.example.math_game

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.math_game.databinding.ActivityMainBinding
import java.util.Random

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    var number1 = 0
    var number2 = 0
    var javob = 0
    var amal = 0
    var userInputAnswer = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        random()
        binding.img1.setOnClickListener {
            random()
        }

        binding.edt.addTextChangedListener{
            if (binding.edt.text.toString().length == javob.toString().length) {
                if (binding.edt.text.isNotEmpty()) {
                    userInputAnswer = binding.edt.text.toString().toInt()


                    if (userInputAnswer == javob) {
                        val mediaPlayer = MediaPlayer.create(this, R.raw.true1)
                        mediaPlayer.start()
                        random()
                        binding.edt.setText("")
                        Toast.makeText(this, "Javob to'g'ri!", Toast.LENGTH_SHORT).show()

                    } else {
                        val mediaPlayer = MediaPlayer.create(this, R.raw.error)
                        mediaPlayer.start()
                        Toast.makeText(this, "Javob no'tg'ri!", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Javob kiritilmagan!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


    fun random() {

        number1 = Random().nextInt(20)
        number2 = Random().nextInt(20)
        amal = Random().nextInt(4)

        showDisplay()
    }

    fun showDisplay() {

        when (amal) {


            0 -> {

                javob = number1 + number2
                binding.txt.text = "$number1 + $number2 ="
            }

            1 -> {
                javob = number1 - number2
                binding.txt.text = "$number1 - $number2 ="
            }

            2 -> {
                javob = number1 * number2
                binding.txt.text = "$number1 * $number2 ="
            }

            3 -> {
                if (number1 % number2 == 0) {
                    javob = number1 / number2
                    binding.txt.text = "$number1 / $number2 ="
                } else {
                    random()
                }
            }
        }
    }
}

