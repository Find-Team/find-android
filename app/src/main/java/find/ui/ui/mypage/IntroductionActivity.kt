package find.ui.ui.mypage

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import find.ui.databinding.ActivityIntroductionBinding
import find.ui.ui.profile.ProfileViewModel

class IntroductionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntroductionBinding
    private val profileViewModel: ProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroductionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.profileViewModel = profileViewModel
        binding.lifecycleOwner = this

        saveData()
    }

    private fun saveData() {
        binding.tvIntroSave.setOnClickListener {
            val intent = Intent(this, MyPageActivity::class.java)
            intent.putExtra("content", profileViewModel.introContent)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}
