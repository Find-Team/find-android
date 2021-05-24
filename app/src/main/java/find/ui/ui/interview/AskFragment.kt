package find.ui.ui.interview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import find.ui.databinding.FragmentAskBinding
import find.ui.util.autoCleared

class AskFragment(val interviewList: List<Interview>) : Fragment() {
    private var binding by autoCleared<FragmentAskBinding>()
    private val viewModel: InterviewViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAskBinding.inflate(inflater, container, false)
        binding.fragment = this
        binding.interviewViewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }
}
