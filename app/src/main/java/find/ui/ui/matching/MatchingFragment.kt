package find.ui.ui.matching

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import find.ui.R
import find.ui.databinding.FragmentMatchingBinding
import find.ui.ui.dibs.DibsFragment
import find.ui.ui.feeling.FeelingFragment
import find.ui.util.autoCleared

class MatchingFragment : Fragment() {
    private var binding by autoCleared<FragmentMatchingBinding>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMatchingBinding.inflate(inflater, container, false)
        initMatchingViewPager()
        initMatchingTabLayout()
        return binding.root
    }

    private fun initMatchingViewPager() {
        binding.vpMatching.adapter = object : FragmentStateAdapter(this@MatchingFragment) {
            override fun getItemCount() = 2
            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> FeelingFragment()
                    1 -> DibsFragment()
                    else -> throw IndexOutOfBoundsException()
                }
            }
        }
    }

    private fun initMatchingTabLayout() {
        TabLayoutMediator(binding.tabMatching, binding.vpMatching) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.matching_feeling)
                1 -> tab.text = getString(R.string.matching_dibs)
            }
        }.attach()
    }
}
