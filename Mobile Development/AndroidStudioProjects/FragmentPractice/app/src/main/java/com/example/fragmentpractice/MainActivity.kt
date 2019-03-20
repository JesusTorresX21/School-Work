package com.example.fragmentpractice

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity

class MainActivity: FragmentActivity(), ToolbarFragment.ToolbarListener {
    private var frag1:Fragment? = null
    private var frag2:Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_fragment)
        frag1 = ToolbarFragment()
        supportFragmentManager.beginTransaction().add(R.id.fragframe, frag1 as ToolbarFragment).commit()
    }

    override fun onButtonClick(fontsize: Int, text: String) {
        val textFragment = supportFragmentManager.findFragmentById(R.id.text_fragment)
                as TextFragment
        textFragment.changeTextProperties(fontsize, text)
    }

    // called by fragment (passed as the parameter) to switch to the other fragment
    override fun switchFragment(frag: Fragment) {
        when (frag) {
            is ToolbarFragment -> {
                if (frag2 == null) {
                    frag2 = ToolbarFragment2()
                }
                supportFragmentManager.beginTransaction().replace(R.id.fragframe, frag2!!).commit()
            }
            is ToolbarFragment2 -> {
                //bring back ToolbarFragment
                if (frag1 == null) {
                    frag1  = ToolbarFragment()
                }
                supportFragmentManager.beginTransaction().replace(R.id.fragframe, frag1!!).commit()
            }
        }
    }
}
