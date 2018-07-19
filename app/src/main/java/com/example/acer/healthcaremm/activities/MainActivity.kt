package com.example.acer.healthcaremm.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.net.Uri
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.example.acer.healthcaremm.R
import com.example.acer.healthcaremm.adapters.HealthCareAdapter
import com.example.acer.healthcaremm.components.SmartScrollListener
import com.example.acer.healthcaremm.data.vos.HealthCareVO
import com.example.acer.healthcaremm.mvp.presenters.HealthCarePresenter
import com.example.acer.healthcaremm.mvp.views.HealthCareView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),HealthCareView {
    override fun onTapHealthCareUrl(url: String) {
      var builder : CustomTabsIntent.Builder = CustomTabsIntent.Builder()
        var intent : CustomTabsIntent = builder.build()
        intent.launchUrl(applicationContext, Uri.parse(url))
    }

    private lateinit var mHealthCareAdapter : HealthCareAdapter
    private var mSmartScrollListener : SmartScrollListener? = null
    private var mPresenter : HealthCarePresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        mPresenter = ViewModelProviders.of(this).get(HealthCarePresenter::class.java)
        mPresenter!!.initPresenter(this,applicationContext)

        mSmartScrollListener = SmartScrollListener(object :SmartScrollListener.SmartScrollListener{
            override fun onListEndReach() {
                Snackbar.make(rvSmartHealthCare,"Loading More Data",Snackbar.LENGTH_LONG).show()
            }

        })
        mHealthCareAdapter = HealthCareAdapter(applicationContext, mPresenter!!)
        rvSmartHealthCare.layoutManager=LinearLayoutManager(applicationContext)
        rvSmartHealthCare.adapter = mHealthCareAdapter
        rvSmartHealthCare.addOnScrollListener(mSmartScrollListener)

        mPresenter!!.getHealthCareLd().observe(this, Observer<List<HealthCareVO>> { t -> displayHealthCare(t!!) })


    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun displayHealthCare(healthCare:List<HealthCareVO>){
        mHealthCareAdapter.appendNewData(healthCare)
    }

}
