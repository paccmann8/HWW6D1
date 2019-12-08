package com.example.hww6d1.presenter

import android.util.Log
import com.example.hww6d1.network.GitFactory
import com.example.hww6d1.model.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitPresenter: GitContract.Presenter {

    private val gitFactory = GitFactory()

    private lateinit var view: GitContract.View
    override fun getRepsotories() {
        //TODO: Implement retrofit
        gitFactory.getRepsotories().enqueue(object :
            Callback<List<Repository>> {
            override fun onResponse(
                call: Call<List<Repository>>,
                response: Response<List<Repository>>
            ) {
                Log.d("TAG_X", "onREsponse")
                response.body()?.let { repositories ->
                    if(repositories.isNotEmpty())
                        view.displayRepsotories(repositories)
                    else
                        view.displayError()

    }




            }
            override fun onFailure(call: Call<List<Repository>>, t: Throwable) {
                Log.d("TAG_X", "onFailure®")
                view.displayError()
            }
        })
    }

    override fun setView(view: GitContract.View) {
        this.view = view
    }

}