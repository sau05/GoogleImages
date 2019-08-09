package com.googleimages.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.googleimages.R
import com.googleimages.adapter.RecyclerAdapter
import com.googleimages.databinding.ActivitySearchResultBinding
import com.googleimages.model.Item
import com.googleimages.model.QueryResponse
import com.googleimages.network.APIInterface
import com.googleimages.network.ApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SearchResultActivity : AppCompatActivity(), RecyclerAdapter.ItemClickListener {
    override fun imageItemClick(item: Item?) {
        val intent = Intent(applicationContext, DetailActivity::class.java)
        intent.putExtra("title", item?.title)
        intent.putExtra("description", item?.pagemap?.metatags?.get(0)?.ogDescription)
        intent.putExtra("image", item?.pagemap?.cseImage?.get(0)?.src)
        startActivity(intent)
    }

    private lateinit var mCompositeDisposable: CompositeDisposable
    private lateinit var apiInterface:APIInterface
    private lateinit var binding: ActivitySearchResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_search_result)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "Search Result"

        apiInterface = ApiClient.getClient().create(APIInterface::class.java)

        mCompositeDisposable = CompositeDisposable()

        getResults()
    }

    private fun getResults(){
        val headers = HashMap<String,String>()
        headers["Content-Type"] = "application/json"
        headers["cache-control"] = "no-cache"
        mCompositeDisposable.add(apiInterface.getQueryData(headers,intent.getStringExtra("query"),"000224400019315401564:j3iehzwrujw","AIzaSyAe9uxOcJ9A2wobue0hF3tIumCSmcd9bB0").subscribeOn(
            Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
            .subscribe({ t: QueryResponse? ->
                binding.progressBar.visibility = View.GONE

                Log.d("query resp",""+t?.items?.size)
                val adapter = RecyclerAdapter(this@SearchResultActivity, t?.items, this@SearchResultActivity)
                binding.recyclerView.adapter = adapter
                binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
                binding.recyclerView.addItemDecoration(
                    DividerItemDecoration(
                        this@SearchResultActivity,
                        DividerItemDecoration.VERTICAL
                    )
                )
            },{t: Throwable? ->  Log.d("ob error", "" + t)}
            ))
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        mCompositeDisposable?.dispose()
    }
}
