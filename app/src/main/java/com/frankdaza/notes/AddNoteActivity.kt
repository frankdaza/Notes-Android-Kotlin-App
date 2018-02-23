package com.frankdaza.notes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class AddNoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
    }

    fun listenerAddNote(view: View) {
        finish()
    }
}
