package com.example.staticcontactlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.staticcontactlist.databinding.ContactItemBinding

class ContactAdapter (
    val contactList: MutableList<ContactInfo>,
    val listener: ContactAdapterListener):
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(
            ContactItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contactList[position]

        holder.name.text = contact.name
        holder.phone.text = contact.phone
        holder.avatar.setImageResource(contact.avatar)

        holder.root.setOnClickListener{
            listener.onItemClicked(contact)
        }
    }

    override fun getItemCount(): Int {
        return contactList.size
    }


    class ContactViewHolder(binding: ContactItemBinding) : RecyclerView.ViewHolder(binding.root) {
        var avatar = binding.contactAvatar
        var name = binding.contactName
        var phone = binding.contactPhone
        var root = binding.root
    }

    interface ContactAdapterListener {
        fun onItemClicked(content: ContactInfo)
    }
}