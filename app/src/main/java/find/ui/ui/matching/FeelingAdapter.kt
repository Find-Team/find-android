package find.ui.ui.matching

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import find.ui.databinding.ItemFeelingSendGetBinding

class FeelingAdapter(private val isSend: Boolean) :
    ListAdapter<ResponseMatching, MatchingViewHolder<ItemFeelingSendGetBinding>>(MatchingDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MatchingViewHolder<ItemFeelingSendGetBinding>(
            ItemFeelingSendGetBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(
        holder: MatchingViewHolder<ItemFeelingSendGetBinding>,
        position: Int
    ) =
        holder.feelingBind(getItem(position), isSend)
}
