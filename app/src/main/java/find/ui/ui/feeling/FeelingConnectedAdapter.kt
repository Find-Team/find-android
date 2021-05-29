package find.ui.ui.feeling

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import find.ui.databinding.ItemFeelingConnectedBinding
import find.ui.ui.matching.MatchingDiffUtil
import find.ui.ui.matching.MatchingViewHolder
import find.ui.ui.matching.ResponseMatching

class FeelingConnectedAdapter :
    ListAdapter<ResponseMatching, MatchingViewHolder<ItemFeelingConnectedBinding>>(
        MatchingDiffUtil()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MatchingViewHolder(
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
