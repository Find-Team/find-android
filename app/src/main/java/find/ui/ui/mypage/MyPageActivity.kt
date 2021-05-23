package find.ui.ui.mypage

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import find.ui.R
import find.ui.databinding.ActivityCreateProfileBinding
import find.ui.ui.dialog.InfoDialog
import find.ui.ui.dialog.PickerDialog
import kotlin.properties.Delegates

class MyPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateProfileBinding
    private var from by Delegates.notNull<Int>()
    private lateinit var startActivityResult: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.profileActivity = this
        initActivityForResult()
    }

    fun showPickerDialog(view: View) {
        when (view) {
            binding.layoutCpInfoEdu -> from = 2
            binding.layoutCpInfoMbti -> from = 3
            binding.layoutCpInfoTall -> from = 4
            binding.layoutCpInfoForm -> from = 5
            binding.layoutCpInfoSmoke -> from = 6
            binding.layoutCpInfoReligion -> from = 7
            binding.layoutCpInfoMarried -> from = 8
            binding.layoutCpInfoDrink -> from = 9
        }
        val pickerDialog = PickerDialog(from)
        pickerDialog.show(supportFragmentManager, DIALOG_TAG)
    }

    fun showTextInputDialog(view: View) {
        when (view) {
            binding.layoutCpInfoJob -> from = 0
            binding.layoutCpInfoOffice -> from = 1
        }
        val dialog = InfoDialog(from)
        dialog.show(supportFragmentManager, DIALOG_TAG)
    }

    fun changeText(from: Int, content: String) {
        when (from) {
            0 -> setTextStyle(binding.tvCpInfoJob, content)
            1 -> setTextStyle(binding.tvCpInfoOffice, content)
            2 -> setTextStyle(binding.tvCpInfoEdu, content)
            3 -> setTextStyle(binding.tvCpInfoMbti, content)
            4 -> setTextStyle(binding.tvCpInfoTall, content)
            5 -> setTextStyle(binding.tvCpInfoForm, content)
            6 -> setTextStyle(binding.tvCpInfoSmoke, content)
            7 -> setTextStyle(binding.tvCpInfoReligion, content)
            8 -> setTextStyle(binding.tvCpInfoMarried, content)
            9 -> setTextStyle(binding.tvCpInfoDrink, content)
        }
    }

    private fun setTextStyle(textView: TextView, txt: String) {
        textView.text = txt
        textView.setTextColor(baseContext.getColor(R.color.gray_4f))
    }

    private fun changeIntroStyle(content: String) {
        val dp = resources.displayMetrics.density
        binding.btnCpIntroduction.apply {
            text = content
            setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12F)
            setTextColor(context.getColor(R.color.black_33))
            gravity = left
            setPadding(14 * dp.toInt(), 14 * dp.toInt(), 14 * dp.toInt(), 20 * dp.toInt())
            setBackgroundResource(R.drawable.border_white_fill_round_10)
            background.setTint(context.getColor(R.color.gray_f2))
        }
    }

    fun goToIntroduction() {
        val intent = Intent(this, IntroductionActivity::class.java)
        startActivityResult.launch(intent)
    }

    private fun initActivityForResult() {
        startActivityResult = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            when (result.resultCode) {
                Activity.RESULT_OK -> {
                    result.data?.let { intent ->
                        changeIntroStyle(intent.getStringExtra("content").toString())
                    }
                }
            }
        }
    }

    companion object {
        const val DIALOG_TAG = "Dialog"
    }
}
