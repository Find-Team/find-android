package find.ui.ui.mypage

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import find.ui.R
import find.ui.databinding.ActivityCreateProfileBinding
import find.ui.ui.dialog.AddPictureDialog
import find.ui.ui.dialog.InfoDialog
import find.ui.ui.dialog.ModifyPictureDialog
import find.ui.ui.dialog.PickerDialog
import find.ui.ui.picture.PictureAdapter
import find.ui.ui.picture.PictureViewModel
import find.ui.ui.profile.ProfileGuideActivity

class MyPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateProfileBinding
    private lateinit var title: String
    private lateinit var startActivityResult: ActivityResultLauncher<Intent>
    private lateinit var getContent: ActivityResultLauncher<String>
    private val viewModel: PictureViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.profileActivity = this
        setAdapter()
        setPictureList()
        initActivityForResult()
        initGetContent()
    }

    fun showPickerDialog(view: View) {
        when (view) {
            binding.layoutCpInfoEdu -> title = getString(R.string.profile_info_edu)
            binding.layoutCpInfoMbti -> title = getString(R.string.profile_info_mbti)
            binding.layoutCpInfoTall -> title = getString(R.string.profile_info_tall)
            binding.layoutCpInfoForm -> title = getString(R.string.profile_info_form)
            binding.layoutCpInfoSmoke -> title = getString(R.string.profile_info_smoke)
            binding.layoutCpInfoReligion -> title = getString(R.string.profile_info_religion)
            binding.layoutCpInfoMarried -> title = getString(R.string.profile_info_married)
            binding.layoutCpInfoDrink -> title = getString(R.string.profile_info_drink)
        }
        val pickerDialog = PickerDialog(title)
        pickerDialog.show(supportFragmentManager, PickerDialog.PICKER_TAG)
    }

    fun showTextInputDialog(view: View) {
        when (view) {
            binding.layoutCpInfoJob -> title = getString(R.string.dialog_info_job)
            binding.layoutCpInfoOffice -> title = getString(R.string.dialog_info_office)
        }
        val dialog = InfoDialog(title)
        dialog.show(supportFragmentManager, InfoDialog.INFO_TAG)
    }

    fun changeTextInfo(content: String) {
        when (title) {
            getString(R.string.dialog_info_job) ->
                setTextStyle(binding.tvCpInfoJob, content)
            getString(R.string.dialog_info_office) ->
                setTextStyle(binding.tvCpInfoOffice, content)
            getString(R.string.profile_info_edu) ->
                setTextStyle(binding.tvCpInfoEdu, content)
            getString(R.string.profile_info_mbti) ->
                setTextStyle(binding.tvCpInfoMbti, content)
            getString(R.string.profile_info_tall) ->
                setTextStyle(binding.tvCpInfoTall, content)
            getString(R.string.profile_info_form) ->
                setTextStyle(binding.tvCpInfoForm, content)
            getString(R.string.profile_info_smoke) ->
                setTextStyle(binding.tvCpInfoSmoke, content)
            getString(R.string.profile_info_religion) ->
                setTextStyle(binding.tvCpInfoReligion, content)
            getString(R.string.profile_info_married) ->
                setTextStyle(binding.tvCpInfoMarried, content)
            getString(R.string.profile_info_drink) ->
                setTextStyle(binding.tvCpInfoDrink, content)
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

    fun goToProfileGuide() {
        val intent = Intent(this, ProfileGuideActivity::class.java)
        startActivity(intent)
    }

    fun finishCreateProfile() {
        finish()
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

    private fun clickAddImage() {
        val dialog = AddPictureDialog(getString(R.string.dialog_picture_title))
        dialog.show(supportFragmentManager, AddPictureDialog.PICTURE_TAG)
    }

    fun clickModifyImage() {
        val dialog = ModifyPictureDialog(getString(R.string.dialog_picture_modify)) {
            viewModel.setMainPicture()
            (binding.rvProfilePicture.adapter as PictureAdapter).notifyDataSetChanged()
        }
        dialog.show(supportFragmentManager, ModifyPictureDialog.PICTURE_TAG)
    }

    private fun initGetContent() {
        getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            binding.imgCpImagePrev.setImageURI(uri)
            binding.imgCpImagePrev.clipToOutline = true
            binding.tvCpImagePrev.visibility = View.INVISIBLE
            binding.tvCpImageModify.visibility = View.VISIBLE

            (binding.rvProfilePicture.adapter as PictureAdapter).changeItem(
                viewModel.itemPos.value!!.toInt(), uri
            )
        }
    }

    fun selectImage() {
        getContent.launch("image/*")
    }

    private fun setAdapter() {
        binding.rvProfilePicture.adapter = PictureAdapter() { pic, pos ->
            viewModel.itemPos.value = pos
            viewModel.itemPicture.value = pic
            if (pic.image == viewModel.getUriResource(R.drawable.btn_add_image)) {
                clickAddImage()
            } else {
                binding.imgCpImagePrev.setImageURI(pic.image)
                binding.tvCpImagePrev.visibility = View.INVISIBLE
                binding.tvCpImageModify.visibility = View.VISIBLE
            }
        }
        viewModel.setDefaultPicture()
    }

    private fun setPictureList() {
        viewModel.pictureList.observe(this) { items ->
            (binding.rvProfilePicture.adapter as PictureAdapter).submitList(items)
        }
    }

    fun removeImage() {
        (binding.rvProfilePicture.adapter as PictureAdapter).changeItem(
            viewModel.itemPos.value!!.toInt(),
            viewModel.getUriResource(R.drawable.btn_add_image)
        )
        binding.imgCpImagePrev.setImageResource(0)
        binding.tvCpImagePrev.visibility = View.VISIBLE
        binding.tvCpImageModify.visibility = View.INVISIBLE
    }
}
