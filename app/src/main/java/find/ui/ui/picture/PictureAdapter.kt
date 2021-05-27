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
            )
        )

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.onClick(getItem(position), itemClick)
    }

    fun changeItem(position: Int, uri: Uri) {
        getItem(position).image = uri
        notifyItemChanged(position)
    }

    class PictureViewHolder(
        private val binding: ItemPhotoBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(picture: ProfilePicture) {
            binding.setVariable(BR.picture, picture)
            binding.imgProfilePicture.clipToOutline = true
        }

        fun onClick(pic: ProfilePicture, itemClick: (ProfilePicture, Int) -> Unit) {
            binding.imgProfilePicture.setOnClickListener {
                itemClick.invoke(pic, adapterPosition)
            }
        }
    }

    private class PictureDiffUtil : DiffUtil.ItemCallback<ProfilePicture>() {
        override fun areItemsTheSame(oldItem: ProfilePicture, newItem: ProfilePicture) =
            oldItem.image == newItem.image

        override fun areContentsTheSame(oldItem: ProfilePicture, newItem: ProfilePicture) =
            oldItem == newItem
    }
}
