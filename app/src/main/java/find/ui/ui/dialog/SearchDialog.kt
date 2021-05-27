package find.ui.ui.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import find.ui.R
import find.ui.databinding.DialogSearchBinding
import find.ui.util.autoCleared

class SearchDialog(private val content: String) : DialogFragment() {
    var binding by autoCleared<DialogSearchBinding>()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogSearchBinding.inflate(requireActivity().layoutInflater)
        binding.lottieSearch.playAnimation()
        return activity?.let {
            val builder = AlertDialog.Builder(it, R.style.full_screen_search_dialog)
            builder.setView(binding.root)
            builder.create()
        } ?: throw IllegalStateException()
    }

    override fun onStart() {
        super.onStart()
        setText()
    }

    private fun setText() {
        binding.tvSearchContent.text = content
    }

    companion object {
        const val TAG = "SEARCH_DIALOG"
    }
}
