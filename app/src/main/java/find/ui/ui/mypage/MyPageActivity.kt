package find.ui.ui.mypage

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import find.ui.R
import find.ui.databinding.ActivityCreateProfileBinding
import find.ui.ui.dialog.InfoDialog
import kotlin.properties.Delegates

class MyPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateProfileBinding
    private var from by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.profileActivity = this
    }

    fun showTextInputDialog(view: View) {
        when (view) {
            binding.layoutCpInfoJob -> from = 0
            binding.layoutCpInfoOffice -> from = 1
        }
        val dialog = InfoDialog(from)
        dialog.show(supportFragmentManager, DIALOG_TAG)
    }

    fun setTextStyle(from: Int, content: String) {
        when (from) {
            0 -> {
                binding.tvCpInfoJob.text = content
                binding.tvCpInfoJob.setTextColor(baseContext.getColor(R.color.gray_4f))
            }
            1 -> {
                binding.tvCpInfoOffice.text = content
                binding.tvCpInfoOffice.setTextColor(baseContext.getColor(R.color.gray_4f))
            }
        }
    }

    fun goToIntroduction() {
        val intent = Intent(this, IntroductionActivity::class.java)
        startActivity(intent)
    }

    companion object {
        const val DIALOG_TAG = "Info Dialog"
    }
}
