package find.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import find.ui.R
import find.ui.databinding.ActivityMainBinding
import find.ui.matching.MatchingFragment
import find.ui.mypage.MyPageFragment
import find.ui.reserve.ReserveFragment
import find.ui.scan.ScanFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewPager()
        initBottomNavigationView()
    }

    private fun initViewPager() {
        binding.vpMain.apply {
            adapter = object : FragmentStateAdapter(this@MainActivity) {
                override fun getItemCount() = 4
                override fun createFragment(position: Int): Fragment {
                    return when (position) {
                        0 -> MyPageFragment()
                        1 -> ScanFragment()
                        2 -> MatchingFragment()
                        3 -> ReserveFragment()
                        else -> throw IndexOutOfBoundsException()
                    }
                }
            }

            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.bottomNavigationViewMain.selectedItemId =
                        when (position) {
                            0 -> R.id.menu_main_my_page
                            1 -> R.id.menu_main_scan
                            2 -> R.id.menu_main_matching
                            3 -> R.id.menu_main_reserve
                            else -> throw IndexOutOfBoundsException()
                        }
                }
            })
        }
    }

    private fun initBottomNavigationView() {
        binding.bottomNavigationViewMain.apply {
            itemIconTintList = null
            setOnNavigationItemSelectedListener {
                binding.vpMain.currentItem =
                    when (it.itemId) {
                        R.id.menu_main_my_page -> 0
                        R.id.menu_main_scan -> 1
                        R.id.menu_main_matching -> 2
                        R.id.menu_main_reserve -> 3
                        else -> throw IndexOutOfBoundsException()
                    }
                true
            }
        }
    }
}
