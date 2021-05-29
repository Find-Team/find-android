package find.ui.ui.matching

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import find.ui.databinding.ItemFeelingConnectedBinding

class FeelingConnectedAdapter :
    ListAdapter<ResponseMatching, MatchingViewHolder<ItemFeelingConnectedBinding>>(
        MatchingDiffUtil()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MatchingViewHolder<ItemFeelingConnectedBinding>(
            ItemFeelingConnectedBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(
        holder: MatchingViewHolder<ItemFeelingConnectedBinding>,
        position: Int
    ) =
        holder.connectedBind(getItem(position))
}
