package find.ui.ui.interview

import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import find.ui.R
import find.ui.databinding.ActivityInterviewBinding
import find.ui.ui.dialog.AddPictureDialog
import find.ui.ui.dialog.ModifyPictureDialog
import find.ui.ui.picture.PictureAdapter

class InterviewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInterviewBinding
    private lateinit var getContent: ActivityResultLauncher<String>
    private val viewModel: InterviewViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInterviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.activity = this
        binding.lifecycleOwner = this

        initValuesViewPager()
        initValuesTabLayout()
        setAdapter()
        setPictureList()
        initGetContent()
    }

    private fun initValuesTabLayout() {
        TabLayoutMediator(binding.tabInterview, binding.vpInterview) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.interview_strength)
                1 -> tab.text = getString(R.string.interview_love)
                2 -> tab.text = getString(R.string.interview_like)
                3 -> tab.text = getString(R.string.interview_life)
            }
        }.attach()
    }

    private fun initValuesViewPager() {
        binding.vpInterview.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount() = 4
            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> AskFragment(strengthList())
                    1 -> AskFragment(strengthList())
                    2 -> AskFragment(strengthList())
                    3 -> AskFragment(strengthList())
                    else -> throw IndexOutOfBoundsException()
                }
            }
        }
    }

    private fun strengthList() = listOf(
        Interview("성격 & 매력포인트", ""),
        Interview("외모 특징 & 자신있는 부분", ""),
        Interview("잘하는 것 & 특기", ""),
        Interview("가지고 있는 것 & 자랑거리", "")
    )

    private fun setAdapter() {
        binding.rvInterviewPhoto.adapter = PictureAdapter() { pic, pos ->
            viewModel.itemPos.value = pos
            viewModel.itemPicture.value = pic
            if (pic.image == viewModel.getUriResource(R.drawable.btn_add_image)) {
                clickAddImage()
            } else {
                binding.imgInterviewPrev.setImageURI(pic.image)
                binding.tvInterviewPrev.visibility = View.INVISIBLE
                binding.tvInterviewModify.visibility = View.VISIBLE
            }
        }
        viewModel.setDefaultPicture()
    }

    private fun setPictureList() {
        viewModel.pictureList.observe(this) { items ->
            (binding.rvInterviewPhoto.adapter as PictureAdapter).submitList(items)
        }
    }

    private fun clickAddImage() {
        val dialog = AddPictureDialog(getString(R.string.dialog_interview_title))
        dialog.show(supportFragmentManager, DIALOG_TAG)
    }

    fun clickModifyImage() {
        val dialog = ModifyPictureDialog(getString(R.string.dialog_interview_modify)) {
        }
        dialog.show(supportFragmentManager, ModifyPictureDialog.PICTURE_TAG)
    }

    private fun initGetContent() {
        getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            binding.imgInterviewPrev.setImageURI(uri)
            binding.imgInterviewPrev.clipToOutline = true
            binding.tvInterviewPrev.visibility = View.INVISIBLE
            binding.tvInterviewModify.visibility = View.VISIBLE

            (binding.rvInterviewPhoto.adapter as PictureAdapter).changeItem(
                viewModel.itemPos.value!!.toInt(), uri
            )
        }
    }

    fun selectImage() {
        getContent.launch("image/*")
    }

    fun finishInterview() {
        finish()
    }

    fun removeImage() {
        (binding.rvInterviewPhoto.adapter as PictureAdapter).changeItem(
            viewModel.itemPos.value!!.toInt(), viewModel.getUriResource(R.drawable.btn_add_image)
        )
        binding.imgInterviewPrev.setImageResource(0)
        binding.tvInterviewPrev.visibility = View.VISIBLE
        binding.tvInterviewModify.visibility = View.INVISIBLE
    }

    companion object {
        const val DIALOG_TAG = "Dialog"
    }
}
