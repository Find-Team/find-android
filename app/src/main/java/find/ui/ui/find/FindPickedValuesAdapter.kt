package find.ui.ui.find

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import find.ui.BR
import find.ui.databinding.ItemFindMyValueBinding

class FindPickedValuesAdapter :
    ListAdapter<ResponsePickedValues, FindPickedValuesAdapter.FindPickedValueViewHolder>(
        FindPickedValuesDiffUtil()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FindPickedValueViewHolder(
            ItemFindMyValueBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: FindPickedValueViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class FindPickedValueViewHolder(private val binding: ItemFindMyValueBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pickedValues: ResponsePickedValues) {
            binding.setVariable(BR.title, pickedValues.question)
        }
    }

    private class FindPickedValuesDiffUtil : DiffUtil.ItemCallback<ResponsePickedValues>() {
        override fun areItemsTheSame(oldItem: ResponsePickedValues, newItem: ResponsePickedValues) =
            oldItem.question == newItem.question

        override fun areContentsTheSame(
            oldItem: ResponsePickedValues,
            newItem: ResponsePickedValues
        ) =
            oldItem == newItem
    }
}
