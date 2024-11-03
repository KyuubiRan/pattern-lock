package com.msinghal34.patternlocksample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.msinghal34.patternlocksample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object {
        const val KEY_PATTERN_TYPE = "type"

        const val TYPE_DEFAULT = 0
        const val TYPE_WITH_INDICATOR = 1
        const val TYPE_JD_STYLE = 2
        const val TYPE_9x9 = 3
        const val TYPE_SECURE_MODE = 4
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.defaultBtn.setOnClickListener { _ -> startPatternActivity(TYPE_DEFAULT) }
        binding.jdStyleBtn.setOnClickListener { _ -> startPatternActivity(TYPE_JD_STYLE) }
        binding.indicatorBtn.setOnClickListener { _ -> startPatternActivity(TYPE_WITH_INDICATOR) }
        binding.nineBtn.setOnClickListener { _ -> startPatternActivity(TYPE_9x9) }
        binding.secureModeBtn.setOnClickListener { _ -> startPatternActivity(TYPE_SECURE_MODE) }
    }

    private fun startPatternActivity(type: Int) {
        val intent = Intent(this, PatternLockActivity::class.java)
        intent.putExtra(KEY_PATTERN_TYPE, type)
        startActivity(intent)
    }
}
