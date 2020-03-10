package com.example.fragmentscope.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.fragmentscope.MainFragmentPresenter
import com.example.fragmentscope.MainFragmentView
import com.example.fragmentscope.R
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(), MainFragmentView {

    private val presenter: MainFragmentPresenter by lazy(LazyThreadSafetyMode.NONE) {
        ViewModelProviders.of(this).get(MainFragmentPresenter::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onStart() {
        presenter.onAttach(this)
        super.onStart()
    }

    override fun onStop() {
        presenter.onDetach()
        super.onStop()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        secondText.setOnClickListener {
            fragmentManager!!
                .beginTransaction()
                .replace(
                    R.id.fragment_container,
                    SecondFragment()
                )
                .addToBackStack("second")
                .commit()
        }
    }

    override fun setMainText(text: String) {
        mainText.text = text
    }

    override fun setSecondText(text: String) {
        secondText.text = text
    }
}