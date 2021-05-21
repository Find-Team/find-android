package find.ui.ui.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import find.ui.R
import find.ui.databinding.DialogProfileInfoBinding
import find.ui.ui.mypage.MyPageActivity
import find.ui.ui.profile.ProfileViewModel
import find.ui.util.autoCleared
import find.ui.util.dialogResize

class InfoDialog(private val from: Int) : DialogFragment() {
    var dialogInfoBinding by autoCleared<DialogProfileInfoBinding>()
    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        dialogInfoBinding = DialogProfileInfoBinding.inflate(requireActivity().layoutInflater)
        dialogInfoBinding.viewModel = viewModel
        dialogInfoBinding.lifecycleOwner = this
        whereFrom()

        return activity?.let {
            saveInfoData()
            val builder = AlertDialog.Builder(it)
            builder.setView(dialogInfoBinding.root)
            builder.create()
        } ?: throw IllegalStateException()
    }

    override fun onResume() {
        super.onResume()
        dialog?.window?.setBackgroundDrawableResource(R.drawable.border_white_fill_round_10)
        context?.dialogResize(this, 0.6f, 0.3f)
    }

    private fun setText(content: String) {
        dialogInfoBinding.titleInfoDialog.text = content
    }

    private fun whereFrom() {
        when (from) {
            0 -> setText(requireContext().getString(R.string.dialog_info_job))
            1 -> setText(requireContext().getString(R.string.dialog_info_office))
        }
    }

    private fun saveInfoData() {
        dialogInfoBinding.btnInfoDialogOk.setOnClickListener {
            (requireActivity() as MyPageActivity).setTextStyle(
                from,
                viewModel.infoContent.get().toString()
            )
            dismiss()
        }
    }
}
