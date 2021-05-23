package find.ui.ui.question

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import find.ui.BR
import find.ui.databinding.ItemQuestionBinding

class QuestionAdapter :
    ListAdapter<Question, QuestionAdapter.QuestionViewHolder>(QuestionDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        QuestionViewHolder(
            ItemQuestionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) =
        holder.bind(getItem(position))

    class QuestionViewHolder(private val binding: ItemQuestionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(question: Question) {
            binding.setVariable(BR.question, question)
            binding.setVariable(BR.position, adapterPosition)
        }
    }

    private class QuestionDiffUtil : DiffUtil.ItemCallback<Question>() {
        override fun areItemsTheSame(oldItem: Question, newItem: Question) =
            oldItem.question == newItem.question

        override fun areContentsTheSame(oldItem: Question, newItem: Question) = oldItem == newItem
    }
}
