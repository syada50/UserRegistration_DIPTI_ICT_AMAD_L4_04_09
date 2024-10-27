package com.example.userregistration_dipti_ict_amad_l4_04_09

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.userregistration_dipti_ict_amad_l4_04_09.R.id.profileRecyclerView
import com.example.userregistration_dipti_ict_amad_l4_04_09.R.layout.activity_profile_list_dipti_ict_amad_l4_04_09

import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProfileListActivity_DIPTI_ICT_AMAD_L4_04_09 : AppCompatActivity() {

    private lateinit var profileViewModel: UserProfileViewModel_DIPTI_ICT_AMAD_L4_04_09
    private lateinit var profileAdapterDIPTIICTAMADL40409: ProfileAdapter_DIPTI_ICT_AMAD_L4_04_09

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_profile_list_dipti_ict_amad_l4_04_09)

        profileViewModel = ViewModelProvider(this).get(UserProfileViewModel_DIPTI_ICT_AMAD_L4_04_09::class.java)

        val recyclerView = findViewById<RecyclerView>(profileRecyclerView)
        profileAdapterDIPTIICTAMADL40409 = ProfileAdapter_DIPTI_ICT_AMAD_L4_04_09()

        recyclerView.adapter = profileAdapterDIPTIICTAMADL40409
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Observe profiles from ViewModel
        profileViewModel.getUserProfiles().observe(this , Observer { profiles ->
            profileAdapterDIPTIICTAMADL40409.submitList(profiles)
        })

        // Set item click listener for details
        profileAdapterDIPTIICTAMADL40409.setOnItemClickListener { userProfile ->
            val intent = Intent(this@ProfileListActivity_DIPTI_ICT_AMAD_L4_04_09 , ProfileDetailActivity_DIPTI_ICT_AMAD_L4_04_09::class.java)
            intent.putExtra("USER_PROFILE" , userProfile)
            startActivity(intent)
        }

        // Set delete click listener
        profileAdapterDIPTIICTAMADL40409.setOnDeleteClickListener { userProfile ->
            showDeleteConfirmationDialog(userProfile)
        }

        // Set update click listener
        profileAdapterDIPTIICTAMADL40409.setOnUpdateClickListener { userProfile ->
            val intent = Intent(this@ProfileListActivity_DIPTI_ICT_AMAD_L4_04_09 , UpdateProfileActivity_DIPTI_ICT_AMAD_L4_04_09::class.java)
            intent.putExtra("USER_PROFILE" , userProfile)
            startActivity(intent)
        }

        // Add profile button click listener
        findViewById<FloatingActionButton>(R.id.addProfileBtn).setOnClickListener {
            val intent = Intent(this@ProfileListActivity_DIPTI_ICT_AMAD_L4_04_09 , AddProfileActivity_DIPTI_ICT_AMAD_L4_04_09::class.java)
            startActivity(intent)
        }
    }

    // Show delete confirmation dialog
    private fun showDeleteConfirmationDialog(userProfileDIPTIICTAMADL40409: UserProfile_DIPTI_ICT_AMAD_L4_04_09) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Delete Profile")
        builder.setMessage("Are you sure you want to delete this profile?")

        builder.setPositiveButton("Yes") { dialog , which ->
            profileViewModel.deleteUserProfile(userProfileDIPTIICTAMADL40409)  // Delete the profile
            dialog.dismiss()
        }

        builder.setNegativeButton("No") { dialog , which ->
            dialog.dismiss()  // Cancel delete operation
        }


        val dialog = builder.create()
        dialog.show()


    }
}