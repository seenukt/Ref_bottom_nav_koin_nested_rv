package com.example.recyclerview.all_nav.dialog

import android.content.Context
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.example.recyclerview.R
import com.example.recyclerview.databinding.DialogActionFragmentBinding


class ActionDialogFragment() : DialogFragment(R.layout.dialog_action_fragment) {

    lateinit var binding : DialogActionFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DialogActionFragmentBinding.inflate(layoutInflater)


        return binding.root

    }

//    override fun onStart() {
//        super.onStart()
//        val window = dialog?.window ?: return
//        val params = window.attributes
//        params.width = ViewGroup.LayoutParams.MATCH_PARENT
//        params.width = ViewGroup.LayoutParams.MATCH_PARENT
//        params.height = ViewGroup.LayoutParams.WRAP_CONTENT
//        window.setLayout(
//            ViewGroup.LayoutParams.MATCH_PARENT-2*0.8.toInt(),
//            ViewGroup.LayoutParams.WRAP_CONTENT
//        )
//        window.attributes = params
//
//    }

    override fun onStart() {
        super.onStart()
        val dialog = dialog ?: return
        val window = dialog.window ?: return

        // Set the dialog's width and apply margins
//        val margin = resources.getDimensionPixelSize(R.dimen.dialog_margin) // Define margin in dimens.xml

        window.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,  // Match parent's width
            ViewGroup.LayoutParams.WRAP_CONTENT  // Wrap content height
        )

        val metrics = resources.displayMetrics
        val screenWidth = metrics.widthPixels

        // Set dialog width minus left & right margins
        window.setLayout(screenWidth -6 * 20, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.window?.apply {
            setBackgroundDrawableResource(android.R.color.transparent) // Removes default background
        }
    }

    private fun getDeviceMetrics(context: Context): DisplayMetrics? {
        val metrics = DisplayMetrics()
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        display.getMetrics(metrics)
        return metrics
    }
}