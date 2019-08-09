package com.googleimages.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import com.googleimages.R
import com.googleimages.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                Log.d("submit", "" + p0)
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                Log.d("textchange", "" + p0)

                binding.btn.setOnClickListener {
                    if (p0?.length!! > 0) {
                        val intent = Intent(this@MainActivity, SearchResultActivity::class.java)
                        intent.putExtra("query", p0)
                        startActivity(intent)
                    }
                }
                return true
            }
        })
    }
}
