package find.ui.ui.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import find.ui.R
import find.ui.databinding.DialogBasicBinding
import find.ui.util.autoCleared

class BasicDialog(private val from: Int) : DialogFragment() {
    var binding by autoCleared<DialogBasicBinding>()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogBasicBinding.inflate(requireActivity().layoutInflater)
        whereFrom()
        return activity?.let {
            val dialog = AlertDialog.Builder(it).create()
            dialog.setView(binding.root)
            dialog.window?.setBackgroundDrawableResource(R.drawable.border_white_fill_round_10)
            dialog
        } ?: throw IllegalStateException()
    }

    private fun whereFrom() {
        when (from) {
            0 -> setText(
                requireContext().getString(R.string.create_profile_guide),
                requireContext().getString(R.string.create_profile_button)
            )
            1 -> setText(
                requireContext().getString(R.string.found_not_find),
                requireContext().getString(R.string.confirm)
            )
        }
    }

    private fun setText(title: String, buttonText: String) {
        binding.tvBasicTitle.text = title
        binding.btnBasicDialog.text = buttonText
    }
}
