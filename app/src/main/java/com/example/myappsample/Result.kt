package com.example.myappsample

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.myappsample.MainActivity.GameState

private const val TAG = "ResultFragment"

class Result : Fragment() {
    private val resultTextResId = GameState.getResult()

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "Lifecycle: onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "Lifecycle: onCreateView")

        GameState.computeHand() // compute enemy's hand

        val view = inflater.inflate(R.layout.fragment_result, container, false)

        view.findViewById<TextView>(R.id.text).setText(resultTextResId) // set the text
        view.findViewById<ImageView>(R.id.your_hand).setBackgroundResource(GameState.getHandDrawables(GameState.myHand)) // set player's hand image
        view.findViewById<ImageView>(R.id.ai_hand).setBackgroundResource(GameState.getHandDrawables(GameState.enemyHand)) // set enemy's hand image

        view.findViewById<Button>(R.id.play_btn).setOnClickListener {
            view.findNavController().navigate(R.id.action_results_to_game)
        }

        view.findViewById<Button>(R.id.home_btn).setOnClickListener {
            view.findNavController().navigate(R.id.action_result_to_title_screen)
        }

        view.findViewById<ImageButton>(R.id.back_btn).setOnClickListener {
            view.findNavController().navigate(R.id.action_back)
        }

        return view
    }

    override fun onStart() {
        Log.d(TAG, "Lifecycle: onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d(TAG, "Lifecycle: onResume")
        Toast.makeText(activity?.applicationContext, getText(resultTextResId), Toast.LENGTH_SHORT).show()
        Log.d(TAG, "Toast fired")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "Lifecycle: onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG, "Lifecycle: onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG, "Lifecycle: onDestroy")
        Toast.makeText(activity?.applicationContext, getText(R.string.game_again_toast), Toast.LENGTH_SHORT).show()
        Log.d(TAG, "Toast fired")
        super.onDestroy()
    }
}