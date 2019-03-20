package com.example.fragments

/**
 * Sample fragment that displays text
 * Created by aaron on 2018.02.08
 */

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.text_fragment.*

class TextFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater?.inflate(R.layout.text_fragment,
            container, false)
    }

    // called to display the -text- with the given -fontsize-
    fun changeTextProperties(fontsize: Int, text: String)
    {
        textView1.textSize = fontsize.toFloat()         // A - where did textView1 come from?
        textView1.text = text
    }
}