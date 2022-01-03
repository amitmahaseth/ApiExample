package com.example.apiexample


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.apiexample.model.Users
import com.example.apiexample.network.ApiInterface
import com.example.apiexample.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.annotation.SuppressLint


class MainActivity : AppCompatActivity() {
    private var btRegister: Button? = null
    private  var btnLogin:Button?=null
    private lateinit var edtEmail:EditText
    private lateinit var edtPassword:EditText
//    private lateinit var imgShow:ImageView
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




//        imgShow=findViewById(R.id.show)
        btRegister=findViewById(R.id.btRegister)
        btnLogin=findViewById(R.id.btn_login1)
        edtEmail= findViewById(R.id.edt_email)
        edtPassword=findViewById(R.id.edt_password)
        btRegister?.setOnClickListener {
            registerUserMethod()
        }
        btnLogin?.setOnClickListener {
            loginMethod()
        }
//
//        imgShow.setOnTouchListener(OnTouchListener { v, event ->
//            when (event.action) {
//                MotionEvent.ACTION_UP -> edtPassword.setInputType(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
//                MotionEvent.ACTION_DOWN -> edtPassword.setInputType(InputType.TYPE_CLASS_TEXT)
//            }
//            true
//        })


    }

    private fun registerUserMethod()
    {
        val apiInterface= ApiService.getInstance().create(ApiInterface::class.java)
        apiInterface.registerData(edtEmail.text.toString().trim(),edtPassword.text.toString().trim(),"1","sdadb").enqueue(object :
            Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                Log.e("Response===",response.code().toString())
            }

            override fun onFailure(call: Call<Users>, t: Throwable) {
                Log.e("onFailure===",t.toString())
            }

        })
    }
    private fun loginMethod(){
        val apiInterface=ApiService.getInstance().create(ApiInterface::class.java)
        apiInterface.loginData(edtEmail.text.toString().trim(),edtPassword.text.toString().trim(),"2","amit")
            .enqueue(object : Callback<Users> {
                override fun onResponse(call: Call<Users>, response: Response<Users>) {
                   if (response.isSuccessful){
                        response.body()
                    }else{
                        response.errorBody()
                    }
                }

                override fun onFailure(call: Call<Users>, t: Throwable) {
                    Log.e("onFailure===",t.toString())
                }
            })
    }
}