package com.example.userregistration_dipti_ict_amad_l4_04_09

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.userregistration_dipti_ict_amad_l4_04_09.R.layout.profile_item_dipti_ict_amad_l4_04_09


class ProfileAdapter_DIPTI_ICT_AMAD_L4_04_09 : ListAdapter<UserProfile_DIPTI_ICT_AMAD_L4_04_09, ProfileAdapter_DIPTI_ICT_AMAD_L4_04_09.ProfileViewHolder>(DiffCallback()) {

    private var onItemClickListener: ((UserProfile_DIPTI_ICT_AMAD_L4_04_09) -> Unit)? = null
    private var onDeleteClickListener: ((UserProfile_DIPTI_ICT_AMAD_L4_04_09) -> Unit)? = null
    private var onUpdateClickListener: ((UserProfile_DIPTI_ICT_AMAD_L4_04_09) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(profile_item_dipti_ict_amad_l4_04_09, parent, false)
        return ProfileViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    fun setOnItemClickListener(listener: (UserProfile_DIPTI_ICT_AMAD_L4_04_09) -> Unit) {
        onItemClickListener = listener
    }

    fun setOnDeleteClickListener(listener: (UserProfile_DIPTI_ICT_AMAD_L4_04_09) -> Unit) {
        onDeleteClickListener = listener
    }

    fun setOnUpdateClickListener(listener: (UserProfile_DIPTI_ICT_AMAD_L4_04_09) -> Unit) {
        onUpdateClickListener = listener
    }

    inner class ProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val profileName: TextView = itemView.findViewById(R.id.userNameTxt)
        private val profileEmail: TextView = itemView.findViewById(R.id.userEmailTxt)
        private val profileDOB: TextView = itemView.findViewById(R.id.userDOBTxt)
        private val profileDistrict: TextView = itemView.findViewById(R.id.userDistritTxt)
        private val profileMobile: TextView = itemView.findViewById(R.id.userMobileTxt)
        private val deleteButton: ImageButton = itemView.findViewById(R.id.deleteBtn)
        private val updateButton: ImageButton = itemView.findViewById(R.id.editBtn)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val profile = getItem(position)
                    onItemClickListener?.invoke(profile)
                }
            }

            deleteButton.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val profile = getItem(position)
                    onDeleteClickListener?.invoke(profile)
                }
            }

            updateButton.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val profile = getItem(position)
                    onUpdateClickListener?.invoke(profile)
                }
            }
        }

        fun bind(userProfileDIPTIICTAMADL40409: UserProfile_DIPTI_ICT_AMAD_L4_04_09) {
            profileName.text = userProfileDIPTIICTAMADL40409.name
            profileEmail.text = userProfileDIPTIICTAMADL40409.email
            profileDOB.text = userProfileDIPTIICTAMADL40409.dob
            profileDistrict.text = userProfileDIPTIICTAMADL40409.district
            profileMobile.text = userProfileDIPTIICTAMADL40409.mobile
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<UserProfile_DIPTI_ICT_AMAD_L4_04_09>() {
        override fun areItemsTheSame(oldItem: UserProfile_DIPTI_ICT_AMAD_L4_04_09, newItem: UserProfile_DIPTI_ICT_AMAD_L4_04_09): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UserProfile_DIPTI_ICT_AMAD_L4_04_09, newItem: UserProfile_DIPTI_ICT_AMAD_L4_04_09): Boolean {
            return oldItem == newItem
        }
    }
}