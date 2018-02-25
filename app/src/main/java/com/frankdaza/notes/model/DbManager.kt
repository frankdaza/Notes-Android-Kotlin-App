package com.frankdaza.notes.model

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

/**
 * Created by Frank Edward Daza González on Feb 22, 2018.
 */
class DbManager {

    val dbName: String = "MyNotes"
    val dbTable: String = "Notes"
    val colId: String = "ID"
    val colTitle: String = "Title"
    val colDescription: String = "Description"
    val dbVersion: Int = 1
    val sqlCreateTable: String = "CREATE TABLE IF NOT EXISTS $dbTable ($colId INTEGER PRIMARY KEY, $colTitle TEXT, $colDescription TEXT);"
    var sqlDB: SQLiteDatabase? = null

    constructor(context: Context) {
        var db = DataBaseHelperNotes(context)
        sqlDB = db.writableDatabase
    }

    fun insert(values: ContentValues) : Long {
        val id = sqlDB!!.insert(dbTable, "", values)
        return id
    }

    inner class DataBaseHelperNotes: SQLiteOpenHelper {

        var context: Context

        constructor(context: Context) : super(context, dbName, null, dbVersion) {
            this.context = context
        }

        override fun onCreate(p0: SQLiteDatabase?) {
            p0!!.execSQL(sqlCreateTable)
            Toast.makeText(this.context, "Database is created", Toast.LENGTH_LONG).show()
        }

        override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
            p0!!.execSQL("DROP TABLE IF EXISTS $dbTable;")
        }

    }

}
