package com.example.talha.retrofitdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.R.attr.resource
import android.widget.TextView
import android.widget.Toast







class MainActivity :AppCompatActivity() {
    var apiInterface:ApiInterface?=null

    var responseText: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        responseText=findViewById(R.id.tview)as TextView
        apiInterface = ApiClient.getClient()?.create(ApiInterface::class.java)
//        val call: Call<MultipleResource> = apiInterface!!.doGetListResources()
//        call.enqueue(object:Callback<MultipleResource>{
//
//           override fun onResponse(call:Call<MultipleResource>, response:Response<MultipleResource>) {
//                Log.d("TAG", response.toString())
//              var displayResponse = ""
//                val resource = response.body()
//                val text = resource.page
//                val total = resource.total
//                val totalPages = resource.totalPages
//                val datumList = resource?.data
//                displayResponse +=""+ text + " Page\n" + total + " Total\n" + totalPages + " Total Pages\n"
//                for (datum in datumList.orEmpty())
//                {
//                    displayResponse += ""+datum.id +" " + datum.name + " " + datum.pantoneValue + " " + datum.year + "\n"
//                }
//                responseText?.setText(displayResponse)
//            }
//            override fun onFailure(call:Call<MultipleResource>, t:Throwable) {
//                call.cancel()
//            }
//
//        })
        /**
        Create new user
         **/
        val user = User("morpheus", "leader")
        val call1 = apiInterface?.createUser(user)
        call1?.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                val user1 = response.body()
                var displayResponse:String=""
                Toast.makeText(applicationContext, user1.name + " " + user1.job + " " + user1.id + " " + user1.createdAt, Toast.LENGTH_SHORT).show()
                displayResponse+=" "+user1.name+" "+user1.job+" "+user1.id+" "+user1.createdAt
                responseText?.setText(displayResponse)
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                call.cancel()
            }
        })


    }
}