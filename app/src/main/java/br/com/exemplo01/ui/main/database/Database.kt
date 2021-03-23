package br.com.exemplo01.ui.main.database;

import android.content.Context
import androidx.room.Database;
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.exemplo01.ui.main.database.dao.ClientDao

import br.com.exemplo01.ui.main.database.entity.Client;

@Database(entities = arrayOf(Client::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun clientDao(): ClientDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "exemplo01_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
