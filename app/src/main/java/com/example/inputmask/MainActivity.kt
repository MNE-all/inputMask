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
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                var digits = binding.txtInputMask.text.toString().length
                if (s?.length!! <= 9) { var lastChar = ""
//                if (digits > 9) {
//                    binding.txtInputMask.setText(
//                        binding.txtInputMask.text.toString().substring(0, 9)
//                    )
//                    val txtValue = binding.txtInputMask.text.toString().substring(0, 4) +
//                            " " + binding.txtInputMask.text.toString().substring(5, 4)
//                    binding.txtInputMask.setText(txtValue)
//                }
                    if (digits > 1) {
                        lastChar = binding.txtInputMask.text.toString().substring(digits - 1)
                    }
                    if (lastChar != " ") {
                        if (digits == 4) {
                            binding.txtInputMask.text.append(" ")
                        }
                    }
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
    }
}