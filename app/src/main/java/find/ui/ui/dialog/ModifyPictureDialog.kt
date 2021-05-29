package find.ui.ui.dialog

import android.Manifest
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import find.ui.R
import find.ui.databinding.DialogModifyPictureBinding
import find.ui.ui.interview.InterviewActivity
import find.ui.ui.mypage.MyPageActivity
import find.ui.ui.picture.PictureViewModel
import find.ui.util.autoCleared

class ModifyPictureDialog(private val title: String, private val onClick: () -> Unit) :
    DialogFragment() {
    var binding by autoCleared<DialogModifyPictureBinding>()
    private val viewModel by activityViewModels<PictureViewModel>()

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            when (title) {
                getString(R.string.dialog_picture_modify) -> (requireActivity() as MyPageActivity).selectImage()
                getString(R.string.dialog_interview_modify) -> (requireActivity() as InterviewActivity).selectImage()
            }
        } else {
            Toast.makeText(requireContext(), "권한을 승인해주세요", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogModifyPictureBinding.inflate(requireActivity().layoutInflater)
        return activity?.let {
            val dialog = AlertDialog.Builder(it).create()
            dialog.setView(binding.root)
            isInterviewDialog()
            setTitleText()
            onClickCancel()
            onClickGet()
            mainDisabled()
            onClickMain()
            onRemove()
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

    private fun mainDisabled(): Boolean {
        if (title == getString(R.string.dialog_picture_modify)) {
            if (viewModel.checkMain(viewModel.itemPicture.value!!)) {
                binding.tvPictureMain.setTextColor(binding.tvPictureMain.context.getColor(R.color.gray_82))
                return true
            }
        }
        return false
    }

    private fun onClickCancel() {
        binding.tvPictureCancel.setOnClickListener {
            dismiss()
        }
    }

    private fun onClickGet() {
        binding.tvPictureGet.setOnClickListener {
            requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
            dismiss()
        }
    }

    private fun onClickMain() {
        binding.tvPictureMain.setOnClickListener {
            if (!mainDisabled()) {
                onClick()
            }
            dismiss()
        }
    }

    private fun onRemove() {
        binding.tvPictureRemove.setOnClickListener {
            when (title) {
                getString(R.string.dialog_picture_modify) -> (requireActivity() as MyPageActivity).removeImage()
                getString(R.string.dialog_interview_modify) -> (requireActivity() as InterviewActivity).removeImage()
            }
            dismiss()
        }
    }

    private fun setTitleText() {
        binding.titlePictureDialog.text = title
    }

    private fun isInterviewDialog() {
        when (title) {
            getString(R.string.dialog_picture_modify) -> {
                binding.tvPictureMain.visibility = View.VISIBLE
                binding.line1PictureDialog.visibility = View.VISIBLE
            }
            getString(R.string.dialog_interview_modify) -> {
                binding.tvPictureMain.visibility = View.GONE
                binding.line1PictureDialog.visibility = View.GONE
            }
        }
    }

    companion object {
        const val PICTURE_TAG = "MODIFY_PICTURE_DIALOG"
    }
}
