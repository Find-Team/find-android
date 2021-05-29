package find.ui.ui.matching

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import find.ui.BR
import find.ui.databinding.ItemFeelingConnectedBinding

class FeelingConnectedAdapter :
    ListAdapter<ResponseMatching, FeelingConnectedAdapter.FeelingConnectedViewHolder>(
        FeelingDiffUtil()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FeelingConnectedViewHolder(
            ItemFeelingConnectedBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: FeelingConnectedViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class FeelingConnectedViewHolder(private val binding: ItemFeelingConnectedBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(connected: ResponseMatching) {
            binding.setVariable(BR.connected, connected)
        }
    }

    private class FeelingDiffUtil : DiffUtil.ItemCallback<ResponseMatching>() {
        override fun areItemsTheSame(oldItem: ResponseMatching, newItem: ResponseMatching) =
            oldItem.userSequence == newItem.userSequence

        override fun areContentsTheSame(oldItem: ResponseMatching, newItem: ResponseMatching) =
            oldItem == newItem
    }
}
