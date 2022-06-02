package id.ac.ubaya.advweek4.viewmodel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import id.ac.ubaya.advweek4.model.Student

class DetailViewModel(application: Application):AndroidViewModel(application) {
    val studentsLD = MutableLiveData<Student>()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun fetch(idStudent:String) {

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://adv.jitusolution.com/student.php?id="+idStudent

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {

                val sType = object: TypeToken<Student>() {}.type
                val result = Gson().fromJson<Student>(it, sType)

                studentsLD.value = result

                Log.d("showvolley", result.toString())
            },
            {
                Log.d("showvolley", it.toString())

            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
}