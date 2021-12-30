package com.example.apiexample

import android.R.attr
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.example.apiexample.model.Users
import com.example.apiexample.network.ApiInterface
import com.example.apiexample.network.ApiService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.view.MotionEvent

import android.view.View.OnTouchListener

import android.R.attr.button
import android.annotation.SuppressLint
import android.text.InputType
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apiexample.adapter.UserAdapter
import com.example.apiexample.model.UserDetails


class MainActivity : AppCompatActivity() {
    private var btRegister: Button? = null
    private lateinit var edtEmail:EditText
    private lateinit var edtPassword:EditText
    private lateinit var imgShow:ImageView
    private lateinit var recycler:RecyclerView

    lateinit var myAdapter: UserAdapter
    lateinit var linearLayoutManager: LinearLayoutManager

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler=findViewById(R.id.show_data)
        recycler.setHasFixedSize(true)

        linearLayoutManager= LinearLayoutManager(this)
        recycler.layoutManager=linearLayoutManager

        getMyData()

//        imgShow=findViewById(R.id.show)
//        btRegister=findViewById<Button>(R.id.btRegister)
//        edtEmail= findViewById<EditText>(R.id.edt_email)
//        edtPassword=findViewById<EditText>(R.id.edt_password)
//        btRegister?.setOnClickListener {
//            registerUserMethod()
//        }
//
//        imgShow.setOnTouchListener(OnTouchListener { v, event ->
//            when (event.action) {
//                MotionEvent.ACTION_UP -> edtPassword.setInputType(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
//                MotionEvent.ACTION_DOWN -> edtPassword.setInputType(InputType.TYPE_CLASS_TEXT)
//            }
//            true
//        })


    }

//    private fun registerUserMethod()
//    {
//        var apiInterface= ApiService.getInstance().create(ApiInterface::class.java)
//        apiInterface.registerData(edtEmail.text.toString().trim(),edtPassword.text.toString().trim(),"1","sdadb").enqueue(object :
//            Callback<Users> {
//            override fun onResponse(call: Call<Users>, response: Response<Users>) {
//                Log.e("Response===",response.code().toString());
//            }
//
//            override fun onFailure(call: Call<Users>, t: Throwable) {
//                Log.e("onFailure===",t.toString());
//            }
//
//        })
//    }

    private fun getMyData(){
        var apiInterface=ApiService.getInstance().create(ApiInterface::class.java)
        apiInterface.getData().enqueue(object : Callback<List<UserDetails>?> {
            override fun onResponse(
                call: Call<List<UserDetails>?>,
                response: Response<List<UserDetails>?>
            ) {
                val responseBody=response.body()
                myAdapter= UserAdapter(baseContext, responseBody as ArrayList<UserDetails>)
                myAdapter.notifyDataSetChanged()
                recycler.adapter=myAdapter


            }

            override fun onFailure(call: Call<List<UserDetails>?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}