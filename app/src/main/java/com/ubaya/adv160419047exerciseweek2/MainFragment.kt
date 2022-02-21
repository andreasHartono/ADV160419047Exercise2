package com.ubaya.adv160419047exerciseweek2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*
import kotlin.random.Random

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val randomNum1 = Random.nextInt(100)
        val randomNum2 = Random.nextInt(100)
        var points = 0
        txtRandomNumber.text = "$randomNum1 + $randomNum2"
        buttonSubmit.setOnClickListener {
            var result = randomNum1 + randomNum2
            // get result from user
            var resultFromUser = editAnswer.text.toString()
            // check the result player is correct or incorrect
            // if correct the players get 1 points
            if(result.toString() == resultFromUser) {
                points += 1
            }
            val action = MainFragmentDirections.actionResultFragment(points)
            Navigation.findNavController(it).navigate(action)
        }
    }
}