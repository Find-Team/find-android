package find.ui.ui.interview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import find.ui.R
import find.ui.databinding.ActivityInterviewBinding

class InterviewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInterviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInterviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initValuesViewPager()
        initValuesTabLayout()
    }

    private fun initValuesTabLayout() {
        TabLayoutMediator(binding.tabInterview, binding.vpInterview) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.interview_strength)
                1 -> tab.text = getString(R.string.interview_love)
                2 -> tab.text = getString(R.string.interview_like)
                3 -> tab.text = getString(R.string.interview_life)
            }
        }.attach()
    }

    private fun initValuesViewPager() {
        binding.vpInterview.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount() = 4
            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> AskFragment()
                    1 -> AskFragment()
                    2 -> AskFragment()
                    3 -> AskFragment()
                    else -> throw IndexOutOfBoundsException()
                }
            }
        }
    }
}
