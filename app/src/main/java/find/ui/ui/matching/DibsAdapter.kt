package find.ui.ui.matching

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import find.ui.BR
import find.ui.databinding.ItemDibsBinding

class DibsAdapter(private val isMyDibs: Boolean) :
    ListAdapter<ResponseMatching, DibsAdapter.DibsViewHolder>(SendDibsDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DibsViewHolder(
            ItemDibsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: DibsViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class DibsViewHolder(private val binding: ItemDibsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(dibs: ResponseMatching) {
            binding.setVariable(BR.dibs, dibs)
            binding.setVariable(BR.isMyDibs, isMyDibs)
        }
    }

    private class SendDibsDiffUtil : DiffUtil.ItemCallback<ResponseMatching>() {
        override fun areItemsTheSame(oldItem: ResponseMatching, newItem: ResponseMatching) =
            oldItem.userSequence == newItem.userSequence

        override fun areContentsTheSame(oldItem: ResponseMatching, newItem: ResponseMatching) =
            oldItem == newItem
    }
}
