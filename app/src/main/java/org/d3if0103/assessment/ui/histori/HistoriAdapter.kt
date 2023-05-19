package org.d3if0103.assessment.ui.histori

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.d3if0103.assessment.R
import org.d3if0103.assessment.databinding.ItemHistoriBinding
import org.d3if0103.assessment.db.ConverterEntity
import org.d3if0103.assessment.model.*
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class HistoriAdapter: ListAdapter<ConverterEntity, HistoriAdapter.ViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<ConverterEntity>() {
                override fun areItemsTheSame(
                    oldData: ConverterEntity, newData: ConverterEntity
                ): Boolean {
                    return oldData.id == newData.id
                }
                override fun  areContentsTheSame(
                    oldData: ConverterEntity, newData: ConverterEntity
                ): Boolean {
                    return oldData == newData
                }
            }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoriBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind1(getItem(position))
        holder.bind2(getItem(position))
        holder.bind3(getItem(position))
        holder.bind4(getItem(position))
        holder.bind5(getItem(position))
        holder.bind6(getItem(position))
    }

    class ViewHolder(
        private val binding: ItemHistoriBinding
    ): RecyclerView.ViewHolder(binding.root) {
        private val dateFormatter = SimpleDateFormat("dd MMMM yyyy",
            Locale("id", "ID")
        )

        fun bind1(item: ConverterEntity) = with(binding) {
            val hasilConverter1 = item.hitungConverter1()
            tanggalTextView.text = dateFormatter.format(Date(item.tanggal))
            bmiTextView.text = root.context.getString(R.string.hasil_x,
                hasilConverter1.converter)
        }

        fun bind2(item: ConverterEntity) = with(binding) {
            val hasilConverter2 = item.hitungConverter2()
            tanggalTextView.text = dateFormatter.format(Date(item.tanggal))
            bmiTextView.text = root.context.getString(R.string.hasil_x,
                hasilConverter2.converter)
        }

        fun bind3(item: ConverterEntity) = with(binding) {
            val hasilConverter3 = item.hitungConverter3()
            tanggalTextView.text = dateFormatter.format(Date(item.tanggal))
            bmiTextView.text = root.context.getString(R.string.hasil_x,
                hasilConverter3.converter)
        }

        fun bind4(item: ConverterEntity) = with(binding) {
            val hasilConverter4 = item.hitungConverter4()
            tanggalTextView.text = dateFormatter.format(Date(item.tanggal))
            bmiTextView.text = root.context.getString(R.string.hasil_x,
                hasilConverter4.converter)
        }

        fun bind5(item: ConverterEntity) = with(binding) {
            val hasilConverter5 = item.hitungConverter5()
            tanggalTextView.text = dateFormatter.format(Date(item.tanggal))
            bmiTextView.text = root.context.getString(R.string.hasil_x,
                hasilConverter5.converter)
        }

        fun bind6(item: ConverterEntity) = with(binding) {
            val hasilConverter6 = item.hitungConverter6()
            tanggalTextView.text = dateFormatter.format(Date(item.tanggal))
            bmiTextView.text = root.context.getString(R.string.hasil_x,
                hasilConverter6.converter)
        }
    }
}