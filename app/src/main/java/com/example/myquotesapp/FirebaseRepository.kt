package com.example.myquotesapp

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

object FirebaseRepository {

    private val db = FirebaseDatabase.getInstance().getReference("quotes")

    fun addQuote(quote: Quote) {
        val id = db.push().key!!
        db.child(id).setValue(quote.copy(id = id))
    }

    fun getQuotes(onDataChange: (List<Quote>) -> Unit) {
        db.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val quoteList = mutableListOf<Quote>()
                snapshot.children.forEach {
                    it.getValue(Quote:: class.java)?.let { quote -> quoteList.add(quote) }
                }
                onDataChange(quoteList)
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }
}