package find.ui.ui.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.ViewGroup
import android.widget.NumberPicker
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import find.ui.R
import find.ui.databinding.DialogPickerBinding
import find.ui.ui.mypage.MyPageActivity
import find.ui.ui.profile.ProfileViewModel
import find.ui.util.autoCleared

class PickerDialog(private val from: Int) : DialogFragment() {
    var binding by autoCleared<DialogPickerBinding>()
    private lateinit var data: Array<String>
    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogPickerBinding.inflate(requireActivity().layoutInflater)
        initPicker()
        numberPickerListener()
        return activity?.let {
            val dialog = AlertDialog.Builder(it).create()
            dialog.setView(binding.root)
            dialog
        } ?: throw IllegalStateException()
    }

    override fun onResume() {
        super.onResume()
        requireNotNull(dialog).apply {
            requireNotNull(window).apply {
                setLayout(
                    (resources.displayMetrics.widthPixels * 0.6).toInt(),
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                setBackgroundDrawableResource(R.drawable.border_white_fill_round_10)
            }
            setCancelable(false)
        }
    }

    private fun pickerStyle() {
        binding.npPicker.apply {
            minValue = 0
            maxValue = data.size - 1
            displayedValues = data
            wrapSelectorWheel = false
            descendantFocusability = NumberPicker.FOCUS_BLOCK_DESCENDANTS
        }
    }

    private fun initPicker() {
        when (from) {
            2 -> {
                viewModel.setTitle(
                    binding.tvPickerTitle,
                    requireContext().getString(R.string.profile_info_edu)
                )
                data = arrayOf("고등학교", "전문대", "대학교", "대학원", "석사", "박사", "기타")
            }
            3 -> {
                viewModel.setTitle(
                    binding.tvPickerTitle,
                    requireContext().getString(R.string.profile_info_mbti)
                )
                data = arrayOf(
                    "ENTJ", "ENTP", "INTJ", "INTP", "ESTJ", "ESFJ", "ISTJ", "ISFJ",
                    "ENFJ", "ENFP", "INFJ", "INFP", "ESTP", "ESFP", "ISTP", "ISFP"
                )
            }
            4 -> {
                viewModel.setTitle(
                    binding.tvPickerTitle,
                    requireContext().getString(R.string.profile_info_tall)
                )
                val tall = (145..190).toList()
                val tallList = tall.map { it.toString() }
                data = tallList.toTypedArray()
            }
            5 -> {
                viewModel.setTitle(
                    binding.tvPickerTitle,
                    requireContext().getString(R.string.profile_info_form)
                )
                data = arrayOf("마른", "슬림", "보통", "근육질", "통통", "우람", "다소 볼륨", "글래머")
            }
            6 -> {
                viewModel.setTitle(
                    binding.tvPickerTitle,
                    requireContext().getString(R.string.profile_info_smoke)
                )
                data = arrayOf("절대 안 핌", "사교적 흡연가", "자주 핌")
            }
            7 -> {
                viewModel.setTitle(
                    binding.tvPickerTitle,
                    requireContext().getString(R.string.profile_info_religion)
                )
                data = arrayOf("종교없음", "개신교", "천주교", "불교", "원불교", "기타")
            }
            8 -> {
                viewModel.setTitle(
                    binding.tvPickerTitle,
                    requireContext().getString(R.string.profile_info_married)
                )
                data = arrayOf("미혼", "재혼")
            }
            9 -> {
                viewModel.setTitle(
                    binding.tvPickerTitle,
                    requireContext().getString(R.string.profile_info_drink)
                )
                data = arrayOf("마시지 않음", "사교적 음주가", "어느정도 즐기는편", "술자리를 즐김")
            }
        }
        pickerStyle()
        binding.btnPickerOk.setOnClickListener {
            numberPickerListener()
            dismiss()
        }
    }

    private fun numberPickerListener() {
        binding.npPicker.setOnValueChangedListener { picker, oldVal, newVal ->
            (requireActivity() as MyPageActivity)
                .changeText(from, picker.displayedValues[picker.value])
        }
    }
}
