package com.frankdaza.notes

import android.content.ContentValues
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.frankdaza.notes.model.DbManager
import kotlinx.android.synthetic.main.activity_add_note.*

class AddNoteActivity : AppCompatActivity() {

    var notId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        var bundle: Bundle = intent.extras
        this.notId = bundle.getInt("id", 0)

        if (this.notId != 0) {
            etTitle.setText(bundle.getString("title").toString())
            etDescription.setText(bundle.getString("description").toString())
        }
    }

    fun actionAddNote(view: View) {
        var dbManager: DbManager = DbManager(this)
        var values: ContentValues = ContentValues()
        values.put("title", etTitle.text.toString().trim().toUpperCase())
        values.put("description", etDescription.text.toString().trim().toUpperCase())


        if (this.notId == 0) {
            val id = dbManager.insert(values)
            if (id > 0) {
                Toast.makeText(this, "The note has been added successfully!", Toast.LENGTH_LONG).show()
                finish()
            } else {
                Toast.makeText(this, "The note has not been added successfully!", Toast.LENGTH_LONG).show()
            }
        } else {
            var selectionArgs = arrayOf(this.notId.toString())
            val id = dbManager.update(values, "ID = ?", selectionArgs)

            if (id > 0) {
                Toast.makeText(this, "The note has been updated successfully!", Toast.LENGTH_LONG).show()
                finish()
            } else {
                Toast.makeText(this, "The note has not been updated successfully!", Toast.LENGTH_LONG).show()
            }
        }

    }
}
