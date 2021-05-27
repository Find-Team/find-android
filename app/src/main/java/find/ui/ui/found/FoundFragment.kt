package find.ui.ui.found

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import find.ui.R
import find.ui.ui.dialog.OneButtonDialog

class FoundFragment(private val isNotFind: () -> Unit) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_found, container, false)
    }

    override fun onResume() {
        super.onResume()
        OneButtonDialog(
            getString(R.string.found_not_find),
            getString(R.string.confirm),
            isNotFind
        ).show(childFragmentManager, OneButtonDialog.TAG)
    }
}
