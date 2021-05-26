package find.ui.ui.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import find.ui.R
import find.ui.databinding.DialogOneButtonBinding
import find.ui.util.autoCleared

class OneButtonDialog(private val from: Int, private val onClick: () -> Unit) : DialogFragment() {
    var binding by autoCleared<DialogOneButtonBinding>()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogOneButtonBinding.inflate(requireActivity().layoutInflater)
        return activity?.let {
            val dialog = AlertDialog.Builder(it).create()
            dialog.setView(binding.root)
            dialog
        } ?: throw IllegalStateException()
    }

    override fun onStart() {
        super.onStart()
        whereFrom()
        setClickListener()
    }

    override fun onResume() {
        super.onResume()
        requireNotNull(dialog).apply {
            requireNotNull(window).apply {
                setLayout(
                    (resources.displayMetrics.widthPixels * 0.9).toInt(),
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                setBackgroundDrawableResource(R.drawable.border_white_fill_round_10)
            }
            setCancelable(false)
        }
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
        binding.tvOneButtonTitle.text = title
        binding.btnOneButtonDialog.text = buttonText
    }

    private fun setClickListener() {
        binding.btnOneButtonDialog.setOnClickListener {
            onClick()
            requireNotNull(dialog).dismiss()
        }
    }

    companion object {
        const val TAG = "BASIC_DIALOG"
    }
}
