package find.ui.ui.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import find.ui.R
import find.ui.databinding.DialogProfileInfoBinding
import find.ui.ui.mypage.MyPageActivity
import find.ui.ui.profile.ProfileViewModel
import find.ui.util.autoCleared

class InfoDialog(private val title: String) : DialogFragment() {
    var dialogInfoBinding by autoCleared<DialogProfileInfoBinding>()
    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        dialogInfoBinding = DialogProfileInfoBinding.inflate(requireActivity().layoutInflater)
        dialogInfoBinding.viewModel = viewModel
        dialogInfoBinding.lifecycleOwner = this
        setTitle()

        return activity?.let {
            saveInfoData()
            val builder = AlertDialog.Builder(it)
            builder.setView(dialogInfoBinding.root)
            builder.create()
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

    private fun setTitle() {
        dialogInfoBinding.titleInfoDialog.text = title
    }

    private fun saveInfoData() {
        dialogInfoBinding.btnInfoDialogOk.setOnClickListener {
            (requireActivity() as MyPageActivity).changeTextInfo(
                viewModel.infoContent.get().toString()
            )
            dismiss()
        }
    }

    companion object {
        const val INFO_TAG = "INFO_DIALOG"
    }
}
