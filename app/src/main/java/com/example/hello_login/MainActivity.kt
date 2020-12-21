package com.example.hello_login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the Intent that started this activity and extract the string
        val message = intent.getStringExtra(EXTRA_MESSAGE)

        // Capture the layout's TextView and set the string as its text
        /*val textView = findViewById<TextView>(R.id.mainLabel).apply {
            text = message
        }*/
    }

    protected val handler: Handler by lazy {
        Handler(Looper.getMainLooper())
    }


    fun sendSearch(view: View){
        try {
            Log.e("hej","try")

            val strSearch = findViewById<TextView>(R.id.searchText).text.toString()

            try {
                Network.search(strSearch,
                    {reply -> onReply(reply)},
                    {error -> errorMessage(error)})
            }
            catch (e: Exception) {
                e.message?.let { errorMessage(it) }
            }

        }
        catch (e: Exception) {
            //e.message?.let { errorMessage(it) }
        }
    }


    private fun onReply(string: String){

        handler.post {
            findViewById<TextView>(R.id.resultText).apply {
                text = string
            }
        }}

    private fun errorMessage(error: String){

        handler.post{
            Toast.makeText(applicationContext, error, Toast.LENGTH_LONG).show()
        }}

    private fun update_list(){}

    private fun proon_data(){}
}
