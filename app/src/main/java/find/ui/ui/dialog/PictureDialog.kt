package find.ui.ui.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import find.ui.R
import find.ui.databinding.DialogPictureBinding
import find.ui.util.autoCleared

class PictureDialog : DialogFragment() {
    var binding by autoCleared<DialogPictureBinding>()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogPictureBinding.inflate(requireActivity().layoutInflater)
        return activity?.let {
            val dialog = AlertDialog.Builder(it).create()
            dialog.setView(binding.root)
            onClickCancel()
            dialog
        } ?: throw IllegalStateException()
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

    private fun onClickCancel() {
        binding.tvPictureCancel.setOnClickListener {
            dismiss()
        }
    }
}
