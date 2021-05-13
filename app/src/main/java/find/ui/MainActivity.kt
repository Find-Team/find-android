package find.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import find.ui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBottomNavigationView(binding)
    }

    private fun initBottomNavigationView(binding: ActivityMainBinding) {
        binding.bottomNavigationViewMain.apply {
            itemIconTintList = null
            setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.menu_main_my_page -> binding.vpMain.currentItem = 0
                    R.id.menu_main_find -> binding.vpMain.currentItem = 1
                    R.id.menu_main_matching -> binding.vpMain.currentItem = 2
                    R.id.menu_main_reserve -> binding.vpMain.currentItem = 3
                }
                true
            }
        }
    }
}
