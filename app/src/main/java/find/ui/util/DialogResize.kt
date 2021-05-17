package find.ui.util

import android.content.Context
import android.view.WindowManager
import androidx.fragment.app.DialogFragment

fun Context.dialogResize(dialogFragment: DialogFragment, width: Float, height: Float) {
    val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager

    val rect = windowManager.currentWindowMetrics.bounds

    val window = dialogFragment.dialog?.window

    val x = (rect.width() * width).toInt()
    val y = (rect.height() * height).toInt()

    window?.setLayout(x, y)
}
