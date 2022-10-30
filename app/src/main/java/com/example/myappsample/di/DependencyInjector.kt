package com.example.myappsample.di

import com.example.myappsample.data.HandsRepository
import com.example.myappsample.data.IHandsRepository

class DependencyInjector : IDependencyInjector {
    override fun handsRepository(): IHandsRepository {
        return HandsRepository()
    }
}