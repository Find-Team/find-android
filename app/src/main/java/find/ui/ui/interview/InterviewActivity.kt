package find.ui.ui.interview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import find.ui.databinding.ActivityInterviewBinding

class InterviewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInterviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInterviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
