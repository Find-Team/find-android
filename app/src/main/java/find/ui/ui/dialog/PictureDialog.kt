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
import find.ui.databinding.DialogPictureBinding
import find.ui.ui.interview.InterviewActivity
import find.ui.ui.mypage.MyPageActivity
import find.ui.util.autoCleared

class PictureDialog(from: String) : DialogFragment() {
    var binding by autoCleared<DialogPictureBinding>()

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            when (from) {
                "Profile"-> (requireActivity() as MyPageActivity).selectImage()
                "Interview" -> (requireActivity() as InterviewActivity).selectImage()
            }
        } else {
            Toast.makeText(requireContext(), "권한을 승인해주세요", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogPictureBinding.inflate(requireActivity().layoutInflater)
        return activity?.let {
            val dialog = AlertDialog.Builder(it).create()
            dialog.setView(binding.root)
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

    companion object {
        const val PICTURE_TAG = "PICTURE_DIALOG"
    }
}
