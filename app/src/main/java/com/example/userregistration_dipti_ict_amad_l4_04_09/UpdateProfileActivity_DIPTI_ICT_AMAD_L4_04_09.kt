package com.example.userregistration_dipti_ict_amad_l4_04_09


import android.app.ProgressDialog
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

import com.example.userregistration_dipti_ict_amad_l4_04_09.R.layout.activity_update_profile_dipti_ict_amad_l4_04_09

class UpdateProfileActivity_DIPTI_ICT_AMAD_L4_04_09 : AppCompatActivity() {
    private lateinit var profileViewModel: UserProfileViewModel_DIPTI_ICT_AMAD_L4_04_09
    private lateinit var userProfileDIPTIICTAMADL40409: UserProfile_DIPTI_ICT_AMAD_L4_04_09

    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var dobEditText: EditText
    private lateinit var districtEditText: EditText
    private lateinit var mobileEditText: EditText

    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_update_profile_dipti_ict_amad_l4_04_09)

        // Initialize ViewModel
        profileViewModel = ViewModelProvider(this).get(UserProfileViewModel_DIPTI_ICT_AMAD_L4_04_09::class.java)

        // Retrieve user profile from intent
        userProfileDIPTIICTAMADL40409 = intent.getSerializableExtra("USER_PROFILE") as UserProfile_DIPTI_ICT_AMAD_L4_04_09

        // Initialize EditText fields
        nameEditText = findViewById(R.id.profileNameEt)
        emailEditText = findViewById(R.id.profileEmailEt)
        dobEditText = findViewById(R.id.profileDOBEt)
        districtEditText = findViewById(R.id.profileDistrictEt)
        mobileEditText = findViewById(R.id.profilemobileEt)

        // Populate fields with user data
        populateFields()

        // Initialize progress dialog
        progressDialog = ProgressDialog(this).apply {
            setMessage("Updating Profile...")
            setCancelable(false) // Prevent closing while loading
        }

        // Update button click listener
        findViewById<Button>(R.id.updateBtn).setOnClickListener {
            if (validateInputs()) {
                showLoading() // Show loading before updating
                updateUserProfile() // Perform the update
            }
        }
    }

    private fun populateFields() {
        nameEditText.setText(userProfileDIPTIICTAMADL40409.name)
        emailEditText.setText(userProfileDIPTIICTAMADL40409.email)
        dobEditText.setText(userProfileDIPTIICTAMADL40409.dob)
        districtEditText.setText(userProfileDIPTIICTAMADL40409.district)
        mobileEditText.setText(userProfileDIPTIICTAMADL40409.mobile)
    }

    private fun validateInputs(): Boolean {
        val name = nameEditText.text.toString().trim()
        val email = emailEditText.text.toString().trim()
        val dob = dobEditText.text.toString().trim()
        val district = districtEditText.text.toString().trim()
        val mobile = mobileEditText.text.toString().trim()

        return when {
            name.isEmpty() -> {
                nameEditText.error = "Please enter your name"
                nameEditText.requestFocus()
                false
            }

            email.isEmpty() -> {
                emailEditText.error = "Please enter your email"
                emailEditText.requestFocus()
                false
            }

            dob.isEmpty() -> {
                dobEditText.error = "Please enter your date of birth"
                dobEditText.requestFocus()
                false
            }

            district.isEmpty() -> {
                districtEditText.error = "Please enter your district"
                districtEditText.requestFocus()
                false
            }

            mobile.isEmpty() -> {
                mobileEditText.error = "Please enter your mobile number"
                mobileEditText.requestFocus()
                false
            }

            else -> true
        }
    }

    private fun updateUserProfile() {
        // Retrieve input values
        val name = nameEditText.text.toString()
        val email = emailEditText.text.toString()
        val dob = dobEditText.text.toString()
        val district = districtEditText.text.toString()
        val mobile = mobileEditText.text.toString()

        // Create updated user profile
        val updatedUserProfileDIPTIICTAMADL40409 = UserProfile_DIPTI_ICT_AMAD_L4_04_09(
            id = userProfileDIPTIICTAMADL40409.id ,
            name = name ,
            email = email ,
            dob = dob ,
            district = district ,
            mobile = mobile
        )

        // Perform the update in ViewModel
        profileViewModel.updateUserProfile(updatedUserProfileDIPTIICTAMADL40409)

        // Delay to simulate loading, then close the activity
        Handler(Looper.getMainLooper()).postDelayed({
            hideLoading() // Hide loading after a delay
            Toast.makeText(this , "Profile updated successfully" , Toast.LENGTH_SHORT).show()
            finish() // Close activity
        } , 2000) // Delay of 2 seconds
    }

    private fun showLoading() {
        // Show the progress dialog
        progressDialog.show()
    }

    private fun hideLoading() {
        // Dismiss the progress dialog
        progressDialog.dismiss()
    }
}