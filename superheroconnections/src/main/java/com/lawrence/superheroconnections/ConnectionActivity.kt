package com.lawrence.superheroconnections

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.lawrence.superheroapp.rest.RetrofitClient
import com.lawrence.superheroapp.rest.model.Connections
import com.lawrence.superheroapp.rest.network.GetService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ConnectionActivity : AppCompatActivity() {
    private var mSearchconnection: EditText? = null
    private var mName: TextView? = null
    private var mGroup: TextView? = null
    private var mRelatives: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connection)
        mSearchconnection = findViewById(R.id.search_connections)
        mName = findViewById(R.id.connection_name)
        mGroup = findViewById(R.id.connection_group)
        mRelatives = findViewById(R.id.connection_relatives)
    }

    fun Search(view: View?) {
        val characterId = mSearchconnection!!.text.toString().trim { it <= ' ' }
        val service = RetrofitClient.buildService(GetService::class.java)
        val call = service.getConnections(characterId)
        call?.enqueue(object : Callback<Connections> {
            override fun onResponse(call: Call<Connections>, response: Response<Connections>) {
                mSearchconnection!!.visibility = View.INVISIBLE
                mName!!.text = String.format("Name: %s", response.body()!!.name)
                mGroup!!.text = String.format("Group: %s", response.body()!!.groupAffiliation)
                mRelatives!!.text = String.format("Relatives: %s", response.body()!!.relatives)
            }

            override fun onFailure(call: Call<Connections>, t: Throwable) {
                mSearchconnection!!.visibility = View.INVISIBLE
                Toast.makeText(this@ConnectionActivity, "Error: " + t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}

private fun <T> Call<T>?.enqueue(callback: Callback<Connections>) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}
