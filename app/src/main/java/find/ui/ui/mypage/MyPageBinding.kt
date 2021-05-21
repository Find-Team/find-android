package find.ui.ui.mypage

import android.annotation.SuppressLint
import android.graphics.Color
import android.widget.TextView
import androidx.databinding.BindingAdapter
import find.ui.R

object MyPageBinding {
    @BindingAdapter("changeIntroColor")
    @JvmStatic
    fun changeColor(text: TextView, content: String?) {
        when (content?.length) {
            in 10..499 -> text.setTextColor(Color.BLUE)
            500 -> text.setTextColor(text.context.getColor(R.color.red_eb57))
            else -> text.setTextColor(text.context.getColor(R.color.gray_bd))
        }
    }

    @SuppressLint("SetTextI18n")
    @BindingAdapter("setTextIntroLength")
    @JvmStatic
    fun setTextLength(text: TextView, editText: String?) {
        text.text = "${editText?.length}/500"
    }
}
