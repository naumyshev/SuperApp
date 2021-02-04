package com.naumyshev.superapp.main.screens.textview

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.naumyshev.superapp.R
import com.naumyshev.superapp.databinding.FragmentTextViewBinding

class TextViewFragment : Fragment(R.layout.fragment_text_view) {
    companion object {
        const val TAG = "TextViewFragment"
    }

    private var fragmentTextViewBinding: FragmentTextViewBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentTextViewBinding = FragmentTextViewBinding.bind(view)
        fragmentTextViewBinding?.toolbar?.title = getString(R.string.text_view)
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
        fragmentTextViewBinding?.toolbar?.setNavigationOnClickListener { activity?.onBackPressed() }
    }

    override fun onDestroyView() {
        fragmentTextViewBinding = null
        super.onDestroyView()
    }
}