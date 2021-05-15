package find.ui.ui.find

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import find.ui.databinding.FragmentFindBinding
import find.ui.ui.values.ValuesActivity

class FindFragment : Fragment() {
    private var _binding: FragmentFindBinding? = null
    private val binding get() = _binding!!
    private val findViewModel by activityViewModels<FindViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFindBinding.inflate(inflater, container, false)
        binding.findViewModel = findViewModel
        binding.lifecycleOwner = this@FindFragment
        startValuesActivity()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun startValuesActivity() {
        binding.btnFindValue.setOnClickListener {
            val intent = Intent(requireContext(), ValuesActivity::class.java)
            startActivity(intent)
        }
    }
}
