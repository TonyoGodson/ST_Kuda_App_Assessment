package com.godston.st_task_kuda.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class KudaViewModel : ViewModel() {
    val passcodeData = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    var passcodeData2: String = ""
}
