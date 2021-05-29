package find.ui.ui.matching

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import find.ui.BR

class MatchingViewHolder<B : ViewDataBinding>(private val binding: B) :
    RecyclerView.ViewHolder(binding.root) {
    fun connectedBind(connected: ResponseMatching) {
        binding.setVariable(BR.connected, connected)
    }

    fun feelingBind(feeling: ResponseMatching, isSend: Boolean) {
        binding.setVariable(BR.feeling, feeling)
        binding.setVariable(BR.isSend, isSend)
    }

    fun dibsBind(dibs: ResponseMatching, isMyDibs: Boolean) {
        binding.setVariable(BR.dibs, dibs)
        binding.setVariable(BR.isMyDibs, isMyDibs)
    }
}
