package com.example.notes

import android.os.Bundle
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var listView: ListView
    private lateinit var notes: MutableList<Note>
    private lateinit var adapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        listView = findViewById(R.id.listView)

        notes = mutableListOf()
        adapter = NoteAdapter(this, notes)
        listView.adapter = adapter

        findViewById<View>(R.id.addButton).setOnClickListener {
            val content = editText.text.toString()
            if (content.isNotEmpty()) {
                val note = Note(notes.size + 1, content)
                notes.add(note)
                adapter.notifyDataSetChanged()
                editText.text.clear()
            }
        }

        listView.setOnItemClickListener { _, _, position, _ ->
            // You can implement note editing or deletion here
            // For simplicity, this example does not include these features
        }
    }
}