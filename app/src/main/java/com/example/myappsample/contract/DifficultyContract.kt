package com.example.myappsample.contract

import com.example.myappsample.data.Difficulties
import com.example.myappsample.data.Hands
import com.example.myappsample.presenter.BasePresenter
import com.example.myappsample.view.BaseView

interface DifficultyContract {
    interface Presenter : BasePresenter {
        fun onViewCreated()
        fun onDifficultyChosen()
        fun onStop()
    }

    interface View : BaseView<Presenter> {
        fun displayDifficulty(difficulties: Difficulties)
        fun displayHand(hands: Hands)
    }
}