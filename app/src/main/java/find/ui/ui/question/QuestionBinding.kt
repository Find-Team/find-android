package find.ui.ui.question

import android.widget.TextView
import androidx.databinding.BindingAdapter
import find.ui.R

object QuestionBinding {
    @BindingAdapter("setPositionText")
    @JvmStatic
    fun setPositionText(textView: TextView, position: Int) {
        textView.text =
            String.format(textView.context.getString(R.string.question_position), position)
    }
}
