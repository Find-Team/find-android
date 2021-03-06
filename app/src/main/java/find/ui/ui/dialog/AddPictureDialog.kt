package find.ui.ui.dialog

import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.DialogFragment
import find.ui.R
import find.ui.databinding.DialogAddPictureBinding
import find.ui.ui.interview.InterviewActivity
import find.ui.ui.mypage.MyPageActivity
import find.ui.util.autoCleared

class AddPictureDialog(private val title: String) : DialogFragment() {
    var binding by autoCleared<DialogAddPictureBinding>()

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            when (title) {
                getString(R.string.dialog_picture_title) -> (requireActivity() as MyPageActivity).selectImage()
                getString(R.string.dialog_interview_title) -> (requireActivity() as InterviewActivity).selectImage()
            }
        } else {
            Toast.makeText(requireContext(), "권한을 승인해주세요", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogAddPictureBinding.inflate(requireActivity().layoutInflater)
        return activity?.let {
            val dialog = AlertDialog.Builder(it).create()
            dialog.setView(binding.root)
            setTitleText()
            onClickCancel()
            onClickGet()
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

    private fun onClickGet() {
        binding.tvPictureGet.setOnClickListener {
            requestPermissionLauncher.launch(READ_EXTERNAL_STORAGE)
            dismiss()
        }
    }

    private fun setTitleText() {
        binding.titlePictureDialog.text = title
    }

    companion object {
        const val PICTURE_TAG = "ADD_PICTURE_DIALOG"
    }
}
