package br.com.exemplo01.ui.main.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
data public class Client(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "cpf") val cpf: String?,
    @ColumnInfo(name = "nome") val nome: String?,
    @ColumnInfo(name = "email") val email: String?,
    @ColumnInfo(name = "telefone") val telefone: String?
)
