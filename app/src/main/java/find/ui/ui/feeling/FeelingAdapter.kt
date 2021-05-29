package find.ui.ui.feeling

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import find.ui.databinding.ItemFeelingSendGetBinding
import find.ui.ui.matching.MatchingDiffUtil
import find.ui.ui.matching.MatchingViewHolder
import find.ui.ui.matching.ResponseMatching

class FeelingAdapter(private val isSend: Boolean) :
    ListAdapter<ResponseMatching, MatchingViewHolder<ItemFeelingSendGetBinding>>(MatchingDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MatchingViewHolder(
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
