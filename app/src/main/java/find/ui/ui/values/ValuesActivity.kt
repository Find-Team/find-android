package find.ui.ui.values

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import find.ui.R
import find.ui.databinding.ActivityValuesBinding
import find.ui.ui.question.Question
import find.ui.ui.question.QuestionFragment
import find.ui.ui.select.SelectFragment

class ValuesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityValuesBinding
    private val valuesViewModel by viewModels<ValuesViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityValuesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        finishValuesActivity()
        setTitleText()
        setTabListener()
        selectedObserver()
        initValuesViewPager()
        initValuesTabLayout()
    }

    private fun finishValuesActivity() {
        binding.btnValuesBack.setOnClickListener {
            finish()
        }
    }

    private fun setTitleText() {
        binding.tvValuesTitle.text =
            when (intent.getStringExtra("values")) {
                "question" -> getString(R.string.value_question)
                "select" -> getString(R.string.value_select)
                else -> throw IllegalAccessException()
            }
    }

    private fun initValuesViewPager() {
        binding.vpValues.adapter = object : FragmentStateAdapter(this@ValuesActivity) {
            override fun getItemCount() = 3
            override fun createFragment(position: Int): Fragment {
                when (intent.getStringExtra("values")) {
                    "question" -> {
                        return when (position) {
                            0 -> QuestionFragment(relationList())
                            1 -> QuestionFragment(familyList())
                            2 -> QuestionFragment(careerList())
                            else -> throw IndexOutOfBoundsException()
                        }
                    }
                    "select" -> {
                        return when (position) {
                            0 -> SelectFragment()
                            1 -> SelectFragment()
                            2 -> SelectFragment()
                            else -> throw IndexOutOfBoundsException()
                        }
                    }
                    else -> {
                        throw IllegalAccessException()
                    }
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

    private fun selectedObserver() {
        valuesViewModel.selectedTab.observe(this) { selectedTab ->
            binding.tabValues.selectTab(binding.tabValues.getTabAt(selectedTab))
        }
    }

    private fun setTabListener() {
        binding.tabValues.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                valuesViewModel.selectedTabClick(requireNotNull(tab).position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }

    private fun relationList() = listOf(
        Question(
            question = "연인관계를주변에알리는것?",
            category = "관계",
            firstAnswer = "관계가깊어지기전까지는금물",
            secondAnswer = "가까운사람에게만",
            thirdAnswer = "당당하게행동"
        ),
        Question(
            question = "연인관계를주변에알리는것?",
            category = "관계",
            firstAnswer = "관계가깊어지기전까지는금물",
            secondAnswer = "가까운사람에게만",
            thirdAnswer = "당당하게행동"
        ),
        Question(
            question = "연인관계를주변에알리는것?",
            category = "관계",
            firstAnswer = "관계가깊어지기전까지는금물",
            secondAnswer = "가까운사람에게만",
            thirdAnswer = "당당하게행동"
        ),
        Question(
            question = "연인관계를주변에알리는것?",
            category = "관계",
            firstAnswer = "관계가깊어지기전까지는금물",
            secondAnswer = "가까운사람에게만",
            thirdAnswer = "당당하게행동"
        ),
        Question(
            question = "연인관계를주변에알리는것?",
            category = "관계",
            firstAnswer = "관계가깊어지기전까지는금물",
            secondAnswer = "가까운사람에게만",
            thirdAnswer = "당당하게행동"
        ),
        Question(
            question = "연인관계를주변에알리는것?",
            category = "관계",
            firstAnswer = "관계가깊어지기전까지는금물",
            secondAnswer = "가까운사람에게만",
            thirdAnswer = "당당하게행동"
        ),
        Question(
            question = "연인관계를주변에알리는것?",
            category = "관계",
            firstAnswer = "관계가깊어지기전까지는금물",
            secondAnswer = "가까운사람에게만",
            thirdAnswer = "당당하게행동"
        ),
        Question(
            question = "연인관계를주변에알리는것?",
            category = "관계",
            firstAnswer = "관계가깊어지기전까지는금물",
            secondAnswer = "가까운사람에게만",
            thirdAnswer = "당당하게행동"
        ),
        Question(
            question = "연인관계를주변에알리는것?",
            category = "관계",
            firstAnswer = "관계가깊어지기전까지는금물",
            secondAnswer = "가까운사람에게만",
            thirdAnswer = "당당하게행동"
        ),
        Question(
            question = "연인관계를주변에알리는것?",
            category = "관계",
            firstAnswer = "관계가깊어지기전까지는금물",
            secondAnswer = "가까운사람에게만",
            thirdAnswer = "당당하게행동"
        )
    )

    private fun familyList() = listOf(
        Question(
            question = "가족?",
            category = "가족",
            firstAnswer = "가족",
            secondAnswer = "가족",
            thirdAnswer = "가족"
        ),
        Question(
            question = "가족?",
            category = "가족",
            firstAnswer = "가족",
            secondAnswer = "가족",
            thirdAnswer = "가족"
        ),
        Question(
            question = "가족?",
            category = "가족",
            firstAnswer = "가족",
            secondAnswer = "가족",
            thirdAnswer = "가족"
        ),
        Question(
            question = "가족?",
            category = "가족",
            firstAnswer = "가족",
            secondAnswer = "가족",
            thirdAnswer = "가족"
        ),
        Question(
            question = "가족?",
            category = "가족",
            firstAnswer = "가족",
            secondAnswer = "가족",
            thirdAnswer = "가족"
        ),
        Question(
            question = "가족?",
            category = "가족",
            firstAnswer = "가족",
            secondAnswer = "가족",
            thirdAnswer = "가족"
        ),
        Question(
            question = "가족?",
            category = "가족",
            firstAnswer = "가족",
            secondAnswer = "가족",
            thirdAnswer = "가족"
        ),
        Question(
            question = "가족?",
            category = "가족",
            firstAnswer = "가족",
            secondAnswer = "가족",
            thirdAnswer = "가족"
        ),
        Question(
            question = "가족?",
            category = "가족",
            firstAnswer = "가족",
            secondAnswer = "가족",
            thirdAnswer = "가족"
        ),
        Question(
            question = "가족?",
            category = "가족",
            firstAnswer = "가족",
            secondAnswer = "가족",
            thirdAnswer = "가족"
        )
    )

    private fun careerList() = listOf(
        Question(
            question = "커리어?",
            category = "커리어",
            firstAnswer = "커리어",
            secondAnswer = "커리어",
            thirdAnswer = "커리어"
        ),
        Question(
            question = "커리어?",
            category = "커리어",
            firstAnswer = "커리어",
            secondAnswer = "커리어",
            thirdAnswer = "커리어"
        ),
        Question(
            question = "커리어?",
            category = "커리어",
            firstAnswer = "커리어",
            secondAnswer = "커리어",
            thirdAnswer = "커리어"
        ),
        Question(
            question = "커리어?",
            category = "커리어",
            firstAnswer = "커리어",
            secondAnswer = "커리어",
            thirdAnswer = "커리어"
        ),
        Question(
            question = "커리어?",
            category = "커리어",
            firstAnswer = "커리어",
            secondAnswer = "커리어",
            thirdAnswer = "커리어"
        ),
        Question(
            question = "커리어?",
            category = "커리어",
            firstAnswer = "커리어",
            secondAnswer = "커리어",
            thirdAnswer = "커리어"
        ),
        Question(
            question = "커리어?",
            category = "커리어",
            firstAnswer = "커리어",
            secondAnswer = "커리어",
            thirdAnswer = "커리어"
        ),
        Question(
            question = "커리어?",
            category = "커리어",
            firstAnswer = "커리어",
            secondAnswer = "커리어",
            thirdAnswer = "커리어"
        ),
        Question(
            question = "커리어?",
            category = "커리어",
            firstAnswer = "커리어",
            secondAnswer = "커리어",
            thirdAnswer = "커리어"
        ),
        Question(
            question = "커리어?",
            category = "커리어",
            firstAnswer = "커리어",
            secondAnswer = "커리어",
            thirdAnswer = "커리어"
        )
    )
}
