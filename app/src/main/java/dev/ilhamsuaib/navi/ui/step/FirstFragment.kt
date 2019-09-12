package dev.ilhamsuaib.navi.ui.step

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import dev.ilhamsuaib.navi.R
import dev.ilhamsuaib.navi.model.Person
import kotlinx.android.synthetic.main.fragment_first.view.*

/**
 * Created by @ilhamsuaib on 2019-08-18.
 * github.com/ilhamsuaib
 */

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
    }

    private fun setupView() = view?.run {

        btnNext.setOnClickListener {
            val firstName = edtFirstName.text.toString()
            val lastName = edtLastName.text.toString()
            val person = Person(firstName, lastName)
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(person)
            findNavController().navigate(action)
        }
    }
}