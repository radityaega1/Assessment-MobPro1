package org.d3if0103.assessment.ui.tentang

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.d3if0103.assessment.R
import org.d3if0103.assessment.databinding.ListItemBinding
import org.d3if0103.assessment.model.TentangConverter
import org.d3if0103.assessment.network.ConverterApi

class TentangAdapter: RecyclerView.Adapter<TentangAdapter.ViewHolder>() {
    private val data = mutableListOf<TentangConverter>()

    fun updateData(newData: List<TentangConverter>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(Converter: TentangConverter) = with(binding) {
            judulTextView.text = Converter.judul
            keteranganTextView.text = Converter.keterangan
            Glide.with(imageView.context)
                .load(ConverterApi.getConverterUrl(Converter.imageId))
                .error(R.drawable.baseline_broken_image_24)
                .into(imageView)

            root.setOnClickListener {
                val message = root.context.getString(R.string.message, Converter.judul)
                Toast.makeText(root.context, message, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }
}