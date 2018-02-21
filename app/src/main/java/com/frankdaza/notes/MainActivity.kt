package com.frankdaza.notes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.frankdaza.notes.model.Note
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.adapter_note.view.*

class MainActivity : AppCompatActivity() {

    var listNotes = ArrayList<Note>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Adding dummy data
        this.listNotes.add(Note(1, "Frank's Happy Birthday", "It's my happy birthday wujuu!"))
        this.listNotes.add(Note(2, "Vanessa's Happy Birthday", "It's my happy birthday wujuu!"))
        this.listNotes.add(Note(3, "Andrea's Happy Birthday", "It's my happy birthday wujuu!"))
        this.listNotes.add(Note(4, "Martha's Happy Birthday", "It's my happy birthday wujuu!"))
        this.listNotes.add(Note(5, "Obed's Happy Birthday", "It's my happy birthday wujuu!"))
        this.listNotes.add(Note(6, "Mauricio's Happy Birthday", "It's my happy birthday wujuu!"))

        var noteAdapter = NoteAdapter(this.listNotes)
        lvNotes.adapter = noteAdapter
    }


    inner class NoteAdapter : BaseAdapter {

        var listNotesAdapter = ArrayList<Note>()

        constructor(listNotes: ArrayList<Note>) {
            this.listNotesAdapter = listNotes
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var myView = layoutInflater.inflate(R.layout.adapter_note, null)
            var myNote = this.listNotesAdapter[p0]
            myView.tvTitle.text = myNote.noteName
            myView.tvDescripcion.text = myNote.noteDescripcion

            return myView
        }

        override fun getItem(p0: Int): Any {
            return this.listNotesAdapter[p0]
        }

        override fun getItemId(p0: Int): Long {
            return this.listNotesAdapter[p0].noteId.toLong()
        }

        override fun getCount(): Int {
            return this.listNotesAdapter.size
        }

    }
}
