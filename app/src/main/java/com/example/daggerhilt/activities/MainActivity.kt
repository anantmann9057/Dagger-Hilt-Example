package com.example.daggerhilt.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daggerhilt.R
import com.example.daggerhilt.data.Cannabis
import com.example.daggerhilt.data.Marvel
import com.example.daggerhilt.databinding.ActivityMainBinding
import com.example.daggerhilt.module.HelperModule
import com.example.daggerhilt.module.PreferenceModule
import com.example.daggerhilt.showLog
import com.example.daggerhilt.showToast
import com.example.daggerhilt.viewModel.MarvelViewModel
import com.example.daggerhilt.viewModel.ViewModel
import com.hunger.worries.adapters.GenericAdapter
import dagger.hilt.android.AndroidEntryPoint
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), GenericAdapter.OnItemClickListener<Any> {
    @Inject
    lateinit var helperModule: HelperModule

    @Inject
    lateinit var preferenceModule: PreferenceModule

    lateinit var cannabisAdapter: GenericAdapter

    private val mViewModel: MarvelViewModel by viewModels()

    lateinit var binding: ActivityMainBinding
    lateinit var cannabisList: ArrayList<Cannabis>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setCannabisAdapter()
        fetchCannabis()
        var marvel = Marvel()

        var s = String.format(
            "${System.currentTimeMillis()}",
            "7b0c2850e8da63ff744683fe227443c8715ebaab",
            "2d8dd006408b31b769b53ea4846ba2ee"
              )


        preferenceModule.setUserToken("this is a usertoken")
        showLog(preferenceModule.getUserToken()!!)
        binding.btFetch.setOnClickListener {
            fetchCannabisBySize(100)
        }
    }

    fun md5(s: String): String? {
        try {
            // Create MD5 Hash
            val digest: MessageDigest = MessageDigest.getInstance("MD5")
            digest.update(s.toByteArray())
            val messageDigest: ByteArray = digest.digest()

            // Create Hex String
            val hexString = StringBuffer()
            for (i in messageDigest.indices) hexString.append(
                Integer.toHexString(
                    0xFF and messageDigest[i]
                        .toInt()
                )
            )
            return hexString.toString()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
        return s
    }

    private fun fetchCannabisBySize(size: Int) {
//        mViewModel.fetchCannabisBySize(size)
//        mViewModel.cannabisAmount.observe(this) {
//            cannabisList = it
//            cannabisAdapter.notifyAdapter(cannabisList as java.util.ArrayList<Any>)
//        }

    }

    private fun fetchCannabis() {
//        mViewModel.fetchCannabisData()
//        mViewModel.cannabis.observe(this) {
//            cannabisList = it
//            cannabisAdapter.notifyAdapter(cannabisList as java.util.ArrayList<Any>)
//        }
    }

    private fun setCannabisAdapter() {
        cannabisList = ArrayList()

        cannabisAdapter =
            GenericAdapter(cannabisList as ArrayList<Any>, this, R.layout.row_base)
        binding.rvHome.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = cannabisAdapter
        }
    }

    override
    fun onItemClick(view: View?, position: Int, `object`: Any) {
        when (`object`) {
            is Cannabis -> {
                startActivity(Intent(this, RestaurantActivity::class.java))
            }
        }
    }
}