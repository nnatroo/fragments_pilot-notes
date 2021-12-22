package com.example.viewpagerpilot.fragments

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.viewpagerpilot.R
import com.example.viewpagerpilot.adapter.ViewPagerFragmentAdapter

class FragmentFirst: Fragment(R.layout.fragment_first) {

    private lateinit var editTextNote : EditText
    private lateinit var buttonAdd : Button
    private lateinit var textView : TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        editTextNote = view.findViewById(R.id.editTextNote)
        buttonAdd = view.findViewById(R.id.buttonAdd)
        textView = view.findViewById(R.id.textView)

        val sharedPreferences = this.activity?.getSharedPreferences("NoteData", MODE_PRIVATE)
        val text = sharedPreferences?.getString("Notes", "None")
        textView.text = text

        buttonAdd.setOnClickListener {
            var note = editTextNote.text.toString()
            var text  = textView.text.toString()
            var result = note + "\n" + text
            textView.text = result
            sharedPreferences?.edit()?.putString("Notes", result)?.apply()


        }



    }


}