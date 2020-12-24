package com.naumyshev.superapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.naumyshev.superapp.databinding.FragmentTextViewBinding

class TextViewFragment: Fragment(R.layout.fragment_text_view) {

    private var fragmentTextViewBinding: FragmentTextViewBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentTextViewBinding?.longText?.post {
            fragmentTextViewBinding?.longText?.lineCount?.let { lineCount ->
                if (lineCount <= 4) {
                    fragmentTextViewBinding?.readFull?.visibility = View.GONE
                } else {
                    fragmentTextViewBinding?.readFull?.visibility = View.VISIBLE
                }

            }
        }

        val collapseListener: (View) -> Unit = {
            fragmentTextViewBinding?.longText?.maxLines = Int.MAX_VALUE
            fragmentTextViewBinding?.readFull?.visibility = View.GONE
        }

        fragmentTextViewBinding?.readFull?.setOnClickListener(collapseListener)

    }
}