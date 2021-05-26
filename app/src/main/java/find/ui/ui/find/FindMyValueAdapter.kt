package find.ui.ui.find

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import find.ui.BR
import find.ui.databinding.ItemFindMyValueBinding

class FindMyValueAdapter :
    ListAdapter<String, FindMyValueAdapter.FindMyValueViewHolder>(FindMyValueDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FindMyValueViewHolder(
            ItemFindMyValueBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: FindMyValueViewHolder, position: Int) =
        holder.bind(getItem(position))

    class FindMyValueViewHolder(private val binding: ItemFindMyValueBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(title: String) {
            binding.setVariable(BR.title, title)
        }
    }

    private class FindMyValueDiffUtil : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: String, newItem: String) =
            oldItem == newItem
    }
}
