package find.ui.ui.values

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import find.ui.R
import find.ui.databinding.ActivityValuesBinding
import find.ui.ui.question.QuestionFragment

class ValuesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityValuesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityValuesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        finishValuesActivity()
        initValuesViewPager()
        initValuesTabLayout()
    }

    private fun finishValuesActivity() {
        binding.btnValuesBack.setOnClickListener {
            finish()
        }
    }

    private fun initValuesViewPager() {
        binding.vpValues.adapter = object : FragmentStateAdapter(this@ValuesActivity) {
            override fun getItemCount() = 3
            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> QuestionFragment()
                    1 -> QuestionFragment()
                    2 -> QuestionFragment()
                    else -> throw IndexOutOfBoundsException()
                }
            }
        }
    }

    private fun initValuesTabLayout() {
        TabLayoutMediator(binding.tabValues, binding.vpValues) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.value_relationship)
                1 -> tab.text = getString(R.string.value_family)
                2 -> tab.text = getString(R.string.value_career)
            }
        }.attach()
    }
}
