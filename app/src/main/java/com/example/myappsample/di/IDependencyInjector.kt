package com.example.myappsample.di

import com.example.myappsample.data.IHandsRepository

interface IDependencyInjector {
    fun handsRepository() : IHandsRepository
}