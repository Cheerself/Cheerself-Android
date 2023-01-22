package com.cheerself.cheerself.utils.network

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindNetworkMonitor(
        networkMonitor: NetworkMonitorManager
    ): NetworkMonitor
}