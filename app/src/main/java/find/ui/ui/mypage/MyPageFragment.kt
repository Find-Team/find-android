package find.ui.ui.mypage

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import find.ui.databinding.FragmentMyPageBinding
import find.ui.ui.dialog.CreateProfileDialog
import find.ui.ui.interview.InterviewActivity
import find.ui.util.autoCleared

class MyPageFragment : Fragment() {
    private var binding by autoCleared<FragmentMyPageBinding>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyPageBinding.inflate(inflater, container, false)
        startDialog()
        goToInterview()
        return binding.root
    }

    private fun startDialog() {
        val dialog = CreateProfileDialog(requireContext())
        dialog.showDialog()
    }

    private fun goToInterview() {
        binding.layoutMyPageInterview.setOnClickListener {
            val intent = Intent(requireContext(), InterviewActivity::class.java)
            startActivity(intent)
        }
    }
}
