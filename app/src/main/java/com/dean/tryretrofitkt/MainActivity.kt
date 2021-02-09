package com.dean.tryretrofitkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dean.tryretrofitkt.adapter.UsersAdapter
import com.dean.tryretrofitkt.model.NetworkConfig
import com.dean.tryretrofitkt.model.ResponseUsers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NetworkConfig().getService()
            .getUsers()
            .enqueue(object : Callback<List<ResponseUsers>> {
                override fun onFailure(call: Call<List<ResponseUsers>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }
                override fun onResponse(
                    call: Call<List<ResponseUsers>>,
                    response: Response<List<ResponseUsers>>
                ) {
                    rvUser.adapter = UsersAdapter(response.body())
                }
            })
    }
}