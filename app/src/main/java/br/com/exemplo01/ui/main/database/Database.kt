package br.com.exemplo01.ui.main.database;

import androidx.room.Database;
import androidx.room.RoomDatabase
import br.com.exemplo01.ui.main.database.dao.ClientDao

import br.com.exemplo01.ui.main.database.entities.Client;

@Database(entities = arrayOf(Client::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun clientDao(): ClientDao
}
