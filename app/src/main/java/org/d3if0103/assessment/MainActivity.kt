package org.d3if0103.assessment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import org.d3if0103.assessment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonhm.setOnClickListener {hitungHm()}
        binding.buttondam.setOnClickListener{hitungDam()}
        binding.buttonm.setOnClickListener  {hitungm()}
        binding.buttondm.setOnClickListener {hitungdm()}
        binding.buttoncm.setOnClickListener {hitungcm()}
        binding.buttonmm.setOnClickListener {hitungmm()}
    }

    private fun hitungHm(){
        val panjang = binding.kmInp.toString()
        if(TextUtils.isEmpty(panjang)) {
            Toast.makeText(this,"Panjang tidak boleh kosong", Toast.LENGTH_LONG).show()
            return
        }

        val tinggi = binding.kmInp.text.toString().toInt()
        val hasilTextView = tinggi * 10
        binding.hasilTextView.text = "Hasil: $hasilTextView"
    }

    private fun hitungDam(){
        val panjang = binding.kmInp.toString()
        if(TextUtils.isEmpty(panjang)) {
            Toast.makeText(this,"Panjang tidak boleh kosong", Toast.LENGTH_LONG).show()
            return
        }

        val tinggi = binding.kmInp.text.toString().toInt()
        val hasilTextView = tinggi * 100
        binding.hasilTextView.text = "Hasil: $hasilTextView"
    }

    private fun hitungm(){
        val panjang = binding.kmInp.toString()
        if(TextUtils.isEmpty(panjang)) {
            Toast.makeText(this,"Panjang tidak boleh kosong", Toast.LENGTH_LONG).show()
            return
        }

        val tinggi = binding.kmInp.text.toString().toInt()
        val hasilTextView = tinggi * 1000
        binding.hasilTextView.text = "Hasil: $hasilTextView"
    }

    private fun hitungdm(){
        val panjang = binding.kmInp.toString()
        if(TextUtils.isEmpty(panjang)) {
            Toast.makeText(this,"Panjang tidak boleh kosong", Toast.LENGTH_LONG).show()
            return
        }

        val tinggi = binding.kmInp.text.toString().toInt()
        val hasilTextView = tinggi * 10000
        binding.hasilTextView.text = "Hasil: $hasilTextView"
    }

    private fun hitungcm(){
        val panjang = binding.kmInp.toString()
        if(TextUtils.isEmpty(panjang)) {
            Toast.makeText(this,"Panjang tidak boleh kosong", Toast.LENGTH_LONG).show()
            return
        }

        val tinggi = binding.kmInp.text.toString().toInt()
        val hasilTextView = tinggi * 100000
        binding.hasilTextView.text = "Hasil: $hasilTextView"
    }

    private fun hitungmm(){
        val panjang = binding.kmInp.toString()
        if(TextUtils.isEmpty(panjang)) {
            Toast.makeText(this,"Panjang tidak boleh kosong", Toast.LENGTH_LONG).show()
            return
        }

        val tinggi = binding.kmInp.text.toString().toInt()
        val hasilTextView = tinggi * 1000000
        binding.hasilTextView.text = "Hasil: $hasilTextView"
    }
}