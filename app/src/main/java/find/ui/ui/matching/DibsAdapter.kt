package find.ui.ui.matching

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import find.ui.databinding.ItemDibsBinding

class DibsAdapter(private val isMyDibs: Boolean) :
    ListAdapter<ResponseMatching, MatchingViewHolder<ItemDibsBinding>>(MatchingDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MatchingViewHolder(
            ItemDibsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MatchingViewHolder<ItemDibsBinding>, position: Int) =
        holder.dibsBind(getItem(position), isMyDibs)
}
