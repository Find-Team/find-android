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

class PickerDialog(private val title: String) : DialogFragment() {
    var binding by autoCleared<DialogPickerBinding>()
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
            maxValue = viewModel.pickerList.value!!.size - 1
            displayedValues = viewModel.pickerList.value
            wrapSelectorWheel = false
            descendantFocusability = NumberPicker.FOCUS_BLOCK_DESCENDANTS
        }
    }

    private fun initPicker() {
        binding.tvPickerTitle.text = title
        viewModel.setPickerList(requireContext(), title)
        pickerStyle()
        binding.btnPickerOk.setOnClickListener {
            numberPickerListener()
            dismiss()
        }
    }

    private fun numberPickerListener() {
        binding.npPicker.setOnValueChangedListener { picker, oldVal, newVal ->
            (requireActivity() as MyPageActivity)
                .changeTextInfo(picker.displayedValues[picker.value])
        }
    }

    companion object {
        const val PICKER_TAG = "PICKER_DIALOG"
    }
}
