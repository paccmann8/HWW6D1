package com.example.hww6d1.view

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.hww6d1.R
import com.example.hww6d1.adapter.RepoAdaptor
import com.example.hww6d1.model.Repository
import com.example.hww6d1.presenter.GitContract
import com.example.hww6d1.presenter.GitPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), GitContract.View {

    lateinit var gitPresenter:GitPresenter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Glide.with(this)
            .load(R.drawable.ic_launcher_background)
            .into(card_background)

        gitPresenter = GitPresenter()
        gitPresenter.setView(this)
        gitPresenter.getRepositories()

    }
    override fun displayRepositories(repositories: List<Repository>) {

        Glide.with(this)
            .load(repositories[0].owner.avatarUrl)
            .into(card_image)

        card_title.text = repositories[0].owner.login

        val repository = RepoAdaptor(repositories)
        card_text.adapter = repository
        val linear = LinearLayoutManager(this)
        //linear.orientation = RecyclerView.HORIZONTAL
        card_text.layoutManager = linear


    }





    //override fun displayRepositories(repositories: List<Repository>){


    //}

    override fun displayError() {
        Toast.makeText(this, "Problems occured", Toast.LENGTH_SHORT).show()
    }
}
