package com.example.hww6d1.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.hww6d1.R
import com.example.hww6d1.model.Repository
import com.example.hww6d1.view.MainActivity
import com.example.hww6d1.view.Repo_Activity

class RepoAdaptor(val repoList: List<Repository>) :RecyclerView.Adapter<RepoAdaptor.RepoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.repo_item_layout, parent, false)


        return RepoViewHolder(view)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {

        holder.apply {
            repo_name.text = repoList[position].fullName

            repo_name.setOnClickListener {

                val intent = Intent(itemView.context, Repo_Activity::class.java)
                intent.putExtra("repositoryLink", repoList[position].htmlUrl)

                itemView.context.startActivity(intent)



            }

        }



    }

    override fun getItemCount(): Int {
        return repoList.size
    }


    inner class RepoViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

        val repo_name: TextView = itemView.findViewById(R.id.repo_text)

    }

}