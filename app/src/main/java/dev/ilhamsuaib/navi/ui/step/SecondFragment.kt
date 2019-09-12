package dev.ilhamsuaib.navi.ui.step

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import dev.ilhamsuaib.navi.R
import kotlinx.android.synthetic.main.fragment_second.view.*

/**
 * Created by @ilhamsuaib on 2019-08-18.
 * github.com/ilhamsuaib
 */

class SecondFragment : Fragment() {

    private val args: SecondFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
    }

    @SuppressLint("SetTextI18n")
    private fun setupView() = view?.run {
        val person = args.person
        tvFirstName.text = "First name : ${person?.firsName.orEmpty()}"
        tvLastName.text = "Last name : ${person?.lastName.orEmpty()}"

        btnFinish.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}