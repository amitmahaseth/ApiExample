package com.example.apiexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.annotation.SuppressLint
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apiexample.adapter.UserAdapter
import com.example.apiexample.model.UserDataItem
import com.example.apiexample.network.ApiInterface
import com.example.apiexample.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
//    private var btRegister: Button? = null
//    private  var btnLogin:Button?=null
//    private lateinit var edtEmail:EditText
//    private lateinit var edtPassword:EditText

    private lateinit var recyclerView: RecyclerView
    lateinit var myAdapter: UserAdapter
    lateinit var linearLayoutManager: LinearLayoutManager

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.show_data)
        recyclerView.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager


//        btRegister=findViewById(R.id.btRegister)
//        btnLogin=findViewById(R.id.btn_login)
//        edtEmail= findViewById(R.id.edt_email)
//        edtPassword=findViewById(R.id.edt_password)
//        btRegister?.setOnClickListener {
//            registerUserMethod()
//        }
//    btnLogin?.setOnClickListener {
//        loginMethod()
//    }
        getData()
    }

    //    private fun registerUserMethod()
//    {
//        val apiInterface= ApiService.getInstance().create(ApiInterface::class.java)
//        apiInterface.registerData(edtEmail.text.toString().trim(),edtPassword.text.toString().trim(),"1","sdadb").enqueue(object :
//            Callback<Users> {
//            override fun onResponse(call: Call<Users>, response: Response<Users>) {
//                Log.e("Response===",response.code().toString())
//            }
//
//            override fun onFailure(call: Call<Users>, t: Throwable) {
//                Log.e("onFailure===",t.toString())
//            }
//
//        })
//    }
//    private fun loginMethod(){
//        val apiInterface=ApiService.getInstance().create(ApiInterface::class.java)
//        apiInterface.loginData(edtEmail.text.toString().trim(),edtPassword.text.toString().trim(),"2","amit")
//            .enqueue(object : Callback<Users> {
//                override fun onResponse(call: Call<Users>, response: Response<Users>) {
//                    if (response.isSuccessful){
//                        response.body()
//                    }else{
//                        response.errorBody()
//                    }
//                }
//
//                override fun onFailure(call: Call<Users>, t: Throwable) {
//                    Log.e("onFailure===",t.toString())
//                }
//            })
//    }
    private fun getData() {
        var apiInterface = ApiService.getInstance().create(ApiInterface::class.java)
        apiInterface.getData().enqueue(object : Callback<List<UserDataItem>?> {
            override fun onResponse(
                call: Call<List<UserDataItem>?>,
                response: Response<List<UserDataItem>?>
            ) {
                val responseBody = response.body()
                myAdapter = UserAdapter(baseContext, responseBody as ArrayList<UserDataItem>)
                myAdapter.notifyDataSetChanged()
                recyclerView.adapter = myAdapter
            }

            override fun onFailure(call: Call<List<UserDataItem>?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}