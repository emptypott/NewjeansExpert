package com.example.newexpert

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView

class NewjeansAdapter constructor(val members : List<Member> = emptyList()) : RecyclerView.Adapter<NewjeansAdapter.PagerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_new_jeans, parent, false)
        return PagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bind(members[position])
    }

    override fun getItemCount(): Int = members.count()


    class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val memberNameTextView : TextView = itemView.findViewById(R.id.tv_member_name)
        private val memberImageView : ImageView = itemView.findViewById(R.id.iv_member)

        fun bind (member: Member) {
            memberNameTextView.text = member.memberName
            memberImageView.setImageDrawable(ResourcesCompat.getDrawable(itemView.context.resources, member.imageResId, null))
        }
    }
}