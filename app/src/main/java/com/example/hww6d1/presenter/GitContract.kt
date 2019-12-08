package com.example.hww6d1.presenter

import android.view.View
import com.example.hww6d1.model.Repository

interface GitContract {

    interface Presenter {
        fun getRepositories()
        fun setView(view: GitContract.View)
    }

    interface View {
        fun displayRepositories(repositories: List<Repository>)
        fun displayError()
    }
}