package find.ui.ui.find

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import find.ui.R
import find.ui.databinding.FragmentFindBinding
import find.ui.ui.dialog.SearchDialog
import find.ui.ui.values.ValuesActivity
import find.ui.util.autoCleared

class FindFragment : Fragment() {
    private var binding by autoCleared<FragmentFindBinding>()
    private val findViewModel by activityViewModels<FindViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFindBinding.inflate(inflater, container, false)
        binding.findViewModel = findViewModel
        binding.lifecycleOwner = this@FindFragment
        startQuestionFragment()
        startSelectFragment()
        startSearchFind()
        setAdapter()
        setTempList()
        return binding.root
    }

    private fun startQuestionFragment() {
        binding.btnFindValue.setOnClickListener {
            val intent = Intent(requireContext(), ValuesActivity::class.java)
            intent.putExtra("values", "question")
            startActivity(intent)
        }
    }

    private fun startSelectFragment() {
        binding.tvFindValueSelect.setOnClickListener {
            val intent = Intent(requireContext(), ValuesActivity::class.java)
            intent.putExtra("values", "select")
            startActivity(intent)
        }
    }

    private fun setAdapter() {
        binding.rvFindMyValue.adapter = FindPickedValuesAdapter()
        findViewModel.setTempList()
    }

    private fun setTempList() {
        findViewModel.tempList.observe(viewLifecycleOwner) {
            (binding.rvFindMyValue.adapter as FindPickedValuesAdapter).submitList(it)
        }
    }

    private fun startSearchFind() {
        binding.btnFindOpponent.setOnClickListener {
            if (requireNotNull(findViewModel.isFindButtonActive.value)) {
                if (requireNotNull(findViewModel.isComplementary.value)) {
                    SearchDialog(getString(R.string.search_complementary)).show(
                        childFragmentManager,
                        SearchDialog.TAG
                    )
                } else if (requireNotNull(findViewModel.isSimilarity.value)) {
                    SearchDialog(getString(R.string.search_similarity)).show(
                        childFragmentManager,
                        SearchDialog.TAG
                    )
                }
            }
        }
    }
}
