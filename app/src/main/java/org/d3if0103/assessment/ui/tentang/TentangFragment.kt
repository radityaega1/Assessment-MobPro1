package org.d3if0103.assessment.ui.tentang

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import org.d3if0103.assessment.databinding.FragmentTentangBinding
import org.d3if0103.assessment.network.ApiStatus

class TentangFragment: Fragment() {
    private val viewModel: TentangViewModel by lazy {
        ViewModelProvider(this)[TentangViewModel::class.java]
    }

    private lateinit var binding: FragmentTentangBinding
    private lateinit var myAdapter: TentangAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        Log.i("TentangFragment", "onCreateView dipanggil")
        binding = FragmentTentangBinding.inflate(layoutInflater, container, false)
        myAdapter = TentangAdapter()
        with(binding.recyclerView) {
            addItemDecoration(DividerItemDecoration(context,
                RecyclerView.VERTICAL))
            adapter = myAdapter
            setHasFixedSize(true)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("TentangFragment", "onViewCreated dipanggil")

        viewModel.getData().observe(viewLifecycleOwner) {
            myAdapter.updateData(it)
        }

        viewModel.getStatus().observe(viewLifecycleOwner) {
            updateProgress(it)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("TentangFragment", "onStart dipanggil")
    }

    override fun onResume() {
        super.onResume()
        Log.i("TentangFragment", "onResume dipanggil")
    }

    override fun onPause() {
        Log.i("TentangFragment", "onPause dipanggil")
        super.onPause()
    }

    override fun onStop() {
        Log.i("TentangFragment", "onStop dipanggil")
        super.onStop()
    }

    override fun onDestroy() {
        Log.i("TentangFragment", "onDestroy dipanggil")
        super.onDestroy()
    }

    private fun updateProgress(status: ApiStatus) {
        when (status) {
            ApiStatus.LOADING -> {
                binding.progressBar.visibility = View.VISIBLE
            }
            ApiStatus.SUCCESS -> {
                binding.progressBar.visibility = View.GONE
            }
            ApiStatus.FAILED -> {
                binding.progressBar.visibility = View.GONE
                binding.networkError.visibility = View.VISIBLE
            }
        }
    }
}