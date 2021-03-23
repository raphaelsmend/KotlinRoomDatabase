package br.com.exemplo01.ui.main.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import br.com.exemplo01.ui.main.database.entity.Client;
import kotlinx.coroutines.flow.Flow

@Dao
interface ClientDao {
    @Query("SELECT * FROM client")
    fun getAll(): Flow<List<Client>>

    @Query("SELECT * FROM client WHERE nome LIKE :nome AND LIMIT 1")
    fun findByName(nome: String): Client

    @Query("SELECT * FROM client WHERE id = :id")
    fun findById(id: Int): Client

    @Insert
    fun insert(vararg client: Client)

    @Delete
    fun delete(client: Client)
}
