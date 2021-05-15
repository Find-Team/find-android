package find.ui.ui.find

import android.widget.Button
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

    @BindingAdapter("isSimilarity", "isComplementary")
    @JvmStatic
    fun isButtonActive(button: Button, isSimilarity: Boolean, isComplementary: Boolean) {
        when {
            isSimilarity || isComplementary -> {
                button.setBackgroundResource(R.drawable.border_mint_fill_round_25)
            }
            else -> {
                button.setBackgroundResource(R.drawable.border_gray_fill_round_25)
            }
        }
    }
}
