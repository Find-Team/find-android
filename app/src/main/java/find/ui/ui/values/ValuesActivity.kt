package find.ui.ui.values

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import find.ui.databinding.ActivityValuesBinding

class ValuesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityValuesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityValuesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        finishValuesActivity()
    }

    private fun finishValuesActivity() {
        binding.btnValuesBack.setOnClickListener {
            finish()
        }
    }
}
