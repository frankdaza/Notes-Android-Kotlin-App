package com.frankdaza.notes

import android.content.ContentValues
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.frankdaza.notes.model.DbManager
import kotlinx.android.synthetic.main.activity_add_note.*

class AddNoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
    }

    fun actionAddNote(view: View) {
        var dbManager: DbManager = DbManager(this)
        var values: ContentValues = ContentValues()
        values.put("title", etTitle.text.toString().trim().toUpperCase())
        values.put("description", etDescription.text.toString().trim().toUpperCase())
        val id = dbManager.insert(values)

        if (id > 0) {
            Toast.makeText(this, "The note has been added successfully!", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "The note has not been added successfully!", Toast.LENGTH_LONG).show()
        }
    }
}
