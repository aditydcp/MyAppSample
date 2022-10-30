package com.example.myappsample.contract

import com.example.myappsample.data.GameState
import com.example.myappsample.data.Hands
import com.example.myappsample.presenter.BasePresenter
import com.example.myappsample.view.BaseView

interface ResultContract {
    interface Presenter : BasePresenter {
        fun onViewCreated()
        fun onPlayClicked()
        fun onHomeClicked()
        fun onResume()
    }

    interface View : BaseView<Presenter> {
        fun displayGameState(gameState: GameState)
        fun displayEnemyHand(hands: Hands)
        fun displayPlayerHand(hands: Hands)
    }
}