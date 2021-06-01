package find.ui.ui.find

import android.widget.Button
import android.widget.TextView
import androidx.databinding.BindingAdapter
import find.ui.R

object FindBinding {
    @BindingAdapter("isButtonChecked")
    @JvmStatic
    fun isButtonChecked(button: Button, isChecked: Boolean) {
        when {
            isChecked -> {
                button.setBackgroundResource(R.drawable.border_mint_stroke_fill_circle)
            }
            else -> {
                button.setBackgroundResource(R.drawable.border_mint_fill_circle)
            }
        }
    }

    @BindingAdapter("isButtonActive")
    @JvmStatic
    fun isButtonActive(button: Button, isButtonActive: Boolean) {
        when (isButtonActive) {
            true -> {
                button.backgroundTintList = button.context.getColorStateList(R.color.mint_81ec)
            }
            false -> {
                button.backgroundTintList = button.context.getColorStateList(R.color.gray_e0)
            }
        }
    }

    @BindingAdapter("setFoundIntroduce", "setFoundJob", "setFoundCompany", "setFoundLocation")
    @JvmStatic
    fun setFoundIntroduce(
        textView: TextView,
        age: Int,
        job: String,
        company: String,
        location: String
    ) {
        textView.text = String.format(
            textView.context.getString(R.string.feeling_connected_introduce),
            age,
            job,
            company,
            location
        )
    }
}
