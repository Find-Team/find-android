package find.ui.ui.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import find.ui.R
import find.ui.databinding.DialogPickerBinding
import find.ui.util.autoCleared
import find.ui.util.dialogResize

class PickerDialog : DialogFragment() {
    var binding by autoCleared<DialogPickerBinding>()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogPickerBinding.inflate(requireActivity().layoutInflater)
        initPicker()
        return activity?.let {
            val dialog = AlertDialog.Builder(it).create()
            dialog.setView(binding.root)
            dialog.window?.setBackgroundDrawableResource(R.drawable.border_white_fill_round_10)
            dialog
        } ?: throw IllegalStateException()
    }

    override fun onResume() {
        super.onResume()
        context?.dialogResize(this, 0.6f, 0.3f)
    }

    private fun initPicker() {
        val data = arrayOf("고등학교", "대학교", "대학원")
        binding.npPicker.apply {
            minValue = 0
            maxValue = data.size - 1
            displayedValues = data
            wrapSelectorWheel = false
        }
    }
}
