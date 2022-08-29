package com.example.newtestgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newtestgame.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_result)
        binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //正解数を取得する
        val score = intent.getIntExtra("RIGHT_ANSWER_COUNT", 0)

        //不正解数を取得する
        val error_score = intent.getIntExtra("ERROR_ANSWER_COUNT", 0)

        //TextViewに表示させる
        binding.resultLabel.text = getString(R.string.result_score, score)

        binding.errorLabel.text = getString(R.string.error_score, error_score)


        //「もう一度」ボタン
        binding.tryAgainBtn.setOnClickListener{
            startActivity(Intent(this@ResultActivity, MainActivity::class.java))
        }

    }
}