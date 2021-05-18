package find.ui.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import find.ui.R
import find.ui.databinding.ActivityCreateProfileBinding

class CreateProfileActivity : AppCompatActivity(), InfoDialogFragment.InfoDialogListener {
    private lateinit var binding: ActivityCreateProfileBinding
    private lateinit var dialogFragment: DialogFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.profileActivity = this
    }

    fun showTextInputDialog(view: View) {
        when (view) {
            binding.layoutCpInfoJob -> {
                dialogFragment =
                    InfoDialogFragment.newInstance(applicationContext.getString(R.string.dialog_info_job))
                dialogFragment.show(supportFragmentManager, DIALOG_TAG)
            }
            binding.layoutCpInfoOffice -> {
                dialogFragment =
                    InfoDialogFragment.newInstance(applicationContext.getString(R.string.dialog_info_office))
                dialogFragment.show(supportFragmentManager, DIALOG_TAG)
            }
        }
    }

    override fun onBtnOkClick(dialog: DialogFragment, content: String, args: String) {
        when (args) {
            applicationContext.getString(R.string.dialog_info_job) -> {
                setTextStyle(binding.tvCpInfoJob, content)
            }
            applicationContext.getString(R.string.dialog_info_office) -> {
                setTextStyle(binding.tvCpInfoOffice, content)
            }
        }
    }

    fun goToIntroduction() {
        val intent = Intent(this, IntroductionActivity::class.java)
        startActivity(intent)
    }

    private fun setTextStyle(textView: TextView, content: String) {
        textView.text = content
        textView.setTextColor((ContextCompat.getColor(applicationContext, R.color.gray_4f)))
    }

    companion object {
        const val DIALOG_TAG = "Info Dialog"
    }
}
