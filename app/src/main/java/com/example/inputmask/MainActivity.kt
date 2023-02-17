package com.example.inputmask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.inputmask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtInputMask.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                var digits = binding.txtInputMask.text.toString().length
                var txtTemp = s.toString()
                if (s?.length!! < 10) {
                    var lastChar = ""
                    if (digits > 1) {
                        lastChar = binding.txtInputMask.text.toString().substring(digits - 1)
                    }
                    if (digits == 4) {
                        binding.txtInputMask.text.append(" ")
                    }
                } else {
                    txtTemp = txtTemp.replace(" ", "")
                    txtTemp = txtTemp.replaceRange(4, 4, " ").substring(0, s?.length!! - 1)
                    binding.txtInputMask.setText(txtTemp)
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }
}