package com.facekikycverification.ui

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.facekikycverification.R
import com.facekikycverification.adapter.DocumentTypeAdapter
import com.facekikycverification.databinding.ActivityDocumentsTypeBinding
import com.facekikycverification.model.DocumentType
import java.util.*

class DocumentTypeActivity : AppCompatActivity() {
    private val list = mutableListOf<DocumentType>()
    lateinit var binding: ActivityDocumentsTypeBinding
    private val adapter : DocumentTypeAdapter by lazy {
        DocumentTypeAdapter()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Objects.requireNonNull(supportActionBar)!!.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_documents_type)
        prepareData()
        adapter.submitList(list)
        binding.rvList.adapter = adapter
        binding.ivBack.setOnClickListener {
            finish()
        }
        binding.ivNext.setOnClickListener {
            startActivity(Intent(this, SdkSetting::class.java))
            finish()
        }
    }

    private fun prepareData() {
        list.add(DocumentType(isSelected = true, documentName = "Driving License", icon = R.drawable.ic_driving, docType = 0))
        list.add(DocumentType(isSelected = false, documentName = "Passport", icon = R.drawable.ic_passport, docType = 1))
        list.add(DocumentType(isSelected = false, documentName = "ID Card", icon = R.drawable.ic_idcard, docType = 2))
    }
}
