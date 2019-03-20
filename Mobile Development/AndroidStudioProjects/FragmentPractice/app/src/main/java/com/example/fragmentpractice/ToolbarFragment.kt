package com.example.fragmentpractice

/**
 * Sample fragment
 * Created by aaron on 2019.02.20.
 */

import  android.os.Bundle
import  android.support.v4.app.Fragment
import  android.view.LayoutInflater
import  android.view.View
import  android.view.ViewGroup
import android.widget.SeekBar
import android.content.Context
import android.widget.Button
import kotlinx.android.synthetic.main.toolbar_fragment.*

class ToolbarFragment : Fragment() {

    var seekvalue = 10

    private var activityCallback: ToolbarFragment.ToolbarListener? = null  //Activity holding this fragment

    interface ToolbarListener {     // defined interface the holding Activity must implement
        fun onButtonClick(fontsize: Int, text: String)
        fun switchFragment(frag: Fragment)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            activityCallback = context as ToolbarListener  // makes sure Activity implements interface
        } catch (e: ClassCastException) {
            throw ClassCastException(context?.toString()
                    + " must implement ToolbarListener")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val view = inflater?.inflate(R.layout.toolbar_fragment,
            container, false)

        val seekBar: SeekBar? = view?.findViewById(R.id.seekBar1)
        val button: Button? = view?.findViewById(R.id.button1)
        val swapButton: Button? = view?.findViewById(R.id.swapbutton1)

        seekBar?.setOnSeekBarChangeListener( object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int,
                                           fromUser: Boolean) {
                seekvalue = progress
                activityCallback?.onButtonClick(seekvalue, editText1.text.toString())
            }

            override fun onStartTrackingTouch(arg0: SeekBar) {
            }

            override fun onStopTrackingTouch(arg0: SeekBar) {
            }
        })

        button?.setOnClickListener {buttonClicked(it)}  //{ v: View -> buttonClicked(v)}
        swapButton?.setOnClickListener {swapButtonClicked(it)}  //{ v: View -> swapButtonClicked(v)}

        return view
    }

    private fun buttonClicked(view: View) {
        activityCallback?.onButtonClick(seekvalue, editText1.text.toString())
    }

    private fun swapButtonClicked(view: View) {
        activityCallback?.switchFragment(this)

    }
}

