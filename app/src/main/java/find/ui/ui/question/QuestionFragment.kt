package find.ui.ui.question

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import find.ui.databinding.FragmentQuestionBinding
import find.ui.util.autoCleared

class QuestionFragment(private val questionList: List<Question>) : Fragment() {
    private var binding by autoCleared<FragmentQuestionBinding>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuestionBinding.inflate(layoutInflater)
        setAdapter()
        return binding.root
    }

    private fun setAdapter() {
        binding.vpQuestion.adapter = QuestionAdapter()
        (binding.vpQuestion.adapter as QuestionAdapter).submitList(questionList)
    }
}
