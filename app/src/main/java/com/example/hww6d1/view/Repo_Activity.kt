package com.example.hww6d1.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hww6d1.R
import kotlinx.android.synthetic.main.activity_repo.*


class Repo_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo)

        val gitLink = intent.getStringExtra("repositoryLink")

        Hubview.loadUrl(gitLink)

    }
}