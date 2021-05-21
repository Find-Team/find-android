package find.ui.ui.interview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import find.ui.databinding.ItemAskBinding

class InterviewAdapter :
    RecyclerView.Adapter<InterviewAdapter.InterviewVHolder>() {
    private val interviewViewModel = InterviewViewModel()
    var items = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InterviewVHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return InterviewVHolder(ItemAskBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: InterviewVHolder, position: Int) {
        holder.bind(interviewViewModel)
        holder.setTextTitle(items[position])
    }

    override fun getItemCount() = items.size

    fun refresh() {
        notifyDataSetChanged()
    }

    class InterviewVHolder(private val binding: ItemAskBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(viewModel: InterviewViewModel) {
            binding.interviewViewModel = viewModel
            binding.executePendingBindings()
        }

        fun setTextTitle(txt: String) {
            binding.tvAskTitle.text = txt
        }
    }
}