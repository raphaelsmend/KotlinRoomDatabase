package br.com.exemplo01.ui.main.viewmodel

import androidx.lifecycle.*
import br.com.exemplo01.ui.main.database.entity.Client
import br.com.exemplo01.ui.main.database.repository.ClientRepository
import kotlinx.coroutines.launch

class ClientViewModel(private val repository: ClientRepository) : ViewModel() {
    val allWords: LiveData<List<Client>> = repository.allClients.asLiveData()

    fun insert(client: Client) = viewModelScope.launch {
        repository.insert(client)
    }
}

class ClientViewModelFactory(private val repository: ClientRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ClientViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ClientViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}