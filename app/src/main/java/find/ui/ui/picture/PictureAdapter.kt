package find.ui.ui.picture

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import find.ui.BR
import find.ui.databinding.ItemPhotoBinding

class PictureAdapter(private val itemClick: (ProfilePicture, Int) -> Unit) :
    ListAdapter<ProfilePicture, PictureAdapter.PictureViewHolder>(PictureDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PictureViewHolder(
            ItemPhotoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            itemClick
        )

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) =
        holder.bind(getItem(position))

    class PictureViewHolder(
        private val binding: ItemPhotoBinding,
        private val itemClick: (ProfilePicture, Int) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(picture: ProfilePicture) {
            binding.setVariable(BR.picture, picture)

            binding.imgProfilePicture.setOnClickListener {
                itemClick.invoke(picture, adapterPosition)
            }
        }

        fun setImage(uri: Uri) {
            binding.imgProfilePicture.clipToOutline = true
            binding.imgProfilePicture.setPadding(2, 2, 2, 2)
            binding.imgProfilePicture.setImageURI(uri)
        }
    }

    private class PictureDiffUtil : DiffUtil.ItemCallback<ProfilePicture>() {
        override fun areItemsTheSame(oldItem: ProfilePicture, newItem: ProfilePicture) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: ProfilePicture, newItem: ProfilePicture) =
            oldItem == newItem
    }
}
