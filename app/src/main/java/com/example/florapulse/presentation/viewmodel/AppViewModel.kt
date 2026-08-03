package com.example.florapulse.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.florapulse.domain.repository.AppRepository
import com.example.florapulse.data.database.AppLogEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {
    val logs: Flow<List<AppLogEntity>> = repository.getLogs()

    fun addLog(title: String, content: String) {
        viewModelScope.launch {
            repository.addLog(title, content)
        }
    }
}
