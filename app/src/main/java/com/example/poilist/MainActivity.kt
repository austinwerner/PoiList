package com.example.poilist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = RecyclerViewAdapter()

        Log.d("WERNER", "created ")
        fetchJson()
    }

    fun fetchJson() {
        val url = "http://sandbox.bottlerocketapps.com/BR_Android_CodingExam_2015_Server/stores.json"
        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("WERNER", "failure " + e )
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response?.body?.string()
                Log.d( "WERNER", body )
            }
        })
    }
}
