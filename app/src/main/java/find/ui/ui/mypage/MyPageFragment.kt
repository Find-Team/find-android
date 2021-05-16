package find.ui.ui.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import find.ui.databinding.FragmentMyPageBinding
import find.ui.ui.profile.CreateProfileDialog

class MyPageFragment : Fragment() {
    private var _binding: FragmentMyPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        startDialog()
        _binding = FragmentMyPageBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    private fun startDialog() {
        val dialog = CreateProfileDialog(requireContext())
        dialog.showDialog()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
