package com.example.staticcontactlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.staticcontactlist.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), ContactAdapter.ContactAdapterListener {
    private val contactList: MutableList<ContactInfo> = mutableListOf()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        populateList()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = getString(R.string.title)

        val list = binding.list

        list.layoutManager = LinearLayoutManager(this)
        list.adapter = ContactAdapter(contactList,this)
    }

    private fun populateList(){
        val avatarList = listOf(R.drawable.face_black,R.drawable.face_blue, R.drawable.face_green, R.drawable.face_orange, R.drawable.face_pink, R.drawable.face_purple, R.drawable.face_red, R.drawable.face_yellow)
        contactList.add(ContactInfo("Clint Conkie","+46 (937) 691-2459", avatarList.random()))
        contactList.add(ContactInfo("Corry Gleeton","+63 (831) 174-8123", avatarList.random()))
        contactList.add(ContactInfo("Mariya Maggiore","+86 (406) 504-3035", avatarList.random()))
        contactList.add(ContactInfo("Winny Lygo","+509 (975) 605-4025", avatarList.random()))
        contactList.add(ContactInfo("Rudy Pynner","+48 (843) 321-0480", avatarList.random()))
        contactList.add(ContactInfo("Leone Corpes","+386 (346) 756-6266", avatarList.random()))
        contactList.add(ContactInfo("Doralyn Rulton","+62 (949) 850-2673", avatarList.random()))
        contactList.add(ContactInfo("Eden Boissier","+55 (864) 663-7782", avatarList.random()))
        contactList.add(ContactInfo("Viviana Perrot","+1 (654) 682-7874", avatarList.random()))
        contactList.add(ContactInfo("Briano Croson","+62 (657) 200-0240", avatarList.random()))
    }

    override fun onItemClicked(content: ContactInfo) {
        Snackbar.make(binding.root,"Hi ${content.name}",Snackbar.LENGTH_SHORT).show()
    }
}