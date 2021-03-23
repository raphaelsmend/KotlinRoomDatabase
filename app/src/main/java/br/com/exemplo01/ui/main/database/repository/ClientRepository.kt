package br.com.exemplo01.ui.main.database.repository

import androidx.annotation.WorkerThread
import br.com.exemplo01.ui.main.database.dao.ClientDao
import br.com.exemplo01.ui.main.database.entity.Client
import kotlinx.coroutines.flow.Flow

class ClientRepository(private val clientDao: ClientDao) {
    val allClients: Flow<List<Client>> = clientDao.getAll()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(client: Client) {
        clientDao.insert(client)
    }
}