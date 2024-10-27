package com.example.userregistration_dipti_ict_amad_l4_04_09



import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.userregistration_dipti_ict_amad_l4_04_09.R.layout.activity_profile_detail_dipti_ict_amad_l4_04_09

class ProfileDetailActivity_DIPTI_ICT_AMAD_L4_04_09 : AppCompatActivity() {
    private lateinit var userProfileDIPTIICTAMADL40409: UserProfile_DIPTI_ICT_AMAD_L4_04_09

    private lateinit var nameTextView: TextView
    private lateinit var emailTextView: TextView
    private lateinit var dobTextView: TextView
    private lateinit var districtTextView: TextView
    private lateinit var mobileTextView: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_profile_detail_dipti_ict_amad_l4_04_09)

        // Retrieve the user profile from the intent
        userProfileDIPTIICTAMADL40409 = intent.getSerializableExtra("USER_PROFILE") as UserProfile_DIPTI_ICT_AMAD_L4_04_09

        nameTextView = findViewById(R.id.nameTextView)
        emailTextView = findViewById(R.id.emailTextView)
        dobTextView = findViewById(R.id.dobTextView)
        districtTextView = findViewById(R.id.districtTextView)
        mobileTextView = findViewById(R.id.mobileTextView)

        populateFields()
    }

    private fun populateFields() {
        nameTextView.text = userProfileDIPTIICTAMADL40409.name
        emailTextView.text = userProfileDIPTIICTAMADL40409.email
        dobTextView.text = userProfileDIPTIICTAMADL40409.dob
        districtTextView.text = userProfileDIPTIICTAMADL40409.district
        mobileTextView.text = userProfileDIPTIICTAMADL40409.mobile
    }
}