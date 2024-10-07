
package com.graminsta.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.graminsta.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.clearAll.setOnClickListener {
            binding.inputTextField.setText("")
            binding.outputTextField.setText("")
        }
        binding.clear.setOnClickListener {
            binding.inputTextField.setText("")
        }

        binding.btn0.setOnClickListener {
            binding.inputTextField.append("0")
        }

        binding.btn1.setOnClickListener {
            binding.inputTextField.append("1")
        }
        binding.btn2.setOnClickListener {
            binding.inputTextField.append("2")
        }
        binding.btn3.setOnClickListener {
            binding.inputTextField.append("3")
        }
        binding.btn4.setOnClickListener {
            binding.inputTextField.append("4")
        }
        binding.btn5.setOnClickListener {
            binding.inputTextField.append("5")
        }
        binding.btn6.setOnClickListener {
            binding.inputTextField.append("6")
        }
        binding.btn7.setOnClickListener {
            binding.inputTextField.append("7")
        }
        binding.btn8.setOnClickListener {
            binding.inputTextField.append("8")
        }
        binding.btn9.setOnClickListener {
            binding.inputTextField.append("9")
        }
        binding.dot.setOnClickListener {
            binding.inputTextField.append(".")
        }
        binding.plus.setOnClickListener {
            binding.inputTextField.append(" + ")
        }
        binding.multiply.setOnClickListener {
            binding.inputTextField.append(" * ")
        }
        binding.mod.setOnClickListener {
            binding.inputTextField.append(" % ")
        }
        binding.divide.setOnClickListener {
            binding.inputTextField.append(" / ")
        }


        binding.result.setOnClickListener {
            val expression = ExpressionBuilder(binding.inputTextField.text.toString()).build()
            val resul = expression.evaluate()
            val longresult = resul.toLong()

            if(resul == longresult.toDouble()){
                binding.outputTextField.setText(longresult.toString())
            }
            else{
                binding.outputTextField.setText(resul.toString())
            }
        }

    }

}