package com.example.fragmentpractice

/**
 * Sample fragment2
 * Created by aaron on 2019.02.20
 */

import  android.os.Bundle
import  android.support.v4.app.Fragment
import  android.view.LayoutInflater
import  android.view.View
import  android.view.ViewGroup
import android.content.Context
import android.widget.Button

class ToolbarFragment2 : Fragment() {

    private var activityCallback: ToolbarFragment.ToolbarListener? = null  // Activity attached to

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            activityCallback = context as ToolbarFragment.ToolbarListener
        } catch (e: ClassCastException) {
            throw ClassCastException(context?.toString()
                    + " must implement ToolbarListener")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val view = inflater?.inflate(R.layout.toolbar_fragment2,
            container, false)

        val button: Button? = view?.findViewById(R.id.button2)
        button?.setOnClickListener { buttonClicked(it)}
        return view
    }

    private fun buttonClicked(view: View) {
        activityCallback?.switchFragment(this)
    }

}