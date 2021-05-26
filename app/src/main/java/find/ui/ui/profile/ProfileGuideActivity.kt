package find.ui.ui.profile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import find.ui.databinding.ActivityProfileGuideBinding

class ProfileGuideActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileGuideBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileGuideBinding.inflate(layoutInflater)
        setContentView(binding.root)
        finishProfileGuide()
    }

    private fun finishProfileGuide() {
        binding.btnGuideBack.setOnClickListener {
            finish()
        }
    }
}