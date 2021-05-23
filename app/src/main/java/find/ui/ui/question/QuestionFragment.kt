package find.ui.ui.question

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.viewpager2.widget.ViewPager2
import find.ui.R
import find.ui.databinding.FragmentQuestionBinding
import find.ui.ui.values.ValuesViewModel
import find.ui.util.autoCleared

class QuestionFragment(private val questionList: List<Question>) : Fragment() {
    private var binding by autoCleared<FragmentQuestionBinding>()
    private val valuesViewModel by activityViewModels<ValuesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuestionBinding.inflate(layoutInflater)
        setAdapter()
        setRegisterOnPageChangeCallback()
        nextButtonClick()
        prevButtonClick()
        return binding.root
    }

    private fun setAdapter() {
        binding.vpQuestion.adapter = QuestionAdapter()
        (binding.vpQuestion.adapter as QuestionAdapter).submitList(questionList)
    }

    private fun setRegisterOnPageChangeCallback() {
        binding.vpQuestion.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setButtonSelector(position)
            }
        })
    }

    private fun setButtonSelector(position: Int) {
        if (valuesViewModel.selectedTab.value == 0 && position == 0) {
            binding.btnQuestionPrev.grayButton()
        } else if (valuesViewModel.selectedTab.value == 2 && position == 9) {
            binding.btnQuestionNext.grayButton()
        } else {
            binding.btnQuestionNext.whiteButton()
            binding.btnQuestionPrev.whiteButton()
        }
    }

    private fun nextButtonClick() {
        binding.btnQuestionNext.setOnClickListener {
            if (binding.vpQuestion.currentItem != 9) {
                binding.vpQuestion.currentItem += 1
            } else if (valuesViewModel.selectedTab.value != 2) {
                valuesViewModel.selectedTabButtonClick(1)
            }
        }
    }

    private fun prevButtonClick() {
        binding.btnQuestionPrev.setOnClickListener {
            if (binding.vpQuestion.currentItem != 0) {
                binding.vpQuestion.currentItem -= 1
            } else if (valuesViewModel.selectedTab.value != 0) {
                valuesViewModel.selectedTabButtonClick(-1)
            }
        }
    }

    private fun Button.grayButton() {
        this.apply {
            backgroundTintList = ColorStateList.valueOf(getColor(R.color.gray_e0))
            setTextColor(getColor(R.color.gray_bd))
        }
    }

    private fun Button.whiteButton() {
        this.apply {
            backgroundTintList = ColorStateList.valueOf(getColor(R.color.white))
            setTextColor(getColor(R.color.black_33))
        }
    }

    private fun getColor(color: Int) = requireContext().getColor(color)
}
