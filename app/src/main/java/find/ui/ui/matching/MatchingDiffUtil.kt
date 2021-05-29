package find.ui.ui.matching

import androidx.recyclerview.widget.DiffUtil

class MatchingDiffUtil : DiffUtil.ItemCallback<ResponseMatching>() {
    override fun areItemsTheSame(oldItem: ResponseMatching, newItem: ResponseMatching) =
        oldItem.userSequence == newItem.userSequence

    override fun areContentsTheSame(oldItem: ResponseMatching, newItem: ResponseMatching) =
        oldItem == newItem
}
