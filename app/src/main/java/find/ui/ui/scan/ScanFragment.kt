package find.ui.ui.scan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import find.ui.R
import find.ui.databinding.FragmentScanBinding
import find.ui.ui.find.FindFragment
import find.ui.ui.found.FoundFragment
import find.ui.util.autoCleared

class ScanFragment : Fragment() {
    private var binding by autoCleared<FragmentScanBinding>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScanBinding.inflate(inflater, container, false)
        initScanViewPager()
        initTabLayout()
        return binding.root
    }

    private fun initScanViewPager() {
        binding.vpScan.adapter = object : FragmentStateAdapter(this@ScanFragment) {
            override fun getItemCount() = 2
            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> FindFragment()
                    1 -> FoundFragment()
                    else -> throw IndexOutOfBoundsException()
                }
            }
        }
    }

    private fun initTabLayout() {
        TabLayoutMediator(binding.tabScan, binding.vpScan) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.scan_tab_find)
                1 -> tab.text = getString(R.string.scan_tab_found)
            }
        }.attach()
    }
}
