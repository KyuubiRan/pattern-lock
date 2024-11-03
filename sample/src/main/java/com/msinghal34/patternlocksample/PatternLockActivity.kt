package com.msinghal34.patternlocksample

import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import com.msinghal34.patternlock.PatternLockView
import com.msinghal34.patternlocksample.databinding.ActivityPattern9x9Binding
import com.msinghal34.patternlocksample.databinding.ActivityPatternDefaultBinding
import com.msinghal34.patternlocksample.databinding.ActivityPatternJdBinding
import com.msinghal34.patternlocksample.databinding.ActivityPatternWithIndicatorBinding

class PatternLockActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val type = intent.getIntExtra(MainActivity.KEY_PATTERN_TYPE, MainActivity.TYPE_DEFAULT)
        when (type) {
            MainActivity.TYPE_DEFAULT -> {
                val binding = ActivityPatternDefaultBinding.inflate(layoutInflater)
                setContentView(binding.root)
                binding.defaultPatternLockView.setOnPatternListener(listener)
            }

            MainActivity.TYPE_JD_STYLE -> {
                val binding = ActivityPatternJdBinding.inflate(layoutInflater)
                setContentView(binding.root)
                binding.jdPatternLockView.setOnPatternListener(listener)
            }

            MainActivity.TYPE_WITH_INDICATOR -> {
                val binding = ActivityPatternWithIndicatorBinding.inflate(layoutInflater)
                setContentView(binding.root)
                binding.indicatorPatternLockView.setOnPatternListener(listener)
            }

            MainActivity.TYPE_9x9 -> {
                val binding = ActivityPattern9x9Binding.inflate(layoutInflater)
                setContentView(binding.root)
                binding.ninePatternLockView.setOnPatternListener(listener)
            }

            MainActivity.TYPE_SECURE_MODE -> {
                val binding = ActivityPatternDefaultBinding.inflate(layoutInflater)
                setContentView(binding.root)
                binding.defaultPatternLockView.enableSecureMode()
                binding.defaultPatternLockView.setOnPatternListener(listener)
            }
        }
    }

    private var listener = object : PatternLockView.OnPatternListener {

        override fun onComplete(ids: ArrayList<Int>): Boolean {
            val isCorrect = TextUtils.equals("012", getPatternString(ids))
            return isCorrect
        }
    }

    private fun getPatternString(ids: ArrayList<Int>): String {
        var result = ""
        for (id in ids) {
            result += id.toString()
        }
        return result
    }
}
