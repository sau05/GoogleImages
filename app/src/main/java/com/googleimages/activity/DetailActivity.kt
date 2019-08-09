package com.googleimages.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.text.HtmlCompat
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.googleimages.R
import com.googleimages.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "Detail"

        val data = intent

        binding.tvTitle.text = HtmlCompat.fromHtml(resources.getString(R.string.label_title,data.getStringExtra("title")), HtmlCompat.FROM_HTML_MODE_LEGACY)
        if (data.getStringExtra("description")!=null)
        binding.tvDescription.text = resources.getString(R.string.label_Description,data.getStringExtra("description"))
        Glide.with(this).load(data.getStringExtra("image"))
            .apply(
                RequestOptions.placeholderOf(R.mipmap.ic_launcher).override(600,600))
            .into(binding.ivDetail)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}
