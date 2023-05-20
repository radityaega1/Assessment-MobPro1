package org.d3if0103.assessment.ui.hitung

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import org.d3if0103.assessment.R
import org.d3if0103.assessment.model.HasilConverter
import org.d3if0103.assessment.databinding.FragmentHitungBinding
import org.d3if0103.assessment.db.ConverterDb

class HitungFragment: Fragment() {
    private lateinit var binding: FragmentHitungBinding
    private val viewModel: HitungViewModel by lazy {
        val db = ConverterDb.getInstance(requireContext())
        val factory = HitungViewModelFactory(db.dao)
        ViewModelProvider(this, factory)[HitungViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        binding = FragmentHitungBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonhm.setOnClickListener {hitungHm()}
        binding.buttondam.setOnClickListener{hitungDam()}
        binding.buttonm.setOnClickListener  {hitungm()}
        binding.buttondm.setOnClickListener {hitungdm()}
        binding.buttoncm.setOnClickListener {hitungcm()}
        binding.buttonmm.setOnClickListener {hitungmm()}
        binding.bagikanButton.setOnClickListener { sharedData() }

        viewModel.getHasil1().observe(requireActivity(),{showResult(it)})
        viewModel.getHasil2().observe(requireActivity(),{showResult(it)})
        viewModel.getHasil3().observe(requireActivity(),{showResult(it)})
        viewModel.getHasil4().observe(requireActivity(),{showResult(it)})
        viewModel.getHasil5().observe(requireActivity(),{showResult(it)})
        viewModel.getHasil6().observe(requireActivity(),{showResult(it)})
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_histori -> {
                findNavController().navigate(
                    R.id.action_hitungFragment_to_historiFragment)
                return true
            }
            R.id.menu_about -> {
                findNavController().navigate(
                    R.id.action_hitungFragment_to_aboutFragment)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun hitungHm(){
        val panjang1 = binding.kmInp.text.toString()
        if(TextUtils.isEmpty(panjang1)) {
            Toast.makeText(context, R.string.panjang_invalid, Toast.LENGTH_LONG).show()
            return
        }

        //val tinggi = binding.kmInp.text.toString().toInt()
        //val hasilTextView = tinggi * 10
        //binding.hasilTextView.text = "Hasil: $hasilTextView"

        viewModel.hitungConverter1(
            panjang1.toFloat()
        )
    }

    private fun hitungDam(){
        val panjang2 = binding.kmInp.text.toString()
        if(TextUtils.isEmpty(panjang2)) {
            Toast.makeText(context, R.string.panjang_invalid, Toast.LENGTH_LONG).show()
            return
        }

        //val tinggi = binding.kmInp.text.toString().toInt()
        //val hasilTextView = tinggi * 100
        //binding.hasilTextView.text = "Hasil: $hasilTextView"

        viewModel.hitungConverter2(
            panjang2.toFloat()
        )
    }

    private fun hitungm(){
        val panjang = binding.kmInp.text.toString()
        if(TextUtils.isEmpty(panjang)) {
            Toast.makeText(context, R.string.panjang_invalid, Toast.LENGTH_LONG).show()
            return
        }

        //val tinggi = binding.kmInp.text.toString().toInt()
        //val hasilTextView = tinggi * 1000
        //binding.hasilTextView.text = "Hasil: $hasilTextView"

        viewModel.hitungConverter3(
            panjang.toFloat()
        )
    }

    private fun hitungdm(){
        val panjang = binding.kmInp.text.toString()
        if(TextUtils.isEmpty(panjang)) {
            Toast.makeText(context, R.string.panjang_invalid, Toast.LENGTH_LONG).show()
            return
        }

        //val tinggi = binding.kmInp.text.toString().toInt()
        //val hasilTextView = tinggi * 10000
        //binding.hasilTextView.text = "Hasil: $hasilTextView"

        viewModel.hitungConverter4(
            panjang.toFloat()
        )
    }

    private fun hitungcm(){
        val panjang = binding.kmInp.text.toString()
        if(TextUtils.isEmpty(panjang)) {
            Toast.makeText(context, R.string.panjang_invalid, Toast.LENGTH_LONG).show()
            return
        }

        //val tinggi = binding.kmInp.text.toString().toInt()
        //val hasilTextView = tinggi * 100000
        //binding.hasilTextView.text = "Hasil: $hasilTextView"

        viewModel.hitungConverter5(
            panjang.toFloat()
        )
    }

    private fun hitungmm(){
        val panjang = binding.kmInp.text.toString()
        if(TextUtils.isEmpty(panjang)) {
            Toast.makeText(context, R.string.panjang_invalid, Toast.LENGTH_LONG).show()
            return
        }

        //val tinggi = binding.kmInp.text.toString().toInt()
        //val hasilTextView = tinggi * 1000000
        //binding.hasilTextView.text = "Hasil: $hasilTextView"

        viewModel.hitungConverter6(
            panjang.toFloat()
        )
    }

    private fun showResult(result: HasilConverter?) {
        if(result == null) return
        binding.hasilTextView.text = getString(R.string.hasil_x, result.converter)
    }

    private fun sharedData() {
        val message = getString(R.string.bagikan,
            binding.kmInp.text,
            binding.hasilTextView.text
        )

        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, message)
        if (shareIntent.resolveActivity(
                requireActivity().packageManager) != null) {
            startActivity(shareIntent)
        }
    }
}