package find.ui.ui.profile

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.InsetDrawable
import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.ObservableField
import androidx.fragment.app.DialogFragment
import find.ui.R
import find.ui.databinding.DialogProfileInfoBinding
import find.ui.util.dialogResize

class InfoDialogFragment : DialogFragment() {
    private lateinit var dialogInfoBinding: DialogProfileInfoBinding
    private lateinit var listener: InfoDialogListener
    val textInputInfo = ObservableField<String>()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        dialogInfoBinding = DialogProfileInfoBinding.inflate(LayoutInflater.from(context))
        dialogInfoBinding.infoDialog = this

        return activity?.let {
            val builder = AlertDialog.Builder(it)
            setText()
            builder.apply {
                setCancelable(false)
                setView(dialogInfoBinding.root)
                dialogInfoBinding.btnInfoDialogOk.setOnClickListener {
                    listener.onBtnOkClick(
                        this@InfoDialogFragment,
                        textInputInfo.get().toString(),
                        requireArguments().getString("title")!!
                    )
                    dismiss()
                    textInputInfo.set("")
                }
            }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    override fun onResume() {
        super.onResume()
        dialog?.window?.setBackgroundDrawable(InsetDrawable(ColorDrawable(Color.WHITE), 80))
        dialog?.window?.setBackgroundDrawableResource(R.drawable.border_white_fill_round_10)
        context?.dialogResize(this, 0.6f, 0.3f)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as InfoDialogListener
        } catch (e: ClassCastException) {
            throw ClassCastException(context.toString() + "must implement InfoDialogListener")
        }
    }

    interface InfoDialogListener {
        fun onBtnOkClick(dialog: DialogFragment, content: String, args: String)
    }

    private fun setText() {
        dialogInfoBinding.titleInfoDialog.text = requireArguments().getString("title")
    }

    companion object {
        fun newInstance(title: String): InfoDialogFragment {
            val fragment = InfoDialogFragment()
            val args = Bundle()
            args.putString("title", title)
            fragment.arguments = args
            return fragment
        }
    }
}
