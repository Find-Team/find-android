package find.ui.ui.interview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import find.ui.databinding.FragmentAskBinding
import find.ui.util.autoCleared

class AskFragment : Fragment() {
    private var binding by autoCleared<FragmentAskBinding>()
    private lateinit var interviewAdapter: InterviewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAskBinding.inflate(inflater, container, false)
        setInterviewAdapter()
        setData()
        return binding.root
    }

    private fun setInterviewAdapter() {
        interviewAdapter = InterviewAdapter()
        binding.rvAsk.apply {
            adapter = interviewAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun setData() {
        interviewAdapter.items =
            mutableListOf("성격 & 매력포인트", "외모 특징 & 자신있는 부분", "잘하는 것 & 특기", "가지고 있는 것 & 자랑거리")
        interviewAdapter.refresh()
    }
}
