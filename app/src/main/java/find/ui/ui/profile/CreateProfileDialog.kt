package find.ui.ui.profile

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.InsetDrawable
import android.view.LayoutInflater
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import find.ui.R
import find.ui.databinding.DialogCreateProfileBinding

class CreateProfileDialog(private val context: Context) {
    private val dialogBinding: DialogCreateProfileBinding = DataBindingUtil
        .inflate(LayoutInflater.from(context), R.layout.dialog_create_profile, null, false)

    private val dialog = Dialog(context)

    fun showDialog() {
        dialog.window?.setBackgroundDrawable(InsetDrawable(ColorDrawable(Color.WHITE), 80))
        dialog.window?.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.border_white_fill_round_10))
        dialog.setCancelable(false)
        dialog.setContentView(dialogBinding.root)

        goToProfile(dialogBinding.btnCpGoProfile)

        dialog.show()
    }

    private fun goToProfile(profileBtn: Button) {
        profileBtn.setOnClickListener {
            dialog.dismiss()
        }
    }
}
