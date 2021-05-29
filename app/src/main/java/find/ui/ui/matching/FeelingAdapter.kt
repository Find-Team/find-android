package find.ui.ui.matching

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import find.ui.BR
import find.ui.databinding.ItemFeelingSendGetBinding

class FeelingAdapter(private val isSend: Boolean) :
    ListAdapter<ResponseMatching, FeelingAdapter.FeelingViewHolder>(SendFeelingDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FeelingViewHolder(
            ItemFeelingSendGetBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: FeelingViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class FeelingViewHolder(private val binding: ItemFeelingSendGetBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(feeling: ResponseMatching) {
            binding.setVariable(BR.feeling, feeling)
            binding.setVariable(BR.isSend, isSend)
        }
    }

    private class SendFeelingDiffUtil : DiffUtil.ItemCallback<ResponseMatching>() {
        override fun areItemsTheSame(oldItem: ResponseMatching, newItem: ResponseMatching) =
            oldItem.userSequence == newItem.userSequence

        override fun areContentsTheSame(oldItem: ResponseMatching, newItem: ResponseMatching) =
            oldItem == newItem
    }
}
