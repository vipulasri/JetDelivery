package com.vipulasri.jetdelivery.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.ui.core.setContent
import com.vipulasri.jetdelivery.data.observe
import com.vipulasri.jetdelivery.ui.JetDeliveryApp

class MainActivity : AppCompatActivity() {

  private lateinit var viewModel: MainViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    viewModel.loadData()

    setContent {
      JetDeliveryApp(viewModel)
    }
  }
}
